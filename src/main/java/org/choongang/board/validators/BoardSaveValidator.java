package org.choongang.board.validators;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.choongang.board.exceptions.BoardNotFoundException;
import org.choongang.board.mappers.BoardDataMapper;
import org.choongang.global.config.annotations.Component;
import org.choongang.global.validators.RequiredValidator;
import org.choongang.global.validators.Validator;
import org.choongang.board.controllers.RequestBoardData;
import org.choongang.global.exceptions.AlertException;
import org.choongang.member.MemberUtil;

/**
 * 필수항목 검증
 * 비회원일때 비회원 비밀번호 입력
 */
@Component
@RequiredArgsConstructor
public class BoardSaveValidator implements Validator<RequestBoardData>, RequiredValidator {

    private final MemberUtil memberUtil;
    private final BoardDataMapper mapper;

    @Override
    public void check(RequestBoardData form) {
        /**
         * 1. 필수 항목 검증
         * - poster, subject, content
         * - bId(게시판 아이디), gId -> 게시글 등록시 필수 항목, 게시글 수정시에는 변경 불가능
         * - seq(게시글 번호) -> 게시글 수정시 필수 / 게시글 수정시 게시글이 조회되는지 체크 해야함
         *
         * 미 로그인시 필수 항목 -> guestPassword: 비회원 비밀번호 / 비밀번호 자리수 4자리 이상
         * RequestBoardData 바탕으로 작성
         */
        String mode = form.getMode(); //write, update ..
        mode = mode == null || mode.isBlank() ? "write" : mode; //mode가 null이거나 비어있는 상태이면 write상태로
        String poster = form.getPoster();
        String subject = form.getSubject();
        String content = form.getContent();
        String bId = form.getBId(); //게시글 등록시 필수
        String gId = form.getGId(); //게시글 등록시 필수
        long seq = form.getSeq(); //게시글 수정시 필수
        String guestPassword = form.getGuestPassword(); //미로그인시 필수

        int status = HttpServletResponse.SC_BAD_REQUEST;

        // 필수 항목 검증
        /* 공통 필수 항목 체크 */
        checkRequired(poster, new AlertException("작성자를 입력하세요.", status));
        checkRequired(subject, new AlertException("제목을 입력하세요.", status));
        checkRequired(content, new AlertException("내용을 입력하세요.", status));

        /* 등록, 수정 구분 항목 체크 */
        if(mode.equals("update")){
            //수정
            checkTrue(seq > 0L, new AlertException("잘못된 접근입니다.",status));//seq번호가 0보다 작을때(없을때) 예외 던짐

            checkTrue(mapper.exists(seq) > 0L, new BoardNotFoundException());
            //게시글이 있는지 체크

        }else {
            //등록
            checkRequired(bId, new AlertException("잘못된 접근입니다.", status)); //주소 잘못입력하거나 개발자의 잘못된 유입시..
            checkRequired(gId, new AlertException("잘못된 접근입니다.", status));
        }

        //미 로그인시 체크 항목
        if(!memberUtil.isLogin()){
            checkRequired(guestPassword, new AlertException("글 수정, 삭제 비밀번호를 입력하세요.",status));
            checkTrue(guestPassword.length() >= 4, new AlertException("비밀번호는 4자리 이상 입력하세요.", status));
        }
    }
}

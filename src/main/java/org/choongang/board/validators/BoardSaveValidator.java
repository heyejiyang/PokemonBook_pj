package org.choongang.board.validators;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.choongang.global.config.annotations.Component;
import org.choongang.global.validators.RequiredValidator;
import org.choongang.global.validators.Validator;
import org.choongang.board.controllers.RequestBoardData;
import org.choongang.global.exceptions.AlertException;

/**
 * 필수항목 검증
 * 비회원일때 비회원 비밀번호 입력
 */
@Component
@RequiredArgsConstructor
public class BoardSaveValidator implements Validator<RequestBoardData>, RequiredValidator {

    @Override
    public void check(RequestBoardData form) {
        /**
         * 1. 필수 항목 검증
         * - poster, subject, content
         * - bId(게시판 아이디), gId -> 게시글 등록시 필수 항목, 게시글 수정시에는 변경 불가능
         * - seq(게시글 번호) -> 게시글 수정시 필수 / 게시글 수정시 게시글이 조회되는지 체크 해야함
         *
         * 미 로그인시 필수 항목 -> guestPassword: 비회원 비밀번호
         * RequestBoardData 바탕으로 작성
         */

        String poster = form.getPoster();
        String subject = form.getSubject();
        String content = form.getContent();
        String bId = form.getBId(); //게시글 등록시 필수
        String gId = form.getGId(); //게시글 수정시 필수
        long seq = form.getSeq(); //게시글 수정시 필수

        String guestPassword = form.getGuestPassword();

        int status = HttpServletResponse.SC_BAD_REQUEST;

        // 필수 항목 검증
        checkRequired(bId, new AlertException("게시판 아이디를 입력하세요.", status));
        checkRequired(subject, new AlertException("제목을 입력하세요.", status));

        // 추가적인 유효성 검사 로직 추가 가능
    }
}

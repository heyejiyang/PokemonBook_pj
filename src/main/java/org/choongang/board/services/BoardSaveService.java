package org.choongang.board.services;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.choongang.board.entities.BoardData;
import org.choongang.board.mappers.BoardDataMapper;
import org.choongang.board.validators.BoardWriteValidator;
import org.choongang.global.config.annotations.Service;
import org.choongang.global.exceptions.AlertException;
import org.choongang.board.controllers.RequestBoardData;

@Service
@RequiredArgsConstructor
public class BoardSaveService {
    private final BoardDataMapper mapper;

    public void process(RequestBoardData form) {

//        BoardData boardData = BoardData.builder()
//                .bId(form.getBId())
//                .gId(form.getGId())
//                .poster(form.getPoster())
//                .guestPassword(form.getGuestPassword())
//                .category(form.getCategory())
//                .notice(form.isNotice() ? 1 : 0)
//                .subject(form.getSubject())
//                .content(form.getContent())
//                .build();
//
//        String mode = form.getMode();
//        mode = mode == null || mode.isBlank() ? "write" : mode;
//
//        int result = 0;
//        if (mode.equals("update")) {
//            // update 처리 추가하기 (mapper.modify(boardData) 사용)
//        } else {
//            result = mapper.register(boardData);
//        }
//
//        if (result < 1) {
//            throw new AlertException("게시글 " + (mode.equals("update") ? "수정" : "등록") + "에 실패하였습니다.", HttpServletResponse.SC_BAD_REQUEST);
//        }
    }
}

package org.choongang.board.services;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.choongang.board.controllers.RequestBoardData;
import org.choongang.board.entities.BoardData;
import org.choongang.board.mappers.BoardDataMapper;
import org.choongang.board.validators.BoardDataValidator;
import org.choongang.global.config.annotations.Service;
import org.choongang.global.exceptions.AlertException;

@Service
@RequiredArgsConstructor
//게시글 작성, 수정
public class BoardDataSaveService {
    private final BoardDataMapper datamapper;
    private final BoardDataValidator validator;

    public void process(RequestBoardData data){
        validator.check(data);

        BoardData boardData = BoardData.builder()
            .bId(data.getBId())
            .gId(data.getBId())
            .poster(data.getPoster())
            .subject(data.getSubject())
            .content(data.getContent())
            .guestPassword(data.getGuestPassword())
            .category(data.getCategory())
            .build();

    System.out.println(boardData);
    String mode = data.getMode();
    mode = mode == null || mode.isBlank() ? "register" : mode;

    int result = 0;
    if (mode.equals("update")){
        result = datamapper.modify(boardData);
    } else {
        result = datamapper.register(boardData);
    }

    if(result < 1){
        throw new AlertException("게시글" + (mode.equals("update")? "수정" : "등록") + "에 실패하였습니다.", HttpServletResponse.SC_BAD_REQUEST);
    }

    }


}

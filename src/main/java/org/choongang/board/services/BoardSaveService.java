package org.choongang.board.services;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.choongang.board.controllers.RequestBoardData;
import org.choongang.board.entities.BoardData;
import org.choongang.board.mappers.BoardDataMapper;
import org.choongang.board.validators.BoardSaveValidator;
import org.choongang.global.config.annotations.Service;
import org.choongang.global.exceptions.AlertException;

@Service
@RequiredArgsConstructor
//게시글 작성, 수정
public class BoardSaveService {
    private final BoardDataMapper mapper;
    private final BoardSaveValidator validator; //권한 체크

    public void process(RequestBoardData data){
//        validator.check(data);
//
//        BoardData boardData = BoardData.builder()
//            .bId(data.getBId())
//            .gId(data.getBId())
//            .poster(data.getPoster())
//            .subject(data.getSubject())
//            .content(data.getContent())
//            .guestPassword(data.getGuestPassword())
//            .category(data.getCategory())
//            .build();
//


    }


}

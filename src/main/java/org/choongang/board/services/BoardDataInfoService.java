package org.choongang.board.services;

import lombok.RequiredArgsConstructor;
import org.choongang.board.controllers.RequestBoardData;
import org.choongang.board.entities.BoardData;
import org.choongang.board.exceptions.BoardDataNotFoundException;
import org.choongang.board.mappers.BoardDataMapper;
import org.choongang.global.config.annotations.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardDataInfoService {
    private final BoardDataMapper mapper;

    public Optional<BoardData> get(long seq){
        BoardData data = mapper.get(seq);

        return Optional.ofNullable(data);
    }

    public RequestBoardData getForm(long seq){
        BoardData boardData = get(seq).orElseThrow(BoardDataNotFoundException::new);

        RequestBoardData form = new RequestBoardData();

        return null;
    }
}

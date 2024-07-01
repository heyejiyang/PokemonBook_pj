package org.choongang.board.services;

import lombok.RequiredArgsConstructor;
import org.choongang.board.entities.BoardData;
import org.choongang.board.exceptions.BoardNotFoundException;
import org.choongang.board.mappers.BoardDataMapper;
import org.choongang.global.config.annotations.Service;

@Service
@RequiredArgsConstructor
public class BoardDeleteService {
    private final BoardDataMapper mapper;
    private final BoardInfoService infoservice;

    public void delete(long seq){
        //권한체크(아직 추가x)
        BoardData data = infoservice.get(seq).orElseThrow(BoardNotFoundException::new);

        mapper.delete(seq);
    }
}

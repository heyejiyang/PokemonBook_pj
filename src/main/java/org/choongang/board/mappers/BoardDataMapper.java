package org.choongang.board.mappers;

import org.choongang.board.controllers.BoardSearch;
import org.choongang.board.entities.BoardData;

import java.util.List;

public interface BoardDataMapper {
    int register(BoardData data);
    int modify(BoardData data);
    int delete(long seq);
    BoardData get(long seq); //개별 게시글 조회
    List<BoardData> getList(BoardSearch search); //게시글 리스트 조회
}

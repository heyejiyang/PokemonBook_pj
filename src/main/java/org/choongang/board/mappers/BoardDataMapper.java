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
    int exists(long seq);
    int getTotal(BoardSearch search);

    // bId 조건 없이 모든 게시글 데이터를 가져오는 메서드 추가
    List<BoardData> getListWithoutBId(BoardSearch search);

}
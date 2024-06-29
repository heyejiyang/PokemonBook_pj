package org.choongang.board.mappers;

import org.choongang.board.entities.BoardEx;

import java.util.List;

public interface BoardExMapper {
    List<BoardEx> getList2();
    int insert(BoardEx boardEx);
}

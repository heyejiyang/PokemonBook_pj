package org.choongang.board.mappers;

import org.apache.ibatis.session.SqlSession;
import org.choongang.board.entities.BoardEx;
import org.choongang.global.config.DBConn;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MapperTest2 {
    private BoardExMapper mapper2;
    private SqlSession session;

    @BeforeEach
    void init() {
        session = DBConn.getSession(false);
        mapper2 = session.getMapper(BoardExMapper.class);
    }

    @Test
    void insertTest(){
        BoardEx boardEx = BoardEx.builder()
                .poster("(추가)작성자")
                .subject("(추가)제목")
                .content("(추가)내용")
                .build();
        int result = mapper2.insert(boardEx);
        System.out.println(result);
    }


    @AfterEach
    void destroy() {
        session.rollback();
    }
}
package org.choongang.board.mappers;

import org.choongang.board.entities.Member;

public interface MemberMapper {
    Member get(String email);
    int exists(String email);
    int register(Member member);
}

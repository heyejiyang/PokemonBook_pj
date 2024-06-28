package org.choongang.member.mappers;

import org.choongang.member.entities.Member;

import java.util.List;

public interface MemberMapper {
    Member get(String email);
    int exists(String email);
    int register(Member member);
    String memberList(Member member);
    List<Member> getList();
}

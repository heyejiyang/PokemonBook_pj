package org.choongang.member.mappers;

import org.choongang.member.entities.Member;

public interface MemberMapper {
    Member get(String email);
    int exists(String email);
    int register(Member member);
    String memberList(String email, String userName, String userType, String regDt);
}

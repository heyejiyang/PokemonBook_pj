package org.choongang.member.mappers;

import org.choongang.member.entities.Member;

import java.util.List;

public interface MemberMapper {
    Member get(String email);
    List<Member> getList();
    int exists(String email); //가입 회원 존재 체크
    int register(Member member); //회원가입
    int modify(Member member); //회원정보 수정
}
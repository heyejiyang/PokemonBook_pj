package org.choongang.member.mappers;

import org.choongang.member.controllers.MemberSearch;
import org.choongang.member.entities.Member;

import java.util.List;

public interface MemberMapper {
    Member get(String email);
    List<Member> getList(); // 회원 리스트
    int exists(String email); //가입 회원 존재 체크
    int register(Member member); //회원가입
    int modify(Member member); //회원정보 수정
    int getTotal(MemberSearch search); // 회원 목록 갯수
    int delete(String email); // 회원 삭제
    int withdraw(Member member); //회원 탈퇴
}

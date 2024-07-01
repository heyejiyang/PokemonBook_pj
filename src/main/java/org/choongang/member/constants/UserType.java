package org.choongang.member.constants;

public enum UserType {
    USER("일반 회원"), // 일반 회원
    ADMIN("관리자"); // 관리자

    private final String title;

    UserType(String title){this.title = title;}

    public String getTitle() {return title;}

}

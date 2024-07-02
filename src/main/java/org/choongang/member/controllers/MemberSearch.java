package org.choongang.member.controllers;

import lombok.Data;

@Data
public class MemberSearch {
    private int page = 1;
    private int limit = 10;
    private int offset;
    private int endRows;
    private String email;
    private String sopt = "ALL";
    private String skey;
}

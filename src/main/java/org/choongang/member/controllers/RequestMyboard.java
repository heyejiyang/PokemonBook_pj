package org.choongang.member.controllers;

public class RequestMyboard {
    private int page = 1;
    private int limit = 2;
    private int offset;
    private int endRows;
    private String bId; //게시판 아이디
    private String category; //게시판 분류
    private String sopt = "ALL";
    private String skey;
}

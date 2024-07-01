package org.choongang.member.controllers;

import lombok.Data;

@Data
public class RequestModify {
    private String email;
    private String password;
    private String confirmPassword;
    private String userName;
    //private long myPokemonSeq; //포켓몬 프로필? 값이 0 이상일 때만 수정 가능하게 함
}

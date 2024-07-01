package org.choongang.member.controllers;

import lombok.Data;
import org.choongang.member.constants.UserType;

import java.time.LocalDateTime;

@Data
public class RequestMypage {
    private String email;
    private String userName;
    private UserType userType;
    private LocalDateTime regDt;
    //private long myPokemonSeq; //포켓몬 프로필? 값이 0 이상일 때만 수정 가능하게 함

    //getter & setter
}

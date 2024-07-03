package org.choongang.member.controllers;

import lombok.Data;

@Data
public class RequestProfile {
    private String userName;
    private String password;
    private String confirmPassword;
    private long myPokemonSeq;
}
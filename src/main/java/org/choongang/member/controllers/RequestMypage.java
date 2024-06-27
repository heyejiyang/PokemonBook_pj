package org.choongang.member.controllers;

import lombok.Data;

@Data
public class RequestMypage {
    private String email;
    private String password;
    private String userName;

    //getter & setter
}

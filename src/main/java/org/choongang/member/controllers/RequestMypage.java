package org.choongang.member.controllers;

import lombok.Data;

import java.time.LocalDate;

@Data
public class RequestMypage {
    private String email;
    private String userName;
    private String userType;
    private LocalDate regDt;

    //getter & setter
}

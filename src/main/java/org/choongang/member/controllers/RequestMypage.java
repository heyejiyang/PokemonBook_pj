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

    //getter & setter
}

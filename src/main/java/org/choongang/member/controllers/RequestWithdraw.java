package org.choongang.member.controllers;

import lombok.Data;
import org.choongang.member.constants.UserType;

import java.time.LocalDateTime;

@Data
public class RequestWithdraw {
    private String email;
    private String userName;
    private String password;
    private String confirmPassword;
}

package org.choongang.admin.controllers;

import lombok.Data;
import org.choongang.member.constants.UserType;

import java.time.LocalDateTime;
@Data
public class RequestMember {
    private String email;
    private String userName;
    private UserType userType;
    private LocalDateTime regDt;
}

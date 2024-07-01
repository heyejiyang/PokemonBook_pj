package org.choongang.admin.adminMypage.controllers;

import lombok.RequiredArgsConstructor;
import org.choongang.global.config.annotations.Controller;
import org.choongang.global.config.annotations.GetMapping;
import org.choongang.global.config.annotations.RequestMapping;

@Controller
@RequestMapping("/admin/adminMypage")
@RequiredArgsConstructor
public class adminMypageController {

    @GetMapping
    public String boardList() {
        return "admin/adminMypage/index";
    }
}

package org.choongang.admin.adminMypage.controllers;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.choongang.global.config.annotations.Controller;
import org.choongang.global.config.annotations.GetMapping;
import org.choongang.global.config.annotations.PostMapping;
import org.choongang.global.config.annotations.RequestMapping;
import org.choongang.member.controllers.RequestModify;
import org.choongang.member.controllers.RequestMypage;
import org.choongang.member.services.ModifyService;

import java.util.List;

@Controller
@RequestMapping("/admin/adminMypage")
@RequiredArgsConstructor

public class adminMypageController {

    private final ModifyService modifyService;
    private final HttpServletRequest request;

    @GetMapping
    public String adminmypage(RequestMypage form, HttpServletRequest request) {
        request.setAttribute("form", form);
        request.setAttribute("addCss", List.of("admin/adminMypage"));
        return "admin/adminMypage/index";
    }

    // 정보 수정 양식
    @GetMapping("/modify")
    public String modify(HttpServletRequest request) {

        request.setAttribute("addCss", List.of("admin/modify"));
        return "admin/adminMypage/modify";
    }

    // 정보 수정 처리
    @PostMapping("/modify")
    public String modifyPs(RequestModify form, HttpServletRequest request) {

        modifyService.process(form);

        String url = request.getContextPath() + "/admin/adminMypage";
        String script = String.format("parent.location.replace('%s');", url);

        request.setAttribute("script", script);

        return "commons/execute_script";
    }
}
package org.choongang.admin.controllers;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.choongang.admin.sevices.config.AllMemberConfigInfoService;
import org.choongang.global.config.annotations.Controller;
import org.choongang.global.config.annotations.GetMapping;
import org.choongang.global.config.annotations.RequestMapping;
import org.choongang.member.entities.Member;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final AllMemberConfigInfoService allMemberConfigInfoService;
    private final HttpServletRequest request;

    @GetMapping
    public String index() {

        List<Member> items = allMemberConfigInfoService.getList();
        request.setAttribute("items", items);
        request.setAttribute("addCss", List.of("admin/members"));
        return "admin/index";
    }
}

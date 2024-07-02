package org.choongang.admin.controllers;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.choongang.admin.sevices.config.AllMemberConfigInfoService;
import org.choongang.global.ListData;
import org.choongang.global.config.annotations.Controller;
import org.choongang.global.config.annotations.GetMapping;
import org.choongang.global.config.annotations.RequestMapping;
import org.choongang.member.controllers.MemberSearch;
import org.choongang.member.entities.Member;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final AllMemberConfigInfoService allMemberConfigInfoService;
    private final HttpServletRequest request;

    @GetMapping
    public String index(MemberSearch search) {

        ListData<Member> data = allMemberConfigInfoService.getList(search);
        request.setAttribute("items", data.getItems());
        request.setAttribute("pagination", data.getPagination());
        request.setAttribute("addCss", List.of("admin/members"));
        return "admin/index";
    }
}
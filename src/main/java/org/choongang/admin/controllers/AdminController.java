package org.choongang.admin.controllers;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.choongang.admin.sevices.config.AllMemberConfigInfoService;
import org.choongang.admin.sevices.config.MemberDeleteService;
import org.choongang.global.ListData;
import org.choongang.global.config.annotations.*;
import org.choongang.member.controllers.MemberSearch;
import org.choongang.member.entities.Member;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final AllMemberConfigInfoService allMemberConfigInfoService;
    private final HttpServletRequest request;
    private final MemberDeleteService deleteService;

    @GetMapping
    public String index(MemberSearch search) {

        ListData<Member> data = allMemberConfigInfoService.getList(search);
        request.setAttribute("items", data.getItems());
        request.setAttribute("pagination", data.getPagination());
        request.setAttribute("addCss", List.of("admin/members"));
        return "admin/index";
    }

    @PostMapping("/delete")
    public String deleteMembers(HttpServletRequest request) {

        deleteService.process();

        String script = "parent.location.reload();";
        request.setAttribute("script", script);
        return "commons/execute_script";
    }
}
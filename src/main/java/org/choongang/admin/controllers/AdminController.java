package org.choongang.admin.controllers;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.choongang.global.config.annotations.Controller;
import org.choongang.global.config.annotations.GetMapping;
import org.choongang.global.config.annotations.RequestMapping;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final HttpServletRequest request;

    @GetMapping
    public String index() {
        //request.setAttribute("addCss", List.of("admin")); // css/admin.css
        return "admin/index";
    }
}

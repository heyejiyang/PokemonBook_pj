package org.choongang.main.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.choongang.global.config.annotations.Controller;
import org.choongang.global.config.annotations.GetMapping;
import org.choongang.global.config.annotations.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {

    @GetMapping
    public String index(HttpServletRequest request) {

        request.setAttribute("addCss", List.of("swiper-bundle.min"));
        request.setAttribute("addScript", List.of("swiper-bundle.min", "main/banner"));
        return "main/index";
    }
}

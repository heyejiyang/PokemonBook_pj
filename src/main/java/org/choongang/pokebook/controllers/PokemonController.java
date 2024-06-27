package org.choongang.pokebook.controllers;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.choongang.global.config.annotations.Controller;
import org.choongang.global.config.annotations.GetMapping;
import org.choongang.global.config.annotations.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/pokebook")
@RequiredArgsConstructor
public class PokemonController {
    private final HttpServletRequest request;

    @GetMapping
    public String index() {
        String uri = request.getRequestURI();
        request.setAttribute("addCss", List.of("pokebook"));
        return "pokebook/pokebookmain";
    }
}




package org.choongang.board.controllers;


import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.choongang.global.config.annotations.Controller;
import org.choongang.global.config.annotations.GetMapping;
import org.choongang.global.config.annotations.PostMapping;
import org.choongang.global.config.annotations.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    private final HttpServletRequest request;

    @GetMapping("/notice")
    public String notice(){
        request.setAttribute("addCss", List.of("notice"));
        return "board/notice";
    }

    @GetMapping("/question")
    public String question(){
        request.setAttribute("addCss", List.of("question"));
        return "board/question";
    }

    @PostMapping("/question")
    public String questionPost() {
        return null;
    }

}

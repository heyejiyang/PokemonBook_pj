package org.choongang.board.controllers;


import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.choongang.global.config.annotations.*;

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

    @GetMapping("/list/{bId}")
    public String list(@PathVariable("bId") String bId){ //게시글 목록
        return "board/list";
    }

    @GetMapping("/view/{seq}")
    public String view(@PathVariable("seq") long seq){ //게시글 보기
        return "board/view";
    }

}

package org.choongang.board.controllers;


import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.choongang.board.entities.Board;
import org.choongang.board.exceptions.BoardConfigNotFoundException;
import org.choongang.board.services.config.BoardConfigInfoService;
import org.choongang.global.config.annotations.*;

import java.util.List;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    private final HttpServletRequest request;
    private final BoardConfigInfoService configInfoService;

    //공지사항
    @GetMapping("/notice")
    public String notice(){
        request.setAttribute("addCss", List.of("notice"));
        return "board/notice";
    }

    //질문과답변
    @GetMapping("/question")
    public String question(){
        request.setAttribute("addCss", List.of("question"));
        return "board/question";
    }

    @PostMapping("/question")
    public String questionPost() {
        return null;
    }

    //게시글 목록
    @GetMapping("/list/{bId}")
    public String list(@PathVariable("bId") String bId){
        commonProcess(bId);
        return "board/list";
    }

    //게시글 보기
    @GetMapping("/view/{seq}")
    public String view(@PathVariable("seq") long seq){
        return "board/view";
    }

    //게시글 작성
    @GetMapping("/write/{bId}")
    public String write(@PathVariable("bId") String bId){
        commonProcess(bId);
        return "board/write";
    }

    //게시글 수정
    @GetMapping("/update/{seq}")
    public String update(@PathVariable("seq") long seq){

        return "board/update";
    }

    /**
     * 모든 요청 처리 메서드에 공통 처리 부분
     * @param bId : 게시판 아이디가 있을 경우 게시판 설정 유지/ 게시판 아이디가 없을 경우 게시판 설정 X -> 게시판이 없음(BoardConfigNotFoundException)
     */
    //bId가 있을때마다 처리
    private void commonProcess(String bId){
        Board board = configInfoService.get(bId).orElseThrow(BoardConfigNotFoundException::new);

        request.setAttribute("addCss", List.of("list"));
        request.setAttribute("board", board);
    }
}

package org.choongang.board.controllers;


import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.choongang.board.entities.Board;
import org.choongang.board.entities.BoardData;
import org.choongang.board.exceptions.BoardConfigNotFoundException;
import org.choongang.board.services.config.BoardConfigInfoService;
import org.choongang.global.config.annotations.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    private final HttpServletRequest request;
    private final BoardConfigInfoService configInfoService;

    //게시글 목록
    @RequestMapping("/list/{bId}")
    public String list(@PathVariable("bId") String bId,
                       @RequestParam(value = "page") int page) {
        /*추가 코드 S*/
        int pageSize = 10;  // 한 페이지에 보여줄 게시글 수
        int totalCount = 100;  // 가상 총 게시글 수 (예: 100개)
        int totalPages = (int) Math.ceil((double) totalCount / pageSize);  // 총 페이지 수

        // 가상 데이터 생성
        List<String> boards = new ArrayList<>();
        for (int i = (page - 1) * pageSize + 1; i <= page * pageSize && i <= totalCount; i++) {
            boards.add("제목 " + i);
        }

        request.setAttribute("boards", boards);
        request.setAttribute("currentPage", page);
        request.setAttribute("totalPages", totalPages);
        request.setAttribute("bId", bId);
        /*추가 코드 E*/
        commonProcess(bId, "list");
        return "board/list";  // JSP 페이지로 이동
    }

    //게시글 보기
    @GetMapping("/view/{seq}")
    public String view(@PathVariable("seq") long seq){
        return "board/view";
    }

    //게시글 작성
    @GetMapping("/write/{bId}")
    public String write(@PathVariable("bId") String bId){
        commonProcess(bId,"write");

        RequestBoardData data = new RequestBoardData();
        data.setBId(bId);

        request.setAttribute("data",data);

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
     * @Param mode: 처리 모드 - write, update, list, view
     */
    //bId가 있을때마다 처리
    private void commonProcess(String bId,String mode){
        Board board = configInfoService.get(bId).orElseThrow(BoardConfigNotFoundException::new);

        //mode가 null이면 write로 기본값 설정
        mode= Objects.requireNonNullElse(mode,"write");

        List<String> addCss = new ArrayList<>();
        List<String> addScript = new ArrayList<>();

        addCss.add("board/style"); //모든 게시판의 공통 스타일

        if(mode.equals("write") || mode.equals("update")){ //쓰기, 수정
            addCss.add("board/form");
            addScript.add("ckeditor5/ckeditor");
            addScript.add("board/form");

        }else if(mode.equals("list")){ //목록
            addCss.add("board/list");

        }else if(mode.equals("view")){ //글보기
            addCss.add("board/view");
        }
        request.setAttribute("board", board);
        request.setAttribute("addCss",addCss);
        request.setAttribute("addScript",addScript);
    }
}
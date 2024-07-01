package org.choongang.board.controllers;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.choongang.board.entities.Board;
import org.choongang.board.entities.BoardData;
import org.choongang.board.exceptions.BoardConfigNotFoundException;
import org.choongang.board.exceptions.BoardNotFoundException;
import org.choongang.board.mappers.BoardDataMapper;
import org.choongang.board.services.BoardDeleteService;
import org.choongang.board.services.BoardInfoService;
import org.choongang.board.services.BoardSaveService;
import org.choongang.board.services.config.BoardConfigInfoService;
import org.choongang.global.ListData;
import org.choongang.global.config.annotations.*;
import org.choongang.global.exceptions.AlertException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardConfigInfoService configInfoService;
    private final BoardSaveService saveService;
    private final BoardInfoService infoService;
    private final BoardDeleteService deleteService;

    private final HttpServletRequest request;
    private BoardData boardData;
    private Board board;

    //게시글 목록
    @RequestMapping("/list/{bId}")
    public String list(@PathVariable("bId") String bId, BoardSearch search) {
        commonProcess(bId, "list");

        ListData<BoardData> data = infoService.getList(bId, search);
        request.setAttribute("items", data.getItems());
        request.setAttribute("pagination", data.getPagination());

        return "board/list";  // JSP 페이지로 이동
    }

    //게시글 보기
    @GetMapping("/view/{seq}")
    public String view(@PathVariable("seq") long seq){
        commonProcess(seq, "view");

        String bId = boardData.getBId();
        ListData<BoardData> data = infoService.getList(bId);
        request.setAttribute("items", data.getItems());
        request.setAttribute("pagination", data.getPagination());
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
        commonProcess(seq, "update");

        RequestBoardData data = infoService.getForm(boardData);
        request.setAttribute("data",data);

        return "board/update";
    }

    @PostMapping("/save")
    public String save(RequestBoardData form){
        String mode = form.getMode();
        String modeStr = mode.equals("update")? "수정":"등록";
        String message = "게시글" + modeStr + "에 실패하였습니다.";

        BoardData data = saveService.save(form).orElseThrow(()->new AlertException(message, HttpServletResponse.SC_BAD_REQUEST));

        //게시글 등록, 수정이 완료되면 - 게시글 보기로 이동
        String url = request.getContextPath() + "/board/view/" + data.getSeq();
        String script = String.format("parent.location.replace('%s');", url);
        request.setAttribute("script", script);

        return "commons/execute_script";
    }

    @GetMapping("/delete/{seq}")
    public String delete(@PathVariable("seq") long seq){
        commonProcess(seq, "delete");

        deleteService.delete(seq);

        return "redirect:/board/list/" + board.getBId();
        //게시글 삭제 후 이동할 화면 (해당 게시판)
    }

    /**
     * 모든 요청 처리 메서드에 공통 처리 부분
     * @param bId : 게시판 아이디가 있을 경우 게시판 설정 유지/ 게시판 아이디가 없을 경우 게시판 설정 X -> 게시판이 없음(BoardConfigNotFoundException)
     * @Param mode: 처리 모드 - write, update, list, view
     */
    //bId가 있을때마다 처리
    private void commonProcess(String bId, String mode){
        board = configInfoService.get(bId).orElseThrow(BoardConfigNotFoundException::new);

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



    /*
    * 게시글 번호가 있는 페이지 URL
    *   - 게시글 보기, 게시글 수정
    *
    * @param seq
    * @param mode
    * */
    private void commonProcess(long seq, String mode){
        boardData = infoService.get(seq).orElseThrow(BoardNotFoundException::new);
        String bId = boardData.getBId();
        commonProcess(bId, mode);
        request.setAttribute("data", boardData);
    }
}
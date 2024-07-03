package org.choongang.admin.board.controllers;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.choongang.board.controllers.BoardSearch;
import org.choongang.board.entities.Board;
import org.choongang.board.entities.BoardData;
import org.choongang.board.services.BoardInfoService;
import org.choongang.board.services.config.BoardConfigInfoService;
import org.choongang.board.services.config.BoardConfigSaveService;
import org.choongang.global.ListData;
import org.choongang.global.config.annotations.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/board")
public class BoardController {

    private final BoardConfigSaveService saveService;
    private final BoardConfigInfoService infoService;
    private final HttpServletRequest request;
    private final BoardInfoService boardInfoService;

    // 게시판 목록
    @GetMapping
    public String boardList() {

        List<Board> items = infoService.getList();
        request.setAttribute("items", items);

        return "admin/board/index";
    }

    // 게시판 등록
    @GetMapping("/register")
    public String register() {

        request.setAttribute("data", new RequestBoard());

        return "admin/board/register";
    }

    //게시글 관리
    @GetMapping("/posts")
    public String posts(BoardSearch search){
        ListData<BoardData> data;

        // search에 bId가 없으면 모든 게시글 가져오기
        if (search.getBId() == null || search.getBId().isEmpty()) {
            data = boardInfoService.getList(search);
        } else {
            data = boardInfoService.getList(search.getBId(), search);
        }

        request.setAttribute("items", data.getItems());
        request.setAttribute("pagination", data.getPagination());
        request.setAttribute("addCss", List.of("admin/posts","board/style"));
        return "admin/board/posts";
    }

    // 특정 카테고리 게시글 목록
    @GetMapping("/{bId}")
    public String categoryPosts(@PathVariable("bId") String bId, BoardSearch search) {
        ListData<BoardData> data = boardInfoService.getList(bId, search);
        request.setAttribute("items", data.getItems());
        request.setAttribute("pagination", data.getPagination());
        request.setAttribute("addCss", List.of("admin/posts","board/style"));
        return "admin/board/posts";
    }

    // 게시판 수정
    @GetMapping("/update/{bId}")
    public String update(@PathVariable("bId") String bId) {

        RequestBoard form = infoService.getForm(bId);
        request.setAttribute("data", form);

        return "admin/board/update";
    }

    @PostMapping("/save")
    public String save(RequestBoard form) {

        saveService.process(form);

        String url = request.getContextPath() + "/admin/board";
        String script = String.format("parent.location.replace('%s');", url);

        request.setAttribute("script", script);
        return "commons/execute_script";
    }
}
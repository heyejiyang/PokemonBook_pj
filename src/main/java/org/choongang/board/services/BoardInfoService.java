package org.choongang.board.services;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.choongang.board.controllers.BoardSearch;
import org.choongang.board.controllers.RequestBoardData;
import org.choongang.board.entities.Board;
import org.choongang.board.entities.BoardData;
import org.choongang.board.exceptions.BoardNotFoundException;
import org.choongang.board.mappers.BoardDataMapper;
import org.choongang.global.ListData;
import org.choongang.global.Pagination;
import org.choongang.global.config.annotations.Service;
import org.choongang.global.config.containers.BeanContainer;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardInfoService {
    private final BoardDataMapper mapper;

    /**
     * 게시글 번호로 게시글 조회
     *  - 쓰기, 수정, 목록, 보기 권한 데이터 추가
     *  - 댓글 목록 데이터 추가
     *  - 게시글에 첨부한 이미지 또는 파일 목록
     * @param seq
     * @return
     */
    public Optional<BoardData> get(long seq){
        BoardData data = mapper.get(seq);

        return Optional.ofNullable(data);
    }

    public RequestBoardData getForm(long seq){
        BoardData data = get(seq).orElseThrow(BoardNotFoundException::new);
        return getForm(seq);
    }

    public RequestBoardData getForm(BoardData data){
        RequestBoardData form = new ModelMapper().map(data,RequestBoardData.class);
        form.setMode("update");
        return form;
    }

    /*
    * 게시글 목록
    * @param search
    * @return - 조회된 목록 + 페이징
    * */
    public ListData<BoardData> getList(BoardSearch search){
        int page = Math.max(search.getPage(), 1); //페이지 수가 1보다 작은경우 1로 고정-Math.max()
        int limit = search.getLimit();
        limit = limit < 1 ? 20 : limit; //1보다 작으면 20으로 고정

        int offset = (page - 1) * limit + 1; //시작번호 1부터 시작하도록 요청
        int endRows = offset + limit; //종료번호
        search.setEndRows(endRows);

        List<BoardData> items = mapper.getList(search);

        //페이징 처리
        int total = mapper.getTotal(search);
        //(int page, int total, int ranges, int limit, HttpServletRequest request)
        HttpServletRequest request = BeanContainer.getInstance().getBean(HttpServletRequest.class);
        Pagination pagination = new Pagination(page, total, 10, limit, request);

        return new ListData<>(items, pagination);
        //데이터와 페이징
    }

    public ListData<BoardData> getList(String bId, BoardSearch search){
        search.setBId(bId);

        return getList(search);
    }

    public ListData<BoardData> getList(String bId){
        return getList(bId, new BoardSearch());
    }
}

package org.choongang.member.services;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.choongang.board.controllers.BoardSearch;
import org.choongang.board.controllers.RequestBoardData;
import org.choongang.board.entities.BoardData;
import org.choongang.board.exceptions.BoardNotFoundException;
import org.choongang.board.mappers.BoardDataMapper;
import org.choongang.global.ListData;
import org.choongang.global.Pagination;
import org.choongang.global.config.annotations.Service;
import org.choongang.global.config.containers.BeanContainer;
import org.choongang.member.controllers.RequestMyboard;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MyboardService {
    private final BoardDataMapper mapper;

    /**
     * 게시글 번호로 게시글 조회
     *      - 쓰기, 수정, 목록, 보기 권한 데이터 추가
     *      - 댓글 목록 데이터 추가
     *      - 게시글에 첨부한 이미지 또는 파일 목록
     *
     * @param seq
     * @return
     */
    public Optional<BoardData> get(long seq) {
        BoardData data = mapper.get(seq);


        return Optional.ofNullable(data);
    }


    public RequestMyboard getForm(long seq) {
        BoardData data = get(seq).orElseThrow(BoardNotFoundException::new);
        return getForm(data);
    }

    public RequestMyboard getForm(BoardData data){
        RequestMyboard form = new ModelMapper().map(data, RequestMyboard.class);
//        form.setMode("update");
        return form;
    }

    /**
     * 게시글 목록
     * @param search
     * @return - 조회된 목록 + 페이징
     */

    public ListData<BoardData> getList(BoardSearch search) {
        int page = Math.max(search.getPage(),1); //max -> 두수중에 큰 수 반환, 음수일 경우 1 반환
        int limit = search.getLimit();
        limit = limit <1 ? 20 : limit; //limit가 0일땐 20으로 고정

        int offset = (page -1) * limit +1; //시작 지점을 1로 시작할 수 있게 설정
        int endRows = offset + limit; //종료 번호
        search.setOffset(offset);
        search.setEndRows(endRows);

        List<BoardData> items = mapper.getList(search);

        //페이징 처리를 하기 위한 데이터가져오기
        /*Pagination 클래스 참고*/
        int total = mapper.getTotal(search);
        HttpServletRequest request = BeanContainer.getInstance().getBean(HttpServletRequest.class);
        Pagination pagination = new Pagination(page,total,10,limit,request);

        return new ListData<>(items, pagination);
    }

    public ListData<BoardData> getList(String bId, BoardSearch search) {
        search.setBId(bId);

        return getList(search);
    }

    public ListData<BoardData> getList(String bId){
        return getList(bId, new BoardSearch());
    }
}


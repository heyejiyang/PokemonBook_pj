package org.choongang.pokemon.controllers;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.choongang.global.ListData;
import org.choongang.global.Pagination;
import org.choongang.global.config.annotations.Controller;
import org.choongang.global.config.annotations.GetMapping;
import org.choongang.global.config.annotations.PathVariable;
import org.choongang.global.config.annotations.RequestMapping;
import org.choongang.pokemon.entities.PokemonDetail;
import org.choongang.pokemon.exceptions.PokemonNotFoundException;
import org.choongang.pokemon.services.PokemonInfoService;

import java.util.List;

@Controller
@RequestMapping("/pokemon")
@RequiredArgsConstructor
public class PokemonController {

    private final PokemonInfoService infoService;
    private final HttpServletRequest request;

    @GetMapping
    public String index(PokemonSearch search) { // PokemonSearch는 검색 조건을 담는 객체
        //index 메소드는 기본 경로(/pokemon)에 대한 GET 요청을 처리
        commonProcess();

        ListData<PokemonDetail> listData = infoService.getList(search);
        // getList 검색 조건을 기반으로 포켓몬 목록을 반환
        List<PokemonDetail> items = listData.getItems();
        // 이건 아마도 페이지 넘길 때 사용되는 메서드이다.
        Pagination pagination = listData.getPagination();

        request.setAttribute("items", items);
        request.setAttribute("pagination", pagination);

        return "pokemon/index";
    }

//{seq} 값을 받아 해당 포켓몬 상세 정보를 가져옵니다. 정보를 찾지 못하면 PokemonNotFoundException을 던짐
// 가져온 데이터를 요청 속성에 저장하고 pokemon/view 뷰를 반환
    @GetMapping("/view/{seq}")
    public String view(@PathVariable("seq") long seq) {
        commonProcess();

        PokemonDetail data = infoService.get(seq).orElseThrow(PokemonNotFoundException::new);
        // 여기로 유입이 된다. admin설정을 확인해보고 왜 여기로 유입되는지 확인해보자
        //여기서 해당 정보를 찾지 못하기 때문에 오류가 뜬다, 그렇다면 왜 정보를 찾지 못하는가?


        request.setAttribute("data", data); // 포켓몬 데이터
        request.setAttribute("addCss", new String[] {"pokemon/view"}); // 뷰 설정들

        return "pokemon/view";
    }

    private void commonProcess() {
        // commonProcess 메소드는 뷰에서 공통으로 사용될 CSS와 스크립트를 요청 속성에 저장.
        request.setAttribute("addCss", new String[] {"pokemon/style"});
        request.setAttribute("addScript", List.of("pokemon/wishlist"));
    }
}
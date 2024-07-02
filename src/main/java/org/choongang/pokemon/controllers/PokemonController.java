package org.choongang.pokemon.controllers;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.choongang.global.ListData;
import org.choongang.global.Pagination;
import org.choongang.global.config.annotations.*;
import org.choongang.member.controllers.RequestJoin;
import org.choongang.pokemon.entities.PokemonDetail;
import org.choongang.pokemon.exceptions.PokemonNotFoundException;
import org.choongang.pokemon.mappers.MyPokemonService;
import org.choongang.pokemon.services.PokemonInfoService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/pokemon")
@RequiredArgsConstructor
public class PokemonController {

    private final PokemonInfoService infoService;
    private final HttpServletRequest request;
    private final MyPokemonService pokemonService;

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


    @GetMapping("/mypokemon")
    public String mypokemon() {
        commonProcess();

        request.setAttribute("addCss", new String[] {"pokemon/mypokemon"});
        return "pokemon/mypokemon";
    }


    @GetMapping("/gacha")
    public String gacha() {
        commonProcess();

        request.setAttribute("addCss", new String[] {"pokemon/gacha"});
        return "pokemon/gacha";
    }


    @GetMapping("/gacharesult")
    public String gacharesult() {
        commonProcess();

        Optional <PokemonDetail> listData = infoService.getRandom();
        PokemonDetail items = listData.get();
        // 랜덤으로 들어오긴 하는데 서버를 껐다가 켜야만 새로운 포켓몬이 나온다.
        // 클릭할 때마다 새로운 포켓몬으로 하려면 어찌해야할까

        request.setAttribute("items", items);
        request.setAttribute("addCss", new String[] {"pokemon/gacharesult"});
        request.setAttribute("addScript", List.of("pokemon/gacharesult"));

        return "pokemon/gacharesult";
    }





    private void commonProcess() {
        // commonProcess 메소드는 뷰에서 공통으로 사용될 CSS와 스크립트를 요청 속성에 저장.
        request.setAttribute("addCss", new String[] {"pokemon/style"});
        request.setAttribute("addScript", List.of("pokemon/wishlist"));
    }
}
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>

<layout:main>
    <h1>내 포켓몬 목록</h1>

    <div class="mypokemon-buttons">
        <button type="button">
            <a href="<c:url value='/pokemon/gacha' />">오늘의 포켓몬 뽑기!</a>
        </button>
    </div>

    <ul class="pokemon-list">
        <c:if test="${empty pokemons}">
            <li class='no-data'>조회된 포켓몬이 없습니다.</li>
        </c:if>
        <c:forEach var="pokemon" items="${pokemons}">
            <div class="pokemon-item">
                <img src="${pokemon.frontImage}" alt="${pokemon.nameKr}">
                <p class="pokemonNum">No.${pokemon.seq}</p>
                <p class="pokemonName">${pokemon.nameKr}</p>
                <p class="pokemonNickname">${pokemon.nickname}</p>
            </div>
        </c:forEach>
    </ul>
</layout:main>

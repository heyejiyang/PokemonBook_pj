<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>

<layout:main>

    <img src="${items.frontImage}" alt="${items.nameKr}">
    <div class="p-name">
        <p class="pokemonNum">No.${items.seq}</p>
        <p class="pokemonName">${items.nameKr}</p>
    </div>

    <section class="gacharesult">
        <form method="post" action="<c:url value='/pokemon/mypokemon' />" autocomplete="off">
            <input type="hidden" name="seq" value="${data.seq}">
            <input type="hidden" name="pokemonId" value="${items.seq}">
            <input type="hidden" name="pokemonName" value="${items.nameKr}">
            <input type="text" name="nickname" value="${param.nickname}" placeholder="별명을 입력해주세요.">
            <button type="submit" class="btn">저장</button>
        </form>
    </section>
///
</layout:main>

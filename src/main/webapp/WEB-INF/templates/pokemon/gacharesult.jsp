<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>

<layout:main>

    <img src="${items.frontImage}" alt="${items.nameKr}">
    <div class="p-name">
        <p class="pokemonNum">No.${items.seq}</p>
        <p class="pokemonName">${items.nameKr}</p>
    </div>

    <form name="frmSearch" method="post" action="<c:url value='/pokemon/save' />" autocomplete="off">
        <input type="hidden" name="pokemonId" value="${items.seq}">
        <input type="hidden" name="pokemonName" value="${items.nameKr}">
        <input type="text" name="nickname" value="${param.skey}" placeholder="별명을 입력해주세요.">
        <div class="backToList">
            <button type="submit" class="btn">저장</button>
        </div>
    </form>

</layout:main>
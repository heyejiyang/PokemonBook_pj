<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>

<layout:main>

            <img src="${items.frontImage}" alt="${items.nameKr}">
            <div class="p-name">
                <p class="pokemonNum">No.${items.seq}</p>
                <p class="pokemonName">${items.nameKr}</p>
            </div>

            <form name="frmSearch" method="get" action="${searchUrl}" autocomplete="off">
                   <input type="text" name="skey" value="${param.skey}" placeholder="별명을 입력해주세요.">
                   <button type="submit">저장</button>
            </form>

</layout:main>
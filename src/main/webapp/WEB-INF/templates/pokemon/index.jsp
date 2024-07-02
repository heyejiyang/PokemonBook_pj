<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<%@ taglib prefix="util" tagdir="/WEB-INF/tags/utils" %>
<c:url var="searchUrl" value="/pokemon" />
<layout:main>
    <section class="layout-width">
        <div class="formWrap">
            <form name="frmSearch" method="get" action="${searchUrl}" autocomplete="off">
                <input type="text" name="skey" value="${param.skey}" placeholder="포켓몬 이름을 입력하세요.">
                <button type="submit">검색</button>
            </form>
        </div>
        <ul class="pokemon-list">
            <c:if test="${items == null || items.isEmpty()}">
                <li class='no-data'>조회된 포켓몬이 없습니다.</li>

            </c:if>
            <c:if test="${items != null && !items.isEmpty()}">
                <c:forEach var="item" items="${items}">
                    <li>
                        <a class="a" href="<c:url value='/pokemon/view/${item.seq}' />">
                            <img src="${item.frontImage}" alt="${item.nameKr}">
                        </a>
                        <div class="p-name">
                            <p class="pokemonNum">No.${item.seq}</p>
                            <p class="pokemonName">${item.nameKr}</p>
                        </div>
                    </li>
                </c:forEach>
            </c:if>
        </ul>
    </section>
    <util:pagination />
</layout:main>
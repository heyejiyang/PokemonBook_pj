<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<layout:main>
<section class="layout-width">
    <form name="frmSearch" method="get" action="${searchUrl}" autocomplete="off">
        포켓몬 검색 :
        <input type="text" name="skey" value="${param.skey}" placeholder="검색어를 입력하세요.">
        <button type="submit">검색</button>
    </form>
    <ul class="pokemon-list">
        <c:if test="${items == null || items.isEmpty()}">
            <li class='no-data'>조회된 포켓몬이 없습니다.</li>
        </c:if>
        <c:if test="${items != null && !items.isEmpty()}">
            <c:forEach var="item" items="${items}">
                <li>
                    <a href="<c:url value='/pokemon/view/${item.seq}' />">
                        <img src="${item.frontImage}" alt="${item.nameKr}">
                    </a>
                    <div class="p-name">
                         No.${item.seq}<br>
                         ${item.nameKr}
                    </div>
                </li>
            </c:forEach>
        </c:if>
    </ul>
</section>

</layout:main>
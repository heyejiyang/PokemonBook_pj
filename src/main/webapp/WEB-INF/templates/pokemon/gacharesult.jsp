<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<layout:main>
<div class="gacha_result_wrap">
        <c:choose>
            <c:when test="${not empty items}">
                <c:forEach var="item" items="${items}">
                    <div class="pokemon_detail">
                        <img src="${item.frontImage}" alt="${item.nameKr}">
                        <div class="p-name">
                            No.${item.seq}<br>
                            ${item.nameKr}
                        </div>
                        <div class="p-description">
                            ${item.description}
                        </div>
                    </div>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <div class="no-data">No Pokémon found.</div>
            </c:otherwise>
        </c:choose>
    </div>
</layout:main>
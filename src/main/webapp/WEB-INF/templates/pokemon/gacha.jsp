<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<c:url var="pokeball" value="/images/pokeball.png" />
<layout:popup>
    <div class="gacha_wrap">
        <div class="gacha_title">
            오늘의 포켓몬!
        </div>
        <a class="pokeball" href="<c:url value='/pokemon/popup' />">
            <img src="${pokeball}" alt="pokeball">
        </a>
        <div class="gacha_explain">
            몬스터볼을 클릭해주세요!
        </div>
    </div>
</layout:popup>
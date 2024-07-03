<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<c:url var="actionUrl" value="/pokemon/mypokemon" />

<layout:main title="시원초이">
    <section class="layout-width">
<div class="mypokemon-buttons">
    <button type="button">
        <a href="<c:url value='/pokemon/gacha' />" alt="TodayPokemon">오늘의 포켓몬 뽑기!</a>
    </button>
    <button type="button">
        <a href="#" alt="MyPokemon" />내 포켓몬 조회</a>
    </button>
</div>
         <form name="frmSave" method="POST" action="${actionUrl}" target="ifrmProcess" autocomplete="off">
            <dl>
             <dt>프로필 이미지</dt>
                <dd>
                    <c:if test="${myProfile != null}">
                       <div class='profile'>
                            <img src="${myProfile.frontImage}" alt="${myProfile.nameKr}">
                            <div>${myProfile.nameKr}</div>
                       </div>
                    </c:if>
                    <button type='button' id="generate-profile-image">
                    랜덤 프로필 이미지
                    </button>
                </dd>
            </dl>
        </form>
         <jsp:include page="_my_pokemon.jsp" />
    </section>
</layout:main>
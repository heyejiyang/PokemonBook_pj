<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<c:url var="popupUrl" value="/pokemon/gacha" />
<layout:main title="이진표">
    <section class="layout-width">
            <div class="button-wrapper">
                <button type='button' class="button-action" id="generate-profile-image" onclick="commonLib.popup.open('${popupUrl}', 650, 700);">
                    랜덤 포켓몬 뽑기
                </button>
            </div>
         <jsp:include page="_my_pokemon.jsp" />
    </section>
</layout:main>

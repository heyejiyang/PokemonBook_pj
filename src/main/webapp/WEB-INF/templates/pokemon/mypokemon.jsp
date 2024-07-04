<%@ page contentType="text/html; charset=UTF-8" %>


<link rel="stylesheet"
href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
crossorigin="anonymous">

<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<c:url var="popupUrl" value="/pokemon/gacha" />
<layout:main title="이진표">
    <section class="layout-width">
            <div class="button-wrapper">
                <button type='button' class="btn btn-info" id="generate-profile-image" onclick="commonLib.popup.open('${popupUrl}', 650, 700);">
                    랜덤 프로필 이미지
                </button>

            </div>
         <jsp:include page="_my_pokemon.jsp" />
    </section>
</layout:main>

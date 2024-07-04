<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>

<c:set var="heightInMeters" value="${data.height * 0.1}" />
<c:set var="weightKilogram" value="${data.weight * 0.1}" />

<layout:main title="${data.nameKr}">
    <div class="navigation-arrows">
            <a href="<c:url value='/pokemon/view/${data.seq - 1}' />" class="arrow left-arrow">
                <div class="left-arrow-box">
                     <div class="left-arrow-ex">이전 포켓몬 조회</div>
                </div>
            </a>

            <a href="<c:url value='/pokemon/view/${data.seq + 1}' />" class="arrow right-arrow">
                <div class="right-arrow-box">
                    <div class="right-arrow-ex">다음 포켓몬 조회</div>
                </div>
            </a>
    </div>
<div class="viewWrap">
    <section class="pokemon-view">
        <div class="separate">
        <div class="image_wrap">
            <img src="${data.frontImage}" alt="프론트">
        </div>
        <div class="content_wrap">
            <div class="p-name-v">
                No.${data.seq}<br>
                <span style="font-size: 50px; color: #000; font-weight: bold;">
                       ${data.nameKr}
                </span>
            </div>
            <div class="p-type">
                <c:if test="${not empty data.type1}">
                    <img src="<c:url value='/images/type/${data.type1}.png' />" alt="${data.type1}" />
                </c:if>
                <c:if test="${not empty data.type2}">
                    <img src="<c:url value='/images/type/${data.type2}.png' />" alt="${data.type2}" />
                </c:if>
            </div>
            <div class="pokemonCh">
                <p class="pokemonHeight"> 키: <fmt:formatNumber value="${heightInMeters}" type="number" minFractionDigits="1" maxFractionDigits="1" />m</p>
                <p class="pokemonWeight"> 몸무게: <fmt:formatNumber value="${weightKilogram}" type="number" minFractionDigits="0" maxFractionDigits="0" />kg</p>
            </div>
            <div class="p-desc">
                ${fn:replace(data.description, '\\n', '<br>')}
            </div><br>

            <div class="imageExplain">게임 속 이미지 </div>
            <div class="pixel">
            <img src="${data.pixelFrontImage}" alt="${item.nameKr}">
            <img src="${data.pixelBackImage}" alt="${item.nameKr}">
            </div>
            </div>
        </div>
        <div class="backToList">
              <a href="<c:url value='/pokemon' />" class="btn">
                   목록으로 돌아가기
              </a>
         </div>
    </section>
</div>
</layout:main>
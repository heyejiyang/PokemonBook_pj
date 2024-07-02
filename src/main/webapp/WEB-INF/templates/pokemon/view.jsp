<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>

<c:set var="heightPoint" value="${data.height * 0.1}" />

<!-- 공부용.
<fmt:formatNumber value="12341234" type="number"/><br>
천 단위마다 ','
<fmt:formatNumber value="1234" type="currency" currencySymbol="$"/><br>
$ 시작, 천단위마다 ','
<fmt:formatNumber value="0.35" type="percent"/><br>
% 표시
<fmt:formatNumber value="1234.1234" pattern=".00"/><br>
1234.12 pattern에 표시한 자리수만큼 반올림
<fmt:parseNumber var="test" value="1234.12" integerOnly="true"/><br>
${test} 출력시 소수점 이하 버림, 1234
-->

<c:set var="heightInMeters" value="${data.height * 0.1}" />

<layout:main title="${data.nameKr}">
    <div class="navigation-arrows">
        <c:if test="${data.seq > 1}">
        </c:if>
        <c:if test="${data.seq > 1}">
        </c:if>
        <a href="<c:url value='/pokemon/view/${data.seq - 1}' />" class="arrow left-arrow"></a>
        <a href="<c:url value='/pokemon/view/${data.seq + 1}' />" class="arrow right-arrow"></a>
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
                <p class="pokemonWeight"> 몸무게: <fmt:formatNumber value="${data.weight}" type="number" minFractionDigits="0" maxFractionDigits="0" />kg</p>
                <!-- 키: <fmt:formatNumber value="${heightInMeters}" type="number" minFractionDigits="1" maxFractionDigits="1" />m<br> -->
                <!-- 몸무게: <fmt:formatNumber value="${data.weight}" type="number" minFractionDigits="0" maxFractionDigits="0" />kg<br> -->
                <!-- 키: ${data.height * 0.1}m<br> -->
                <!-- 몸무게: ${data.weight}kg<br> -->
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
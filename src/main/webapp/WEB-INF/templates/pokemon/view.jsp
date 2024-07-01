<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>

<layout:main title="${data.nameKr}">

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
            <div class="p-desc">
                ${fn:replace(data.description, '\\n', '<br>')}
            </div>
            <div class="pokemonCh">
                키: ${data.height*0.1}m<br>
                몸무게: ${data.weight}kg<br>
            </div>
            <div class="p-type">
                    속성:
        <c:if test="${not empty data.type1}">
            <img src="<c:url value='/images/type/${data.type1}.png' />" alt="${data.type1}" />
        </c:if>
        <c:if test="${not empty data.type2}">
            <img src="<c:url value='/images/type/${data.type2}.png' />" alt="${data.type2}" />
        </c:if>
            </div>
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
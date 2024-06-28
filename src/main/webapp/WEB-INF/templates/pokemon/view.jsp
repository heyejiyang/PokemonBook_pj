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
            <div class="p-name">
                No.${data.seq}<br>
                <span style="font-size: 50px; color: #000; font-weight: bold;">
                       ${data.nameKr}
                </span>
            </div>
            <div class="p-desc">
                ${fn:replace(data.description, '\\n', '<br>')}
            </div>
            <div class="pokemonCh">
                키: <br>
                몸무게: <br>
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
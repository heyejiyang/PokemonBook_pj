<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<fmt:setBundle basename="messages.pokebook" />
<fmt:message var="pageTitle" key="도감_개별페이지"/>
<c:url var="pokebook" value="/pokebookmain" />
<c:url var="pokebooksubUrl" value="/pokebook/pokebooksub" />

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/pokebooksub.css">
<layout:main title="${pageTitle}">
<div class="subWrap">
    <div class="bookSub">
        <div class="pokemonSubWrap-top">
            <div class="pokemonBoxsub">
                    <img src="https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png" class="pokemonSub">
                </a>
            </div>
            <div class="pokemonBoxsubEx">
            </div>
        </div>
    </div>

    <div class="pokemonSubWrap-bottom">
       <div class="pokemonBoxsub2">
             <img src="https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png" class="pokemonSub2">
             </a>
        </div>

        <div class="pokemonBoxsub2">
            <img src="https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/2.png" class="pokemonSub2">
            </a>
        </div>


        <div class="pokemonBoxsub2">
            <img src="https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/3.png" class="pokemonSub2">
            </a>
        </div>
    </div>
    </div>
</layout:main>

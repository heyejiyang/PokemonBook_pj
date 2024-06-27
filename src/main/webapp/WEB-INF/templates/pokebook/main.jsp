<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<fmt:setBundle basename="messages.pokebook" />
<fmt:message var="pageTitle" key="도감_메인페이지"/>
<c:url var="pokebook" value="/main" />

<layout:main title="${pageTitle}">
    <div class="bookMain">
    <c:forEach var="i" begin="1" end="800">
        <div class="pokemonBox" >
            <section class="main-section">
                <img src="https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${i}.png" class="pokemon">
            </section>
        </div>
    </c:forEach>
    </div>
</layout:main>
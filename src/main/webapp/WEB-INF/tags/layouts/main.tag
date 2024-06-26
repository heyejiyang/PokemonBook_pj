<%@ tag body-content="scriptless" %>
<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<%@ attribute name="title" %>
<fmt:setBundle basename="messages.commons" />
<c:url var="cssUrl" value="/css/" />
<c:url var="jsUrl" value="/js/" />
<c:url var="homeUrl" value="/" />
<c:url var="searchUrl" value="/board/search" />
<c:url var="logoUrl" value="/images/book_logo11.png" />

<layout:common title="${title}">
    <jsp:attribute name="header">
        <section class="site-top">
            <nav>
                <div class="left">
                    <a href="${homeUrl}">
                        <img src="${logoUrl}" alt="<fmt:message key='홈' />">
                    </a>
                </div>
                <div class="layout-width inner">
                    <div class="dropdown">
                    <a href="#">게시판</a>
                        <ul class="dropdown-content">
                            <li><a href="#">공지사항</a></li>
                            <li><a href="#">QnA</a></li>
                        </ul>
                    </div>
                    <a href="#">도감</a>
                    <a href="<c:url value='/member/login' />">
                        <fmt:message key="로그인" />
                    </a>
                    <a href="<c:url value='/member/join' />">
                        <fmt:message key="회원가입" />
                    </a>
                </div>
            </nav>
        </section>
    </jsp:attribute>
    <jsp:attribute name="footer">
        <section class="layout-width inner">
            <div class="bottom-bar">
                포켓몬 도감 프로젝트
            </div>
            <div class="bottom-bar">
                pokebook@pokemonkorea.co.kr
            </div>
        </section>
    </jsp:attribute>
    <jsp:attribute name="commonCss">
        <link rel="stylesheet" type="text/css" href="${cssUrl}main.css">
    </jsp:attribute>
    <jsp:attribute name="commonJs">
        <script src="${jsUrl}main.js"></script>
    </jsp:attribute>
    <jsp:body>
        <jsp:doBody />
    </jsp:body>
</layout:common>
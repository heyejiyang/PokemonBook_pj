<%@ tag body-content="scriptless" %>
<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<%@ taglib prefix="util" tagdir="/WEB-INF/tags/utils" %>
<%@ attribute name="title" %>
<fmt:setBundle basename="messages.commons" />
<c:url var="cssUrl" value="/css/" />
<c:url var="jsUrl" value="/js/" />
<c:url var="homeUrl" value="/" />
<c:url var="searchUrl" value="/board/search" />
<c:url var="logoUrl" value="/images/book_logo2.png" />
<c:url var="logo4Url" value="/images/ball.png" />
<c:url var="miniLogo1Url" value="/images/mini_logo3.png" />
<c:url var="miniLogo2Url" value="/images/mini_logo4.png" />
<c:url var="miniLogo3Url" value="/images/mini_logo5.png" />
<c:url var="miniLogo4Url" value="/images/mini_logo6.png" />
<c:url var="storeUrl" value="https://www.pokemonstore.co.kr/" />

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
                    <div class="mini_logo">
                    <img src="${miniLogo1Url}"></div>
                    <div class="dropdown">
                        <a href="#">게시판</a>
                        <ul class="dropdown-content">
                            <li><a href="<c:url value="/board/list/notice"/>">공지사항</a></li>
                            <li><a href="<c:url value="/board/list/QnA"/>">QnA</a></li>
                        </ul>
                    </div>
                    <div class="mini_logo">
                        <img src="${miniLogo2Url}"></div>
                    <a href="<c:url value='/pokemon' />">도감</a>
                    <util:guestOnly>
                        <div class="mini_logo">
                            <img src="${miniLogo3Url}"></div>
                        <a href="<c:url value='/member/login' />">
                            <fmt:message key="로그인" />
                        </a>
                        <div class="mini_logo">
                            <img src="${miniLogo4Url}"></div>
                        <a href="<c:url value='/member/join' />">
                            <fmt:message key="회원가입" />
                        </a>
                    </util:guestOnly>
                        <%--
                   <fmt:message key="LOGIN_MSG">
                       <fmt:param>${loggedMember.userName}</fmt:param>
                       <fmt:param>${loggedMember.email}</fmt:param>
                   </fmt:message>
                   --%>
                    <%--
                    <c:if test="${isLogin}">
                    --%>
                    <util:memberOnly>
                        <div class="mini_logo">
                            <img src="${miniLogo3Url}"></div>
                        <a href="<c:url value='/mypage' />">
                            <fmt:message key="마이페이지" />
                        </a>
                        <div class="mini_logo">
                            <img src="${miniLogo4Url}"></div>
                        <a href="<c:url value='/member/logout' />">
                            <fmt:message key="로그아웃" />
                        </a>
                    </div>
                <div class="right">
                        <c:if test="${isAdmin}">
                            <img src="${logo4Url}" alt="<fmt:message key='로고' />">
                            <a href="<c:url value='/admin' />" target="_blank">
                                <fmt:message key="사이트_관리" />
                            </a>
                        </c:if>
                        </util:memberOnly>
                    <%--
                    </c:if>
                    --%>
                    </div>
                </nav>
        </section>
    </jsp:attribute>
    <jsp:attribute name="footer">
        <section class="layout-width inner">
            <div class="bottom-bar">
                포켓몬 도감 프로젝트
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
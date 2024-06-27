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
<c:url var="logoUrl" value="/images/book_logo1.png" />

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
                            <li><a href="<c:url value="/board/notice"/>">공지사항</a></li>
                            <li><a href="<c:url value="/board/question"/>">QnA</a></li>
                        </ul>
                    </div>
                    <a href="#">도감</a>
                    <util:guestOnly>
                        <a href="<c:url value='/member/login' />">
                            <fmt:message key="로그인" />
                        </a>
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
                    <c:if test="${isLogin}">
                        <a href="<c:url value='/mypage' />">
                            <fmt:message key="마이페이지" />
                        </a>
                        <a href="<c:url value='/member/logout' />">
                            <fmt:message key="로그아웃" />
                        </a>

                        <c:if test="${isAdmin}">
                            <a href="<c:url value='/admin' />" target="_blank">
                                <fmt:message key="사이트_관리" />
                            </a>
                        </c:if>

                    </c:if>
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
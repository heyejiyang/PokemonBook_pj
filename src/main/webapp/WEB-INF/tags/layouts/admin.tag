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
<c:url var="homeUrl" value="/admin" />
<c:url var="logoUrl" value="/images/book_logo2.png" />
<c:url var="logo2Url" value="/images/mini_logo1.jpg" />
<c:url var="logo3Url" value="/images/mini_logo2.jpg" />
<c:url var="logo4Url" value="/images/ball.png" />

<layout:common title="${title}">
    <jsp:attribute name="header">
        <div class="left">
            <a href="${homeUrl}">
                <img class="book_logo" src="${logoUrl}" alt="로고">
            </a>
        </div>
        <div class="center">
            <img class="mini_logo1" src="${logo2Url}" alt="미니로고1">
            <img class="mini_logo2" src="${logo3Url}" alt="미니로고2">
        </div>
        <div class="right">
            <img src="${logo4Url}" alt="<fmt:message key='로고' />">
            <a href="<c:url value='/member/logout' />">
                <fmt:message key="로그아웃" />
            </a>
        </div>
    </jsp:attribute>
    <jsp:attribute name="commonCss">
        <link rel="stylesheet" type="text/css" href="${cssUrl}admin/style.css">
    </jsp:attribute>
    <jsp:attribute name="commonJs">
        <script src="${jsUrl}admin/common.js"></script>
    </jsp:attribute>
    <jsp:body>
        <!-- 주 메뉴 -->
        <aside class="side-menu">
            <a href="${homeUrl}" class="menu${menuCode == '' ? ' on':''}">회원 관리</a>
            <a href="${homeUrl}/board" class="menu${menuCode == 'board' ? ' on':''}">게시판 관리</a>
            <a href="${homeUrl}/adminMypage" class="menu${menuCode == 'adminMypage' ? ' on':''}">관리자 정보</a>
        </aside>
        <!-- 내용 영역 -->
        <section class="main-content">
            <c:if test="${subMenus != null && !subMenus.isEmpty()}">
                <nav class="sub-menu">
                    <c:forEach var="menu" items="${subMenus}">
                        <a href="<c:url value='${menu[1]}' />">
                                ${menu[0]}
                        </a>
                    </c:forEach>
                </nav>
            </c:if>

            <jsp:doBody />
        </section>
    </jsp:body>

</layout:common>
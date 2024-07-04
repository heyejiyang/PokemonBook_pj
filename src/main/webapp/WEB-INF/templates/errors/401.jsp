<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="util" tagdir="/WEB-INF/tags/utils" %>
<c:url var="logoUrl" value="/images/ghost.png" />
<layout:main>
    <div class="admin401main">
        <div class="admin401">
        <div class="title401">
            <h1>ERROR: ${status} / 접근 권한이 없습니다.</h1>
            <img src="${logoUrl}" alt="<fmt:message key='로고' />" class="logo">
    <%--    <h2>${method} ${requestUrl}</h2>--%>
        </div>
        <div class="buttons401">
        <util:memberOnly>
            <button type="button" class="button401" >
                <a href="<c:url value='/' />">확인</a>
            </button>
        </util:memberOnly>
        <util:guestOnly>
            <button type="button" class="button401" >
                <a href="<c:url value='/member/login' />">로그인</a>
            </button>
        </util:guestOnly>
        </div>
        </div>
    </div>
</layout:main>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="util" tagdir="/WEB-INF/tags/utils" %>
<layout:main>
    <div class="admin401main">
        <div class="admin401">
        <div class="title401">
            <h1>ERROR: ${status} / 접근 권한이 없습니다.</h1>
    <%--    <h2>${method} ${requestUrl}</h2>--%>
        </div>
        <div class="buttons401">
        <util:memberOnly>
            <button type="button" class="button401" value="<c:url value='/' />">확인</button>
        </util:memberOnly>
        <util:guestOnly>
            <button type="button" class="button401" value="<c:url value='/member/login' />">로그인</button>
        </util:guestOnly>
        </div>
        </div>
    </div>
</layout:main>
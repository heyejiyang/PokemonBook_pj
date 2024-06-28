<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<fmt:setBundle basename="messages.commons" />
<fmt:message var="pageTitle" key="회원 관리" />
<c:url var="logoUrl" value="/images/ball.png" />
<layout:admin title="관리자 정보">

    <div class="admin_title">
        <div class="admin_title_img"><img src="${logoUrl}" alt="<fmt:message key='로고' />"></div>
        <div class="admin_title_text"><h1>관리자 마이페이지</h1></div>
    </div>
</layout:admin>
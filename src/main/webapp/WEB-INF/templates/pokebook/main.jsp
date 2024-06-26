<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<fmt:setBundle basename="messages.pokebook" />
<fmt:message var="pageTitle" key="도감_메인페이지"/>
<c:url var="pokebook" value="/main" />

<layout:main title="${pageTitle}">
    <section class=""
</layout:main>
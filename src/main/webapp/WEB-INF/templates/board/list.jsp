<%--게시판 목록
title: 게시판 이름
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>

<layout:main title="${board.BName}">
    <section class="layout-width">
        <jsp:include page="_header.jsp"/>
    </section>
        <jsp:include page="list_main.jsp"/>
    <section class="layout-width">
        <jsp:include page="_footer.jsp"/>
    </section>
</layout:main>
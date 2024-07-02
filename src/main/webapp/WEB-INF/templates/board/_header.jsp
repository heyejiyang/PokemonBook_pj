<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:url var="mainUrl" value="/"/>
<c:url var="listUrl" value="/board/list/${board.BId}"/>
<c:url var="logoUrl" value="/images/ball.png" />

<div class="page-container">
    <div class="location">

        <em>
            <a href="${mainUrl}">HOME</a>
            &gt;
            <a href="${listUrl}">${board.BName}</a>
        </em>

    </div>

    <div class="boardTitle">
        <img src="${logoUrl}" alt="<fmt:message key='로고' />">
        <h1 class="do-hyeon-regular">${board.BName}</h1>
        <img src="${logoUrl}" alt="<fmt:message key='로고' />">
    </div>
</div>
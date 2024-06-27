<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<fmt:setBundle basename="messages.commons" />
<fmt:message var="pageTitle" key='질문과답변' />
<c:url var="homeUrl" value="/" />
<c:url var="logoUrl" value="/images/ball.png" />

<link rel="stylesheet" type="text/css" href="<c:url value='/css/question.css'/>" />

<layout:main title="${pageTitle}">
    <div class="page-container">
        <div class="location_cont">
            <em><a href="${homeUrl}" class="local_home">HOME</a> &gt; 질문과답변</em>
        </div>
        <div class="sub-container">
            <div class="boardTitle">
                <img src="${logoUrl}" alt="<fmt:message key='로고' />">
                <h1>질문과답변</h1>
            </div>
        </div>
        <div class="q-list">
            <p>질문목록...</p>
            <p>질문목록...</p>
        </div>
    </div>
</layout:main>
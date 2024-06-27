<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<fmt:setBundle basename="messages.pokebook" />
<fmt:message var="pageTitle" key="도감_개별페이지"/>
<c:url var="pokebook" value="/pokebookmain" />
<c:url var="pokebooksubUrl" value="/pokebook/pokebooksub" />

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/pokebooksub.css">
<layout:main title="${pageTitle}">

</layout:main>

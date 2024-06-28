<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:url var="logoUrl2" value="/images/Pachi2.png" />
<layout:main>
    <h1>메인 페이지</h1>
    <img src="${logoUrl2}" alt="<fmt:message key='메인이미지' />">
</layout:main>
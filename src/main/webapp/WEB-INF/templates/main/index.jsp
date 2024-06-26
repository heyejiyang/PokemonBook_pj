<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<c:url var="logo2Url" value="/images/book_logo22.png" />
<layout:main>
    <img src="${logo2Url}" alt="<fmt:message key="로고2" />">
</layout:main>
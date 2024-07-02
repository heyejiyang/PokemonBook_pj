<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<fmt:message var="pageTitle" key='나의 작성글' />

<layout:main title="${pageTitle}}">
    <jsp:include page="boardlist_main.jsp"/>
<%--    <section class="layout-width">--%>
<%--        <jsp:include page="_footer.jsp"/>--%>
<%--    </section>--%>
</layout:main>
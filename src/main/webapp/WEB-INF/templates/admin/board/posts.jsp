<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<%@ taglib prefix="util" tagdir="/WEB-INF/tags/utils" %>

<layout:admin title="게시글 관리">

    <div>
        <div class='tab-menu'>
            <a href="<c:url value='/admin/board/posts' />">전체</a>
            <a href="<c:url value='/admin/board/notice' />">공지사항</a>
            <a href="<c:url value='/admin/board/QnA' />">질문과답변</a>
        </div>
    </div>

    <h2>${boardName} 전체 게시글 목록</h2> <!-- 카테고리명 표시 -->

    <section class="layout-width">
        <jsp:include page="/WEB-INF/templates/board/_footer.jsp"/>
    </section>

    <c:if test="${items != null && !items.isEmpty()}">
        <section class="view-layout-width">
            <jsp:include page="/WEB-INF/templates/board/list_main.jsp" />
        </section>
    </c:if>
</layout:admin>

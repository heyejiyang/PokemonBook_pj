<%--게시판 상세보기--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<%@ taglib prefix="util" tagdir="/WEB-INF/tags/utils" %>
<%--<c:url var="updateUrl" value="/board/update/${data.seq}" />--%>
<%--<c:url var="actionUrl" value="/board/list/${board.BId}" />--%>

<layout:main title="${board.BName}">
    <section class="layout-width">
        <jsp:include page="_header.jsp"/>
        <div class="view-layout-width">
            <div class="subject">
                <c:if test="${! empty data.category}">
                    [${data.category}]
                </c:if>
                ${data.subject}
            </div>
            <div class="poster-info">
                <div class="view-left">
                    ${data.poster}
                    (${data.memberSeq > 0 ? data.email : '비회원'})
                </div>
                <div class="view-right">
                    IP: ${data.ip} / DATE: <util:formatDate value="${data.regDt}" pattern="yyyy.MM.dd HH:mm"></util:formatDate>
                </div>
            </div>
            <div class="content">
                ${data.content}
            </div>
            <div class="btn-group">
<%--                <button type="button" class="btn" onclick="location.href='${updateUrl}'">수정하기</button>--%>
    <a class="btn" href="<c:url value="/board/write/${data.BId}"/>">글쓰기</a>
    <a class="btn" href="<c:url value="/board/update/${data.seq}"/>">수정하기</a>
    <a class="btn" href="<c:url value="/board/delete/${data.seq}"/>" onclick ="return confirm('정말 삭제하시겠습니까?');">삭제하기</a>
    <a class="btn" href="<c:url value="/board/list/${data.BId}"/>">목록으로가기</a>
<%--                <button type="button" class="btn" onclick="location.href='${actionUrl}'">목록으로 가기</button>--%>
            </div>
        </div>
    </section>

    <c:if test="${items != null && !items.isEmpty()}">
        <section>
            <jsp:include page="list_main.jsp"/>
        </section>
    </c:if>
</layout:main>
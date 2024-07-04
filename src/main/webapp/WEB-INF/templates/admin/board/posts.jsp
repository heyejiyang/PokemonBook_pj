<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<%@ taglib prefix="util" tagdir="/WEB-INF/tags/utils" %>
<c:url var="logoUrl" value="/images/ball.png" />


<layout:admin title="게시글 관리">

    <div>
        <div class='tab-menu'>
            <a href="<c:url value='/admin/board/posts' />">전체</a>
            <a href="<c:url value='/admin/board/notice' />">공지사항</a>
            <a href="<c:url value='/admin/board/QnA' />">질문과답변</a>
        </div>
    </div>

    <div class="header">
        <img src="${logoUrl}" alt="<fmt:message key='로고' />">
        <h2>게시글 목록</h2>
    </div>
    <section class="layout-width">
        <jsp:include page="/WEB-INF/templates/board/_footer.jsp"/>
    </section>

    <c:if test="${items != null && !items.isEmpty()}">
        <section>
            <ul class="list-items">
                <c:if test="${items == null || items.isEmpty()}">
                    <li class='no-data'>조회된 게시글이 없습니다.</li>
                </c:if>

                <c:if test="${items != null && !items.isEmpty()}">
                    <c:forEach var="item" items="${items}">
                        <li class="list-item">
                            <a href="<c:url value='/board/view/${item.seq}' />" class='subject'>
                                <c:if test="${! empty item.category}">
                                    <span class="item-category">[${item.category}]</span>
                                </c:if>
                                    ${item.subject}
                            </a>
                            <div class='post-info'>
                                    ${item.poster} (${item.memberSeq > 0 ? item.email : '비회원'})
                                <util:formatDate value='${item.regDt}' pattern='yyyy.MM.dd HH:mm' />
                            </div>
                        </li>
                    </c:forEach>
                </c:if>
            </ul>
            <util:pagination />
        </section>
    </c:if>

</layout:admin>

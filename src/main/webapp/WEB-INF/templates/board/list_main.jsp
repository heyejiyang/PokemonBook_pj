<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<%@ taglib prefix="util" tagdir="/WEB-INF/tags/utils" %>
<fmt:setBundle basename="messages.commons" />
<fmt:message var="pageTitle" key='질문과답변' />
<c:url var="homeUrl" value="/" />
<c:url var="logoUrl" value="/images/ball.png" />
<c:url var="writeUrl" value="/board/write/${board.BId}" />

<div class="page-container">
<c:if test="${board.activeCategory == 1 && board.categories != null && !board.categories.isEmpty()}">
<div class='tab-category'>
    | <a href="<c:url value='/board/list/${board.BId}' />" class="category-hover tab${empty param.category ? ' on':''}">전체</a> |
    <c:forEach var="category" items="${board.categories}">
        <a href="<c:url value='/board/list/${board.BId}?category=${category}' />" class="category-hover tab${param.category == category ? ' on':''}">
            ${category}
        </a> |
    </c:forEach>
</div>
</c:if>
    <table class="notice-table">
        <tr>
            <th>번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>날짜</th>
        </tr>
        <c:if test="${items != null && !items.isEmpty()}">
            <c:forEach var="item" items="${items}">
                <tr>
                    <td>
                        ${item.seq}
                    </td>
                    <td class>
                        <a href="<c:url value="/board/view/${item.seq}"/>" class="l_subject">
                        <c:if test="${! empty item.category }">
                            [${item.category}]
                        </c:if>
                            ${item.subject}
                        </a>
                    </td>
                    <td>
                        <div class="post-info">
<%--                            <c:if test="${member.userNo = null}">--%>
<%--                                ${item.poster}(알 수 없음)--%>
<%--                            </c:if>--%>
                            <c:if test="${item.memberSeq >= 0}">
                                ${item.poster}(${item.memberSeq > 0 ? item.email : "비회원"})
                            </c:if>
                        </div>
                    </td>
                    <td><util:formatDate value="${item.regDt}" pattern="yyyy.MM.dd HH:mm" /></td>
                </tr>
            </c:forEach>
        </c:if>
    </table>
    <c:if test="${items == null || items.isEmpty()}">
        <li class="no-data">조회된 게시글이 없습니다.</li>
    </c:if>
    <br>

    <c:choose>
        <c:when test="${board.BId == 'notice'}">
            <div class="btn_right_box">
                <c:if test="${isAdmin}">
                    <button type="button" class="btn_write" onclick="location.href='${writeUrl}'">
                        작성하기
                    </button>
                </c:if>
            </div>
        </c:when>
        <c:when test="${board.BId == 'QnA'}">
            <div class="btn_right_box">
                <button type="button" class="btn_write" onclick="location.href='${writeUrl}'">
                    작성하기
                </button>
            </div>
        </c:when>
        <c:otherwise>
            <!-- 기본 동작: 버튼 표시 안함 -->
        </c:otherwise>
    </c:choose>
</div>
<util:pagination />
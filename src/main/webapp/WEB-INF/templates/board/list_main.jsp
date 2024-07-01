<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<fmt:setBundle basename="messages.commons" />
<fmt:message var="pageTitle" key='질문과답변' />
<c:url var="homeUrl" value="/" />
<c:url var="logoUrl" value="/images/ball.png" />
<c:url var="writeUrl" value="/board/write/${board.BId}" />

<c:set var="currentDate" value="<%= new java.util.Date() %>" />
<c:set var="boards" value="${requestScope.boards}" />
<c:set var="currentPage" value="${requestScope.currentPage}" />
<c:set var="totalPages" value="${requestScope.totalPages}" />
<c:set var="bId" value="${requestScope.bId}" />

<div class="page-container">
    <div class="table-container">
        <table class="notice-table">
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>작성자</th>
                <th>날짜</th>
                <th>조회</th>
            </tr>
            <c:forEach var="item" items="${boards}" varStatus="status">
                <tr>
                    <td>${status.index + 1}</td>
                    <td>${item}</td>
                    <td>user ${status.index + 1}</td>
                    <td><fmt:formatDate value="${currentDate}" pattern="yyyy.MM.dd"/></td>
                    <td>${status.index + 101}</td>
                </tr>
            </c:forEach>
        </table>
        <br>
        <c:choose>
            <c:when test="${board.BId == 'notice'}">
                <c:if test="${isAdmin}">
                    <div class="btn_right_box">
                        <button type="button" class="btn_write" onclick="location.href='${writeUrl}'">
                            <strong>작성하기</strong>
                        </button>
                    </div>
                </c:if>
            </c:when>
            <c:when test="${board.BId == 'QnA'}">
                <div class="btn_right_box">
                    <button type="button" class="btn_write" onclick="location.href='${writeUrl}'">
                        <strong>작성하기</strong>
                    </button>
                </div>
            </c:when>
            <c:otherwise>
                <!-- 기본 동작: 버튼 표시 안함 -->
            </c:otherwise>
        </c:choose>

        <!-- Pagination -->
        <div class="pagination-container">
            <c:if test="${currentPage > 1}">
                <a class="pagination__button pagination__button--prev" href="${pageContext.request.contextPath}/board/list/${bId}?page=${currentPage - 1}">&lt;</a>
            </c:if>

            <div class="pagination__pages">
                <c:forEach var="i" begin="1" end="${totalPages}">
                    <a class="pagination__button ${i == currentPage ? 'pagination__button--active' : ''}" href="${pageContext.request.contextPath}/board/list/${bId}?page=${i}">
                            ${i}
                    </a>
                </c:forEach>
            </div>

            <c:if test="${currentPage < totalPages}">
                <a class="pagination__button pagination__button--next" href="${pageContext.request.contextPath}/board/list/${bId}?page=${currentPage + 1}">&gt;</a>
            </c:if>
        </div>
    </div>
</div>
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
    <div class="table-container">
        <table class="notice-table">
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>작성자</th>
                <th>날짜</th>
            </tr>
            <c:if test="${items == null || items.isEmpty()}">
                <li class="no-data">조회된 게시글이 없습니다.</li>
            </c:if>
            <c:if test="${items != null && !items.isEmpty()}">
                <c:forEach var="item" items="${items}">
                    <tr>
                        <td>
                                ${item.seq}
                        </td>
                        <td>
                            <a href="<c:url value="/board/view/${item.seq}"/>" class="l_subject">
                                ${item.subject}
                            </a>
                        </td>
                        <td>
                            <div class="post-info">
                                ${item.poster}(${item.memberSeq > 0 ? item.email : "비회원"})
                            </div>
                        </td>
                        <td><util:formatDate value="${item.regDt}" pattern="yyyy.MM.dd HH:mm"></util:formatDate></td>
                    </tr>
                </c:forEach>
            </c:if>
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
    </div>
</div>
<util:pagination />
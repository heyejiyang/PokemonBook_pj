<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<%@ taglib prefix="util" tagdir="/WEB-INF/tags/utils" %>
<fmt:setBundle basename="messages.commons" />
<fmt:message var="pageTitle" key="관리자_페이지" />
<c:url var="logoUrl" value="/images/ball.png" />
<%@ page import="java.time.format.DateTimeFormatter" %>

<layout:admin title="${pageTitle}">

    <div class="admin_title">
        <div class="admin_title_img"><img src="${logoUrl}" alt="<fmt:message key='로고' />"></div>
        <div class="admin_title_text"><h1>회원 관리</h1></div>
    </div>
    <div class="member_list" >
        <table class="member_list_table">
            <thead>
            <th>이메일</th>
            <th>이름</th>
            <th>등급</th>
            <th>가입날짜</th>
            <th>회원탈퇴</th>
            </thead>
            <tbody>
            <c:if test="${items != null && !items.isEmpty()}">
                <c:forEach var="item" items="${items}">
                    <tr>
                        <td>${item.email}</td>
                        <td>${item.userName}</td>
                        <td>${item.userType}</td>
                        <td><c:out value="${item.regDt.format(DateTimeFormatter.ofPattern('yyyy-MM-dd'))}"/></td>
                        <td><button class="delete" type="submit">삭제</button></td>
                    </tr>
                </c:forEach>
            </c:if>
            </tbody>
        </table>
        <div class="pagination"><util:pagination /></div>
    </div>
</layout:admin>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<fmt:setBundle basename="messages.commons" />
<fmt:message var="pageTitle" key="회원 관리" />
<c:url var="logoUrl" value="/images/ball.png" />
<layout:admin title="관리자 페이지">
    <c:set var="date" value="<%=new Date()%>" />
    <%@ page import="java.util.*"%>

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
            </thead>
            <tbody>
            <c:forEach var="item" begin="1" end="10">
                <tr>
                    <td>user${item}@</td>
                    <td>이름 ${item}</td>
                    <td>USER</td>
                    <td><fmt:formatDate type="date" value="${date}" pattern="yyyy.MM.dd" dateStyle="short" timeStyle="short"/></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</layout:admin>
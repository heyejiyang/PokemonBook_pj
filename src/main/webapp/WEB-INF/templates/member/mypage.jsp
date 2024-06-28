<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<fmt:setBundle basename="messages.commons" />
<fmt:message var="pageTitle" key='마이페이지' />
<c:url var="actionUrl" value="/member/mypage" />
<c:url var="modUrl" value="/member/modify" />
<%@ page import="java.time.format.DateTimeFormatter" %>

<layout:main title="${pageTitle}">

<table class="userinfo-table">
    <tr>
        <th>이메일</th>
        <td>${member.email}</td>
    </tr>
    <tr>
        <th>회원명</th>
        <td>${member.userName}</td>
    </tr>
    <tr>
        <th>회원 등급</th>
        <td>${member.userType}</td>
    </tr>
    <tr>
        <th>가입일</th>
        <td><c:out value="${member.regDt.format(DateTimeFormatter.ofPattern('yyyy-MM-dd'))}"/></td>
    </tr>
</table>
<div class="button-group">
    <button type="button">
        <a href="${modUrl}" alt="<fmt:message key="회원정보_수정하기" />">회원정보 수정하기</a>
    </button>
    <button type="button">
        <a href="#" alt="<fmt:message key="작성글_조회하기" />">작성글 조회하기</a>
    </button>
</div>
</layout:main>
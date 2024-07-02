<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<fmt:setBundle basename="messages.commons" />
<fmt:message var="pageTitle" key="관리자_정보" />
<fmt:message var="adminmodifyTitle" key="관리자_정보_수정하기" />
<c:url var="modUrl" value="/admin/adminMypage/modify" />
<%@ page import="java.time.format.DateTimeFormatter" %>
<c:url var="logoUrl" value="/images/ball.png" />
<c:url var="logo2Url" value="/images/main_logo.png" />
<layout:admin title="${pageTitle}">

    <div class="admin_title">
        <div class="admin_title_img"><img src="${logoUrl}" alt="<fmt:message key='로고' />"></div>
        <div class="admin_title_text"><h1>관리자 마이페이지</h1></div>
    </div>
    <section class="content-box">
        <div class="logo2"> <img src=${logo2Url} alt="<fmt:message key='로고' />"></div>
        <table class="admin-mypage-table">
            <tr>
                <th>이메일</th>
                <td>${loggedMember.email}</td>
            </tr>
            <tr>
                <th>회원명</th>
                <td>${loggedMember.userName}</td>
            </tr>
            <tr>
                <th>회원 등급</th>
                <td>${loggedMember.userType}</td>
            </tr>
            <tr>
                <th>가입일</th>
                <td><c:out value="${loggedMember.regDt.format(DateTimeFormatter.ofPattern('yyyy-MM-dd'))}"/></td>
            </tr>
        </table>
        <div class="admin_button">
            <button type="button">
                <a href="${modUrl}" alt="<fmt:message key="관리자_정보_수정하기" />">${adminmodifyTitle}</a>
            </button>
        </div>
    </section>
</layout:admin>
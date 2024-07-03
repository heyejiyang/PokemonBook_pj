<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<fmt:setBundle basename="messages.commons" />
<fmt:message var="adminmodifyTitle" key="관리자_정보_수정하기" />
<fmt:message var="pageTitle" key="관리자_정보_수정하기" />
<c:url var="modUrl" value="/admin/adminMypage/modify" />
<%@ page import="java.time.format.DateTimeFormatter" %>
<c:url var="logoUrl" value="/images/ball.png" />
<c:url var="logo2Url" value="/images/main_logo.png" />
<layout:admin title="${pageTitle}">
    <div class="admin_title">
        <div class="admin_title_img"><img src="${logoUrl}" alt="<fmt:message key='로고' />"></div>
        <div class="admin_title_text"><h1>${adminmodifyTitle}</h1></div>
    </div>
    <section class="content-box">
        <form name="frmModify" method="POST" action="${actionUrl}" autocomplete="off" target="ifrmProcess">
            <div class="logo2"> <img src=${logo2Url} alt="<fmt:message key='로고' />"></div>
            <table class="modify-table">
                <tr>
                    <th>
                        <span><fmt:message key="이메일" /></span>
                    </th>
                    <td>
                        <span>${loggedMember.email}</span>
                    </td>
                </tr>
                <tr>
                    <th>
                        <span><fmt:message key="비밀번호" /></span>
                    </th>
                    <td>
                        <input type="password" name="password" placeholder="<fmt:message key="변경할_비밀번호를_입력하세요"/>">
                    </td>
                </tr>
                <tr>
                    <th>
                        <span><fmt:message key="비밀번호_확인" /></span>
                    </th>
                    <td>
                        <input type="password" name="confirmPassword" placeholder="<fmt:message key="비밀번호를_다시_입력하세요"/>">
                    </td>
                </tr>
                <tr>
                    <th>
                        <span><fmt:message key="회원명"/></span>
                    </th>
                    <td>
                        <input type="text" name="userName" value="${member.userName}">
                    </td>
                </tr>
            </table>
            <div class="button-group">
                <button type="reset">
                    <fmt:message key="다시_입력하기" />
                </button>
                <button type="submit">
                    <fmt:message key="수정하기" />
                </button>
            </div>
        </form>
    </section>
</layout:admin>
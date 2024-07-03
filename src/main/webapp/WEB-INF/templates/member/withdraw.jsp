<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<fmt:setBundle basename="messages.commons" />
<fmt:message var="pageTitle" key='회원_탈퇴' />
<c:url var="actionUrl" value="/member/withdraw" />
<c:url var="logoUrl" value="/images/ball.png" />

<layout:main title="${pageTitle}">
    <section class="all-form">
        <section class="layout-form">
            <div class="withdraw-title">
                <img src="${logoUrl}" alt="<fmt:message key='로고' />">
                <h1>${pageTitle}</h1>
            </div>
            <body>
                <section class="withdraw-box">
                    <form name="frmWithdraw" method="POST" action="${actionUrl}" autocomplete="off" target="ifrmProcess">
                        <table class="withdraw-table">
                            <tr>
                                <th>
                                    <span><fmt:message key="회원명"/></span>
                                </th>
                                <td>
                                    <span>${loggedMember.userName}</span>
                                </td>
                            </tr>
                            <tr>
                                <th>
                                    <span><fmt:message key="이메일" /></span>
                                </th>
                                <td>
                                    <span>${loggedMember.email}</span>
                                        <%--<input type="text" name="email" value="${member.email}">--%>
                                </td>
                            </tr>
                            <tr>
                                <th>
                                    <span><fmt:message key="비밀번호" /></span>
                                </th>
                                <td>
                                    <input type="password" name="password" placeholder="<fmt:message key="비밀번호를_입력하세요"/>">
                                </td>
                            </tr>
                            <tr>
                                <th>
                                    <span><fmt:message key="비밀번호_확인" /></span>
                                </th>
                                <td>
                                    <input type="password" name="confirmPassword" placeholder="<fmt:message key="비밀번호를_다시_입력하세요"/>" autofocus>
                                </td>
                            </tr>

                        </table>

                        <div class="buttons">
                            <button type="reset">
                                <fmt:message key="다시_입력하기" />
                            </button>
                            <button type="submit" onclick="return confirm('정말 탈퇴하시겠습니까?')">
                                <fmt:message key="탈퇴하기" />
                            </button>
                        </div>
                    </form>
                </section>
            </body>
        </section>
</layout:main>
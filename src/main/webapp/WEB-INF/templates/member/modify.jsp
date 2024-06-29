<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<fmt:setBundle basename="messages.commons" />
<fmt:message var="pageTitle" key='회원_정보_수정' />
<c:url var="actionUrl" value="/member/modify" />
<c:url var="logoUrl" value="/images/ball.png" />

<layout:main title="${pageTitle}">
    <section class="layout-width">
        <div class="modify-title">
            <img src="${logoUrl}" alt="<fmt:message key='로고' />">
            <h1>${pageTitle}</h1>
        </div>
    <body>
    <section class="modify-box">
    <form name="frmModify" method="POST" action="${actionUrl}" autocomplete="off" target="ifrmProcess">
    <dl>
        <dt>
            <fmt:message key="이메일" />
        </dt>
        <dd>${member.email}
        <%--<input type="text" name="email" value="${member.email}">--%>
        </dd>
    </dl>
    <dl>
        <dt>
            <fmt:message key="비밀번호" />
        </dt>
        <dd>
            <input type="password" name="password" placeholder="<fmt:message key="변경할_비밀번호를_입력하세요"/>">
        </dd>
    </dl>
    <dl>
        <dt>
            <fmt:message key="비밀번호_확인" />
        </dt>
        <dd>
            <input type="password" name="confirmPassword" placeholder="<fmt:message key="비밀번호를_다시_입력하세요"/>">
        </dd>
    </dl>
    <dl>
        <dt>
            <fmt:message key="회원명"/>
        </dt>
        <dd>
            <input type="text" name="userName" value="${member.userName}">
        </dd>
    </dl>
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
    </body>
</layout:main>
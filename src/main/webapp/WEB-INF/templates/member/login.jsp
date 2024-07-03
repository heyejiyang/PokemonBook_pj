<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<fmt:setBundle basename="messages.commons" />
<fmt:message var="pageTitle" key="로그인" />
<c:url var="actionUrl" value="/member/login" />
<c:url var="joinUrl" value="/member/join" />
<c:url var="logoUrl" value="/images/book_logo1.png" />

<layout:main title="${pageTitle}">


    <section class="all-form">
        <section class="form-box">
            <section class="login-title">
            <a href="<c:url value='/' />" class="logo-img">
                    <img src="${logoUrl}" />
                </a>

                <h1>${pageTitle}</h1>
            </section>
            <form name="frmLogin" method="POST" action="${actionUrl}" target="ifrmProcess" autocomplete="off">
                <c:if test="${! empty param.redirectUrl}">
                    <input type="hidden" name="redirectUrl" value="${param.redirectUrl}">
                </c:if>
                <div class="email">
                    <input type="text" name="email" placeholder="<fmt:message key='이메일' />" autofocus value="${cookie.saveEmail != null ? cookie.saveEmail.value : ''}"
                      class="input-icon email">
                </div>
                <div class="pw">
                    <input type="password" name="password" placeholder="<fmt:message key='비밀번호' />" class="input-icon password">
                </div>
                <div class="save-email">
                    <input type="checkbox" name="saveEmail" value="true" id="saveEmail"${cookie.saveEmail != null ? ' checked':''}>
                    <label for="saveEmail">
                        <fmt:message key="이메일_기억하기" />
                    </label>
                </div>
                <div class="button-group">
                <button type="submit" class="button">
                    <p><fmt:message key="로그인" /></p>
                </button>
                </div>
                <div class="link-login">
                    <a href="${joinUrl}">
                        <fmt:message key="아직_회원이_아니신가요?" />
                        <i class="xi-angle-right"></i>
                    </a>
                </div>
            </form>
        </section>
    </section>
</layout:main>
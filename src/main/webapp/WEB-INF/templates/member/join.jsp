<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<fmt:setBundle basename="messages.commons" />
<fmt:message var="pageTitle" key='회원가입' />
<c:url var="actionUrl" value="/member/join" />
<c:url var="logoUrl" value="/images/book_logo1.png" />

<layout:main title="${pageTitle}">
    <section class="all-form">
        <section class="form-box">
            <section class="join-title">
                <img src="${logoUrl}" alt="<fmt:message key='로고' />" class="logo">
                <h1>${pageTitle}</h1>
            </section>
            <form name="frmJoin" method="POST" action="${actionUrl}" autocomplete="off" target="ifrmProcess">
                <dl>
                    <dt>
                        <fmt:message key="이메일" />
                    </dt>
                    <dd>
                        <input type="text" name="email">
                    </dd>
                </dl>
                <dl>
                    <dt>
                        <fmt:message key="비밀번호" />
                    </dt>
                    <dd>
                        <input type="password" name="password">
                    </dd>
                </dl>
                <dl>
                    <dt>
                        <fmt:message key="비밀번호_확인" />
                    </dt>
                    <dd>
                        <input type="password" name="confirmPassword">
                    </dd>
                </dl>
                <dl>
                    <dt>
                        <fmt:message key="회원명" />
                    </dt>
                    <dd>
                        <input type="text" name="userName">
                    </dd>
                </dl>
                <div class="terms">
                    <div class="tit">
                        <fmt:message key="약관_동의" />
                    </div>
                    <p class="termsContent">
                        포켓몬 도감의 회원이 되어주셔서 감사합니다!<br>
                        회원가입은 언제나 환영이지만 회원 탈퇴는 불가합니다ㅠㅠ<br>
                        한 번 회원은 영원한 회원!!<br>
                        영원히 함께해요~
                    </p>

                    <input type="checkbox" name="termsAgree" value="true" id="termsAgree">
                    <label for="termsAgree" class="agree-check">
                        <fmt:message key="약관에_동의합니다." />
                    </label>
                </div>
                <div class="button-group">
                    <button type="reset" class="button">
                        <p><fmt:message key="다시_입력하기" /></p>
                    </button>
                    <button type="submit" class="button">
                        <p><fmt:message key="가입하기" /></p>
                    </button>
                </div>
            </form>
        </section>
    </section>
</layout:main>
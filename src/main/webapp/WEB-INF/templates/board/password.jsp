<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<c:url var="logoUrl" value="/images/ghost.png" />

<layout:main title="게시글 비밀번호 확인">
    <section class="password-box">
        <div>
            <img src="${logoUrl}" alt="<fmt:message key='로고' />" class="logo">
        </div>
        <h1 class="do-hyeon-regular">게시글 비밀번호를 입력하세요.</h1>

        <form class="pw-ck" name="frmCheck" method="POST" action="<c:url value='/board/password' />" target="ifrmProcess" autocomplete="off">
            <input type="hidden" name="seq" value="${seq}">
            <input type="password" name="password">
            <button type="submit">확인하기</button>
        </form>
    </section>
</layout:main>
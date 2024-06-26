<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<fmt:setBundle basename="messages.commons" />
<fmt:message var="pageTitle" key='마이페이지' />
<c:url var="actionUrl" value="/member/mypage" />

<layout:main title="${pageTitle}">
    <section class="content-box">
        <h1>${pageTitle}</h1>
            <dl>
                <dt>
                    <fmt:message key="이메일" />
                </dt>
                <dd>
                    <div class="userInfo" alt="<fmt:message key="이메일" />"></div>
                </dd>
            </dl>
            <dl>
                <dt>
                    <fmt:message key="비밀번호" />
                </dt>
                <dd>
                    <div class="userInfo" alt="<fmt:message key="비밀번호" />" >

                    </div>>
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
            <div class="button-group">
                <button type="button">
                    <fmt:message key="회원정보_수정하기" />
                </button>
                <button type="button">
                    <fmt:message key="작성글_조회하기" />
                </button>
            </div>
    </section>
</layout:main>
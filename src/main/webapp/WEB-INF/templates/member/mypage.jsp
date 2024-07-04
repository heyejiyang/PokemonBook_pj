<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<%@ taglib prefix="util" tagdir="/WEB-INF/tags/utils" %>
<fmt:setBundle basename="messages.commons" />
<fmt:message var="pageTitle" key='마이페이지' />
<c:url var="actionUrl" value="/member/mypage" />
<c:url var="modUrl" value="/member/modify" />
<c:url var="wdUrl" value="/member/withdraw" />
<%@ page import="java.time.format.DateTimeFormatter" %>
<c:url var="logoUrl" value="/images/ball.png" />

<layout:main title="${pageTitle}">
    <section class="all-form">
        <section class="layout-form">
            <div class="mypage-title">
                <img src="${logoUrl}" alt="<fmt:message key='로고' />">
                <h1>${pageTitle}</h1>
            </div>
            <body>
                <section class="mypage-box">
                    <table class="mypage-table">
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
                            <td>${loggedMember.userType.title}</td>
                        </tr>
                        <tr>
                            <th>가입일</th>
                            <td><c:out value="${loggedMember.regDt.format(DateTimeFormatter.ofPattern('yyyy-MM-dd'))}"/></td>
                        </tr>
                    </table>
                </section>
            </body>

            <div class="buttons">

                <button type="button">
                    <a href="${modUrl}" alt="<fmt:message key="회원정보_수정하기" />">회원정보 수정하기</a>
                </button>
                <c:if test="${!isAdmin}">
                    <button type="button">
                        <a href="${wdUrl}" alt="<fmt:message key="회원_탈퇴하기" />">회원 탈퇴하기</a>
                    </button>
                    <button type="button">
                        <a href="<c:url value='/pokemon/mypokemon' />" alt="<fmt:message key="나의_포켓몬_보기" />" >나의 포켓몬 보기</a>
                    </button>
                </c:if>
            </div>
        </section>
    </section>
</layout:main>
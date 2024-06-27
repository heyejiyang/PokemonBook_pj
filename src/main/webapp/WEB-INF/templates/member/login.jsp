<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<fmt:setBundle basename="messages.commons" />
<fmt:message var="pageTitle" key="로그인" />
<c:url var="actionUrl" value="/member/login" />

<layout:main title="${pageTitle}">
    <style>
        .center-image {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 20vh; /* 필요한 경우 높이를 조정하세요 */
        }
        .center-image img {
            max-width: 13%; /* 이미지를 화면에 맞게 조정 */
            height: auto;   /* 비율 유지 */
        }
        .content-box {
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            height: 50vh;
            text-align: center; /* 필요한 경우 텍스트를 가운데 정렬 */
        }
        .center-image2 {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 20vh; /* 로그인,비밀번호 박스 높이 조정  */
        }
        .center-image2 img {
            max-width: 70%; /* 이미지를 화면에 맞게 조정 */
            height: auto;   /* 비율 유지 */
        }
    </style>

    <!-- 첫 번째 이미지 추가 및 가운데 정렬 -->
    <div class="center-image">
        <img src="${pageContext.request.contextPath}/images/poke3.png" alt="Poke Image"/>
    </div>


    <div class="content-box small">
        <h1>${pageTitle}</h1>

        <form name="frmLogin" method="POST" action="${actionUrl}" target="ifrmProcess" autocomplete="off">
            <c:if test="${! empty param.redirectUrl}">
                <input type="hidden" name="redirectUrl" value="${param.redirectUrl}">
            </c:if>

            <input type="text" name="email" placeholder="<fmt:message key='이메일' />">
            <input type="password" name="password" placeholder="<fmt:message key='비밀번호' />">
            <div class="save-email">
                <input type="checkbox" name="saveEmail" value="true" id="saveEmail">
                <label for="saveEmail">
                    <fmt:message key="이메일_기억하기" />
                </label>
            </div>
            <button type="submit">
                <fmt:message key="로그인" />
            </button>
        </form>
         <!-- 두 번째 이미지 추가 및 가운데 정렬 -->
            <div class="center-image2">
                <img src="${pageContext.request.contextPath}/images/Jirachi2.png" />
            </div>
    </div>


</layout:main>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<fmt:setBundle basename="messages.commons" />
<fmt:message var="pageTitle" key='회원가입' />
<c:url var="actionUrl" value="/member/join" />

<layout:main title="${pageTitle}">
<style>
        .center-image {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 20vh;
        }
        .center-image img {
            max-width: 13%;
            height: auto;
        }
        .content-box {
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            height: 30vh;
            text-align: center;
        }

        .center-image2 {
                   display: flex;
                   justify-content: center;
                   align-items: center;
                   height: 20vh; /* 회원가입 이메일,비밀번호 박스 높이 조정  */
               }
               .center-image2 img {
                   max-width: 30%; /* 이미지를 화면에 맞게 조정 */
                   height: auto;   /* 비율 유지 */
               }
           </style>
    </style>
 <div class="center-image">
   <img src="${pageContext.request.contextPath}/images/poke3.png" />
            </div>
    <div class="content-box small">


        <h1>${pageTitle}</h1>
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
                <div class="termsContent">약관 내용...</div>

                <input type="checkbox" name="termsAgree" value="true" id="termsAgree">
                <label for="termsAgree">
                    <fmt:message key="약관에_동의합니다." />

                </label>
            </div>
            <div class="button-group">
                <button type="reset">
                    <fmt:message key="다시입력" />
                </button>
                <button type="submit">
                    <fmt:message key="가입하기" />
                </button>
            </div>
        </form>
    </section>
      <!-- 두 번째 이미지 추가 및 가운데 정렬 -->
                <div class="center-image2">
                    <img src="${pageContext.request.contextPath}/images/bee.png" />
                </div>

</layout:main>
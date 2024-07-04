<%@ tag body-content="scriptless" %>
<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<%@ taglib prefix="util" tagdir="/WEB-INF/tags/utils" %>
<%@ attribute name="title" %>
<%@ attribute name="addScript" fragment="true" %>
<fmt:setBundle basename="messages.commons" />
<c:url var="cssUrl" value="/css/" />
<c:url var="jsUrl" value="/js/" />
<c:url var="homeUrl" value="/" />
<c:url var="searchUrl" value="/board/search" />
<c:url var="logoUrl" value="/images/book_logo2.png" />
<c:url var="logo4Url" value="/images/ball.png" />
<c:url var="miniLogo1Url" value="/images/mini_logo3.png" />
<c:url var="miniLogo2Url" value="/images/mini_logo4.png" />
<c:url var="miniLogo3Url" value="/images/mini_logo5.png" />
<c:url var="miniLogo4Url" value="/images/mini_logo6.png" />
<c:url var="storeUrl" value="https://www.pokemonstore.co.kr/" />
<c:url var="footerUrl" value="/images/ft_logo.png" />
<c:url var="store2Url" value="/images/a-store.png" />
<c:url var="sns1Url" value="/images/icon_faceb.png" />
<c:url var="sns2Url" value="/images/icon_youtube.png" />
<c:url var="sns3Url" value="/images/icon_insta.png" />
<c:url var="sns4Url" value="/images/icon_pokemon.png" />
<c:url var="sns5Url" value="https://www.facebook.com/PokemonCoKr" />
<c:url var="sns6Url" value="https://www.instagram.com/pokemon_korea_official/?igshid=OGQ5ZDc2ODk2ZA%3D%3D" />
<c:url var="sns7Url" value="https://www.youtube.com/user/PokemonKoreaInc" />

<layout:common title="${title}">
    <jsp:attribute name="header">
        <section class="site-top">
            <nav>
                <div class="left">
                    <a href="${homeUrl}">
                        <img src="${logoUrl}" alt="<fmt:message key='홈' />">
                    </a>
                </div>
                <div class="layout-width inner">
                    <div class="mini_logo">
                        <img src="${miniLogo1Url}"></div>
                    <div class="dropdown">
                        <div class="nav_title"><a onclick="alert('아래의 공지사항 또는 QnA를 선택해주세요')">게시판</a></div>
                        <ul class="dropdown-content">
                            <li><a href="<c:url value="/board/list/notice"/>">공지사항</a></li>
                            <li><a href="<c:url value="/board/list/QnA"/>">QnA</a></li>
                        </ul>
                    </div>
                    <div class="mini_logo">
                        <img src="${miniLogo2Url}"></div>
                    <div class="nav_title"><a href="<c:url value='/pokemon' />">도감</a></div>
                    <util:guestOnly>
                        <div class="mini_logo">
                            <img src="${miniLogo3Url}"></div>
                    <div class="nav_title"><a href="<c:url value='/member/login' />">
                        <fmt:message key="로그인" />
                    </a></div>
                        <div class="mini_logo">
                            <img src="${miniLogo4Url}"></div>
                    <div class="nav_title"><a href="<c:url value='/member/join' />">
                        <fmt:message key="회원가입" />
                    </a></div>
                    </util:guestOnly>
                        <%--
                   <fmt:message key="LOGIN_MSG">
                       <fmt:param>${loggedMember.userName}</fmt:param>
                       <fmt:param>${loggedMember.email}</fmt:param>
                   </fmt:message>
                   --%>
                        <%--
                        <c:if test="${isLogin}">
                        --%>
                    <util:memberOnly>
                    <div class="mini_logo">
                        <img src="${miniLogo3Url}"></div>
                    <div class="nav_title"><a href="<c:url value='/member/mypage' />">
                        <fmt:message key="마이페이지" />
                    </a></div>
                    <div class="mini_logo">
                        <img src="${miniLogo4Url}"></div>
                    <div class="nav_title"><a href="<c:url value='/member/logout' />">
                        <fmt:message key="로그아웃" />
                    </a></div>
                </div>
                <div class="right">
                        <c:if test="${isAdmin}">
                            <img src="${logo4Url}" alt="<fmt:message key='로고' />">
                            <a href="<c:url value='/admin' />" target="_blank">
                                <fmt:message key="사이트_관리" />
                            </a>
                        </c:if>
                    <c:if test="${!isAdmin}">
                            <a href="<c:url value="${storeUrl}" />" target="_blank">
                                <img class="store" src="${store2Url}" alt="<fmt:message key='로고' />">
                            </a>
                        </c:if>
                    </util:memberOnly>
                        <%--
                        </c:if>
                        --%>
                </div>
            </nav>
        </section>
    </jsp:attribute>
    <jsp:attribute name="footer">
        <section class="layout-width inner">
            <div class="bottom-bar">
                <div class="bottom1"><img src="${footerUrl}">포켓몬 도감 프로젝트</div>
                <div class="bottom2">회사 소개 | 사업내용 | 제휴안내 | 이용약관 | 개인정보처리방침 | 이메일무단수집거부 | 고객센터</div>
                <div class="bottom2">♡이용교 강사님 감사합니다 사랑합니다♡ 이번 프로젝트로 고생하셨습니다♡</div>
                <div class="bottom2">@중앙 502호 3조@</div>
            </div>
        <div class="sns">
        <div class="sns-content"><a href="<c:url value="${sns5Url}" />" target="_blank"><img src="${sns1Url}"></a></div>
        <div class="sns-content"><a href="<c:url value="${sns7Url}" />" target="_blank"><img src="${sns2Url}"></a></div>
        <div class="sns-content"><a href="<c:url value="${sns6Url}" />" target="_blank"><img src="${sns3Url}"></a></div>
            <div class="sns-content"><a href="${homeUrl}"><img src="${sns4Url}"></a></div>
        </div>
        </section>
    </jsp:attribute>
    <jsp:attribute name="commonCss">
        <link rel="stylesheet" type="text/css" href="${cssUrl}main.css">
    </jsp:attribute>
    <jsp:attribute name="commonJs">
        <script src="${jsUrl}main.js"></script>
    </jsp:attribute>
    <jsp:body>
        <jsp:doBody />
    </jsp:body>
</layout:common>
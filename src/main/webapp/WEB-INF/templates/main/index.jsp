<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<c:url var="banner1Url" value="/images/banner1.png" />
<c:url var="banner2Url" value="/images/banner2.png" />
<c:url var="banner3Url" value="/images/banner3.png" />
<c:url var="banner4Url" value="/images/banner4.png" />
<c:url var="news1Url" value="/images/new1.jpg" />
<c:url var="news2Url" value="/images/new2.jpg" />
<c:url var="news3Url" value="/images/new3.png" />
<c:url var="news4Url" value="/images/new4.png" />
<c:url var="news5Url" value="/images/new5.png" />
<c:url var="product1Url" value="/images/product1.jpg" />
<c:url var="product2Url" value="/images/product2.jpg" />
<c:url var="product3Url" value="/images/product3.png" />
<c:url var="product4Url" value="/images/product4.jpg" />
<c:url var="product5Url" value="/images/product5.png" />
<c:url var="wideBannerUrl" value="/images/wide_banner.png" />
<c:url var="ballUrl" value="/images/ball.png" />

<layout:main>
    <div class="swiper mySwiper">
        <div class="swiper-wrapper">
        <div class="swiper-slide"><img src="${banner1Url}" alt="<fmt:message key='배너' />"></div>
        <div class="swiper-slide"><img src="${banner2Url}" alt="<fmt:message key='배너' />"></div>
        <div class="swiper-slide"><img src="${banner3Url}" alt="<fmt:message key='배너' />"></div>
        <div class="swiper-slide"><img src="${banner4Url}" alt="<fmt:message key='배너' />"></div>
        </div>
        <div class="swiper-button-next"></div>
        <div class="swiper-button-prev"></div>
    </div>

    <div class="container">
        <div class="container1">
            <h2 class="do-hyeon-regular"><img src="${ballUrl}" alt="포켓볼">새로운 소식<img src="${ballUrl}" alt="포켓볼"></h2>
            <div class="content_list">
            <div class="content"><img src="${news1Url}" alt="<fmt:message key='소식1' />"><p>2024 포켓몬 카드샵 대항전 대표 선수 결원 보충 선발전 개최안내</p></div>
            <div class="content"><img src="${news2Url}" alt="<fmt:message key='소식2' />"><p>2024 코리안 리그 파이널 시즌 대회 5월 5일~6일 <br>in 서울 롯데호텔 월드</p></div>
            <div class="content"><img src="${news3Url}" alt="<fmt:message key='소식3' />"><p>Pokemon Go Plus 발매 개시</p></div>
            <div class="content"><img src="${news4Url}" alt="<fmt:message key='소식4' />"><p>팀 전략 배틀 게임 PoKeMon UNITE 공식 사이트 오픈</p></div>
            <div class="content"><img src="${news5Url}" alt="<fmt:message key='소식5' />"><p>좋은 수면 리듬을 잡아 보자! PoKeMon Sleep 절찬 배포중</p></div></div>
        </div>

    <div class="container2">
            <h2 class="do-hyeon-regular"><img src="${ballUrl}" alt="포켓볼">상품<img src="${ballUrl}" alt="포켓볼"></h2>
            <div class="content_list">
                <div class="content content2"><img src="${product1Url}" alt="<fmt:message key='상품1' />"><p>롯데 칠성 포켓몬 코코리치 출시</p></div>
            <div class="content content2"><img src="${product2Url}" alt="<fmt:message key='상품2' />"><p>포켓몬 콤부차 <br>새로운 플레이버 출시</p></div>
            <div class="content content2"><img src="${product3Url}" alt="<fmt:message key='상품3' />"><p>가면과 타입을 바꿔서 배틀하자 <br>오거폰 ex 등장</p></div>
            <div class="content content2"><img src="${product4Url}" alt="<fmt:message key='상품4' />"><p>얼려먹고 거꾸로 먹는 <br>포켓몬 야쿠르트</p></div>
            <div class="content content2"><img src="${product5Url}" alt="<fmt:message key='상품5' />"><p>처음 해보는 포켓몬 카드 게임<br> 모두 함께 배틀하자</p></div>
        </div>
    </div>
    </div>
    <div class="container3"><img src="${wideBannerUrl}" alt="<fmt:message key='긴배너' />"></div>
</layout:main>
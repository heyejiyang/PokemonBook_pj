<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>

<style>
    .center-image {
        display: flex;
        justify-content: center;
        align-items: center;
        height: 50vh;
    }
    .center-image img {
        max-width: 50%;
        height: auto;
    }
</style>

<layout:main>
    <h1></h1>

    <!-- 이미지 추가 및 가운데 정렬 -->
    <div class="center-image">
        <img src="${pageContext.request.contextPath}/images/Pachi2.png" />
    </div>

</layout:main>

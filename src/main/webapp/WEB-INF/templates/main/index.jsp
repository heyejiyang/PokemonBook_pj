<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<layout:main>
 <style>
            .center-image {
                display: flex;
                justify-content: center;
                align-items: center;
                height: 50vh; /* 필요한 경우 높이를 조정하세요 */
            }
            .center-image img {
                max-width: 50%; /* 이미지를 화면에 맞게 조정 */
                height: auto;    /* 비율 유지 */
            }
            .content-box {
                display: flex;
                flex-direction: column;
                justify-content: center;
                align-items: center;
                height: 50vh;
                text-align: center; /* 필요한 경우 텍스트를 가운데 정렬 */
            }
        </style>

        <!-- 이미지 추가 및 가운데 정렬 -->
        <div class="center-image">
            <img src="${pageContext.request.contextPath}/images/Pachi2.png" />
        </div>


        <!-- 이미지 추가 및 가운데 정렬 -->
        <div class="center-image">
            <img src="${pageContext.request.contextPath}/images/grass.jpeg" />
        </div>






</layout:main>
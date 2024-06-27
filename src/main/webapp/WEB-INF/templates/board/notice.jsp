<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<fmt:setBundle basename="messages.commons" />
<fmt:message var="pageTitle" key="공지사항" />
<c:url var="homeUrl" value="/" />
<c:url var="logoUrl" value="/images/ball.png" />

<layout:main title="${pageTitle}">

    <div class="board-area">
        <div class="location_cont">
            <em><a href="${homeUrl}" class="local_home">HOME</a> &gt; NOTICE</em>
        </div>

        <div class="boardTitle">
            <img src="${logoUrl}" alt="<fmt:message key='로고' />">
            <h1>${pageTitle}</h1>
        </div>

        <table class="notice-table">
                <tr>
                    <th>번호</th>
                    <th>제목</th>
                    <th>내용</th>
                    <th>작성자</th>
                    <th>날짜</th>
                    <th>조회</th>
                </tr>
                <c:forEach var="item" begin="1" end="10">
                    <tr>
                        <td>${item}</td>
                        <td>제목 ${item}</td>
                        <td>내용 ${item}</td>
                        <td>user ${item}</td>
                        <td>2024-06-27</td>
                        <td>100</td>
                    </tr>
                </c:forEach>
        </table>
    </div>

</layout:main>
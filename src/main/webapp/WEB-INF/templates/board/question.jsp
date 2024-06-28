<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<fmt:setBundle basename="messages.commons" />
<fmt:message var="pageTitle" key='질문과답변' />
<c:url var="homeUrl" value="/" />
<c:url var="logoUrl" value="/images/ball.png" />

<layout:main title="${pageTitle}">
    <div class="page-container">
        <div class="location_cont">
            <em><a href="${homeUrl}" class="local_home">HOME</a> &gt; 질문과답변</em>
        </div>
        <div class="boardTitle">
            <img src="${logoUrl}" alt="<fmt:message key='로고' />">
            <h1>질문과답변</h1>
        </div>
        <div class="q-list">
            <p>질문목록...</p>
            <p>질문목록...</p>
        </div>
    </div>

    <div class="search-container">
        <form class="board_search_box" method="post">
            <select name="searchType">
                <option value="TITLE" <c:out value="#"/> >제목</option>
                <option value="CONTENT">내용</option>
                <option value="WRITER">작성자</option>
            </select>
            <input type="text" id="articleKeyword" class="text" name="keyword">
            <button id="btnArticleSearch" class="btn_board_search"><em>조회</em></button>
        </form>
    </div>
</layout:main>
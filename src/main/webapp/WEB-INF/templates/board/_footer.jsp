<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:url var="mainUrl" value="/"/>
<c:url var="listUrl" value="/board/list/${board.BId}"/>

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
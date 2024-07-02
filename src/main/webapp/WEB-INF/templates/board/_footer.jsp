<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:url var="mainUrl" value="/"/>
<c:url var="searchUrl" value="/board/list/${board.BId}"/>

<div class="search-container">
    <form class="board_search_box" name="frmSearch" method="get" autocomplete="off">
        <c:if test="${! empty param.category}">
            <input  type="hidden" name="category" value="${param.category}">
        </c:if>
        <select name="sopt">
            <option value="ALL"${param.sopt == 'ALL' || empty param.sopt ? ' selected':''}>통합검색</option>
            <option value="SUBJECT"${param.sopt == 'SUBJECT' ? ' selected':''}>제목</option>
            <option value="CONTENT"${param.sopt == 'CONTENT' ? ' selected':''}>내용</option>
            <option value="SUBJECT_CONTENT${param.sopt == 'SUBJECT_CONTENT' ? ' selected':''}">제목+내용</option>
            <option value="NAME"${param.sopt == 'NAME' ? ' selected':''}>이름</option>
        </select>
        <input type="text" id="articleKeyword" class="text" name="skey" value="${param.skey}" placeholder="검색어를 입력하세요.">
        <button id="btnArticleSearch" class="btn_board_search" type="submit">조회</button>
    </form>
</div>

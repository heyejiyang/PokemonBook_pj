<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<fmt:setBundle basename="messages.commons" />
<fmt:message var="pageTitle" key="공지사항" />
<c:url var="homeUrl" value="/" />
<c:url var="logoUrl" value="/images/ball.png" />
<c:set var="date" value="<%=new Date()%>" />

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
                        <td><fmt:formatDate type="date" value="${date}" pattern="yyyy.MM.dd" dateStyle="short" timeStyle="short"/></td>
                        <td>${item+100}</td>
                    </tr>
                </c:forEach>
        </table>
    </div>
    <div class="search">
        <select name="searchType">
            <option value="TITLE">제목</option>
            <option value="CONTENT">내용</option>
            <option value="WRITER">작성자</option>
        </select>
        <form class="search-box" method="GET" action="${searchUrl}" autocomplete="off">
            <input type="text" name="keyword" placeholder="<fmt:message key='검색어를_입력하세요.' />">
            <button type="submit">
                <i class="xi-search"></i>
            </button>
        </form>
    </div>

</layout:main>
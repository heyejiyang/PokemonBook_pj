<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<c:url var="actionUrl" value="/admin/board/save"/>
<c:url var="logoUrl" value="/images/ball.png" />

<%--mode에 따라서 등록인지 수정인지 구분
<jsp:include page="_form.jsp"/> -> 공유 할 부분임
--%>

<layout:admin title="게시판 등록">
    <div class="admin_title">
        <div class="admin_title_img"><img src="${logoUrl}" alt="<fmt:message key='로고' />"></div>
        <div class="admin_title_text"><h1>게시판 등록</h1></div>
    </div>
    <form name="frmSave" method="post" action="${actionUrl}" target="ifrmProcess" autocomplete="off">
        <input type="hidden" name="mode" value="register">
        <jsp:include page="_form.jsp"/>

        <div class="button-group">
            <button type="submit" class="button">
                <p class="btnText">등록하기</p>
                <div class="btnTwo">
                    <p class="btnText2"> ✔ </p>
                </div>
            </button>

            <button type="reset" class="button">
                <p class="btnText">다시입력</p>
                <div class="btnTwo">
                    <p class="btnText2"> ↺ </p>
                </div>
            </button>
        </div>
    </form>
</layout:admin>
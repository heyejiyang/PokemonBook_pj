<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<c:url var="actionUrl" value="/admin/board/save"/>

<%--mode에 따라서 등록인지 수정인지 구분
<jsp:include page="_form.jsp"/> -> 공유 양식 부분
--%>

<layout:admin title="게시판 수정">
    <h1>게시판 수정</h1>
    <form name="frmSave" method="post" action="${actionUrl}" target="ifrmProcess" autocomplete="off">
        <input type="hidden" name="mode" value="update">
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
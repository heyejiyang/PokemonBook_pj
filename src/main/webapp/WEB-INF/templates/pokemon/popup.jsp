<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<layout:popup>
    <section class="popup-view">
    <div class="background">
    <form method="post" action="<c:url value='/pokemon/popup' />" autocomplete="off" target="ifrmProcess">
        <input type="hidden" name="seq" value="${data.seq}">
        <img src="${data.frontImage}" alt="${data.nameKr}">
    </div>
    <div class="popup_explain">
        <div class="no">
        No.${data.seq}
        ${data.nameKr}</div>
        <p class="ex">${fn:replace(data.description, '\\n', '<br>')}</p>
    </div>
        <button type='submit' class="popup-button">확인</button>
    </section>
    </form>
</layout:popup>
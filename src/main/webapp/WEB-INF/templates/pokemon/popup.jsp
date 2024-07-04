<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<layout:popup>
    <section class="popup-view">
    <form method="post" action="<c:url value='/pokemon/popup' />" autocomplete="off" target="ifrmProcess">
        <input type="hidden" name="seq" value="${data.seq}">
        <img src="${data.frontImage}" alt="${data.nameKr}">
        <div>No.${data.seq}</div>
        <div>${data.nameKr}</div>
        <div>${fn:replace(data.description, '\\n', '<br>')}</div>
        <button type='submit'>저장</button>
    </form>
    </section>
</layout:popup>
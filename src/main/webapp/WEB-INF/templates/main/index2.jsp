<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:url var="logoUrl3" value="/images/grass.jpeg" />
<link rel="stylesheet" type="text/css" href="${cssUrl}css/mainimg2.css">

<layout:main>
    <h1></h1>
      <div class="image-container">
   <img src="${logoUrl3}" alt="<fmt:message key='메인이미지' />" class="center-image">
    </div>
</layout:main>
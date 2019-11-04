<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<html>
<head>

    <title>BookData</title>
    <link href="${pageContext.request.contextPath }/resources/css/style.css"
          rel="stylesheet" type="text/css">


</head>
<body>
<jsp:include page="menu.jsp"/>
<h1>Организации</h1>

<table class="tg">
    <tr>
        <th width="80">ID</th>
        <th width="120">Title</th>
        <th width="120">Author</th>
        <th width="120">Price</th>
    </tr>
    <tr>
        <td>${rekvizity.id}</td>
        <td>${rekvizity.nameOrganization}</td>
        <td>${rekvizity.rekvizitOrganization}</td>
        <td>${rekvizity.phoneOrganization}</td>
    </tr>
</table>
</body>
</html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<html>
<head>
    <title>Справочник</title>
    <link href="${pageContext.request.contextPath }/resources/css/style.css"
          rel="stylesheet" type="text/css">
</head>
<body>
<jsp:include page="menu.jsp"/>
<h1>Реквизиты и телефоны организации</h1>

<c:if test="${!empty  listOrganization}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Название</th>
            <th width="120">Реквизиты</th>
            <th width="120">Телефоны</th>
            <th width="60">Исправить</th>
            <th width="60">Удалить</th>
            <th width="60">Добавить в ворд</th>
        </tr>
        <c:forEach items="${ listOrganization}" var="rekvizity">
            <tr>
                <td>${rekvizity.id}</td>
                <td><a href="/organizationdata/${rekvizity.id}" target="_blank">${rekvizity.nameOrganization}</a></td>
                <td>${rekvizity.rekvizitOrganization}</td>
                <td>${rekvizity.phoneOrganization}</td>
                <td><a href="<c:url value='../edit/${rekvizity.id}'/>">Исправить</a></td>
                <td><a href="<c:url value='../remove/${rekvizity.id}'/>">Удалить</a></td>
                <td><a href="<c:url value='../addword/${rekvizity.id}'/>">Добавить в ворд</a></td>

            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
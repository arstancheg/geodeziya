<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>

<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/hide.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/smetaspisok.js" charset="utf-8"></script>
<link
        href="${pageContext.request.contextPath }/resources/css/themes/base/jquery.ui.all.css"
        rel="stylesheet" type="text/css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.0/jquery.validate.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.0/additional-methods.js"></script>
<link href="${pageContext.request.contextPath }/resources/css/style.css"
      rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath }/resources/css/screen.css"
      rel="stylesheet" type="text/css">
<script type="text/javascript">
    $(document).ready(function () {
        $('#nameOrg').autocomplete({
            source: '${pageContext.request.contextPath }/search',

        });
    });

</script>
<head>
    <title>Задания на проектирование</title>


</head>
<body>
<jsp:include page="menu.jsp"/>

<br/>
<br/>


<h1>Задания на проектирование</h1>

<c:if test="${!empty  listZadaniya}">
    <table class="tg">
        <tr>

            <th width="120">ID</th>

            <th width="120">Объект</th>
            <th width="60">Изменить</th>
            <th width="60">Скопировать</th>
            <th width="60">Удалить</th>

        </tr>
        <c:forEach items="${listZadaniya}" var="zadaniya">
            <tr>

                <td><a href="/editzadanie/${zadaniya.id}" target="_blank">${zadaniya.id}</a></td>

                <td>${zadaniya.nameObject}</td>
                <td><a href="<c:url value='/editzadanie/${zadaniya.id}'/>">Изменить</a></td>
                <td><a href="<c:url value='/copyzadanie/${zadaniya.id}'/>">Скопировать</a></td>
                <td><a href="<c:url value='/removezadanie/${zadaniya.id}'/>">Удалить</a></td>


            </tr>
        </c:forEach>
    </table>

</c:if>
</body>
</html>


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
    <title>Справочник</title>


</head>
<body>
<jsp:include page="menu.jsp"/>

<br/>
<br/>




<h1>Добавить организацию в справочник</h1>

<c:url var="addAction" value="/organizacii/add" />

<form:form action="${addAction}" modelAttribute="rekvizity"  method="get">
    <table>
        <c:if test="${!empty rekvizity.nameOrganization}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="id"/>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="nameOrganization">
                    <spring:message text="Название организации"/>
                </form:label>
            </td>
            <td>
                <form:textarea path="nameOrganization"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="rekvizitOrganization">
                    <spring:message text="Реквизиты организации"/>
                </form:label>
            </td>
            <td>
                <form:textarea path="rekvizitOrganization"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="phoneOrganization">
                    <spring:message text="Телефоны организации"/>
                </form:label>
            </td>
            <td>
                <form:textarea path="phoneOrganization"/>
            </td>
        </tr>
        <p>
            <form:label path="position">
                <spring:message text="Должность:"/>
            </form:label>

            <form:select path="position" id="dolzhnost" onchange="drugayaDolzhnost()">
                <form:option value="Директор">Директор</form:option>
                <form:option value="Зам. директора">Зам. директора</form:option>
                <form:option value="И.о. директора">И.о. директора</form:option>
                <form:option value="Управляющий">Управляющий</form:option>
                <form:option value="drugaya">другая должность</form:option>
            </form:select>
            <span style="display: none" id="spdrugayadolzhnost"> Другая должность: <input  type="text"
                                                                                     id="drugayadolzhnost"
            /></span>
            <form:label path="fullName">
                <spring:message text="ФИО:"/>
            </form:label>
            <form:input path="fullName" id="fio" name="fio"/>
        </p>
            <%--в родительном падеже--%>
        <p>
            <form:label path="positionRodPadezh">
                <spring:message text="Должность в родительном падеже (кого?):"/>
            </form:label>

            <form:select path="positionRodPadezh" id="dolzhnostrod" onchange="drugayaDolzhnostRod()">
                <form:option value="директора">директора</form:option>
                <form:option value="зам. директора">зам. директора</form:option>
                <form:option value="и.о. директора">и.о. директора</form:option>
                <form:option value="управляющего">управляющего</form:option>
                <form:option value="drugayarod">другая должность</form:option>
            </form:select>
            <span style="display: none" id="spdrugayadolzhnostrod"> Другая должность: <input  type="text"  id="drugayadolzhnostrod"
            /></span>
            <form:label path="fullNameRodPadezh">
                <spring:message text="ФИО в родительном падеже (кого?):"/>
            </form:label>
            <form:input path="fullNameRodPadezh" id="fio" name="fio"/>
        </p>
        <tr>
            <td colspan="2">
                <c:if test="${!empty rekvizity.nameOrganization}">
                    <input type="submit"
                           value="<spring:message text="Редактирвоать организацию"/>"/>
                </c:if>
                <c:if test="${empty rekvizity.nameOrganization}">
                    <input type="submit"
                           value="<spring:message text="Добавить организацию"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>

<h3>Поиск по названию организации</h3>

<form action="organizationdatasearch" method="get">
   <input type="text" id="nameOrg" name="nameOrganization"/>
    <input type="submit"
           value="<spring:message text="Найти организацию"/>"/>

</form>

<%--<form:form action="${addActionSearch}" commandName="rekvizity">
<form:input type="text" id="productName" name="productName" path="name_organization" />
    <c:if test="${empty rekvizity.name_organization}">
        <input type="submit"
               value="<spring:message text="Найти организацию"/>"/>
    </c:if>
</form:form>--%>
<%--<script>
    $("#country").autocomplete("../../getdata.jsp");
</script>--%>
<h1>Список организаций</h1>

<c:if test="${!empty  listOrganization}">
    <table class="tg">
        <tr>

            <th width="120">Название</th>
            <th width="120">Должность</th>
            <th width="120">ФИО</th>
            <th width="120">Реквизиты</th>
            <th width="120">Телефоны</th>
            <th width="60">Исправить</th>
            <th width="60">Удалить</th>

        </tr>
        <c:forEach items="${ listOrganization}" var="rekvizity">
            <tr>

                <td><a href="/organizationdata/${rekvizity.id}" target="_blank">${rekvizity.nameOrganization}</a></td>
                <td>${rekvizity.position}</td>
                <td>${rekvizity.fullName}</td>
                <td>${rekvizity.rekvizitOrganization}</td>
                <td>${rekvizity.phoneOrganization}</td>
                <td><a href="<c:url value='/edit/${rekvizity.id}'/>">Исправить</a></td>
                <td><a href="<c:url value='/remove/${rekvizity.id}'/>">Удалить</a></td>


            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>

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
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/geo.js"></script>
<link
        href="${pageContext.request.contextPath }/resources/css/themes/base/jquery.ui.all.css"
        rel="stylesheet" type="text/css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.0/jquery.validate.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/messages_ru.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.0/additional-methods.js"></script>
<link href="${pageContext.request.contextPath }/resources/css/style.css"
      rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath }/resources/css/screen.css"
      rel="stylesheet" type="text/css">

<script type="text/javascript">
    $(document).ready(function () {
        $('#nameOrganization').autocomplete({
            source: '${pageContext.request.contextPath }/search',

        });
    });

    function getIdOrganization() {
        $.ajax({
            url: '${pageContext.request.contextPath }/searchid',
            dataType: 'html',
            data: 'nameOrg=' + $('#nameOrganization').val(),
            success: function (data) {
                $('#idOrganization').val(data);

            }
        });
    };
</script>
<script>

    $().ready(function () {


        // validate signup form on keyup and submit
        $("#geodeziyaYur").validate({
            rules: {
                numberContract: "required",

                object: "required",
                dataDogovara: "required",
                dataAct: "required",

                srok: {
                    required: true,
                    digits: true
                },
                polevoiTarif: {
                    required: true,
                    number: true
                },
                kamerTarif: {
                    required: true,
                    number: true
                },
                obem: {
                    required: true,
                    number: true
                },

                transportnye: {
                    required: true,
                    number: true
                },

            },
            messages: {


            }
        });


    });


</script>
<head>
    <title>Создать договор</title>

    <style type="text/css">

    </style>
</head>
<body>
<jsp:include page="menu.jsp"/>

<br/>
<br/>

<h1>Добавить договор</h1>


<c:url var="addActionGeoYur" value="/addgeoyur/add"/>

<form:form action="${addActionGeoYur}" modelAttribute="geodeziyaYur" method="get">
    <table>
        <c:if test="${!empty geodeziyaYur.id}">
            <tr style="display: none">
                <td>

                </td>
                <td>
                    <form:input path="id" readonly="true" size="8" disabled="true" cssStyle="display: none"/>
                    <form:hidden path="id"/>
                </td>
            </tr>
        </c:if>

        </tr>
        <tr>
            <td align="right">
                Поиск заказчика по БД:</td>
            <td><input type="text" id="nameOrganization" onchange="getIdOrganization()"/>
                <form:hidden path="rekvizity.id"  id="idOrganization"/>

                <input type="button" value="Добавить нового в справочник" onClick="opwin('organizacii')"></td>
        </tr>
        <tr>
            <td align="right">
                <form:label path="nameObject">
                    <spring:message text="Наименование объекта:"/>
                </form:label></td>
            <td>

                <form:input path="nameObject" type="text" name="object" id="object" cssStyle="width:400px"/>
            </td>
        </tr>


        <tr>
            <td align="right">
                <form:label path="nomerDogovara">
                    <spring:message text="Номер договора:"/>
                </form:label></td>
            <td>

                <form:input path="nomerDogovara" type="text" name="nomerDogovara" id="nomerDogovara"/>
            </td>
        </tr>


        <tr>
            <td align="right">
                <form:label path="dataDogovara">
                    <spring:message text="Дата договора:"/>
                </form:label></td>
            <td>

                <form:input path="dataDogovara" type="date" name="dataDogovara" id="dataDogovara"/>
            </td>
        </tr>

        <tr>
            <td align="right">
                <form:label path="srok">
                    <spring:message text="Срок:"/>
                </form:label></td>
            <td>

                <form:input path="srok" type="text" name="srok" id="srok" value="30"/>
            </td>
        </tr>
        <tr>
            <td align="right">
                <form:label path="polevoiTarif">
                    <spring:message text="Полевой тариф:"/>
                </form:label></td>
            <td>

                <form:input path="polevoiTarif" type="text" name="polevoiTarif" id="polevoiTarif" value="181.9"/>
            </td>
        </tr>
        <tr>
            <td align="right">
                <form:label path="kamerTarif">
                    <spring:message text="Камеральный тариф:"/>
                </form:label></td>
            <td>

                <form:input path="kamerTarif" type="text" name="kamerTarif" id="kamerTarif" value="59.0"/>
            </td>
        </tr>


        <tr>
            <td align="right">
                <form:label path="obem">
                    <spring:message text="Объем:"/>
                </form:label></td>
            <td>

                <form:input path="obem" type="text" name="obem" id="obem"/>
            </td>
        </tr>

        <tr>
            <td align="right">
                Расстояние до участка
            <td>
                <input id="rasstoyanie" type="text">

            </td>
        </tr>
        <tr>
            <td align="right">
                <form:label path="transportnye">
                    <spring:message text="Транспортные:"/>
                </form:label></td>
            <td>

                <form:input path="transportnye" type="text" name="transportnye" id="transportnye"/>
            </td>
        </tr>

        <tr>
            <td align="right">
                <form:label path="zimnUdorozhanie">
                    <spring:message text="Зимнее удорожание:"/>
                </form:label></td>
            <td>

                <form:select path="zimnUdorozhanie" name="zimnUdorozhanie">
                    <form:option value="1.0">1.0</form:option>
                    <form:option value="1.3">1.3</form:option>

                </form:select>
            </td>
        </tr>

        <tr>
            <td align="right">
                <form:label path="koefPerescheta">
                    <spring:message text="Коэффициент пересчета:"/>
                </form:label></td>
            <td>

                <form:input path="koefPerescheta" type="text" name="koefPerescheta" id="koefPerescheta"/>
            </td>
        </tr>

        <tr>
            <td align="right">
                <form:label path="dataAct">
                    <spring:message text="Акт от:"/>
                </form:label></td>
            <td>

                <form:input path="dataAct" type="date" name="dataAct" id="dataAct"/>
            </td>
        </tr>

    </table>


    <p><br>
        <c:if test="${!empty geodeziyaYur.id }">
            <input type="submit"
                   value="<spring:message text="Добавить"/>"/>
        </c:if>
        <c:if test="${empty geodeziyaYur.id}">
            <input type="submit"
                   value="<spring:message text="Редактировать"/>"/>
        </c:if>
    </p>
</form:form>

<h1>Договоры</h1>

<c:if test="${!empty  listGeodeziyaYur}">
    <table class="tg">
        <tr>
            <th width="40">ID</th>
            <th width="120">Название</th>
            <th width="120">Дата</th>

            <th width="120">Заказчик</th>

            <th width="60">Исправить</th>
            <th width="60">Удалить</th>
            <th width="60">Добавить в ворд</th>
        </tr>
        <c:forEach items="${listGeodeziyaYur}" var="geodeziya">
            <tr>
                <td>${geodeziya.id}</td>
                <td><a href="/editgeoyur/${geodeziya.id}" target="_blank">${geodeziya.nameObject}</a></td>
                <td>${geodeziya.dataDogovara}</td>

                <td>${geodeziya.rekvizity.nameOrganization}</td>

                <td><a href="<c:url value='/editgeoyur/${geodeziya.id}'/>">Исправить</a></td>
                <td><a href="<c:url value='/removegeoyur/${geodeziya.id}'/>">Удалить</a></td>
                <td><a href="<c:url value='/addgeowordyur/${geodeziya.id}'/>" target="_blanc">Добавить в ворд</a></td>

            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>

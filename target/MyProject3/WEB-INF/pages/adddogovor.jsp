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
        $("#dogovor").validate({
            rules: {
                numberContract: "required",
                dateBegin: "required",
                nameContact: {
                    required: true,
                    minlength: 2
                },
                fullName: {
                    required: true,
                    pattern: "[А-ЯЁ][а-яё-]{1,30} [А-ЯЁ].[А-ЯЁ]."
                },

            },
            messages: {
                numberContract: "Введите номер договора",
                dateBegin: "Ведите дату начала",
                nameContact: {
                    required: "Введите название договора",
                    minlength: "Слимшком короткое название договора"
                },
                fullName: {
                    required: "Введите Фамилию И.О.",
                    pattern: "Не соответсвует формату \"Фамилия И.О.\""
                }

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


<c:url var="addActionDogovor" value="/adddogovor/add"/>

<form:form action="${addActionDogovor}" modelAttribute="dogovor" method="get">
    <c:if test="${!empty dogovor.numberContract}">
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
    <p>
        <form:select path="expertise" name="expertiza">
            <form:option value="С экспертизой">С экспертизой</form:option>
            <form:option value="Без экспертизы">Без экспертизы</form:option>
            <form:option value="Частное лицо">Частное лицо</form:option>
        </form:select>
        <form:label path="numberContract">
            <spring:message text="Номер договора"/>
        </form:label>
        <form:input path="numberContract" name="numberContract"/>
        <form:label path="nameContact">
            <spring:message text="Наименование:"/>
        </form:label>

        <form:input path="nameContact" name="nameContact"/>
    </p>
    <p>

        Заказчик: <input type="text" id="nameOrganization" onchange="getIdOrganization()"/>
            <form:hidden path="rekvizity.id" value="-1" id="idOrganization"/>

        <input type="button" value="Добавить нового" onClick="opwin('organizacii')">


    <p>
        <form:label path="dateBegin">
            <spring:message text="Дата начала выполнения работ:"/>
        </form:label>
        <form:input path="dateBegin" type="date" name="date_begin" id="date_begin"/>
    </p>
    <p>

        <label>
            <form:radiobutton path="dateTerm" name="date_end_dogovor" value="1" id="date_1"
                              onclick="hideFieldsDateEnd(true)"/>
            Дата окончания</label>
        <label>
            <form:radiobutton path="dateTerm" name="date_end_dogovor" value="0" id="date_0"
                              onclick="hideFieldsDateEnd(false)"/>
            Срок окончания</label>
    </p>
    <div id="date_okonchaniya" style="display:none">
        <p>
            <form:label path="dateEnd">
                <spring:message text="Дата окончания выполнения работ:"/>
            </form:label>

            <form:input path="dateEnd" type="date" name="date_end" id="date_end"/>
        </p>
    </div>
    <div id="srok_okonchaniya" style="display:none">

        <p>
            <form:label path="termEnd">
                <spring:message text="Срок окончания выполнения работ:"/>
            </form:label>

            <form:input path="termEnd" type="number" name="srok" id="srok"/>
            <form:select path="kindDays" name="vid_dnei" id="vid_dnei">
                <form:option value="банковских дней">банковских дней</form:option>
                <form:option value="календарных дней">календарных дней</form:option>

            </form:select>
        </p>
    </div>
    <p>Аванс:
        <label>
            <form:radiobutton path="prepayment" name="avans" value="1" id="avans_0"
                              onclick="hideFieldsAvans(true)"/>
            Есть</label>
        <label>
            <form:radiobutton path="prepayment" name="avans" value="0" id="avans_1"
                              onclick="hideFieldsAvans(false)"/>
            Нет</label>
    </p>
    <div id="avans_yes" style="display:none">
        <p>
            <form:label path="startCondition">
                <spring:message text="Начало:"/>
            </form:label>

            <form:select path="startCondition" id="prepayment_yes_begin" onchange="myOptionStartConditionYes()">
                <form:option value="с момента авансирования">с момента авансирования</form:option>
                <form:option value="с момента авансирования и передачи полного пакета исходных данных">с момента
                    авансирования и передачи полного пакета исходных данных
                </form:option>
                <form:option
                        value="с момента авансирования (без учета прохождения государственной экспертизы)">с момента
                    авансирования (без учета прохождения государственной экспертизы)
                </form:option>
                <form:option value="myoption">свой вариант</form:option>
            </form:select>
        </p>
    </div>
    <div id="avans_no" style="display:none">
        <form:label path="startCondition">
            <spring:message text="Начало:"/>
        </form:label>
        <form:select path="startCondition" id="prepayment_no_begin" onchange="myOptionStartConditionNo()">

            <form:option
                    value="с момента передачи полного пакета исходных данных">с момента передачи полного пакета исходных
                данных
            </form:option>
            <form:option
                    value="с момента передачи полного пакета исходных данных (без учета прохождения государственной экспертизы)">
                с момента передачи полного пакета исходных данных (без учета прохождения государственной экспертизы)
            </form:option>
            <form:option value="myoption">свой вариант</form:option>
        </form:select>
    </div>
    <span id="avans_my_option" style="display:none">
     Свой вариант начала:    <form:input path="startCondition" id="myoptionstart"/>
    </span>

    <p><br>
        <c:if test="${!empty dogovor.nameContact}">
            <input type="submit"
                   value="<spring:message text="Редактировать договор"/>"/>
        </c:if>
        <c:if test="${empty dogovor.nameContact}">
            <input type="submit"
                   value="<spring:message text="Добавить договор"/>"/>
        </c:if>
    </p>
</form:form>

<h1>Договоры</h1>

<c:if test="${!empty  listDogovor}">
    <table class="tg">
        <tr>
            <th width="40">ID</th>
            <th width="120">Название</th>
            <th width="120">Дата начала</th>
            <th width="120">Дата окончания</th>
            <th width="120">Заказчик</th>
            <th width="30">Аванс</th>
            <th width="60">Исправить</th>
            <th width="60">Удалить</th>
            <th width="60">Добавить в ворд</th>
        </tr>
        <c:forEach items="${ listDogovor}" var="dogovor">
            <tr>
                <td>${dogovor.id}</td>
                <td><a href="/editdogovor/${dogovor.id}" target="_blank">${dogovor.nameContact}</a></td>
                <td>${dogovor.dateBegin}</td>
                <td>${dogovor.dateEnd}</td>
                <td>${dogovor.rekvizity.nameOrganization}</td>
                <td>${dogovor.prepayment}</td>
                <td><a href="<c:url value='/editdogovor/${dogovor.id}'/>">Исправить</a></td>
                <td><a href="<c:url value='/removedogovor/${dogovor.id}'/>">Удалить</a></td>
                <td><a href="<c:url value='/addword/${dogovor.id}'/>" target="_blanc">Добавить в ворд</a></td>

            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>

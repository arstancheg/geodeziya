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


<script>

    $().ready(function () {


        // validate signup form on keyup and submit
        $("#geodeziya").validate({
            rules: {
                numberContract: "required",
                kogdaVydan: "required",
                naselPunkt: "required",
                ulica: "required",
                dom: "required",
                object: "required",
                dataDogovara: "required",
                dataAct: "required",
                kemVydan: "required",
                fio: {
                    required: true,
                    pattern: "[А-ЯЁ][а-яё-]{1,30} [А-ЯЁ].[А-ЯЁ]."
                },
                passportSeriya: {
                    required: true,
                    pattern: "[a-zA-Z]{2}"
                },
                passportNomer: {
                    required: true,
                    pattern: "[0-9]{7}"
                },
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
                passportSeriya:"Серия паспорта должна состоять из двух латинских букв",

                kogdaVydan: "Ведите дату начала",

                fio: {
                    required: "Введите Фамилию И.О.",
                    pattern: "Не соответсвует формату \"Фамилия И.О.\""
                },
                passportNomer: {
                    required: "Введите номер паспорта",
                    pattern: "Номер паспорта должен состоять из 7 цифр"
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


<c:url var="addActionGeo" value="/addgeo/add"/>

<form:form action="${addActionGeo}" modelAttribute="geodeziya" method="get">
  <table>
    <c:if test="${!empty geodeziya.id}">
        <tr style="display: none">
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

      <tr><td align="right">
          <form:label path="fio">
              <spring:message text="ФИО:"/>
          </form:label></td><td>

          <form:input path="fio" type="text" name="fio" id="fio"/>
      </td></tr>
      <tr><td align="right">
          <form:label path="passportSeriya">
              <spring:message text="Серия паспорта:"/>
          </form:label></td><td>

          <form:input path="passportSeriya" type="text" name="passportSeriya" id="passportSeriya"/>
      </td></tr>

      <tr><td align="right">
          <form:label path="passportNomer">
              <spring:message text="Номер паспорта:"/>
          </form:label></td><td>

          <form:input path="passportNomer" type="text" name="passportNomer" id="passportNomer"/>
      </td></tr>
      <tr><td align="right">
          <form:label path="kogdaVydan">
              <spring:message text="Когда выдан:"/>
          </form:label></td><td>

          <form:input path="kogdaVydan" type="date" name="kogdaVydan" id="kogdaVydan"/>
      </td></tr>

      <tr><td align="right">
          <form:label path="kemVydan">
              <spring:message text="Кем выдан:"/>
          </form:label></td><td>

          <form:input path="kemVydan" type="text" name="kemVydan" id="kemVydan"/>
      </td></tr>

      <tr><td align="right">
          <form:label path="naselPunkt">
              <spring:message text="Проживает в городе/деревне:"/>
          </form:label></td><td>

          <form:input path="naselPunkt" type="text" name="naselPunkt" id="naselPunkt"/>
      </td></tr>

      <tr><td align="right">
          <form:label path="ulica">
              <spring:message text="Улица:"/>
          </form:label></td><td>

          <form:input path="ulica" type="text" name="ulica" id="ulica"/>
      </td></tr>


      <tr><td align="right">
          <form:label path="dom">
              <spring:message text="Дом:"/>
          </form:label></td><td>

          <form:input path="dom" type="text" name="dom" id="dom"/>
      </td></tr>


      <tr><td align="right">
          <form:label path="korpus">
              <spring:message text="Корпус:"/>
          </form:label></td><td>

          <form:input path="korpus" type="text" name="korpus" id="korpus"/>
      </td></tr>

      <tr><td align="right">
          <form:label path="kvartira">
              <spring:message text="Квартира:"/>
          </form:label></td><td>

          <form:input path="kvartira" type="text" name="kvartira" id="kvartira"/>
      </td></tr>



      <tr><td align="right">
          <form:label path="telephone">
              <spring:message text="Телефон:"/>
          </form:label></td><td>

          <form:input path="telephone" type="text" name="telephone" id="telephone"/>
      </td></tr>

      <tr><td align="right">
          <form:label path="nameObject">
              <spring:message text="Наименование объекта:"/>
          </form:label></td><td>

          <form:input path="nameObject" type="text" name="object" id="object" cssStyle="width:400px"/>
      </td></tr>


      <tr><td align="right">
          <form:label path="nomerDogovara">
              <spring:message text="Номер договора:"/>
          </form:label></td><td>

          <form:input path="nomerDogovara" type="text" name="nomerDogovara" id="nomerDogovara"/>
      </td></tr>



      <tr><td align="right">
          <form:label path="dataDogovara">
              <spring:message text="Дата договора:"/>
          </form:label></td><td>

          <form:input path="dataDogovara" type="date" name="dataDogovara" id="dataDogovara"/>
      </td></tr>

      <tr><td align="right">
          <form:label path="srok">
              <spring:message text="Срок:"/>
          </form:label></td><td>

          <form:input path="srok" type="text" name="srok" id="srok" />
      </td></tr>
      <tr><td align="right">
          <form:label path="polevoiTarif">
              <spring:message text="Полевой тариф:"/>
          </form:label></td><td>

          <form:input path="polevoiTarif" type="text" name="polevoiTarif" id="polevoiTarif" value="181.9"/>
      </td></tr>
      <tr><td align="right">
          <form:label path="kamerTarif">
              <spring:message text="Камеральный тариф:"/>
          </form:label></td><td>

          <form:input path="kamerTarif" type="text" name="kamerTarif" id="kamerTarif" value="59.0"/>
      </td></tr>


      <tr><td align="right">
          <form:label path="obem">
              <spring:message text="Объем:"/>
          </form:label></td><td>

          <form:input path="obem" type="text" name="obem" id="obem"/>
      </td></tr>
      <tr>
          <td align="right">
              Расстояние до участка
          <td>
              <input id="rasstoyanie" type="text">

          </td>
      </tr>

      <tr><td align="right">
          <form:label path="transportnye">
              <spring:message text="Транспортные:"/>
          </form:label></td><td>

          <form:input path="transportnye" type="text" name="transportnye" id="transportnye"/>
      </td></tr>

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

      <tr><td align="right">
          <form:label path="koefPerescheta">
              <spring:message text="Коэффициент пересчета:"/>
          </form:label></td><td>

          <form:input path="koefPerescheta" type="text" name="koefPerescheta" id="koefPerescheta"/>
      </td></tr>

      <tr><td align="right">
          <form:label path="dataAct">
              <spring:message text="Акт от:"/>
          </form:label></td><td>

          <form:input path="dataAct" type="date" name="dataAct" id="dataAct"/>
      </td></tr>

  </table>





    <p><br>
        <c:if test="${!empty geodeziya.id}">
            <input type="submit"
                   value="<spring:message text="Добавить"/>"/>
        </c:if>
        <c:if test="${empty geodeziya.id}">
            <input type="submit"
                   value="<spring:message text="Редактировать"/>"/>
        </c:if>
    </p>
</form:form>

<h1>Договоры</h1>

<c:if test="${!empty  listGeodeziya}">
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
        <c:forEach items="${listGeodeziya}" var="geodeziya">
            <tr>
                <td>${geodeziya.id}</td>
                <td><a href="/editgeo/${geodeziya.id}" target="_blank">${geodeziya.nameObject}</a></td>
                <td>${geodeziya.dataDogovara}</td>

                <td>${geodeziya.fio}</td>

                <td><a href="<c:url value='/editgeo/${geodeziya.id}'/>">Исправить</a></td>
                <td><a href="<c:url value='/removegeo/${geodeziya.id}'/>">Удалить</a></td>
                <td><a href="<c:url value='/addgeoword/${geodeziya.id}'/>" target="_blanc">Добавить в ворд</a></td>

            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>

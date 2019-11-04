<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<meta charset="UTF-8"/>

<style>
    .del {
        display: none;
    }

    .del:not(:checked) + label + div {
        display: none;
    }

    /* фактически нужна только одна строка */

    /* вид CSS кнопки */
    .del:not(:checked) + label,
    .del:checked + label {
        display: inline-block;
        padding: 2px 10px;
        border-radius: 2px;
        color: #fff;
        background: #4e6473;
        cursor: pointer;
    }

    .del:checked + label {
        background: #e36443;
    }
</style>
<style type="text/css">
    select {
        width: 90%;
    }
</style>
<style type="text/css">
    TABLE, tbody {
        font-size: 12px;
        -moz-hyphens: auto;
        -webkit-hyphens: auto;
        -ms-hyphens: auto;
        width: 1120px;
        border-collapse: collapse; /* Убираем двойные линии между ячейками */
    }

    td, th {
        border: 1px solid black;
    }


    tr:nth-child(2n) {
        background: #effcff; /* Цвет фона */
    }

    tr:nth-child(1) {
        font-weight: bold;
        background: #d1f7ff; /* Цвет фона */
    }

    /*    #nzt tr:nth-child(1) td:nth-child(1) {
            width: 35px;
        }

        #nzt tr:nth-child(1) td:nth-child(2) {
            width: 180px;
        }

        #nzt tr:nth-child(1) td:nth-child(3) {
            width: 97px;
        }

        #nzt tr:nth-child(1) td:nth-child(4) {
            width: 258px;
        }

        #nzt tr:nth-child(1) td:nth-child(5) {
            width: 86px;
        }

        #nzt tr:nth-child(1) td:nth-child(6) {
            width: 86px;
        }

        #nzt tr:nth-child(1) td:nth-child(7) {
            width: 60px;
        }

        #nzt tr:nth-child(1) td:nth-child(8) {
            width: 86px;
        }*/
    .shapka tr, .shapka td, .tableFooter tr, .tableFooter td {
        background-color: #ffffff;
        border: none;
        font-weight: normal;
    }


</style>
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>

<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/hide.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/printThis.js" charset="utf-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/smeta.js" charset="utf-8"></script>

<link
        href="${pageContext.request.contextPath }/resources/css/themes/base/jquery.ui.all.css"
        rel="stylesheet" type="text/css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.0/jquery.validate.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.0/additional-methods.js"></script>
<link href="${pageContext.request.contextPath }/resources/css/style.css"
      rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath }/resources/css/screen.css"
      rel="stylesheet" type="text/css">
<script>
    $(function () {
        $("#tabs").tabs();
    });
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
    <title>Смета</title>

</head>
<body>
<jsp:include page="menu.jsp"/>


<br/>
<br/>

<h1>Посчитать смету</h1>

<input id="idSmeta" style="display: none"
<c:if test="${!empty  smety}">
       value="${smety.id}"
</c:if>
>
<c:url var="addSmeta" value="/smeta/add"/>

<form:form action="${addActionSmeta}" modelAttribute="smeta" method="get">

    <p></p>
    <div id="tabs">
        <ul>
            <li><a href="#tabs-6">Дата</a></li>
            <li><a href="#tabs-0">Шапка</a></li>
            <li><a href="#tabs-1">СНЗТ</a></li>
            <li><a href="#tabs-2">Дополнительные проектные работы</a></li>
            <li><a href="#tabs-3">Субподряд</a></li>
            <li><a href="#tabs-4">Налог</a></li>
            <li><a href="#tabs-5">Коэффициенты</a></li>
            <li><a href="#tabs-7">Примечание</a></li>
        </ul>
        <div id="tabs-6">Дата начала разработки сметной документации <input type="date" name="dateBegin" id="dateBegin"
        <c:if test="${!empty  smety}">
            value="${smety.dateBegin}"
        </c:if>
                                                                            onchange="getVr()">
        </div>
        <div id="tabs-0">
            <table class="shapka">
                <tr>
                    <td>Номер объекта:</td>

                    <td><input type="text" id="inpNomerDogovora" value="${smety.nomerObject}"></td>
                <tr>
                <tr>
                    <td>Дополнительное поле:</td>
                    <td><textarea id="prilozhenie"> Приложение к договору №

 </textarea></td>
                </tr>
                <tr style="background-color: #ffffff; border: none; font-weight: normal ">
                    <td style="width: 180px;"> Название:</td>
                    <td><textarea id="nameSmeta"> ИСПОЛНИТЕЛЬНАЯ СМЕТА № на выполнение проектно-изыскательских работ
 </textarea></td>
                </tr>
                <tr style="background-color: #ffffff; border: none; font-weight: normal ">
                    <td>Наименование объекта:</td>
                    <td><textarea id="nameObject"><c:if test="${!empty  smety}">${smety.nameObject}</c:if></textarea></td>
                </tr>
                <tr>
                    <td>Заказчик:</td>
                    <td><input type="text" id="nameOrganization" onchange="getIdOrganization()"/>
                        Должность: <input type="text" id="positionZakazchik"/>
                        ФИО: <input type="text" id="fullNameZakazchik"/>

                        <input type="button" value="Добавить нового" onClick="opwin('organizaii')"></td>
                </tr>
            </table>
            <span id="idZakazchik" style="display: none"></span>
            <input type="button" value="Добавить" id="prilozhenieButton">

        </div>
        <div id="tabs-1">
            <p><form:label path="nztName">
                <spring:message text="Выберите справочник:"/>
            </form:label>
            </p>
            <p>
                <form:select path="nztName" name="nztName" id="nztId" onchange="getNztTable();">
                    <c:forEach items="${listNzt}" var="nzt">
                        <form:option value="${nzt.id}">${nzt.nztNumber} ${nzt.nztName}</form:option>
                    </c:forEach>
                </form:select>
            </p>
            <span id="vrHide" style="display: none">${vr}</span>
            <span id="nztTableSpan"></span>
            <div id="divRaspredelenie" style="display: none">
                <label><input type="radio" name="raspredelenie" value="yes">с распределением по разделам проектирования</label><br>
                <label><input type="radio" name="raspredelenie" value="no">без распределения по разделам проектирования</label><br>

                <div id="vidZdaniya"></div>
            </div>

            <span id="nztNormSpan"></span>
            <span id="nztNormMinMaxTable"></span>

            <p>    <%--<form:label path="nztZnachenie">
        <spring:message text="Введите значение"/>
    </form:label>--%>
                Введите значение <input type="text" name="valueNzt" id="valueNzt"> ед. измерения
            </p>
            <p id="paralProkladkaP" style="display: none">
                <input type="checkbox" id="paralProkladka" value="0">Параллельная прокладка
            </p>
            <p>
                Коэффициент по виду строительства <select id="koefVidStroitelstva" name="koefVidStroitelstva">
                <option value="0.6">0.6 капитальный ремонт</option>
                <option value="1">1 возведение</option>
                <option value="1.3">1.3 модернизация</option>
                <option value="1.3">1.3 реконструкция</option>
                <option value="0.15">0.15 снос</option>
            </select>
            <div id="divDopKoef" style="display: none">

            </div>

            <p></p>
            <input type="button" value="Добавить" onclick="getNztNormByName()" name="btn">
        </div>
        <div id="tabs-2">

            <h3>Дополнительные проектные работы</h3><%-- <input type="checkbox" id="raz" class="del"/>
            <label for="raz" class="del">развернуть/свернуть</label>--%>
            <div id="dop" style="font-size: 0.8em;">
                    ${dop}
                <p><label><input type="checkbox" id="otherDop" value="otherDop">Другой вид работ</label></p>
            </div>
            <input type="button" id="dopButton" value="Добавить">
        </div>
        <div id="tabs-3">
            <h3>Субподряд</h3>
            <div id="subpodryadGeo" style="font-size: 0.8em;">
                <p><label><input type="checkbox" value="Инженерно-геологические изыскания"/>Инженерно-геологические
                    изыскания</label></p>
            </div>
            <div id="subpodryad" style="font-size: 0.8em;">
                <p><label><input type="checkbox" value="Проект на газоснабжение"/>Проект на газоснабжение</label></p>
                <p><label><input type="checkbox" value="Пожарно-охранная сигнализация"/>Пожарно-охранная
                    сигнализация</label></p>
                <p><label><input type="checkbox" value="Инженерно-геодезические изыскания"/>Инженерно-геодезические
                    изыскания</label></p>
                <p><label><input type="checkbox" value="Видеонаблюдение"/>Видеонаблюдение</label></p>
                <p><label><input type="checkbox" value="Обследование строительных конструкций"/>Обследование
                    строительных конструкций</label></p>
                <p><label><input type="checkbox" value="Декларирование ПСД"/>Декларирование ПСД</label></p>
            </div>
            <div id="subpodryadDrugoe" style="font-size: 0.8em;">
                <p><label><input type="checkbox" value="Другое"/>Другое</label></p>
            </div>
            <input type="button" id="subpodryadButton" value="Добавить">
        </div>

        <div id="tabs-4">
            <h3>Налоги</h3>
            <div id="nalogSpisok">
                <input type="radio" id="inputNalog" value="Единый налог по упрощенной системе налогооблажения:">Единый
                налог по упрощенной системе налогооблажения: 5%
            </div>
            <input type="button" id="nalogButton" value="Добавить">
        </div>
        <div id="tabs-5">
            <h3>Коэффициенты</h3>
            <div id="koefSpisok">
                <p><label><input type="checkbox" value="Коэффициент, учитывающий сложность проектирования"/>Коэффициент,
                    учитывающий сложность проектирования</label></p>
                <p><label><input type="checkbox" value="Коэффициент снижения ценового предложения"/>Коэффициент снижения
                    ценового предложения</label></p>
               <%-- <p><label><input type="checkbox" value="Снижение ценового предложения на 15%"/>Снижение ценового предложения на 15%</label></p>
                <p><label><input type="checkbox" value="Снижение ценового предложения на 9.99%"/>Снижение ценового предложения на 9.99%</label></p>
--%> <p><label><input type="checkbox" value="drKoef"/>Другой коэффициент</label></p>
            </div>
            <input type="button" id="koefButton" value="Добавить">
        </div>
        <div id="tabs-7">
            <h3>Примечание</h3>
            <div id="divPrimechanie">
                <textarea id="taxtareaPrimechanie">${smety.primechanie} </textarea>


            </div>


        </div>
    </div>


    <table class="smetaTable" id="fullSmetaTable" cellspacing="0" cellpadding="0">
        <c:if test="${!empty  smety}">
            ${smety.smetaTable}
        </c:if>
    </table>



    <div class="proverka"></div>


</form:form>
<form action="/smetatabletoword" method="POST" target="_blank" id="formWord">
    <input type="hidden" name="smetaTable" id="smetaTableInp"/>
    <input type="hidden" name="idZakazchik" id="idZakazchikInp"/>
    <input type="hidden" name="nomerSmety" id="nomerSmetyInp"/>
    <input type="hidden" name="nameObject" id="nameObjectInp"/>

</form>
<input type="button" id="pereschet" value="Пересчитать" style="margin-left: 20px; margin-bottom: 20px;">
<input type="button" id="saveSmeta" value="Сохранить" style="margin-left: 20px; margin-bottom: 20px;">

<input type="submit" id="toWord" value="Скачать в Word" style="margin-left: 20px; margin-bottom: 20px;">

<input type="button" id="toExcelOld" value="Скачать в Excel" style="margin-left: 20px; margin-bottom: 20px;" onclick="tableToExcel('fullSmetaTable','Смета', 'смета.xls')">
<%--<input type="button" id="toExcel" value="Скачать в Excel New" style="margin-left: 20px; margin-bottom: 20px;">--%>

<%--<input type="button" value="Печать" onclick="PrintElem('#fullSmetaTable')"/>--%>
<input type="button" value="Печать" id="printTable"/>

</body>
</html>

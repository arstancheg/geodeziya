<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Задание на проектирование</title>
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
            margin: 10px;
            font-size: 16px;
            -moz-hyphens: auto;
            -webkit-hyphens: auto;
            -ms-hyphens: auto;
            width: 1120px;
            border-collapse: collapse; /* Убираем двойные линии между ячейками */
            white-space: normal;

        }

        td, th {
            border: 1px solid black;
        }

        #ishDannyeTable td, #zadanieNaProekt td {
            border: none;
            background-color: #FFFFFF;
        }
        #zadanieProektTBody td{
            font-size: 1.5em;

            background-color: #EFFCFF;
        }
        #zadanieProektTBody tr:nth-child(1) td{

            background-color: #d1f7ff;
        }

        tr:nth-child(2n) {
            background: #effcff; /* Цвет фона */
        }

        tr:nth-child(1) {
            /* font-weight: bold;*/
            background: #d1f7ff; /* Цвет фона */
        }


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
    <script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/zadanieproekt.js" charset="utf-8"></script>
    <%--<link
            href="${pageContext.request.contextPath }/resources/css/themes/base/jquery.ui.all.css"
            rel="stylesheet" type="text/css">--%>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.0/jquery.validate.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.0/additional-methods.js"></script>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/smoothness/jquery-ui.css">
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
        $(document).tooltip();
    </script>
</head>
<body>
<jsp:include page="menu.jsp"/>
<div id="tabs">
    <ul>

        <li><a href="#tabs-0">Шапка</a></li>
        <li><a href="#tabs-1">Данные</a></li>

    </ul>
    <div id="tabs-0">
        <table class="shapka">
            <tr>
                <td><strong>Дата:</strong></td>
                <td><input type="date" id="dateZadanie"></td>
            </tr>
            <tr>
                <td><strong>Наименование и местонахождение объекта строительства:</strong></td>
                <td><textarea id="nameObjAdres"></textarea></td>
            </tr>

            <tr>
                <td><strong>Согласовано (распорядитель финансов):</strong><br/> Добавить:<input type="radio" name="soglasovano" value="1"> Удалить:<input type="radio" name="soglasovano" value="0"> </td>
                <td>
                    Должность: <input type="text" id="positionSogl"/>
                    ФИО: <input type="text" id="fullNameSogl"/>

                </td>
            </tr>

            <tr>
                <td style="padding: 10px 0; background-color: #EFFCFF;"><strong>Утверждено (заказчик):</strong></td>
                <td style="padding: 10px 0; background-color: #EFFCFF;">Поиск в БД: <input type="text"
                                                                                           id="nameOrganization"
                                                                                           onchange="getIdOrganization()"/>
                   <br>
                    Должность: <input type="text" id="positionZakazchik"/>

                    ФИО: <input type="text" id="fullNameZakazchik"/><br>
                    Реквизиты: <textarea id="rekvizity"></textarea>

                    <input type="button" value="Добавить нового" onClick="opwin('organizacii')"></td>
            </tr>
            <tr>
                <td><strong>От заказчика (задание составил):</strong></td>
                <td>
                    Должность: <input type="text" id="positionUtv"/>
                    ФИО: <input type="text" id="fullNameUtv"/>

                </td>
            </tr>
            <tr>
            <td><strong>От проектной организации (ГИП):</strong></td>
            <td>
                Должность: <input type="text" id="positionPrOrg" value="Главный инженер проекта"/>
                ФИО: <input type="text" id="fullNamePrOrg"/>

            </td>

        </tr>
            <tr>
                <td><strong>Подпись:</strong></td>
                <td>
                    Добавить: <input type="radio" name="signature" value="1" />
                    Удалить: <input type="radio" name="signature" value="0"/>

                </td>

            </tr>
        </table>
        <span id="idZakazchik" style="display: none"></span>
        <input type="button" value="Добавить" id="shapkaZadanieButton">

    </div>
    <div id="tabs-1">
        <h2>Состав и содержание задания на проектирование</h2>
        <label><input type="radio" name="vidSTR" value="zh">для объектов жилищно-гражданского назначения</label><br>
        <label><input type="radio" name="vidSTR" value="kap">для объектов капитального ремонта и
            модернизации</label><br>
        <label><input type="radio" name="vidSTR" value="pr">для объектов производственного назначения,
            инженерной и транспортной инфраструктуры</label><br>
    </div>
</div>
<input id="idZadanie" style="display: none" value="0">
<table cellspacing="0" cellpadding="0" id="zadanieNaProekt">

    <c:choose>
        <c:when test="${!empty zadanie.tableZadanie}">
            ${zadanie.tableZadanie}
        </c:when>
        <c:otherwise>


    <tr>
        <td class="soglasovanoTd"><strong>СОГЛАСОВАНО</strong></td>
        <td><strong>УТВЕРЖДЕНО</strong></td>
    </tr>
    <tr>
        <td><span id="soglPosition" class="soglasovanoTd">_______________________</span></td>
        <td><span id="utvPosition">_______________________</span></td>
    </tr>

    <tr>
        <td valign="top" style="font-size: 10px" class="soglasovanoTd">                    должность</td>
        <td valign="top" style="font-size: 10px">                    должность</td>
    </tr>
    <tr>
        <td class="soglasovanoTd"><span id="soglFIO">_______________________</span></td>
        <td><span id="utvlFIO">_______________________</span></td>
    </tr>
    <tr>
        <td valign="top" style="font-size: 10px" class="soglasovanoTd">    подпись                инициалы, фамилия</td>
        <td valign="top" style="font-size: 10px">    подпись                инициалы, фамилия</td>
    </tr>
    <tr>
        <td class="soglasovanoTd"><span class="chisloZapolneniya">«____»</span> <span class="monthZapolneniya">   ____________</span><span class="godZapolnenoya">20___г.</span></td>
        <td><span class="chisloZapolneniya">«____»</span> <span class="monthZapolneniya">   ____________</span><span class="godZapolnenoya">20___г.</span></td>
    </tr>
    <tr>
        <td colspan="2" align="center" style="height: 2em;">Задание на проектирование</td>
    </tr>
    <tr>
        <td colspan="2" style="height: 2em;"><p align="center" style="font-size: 1.2em  "><u id="nameProekt"></u></td>
    </tr>
    <tr>
        <td colspan="2"><p align="center" style="font-size: 0.8em">наименование и местонахождение объекта
            строительства</p></td>
    </tr>
    <tbody id="zadanieProektTBody"></tbody>
    <tr>
        <td style="height: 3em; font-weight: bold">От Заказчика</td>
        <td style="height: 3em; font-weight: bold">От проектной организации-исполнителя:</td>
    </tr>
    <tr>
            <td><u id="zakazchikPosition">                                              </u>   </td>
        <td><u>Главный инженер проекта</u></td>
    </tr>
    <tr>
        <td style="font-size: 10px" valign="top">должность представителя заказчика</td>
        <td style="font-size: 10px" valign="top">должность представителя исполнителя</td>
    </tr>
    <tr>
        <td><span id="tdOtZakazchikaFIO">________ ________________</span></td>
        <td id="tdSignature"><img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAD8AAABFCAYAAAD95j54AAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAyJpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuMy1jMDExIDY2LjE0NTY2MSwgMjAxMi8wMi8wNi0xNDo1NjoyNyAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvIiB4bWxuczp4bXBNTT0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wL21tLyIgeG1sbnM6c3RSZWY9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9zVHlwZS9SZXNvdXJjZVJlZiMiIHhtcDpDcmVhdG9yVG9vbD0iQWRvYmUgUGhvdG9zaG9wIENTNiAoV2luZG93cykiIHhtcE1NOkluc3RhbmNlSUQ9InhtcC5paWQ6QTNCMEI0RDVEQUYyMTFFOTlDN0RCMDM3NUJEREUxQkEiIHhtcE1NOkRvY3VtZW50SUQ9InhtcC5kaWQ6QTNCMEI0RDZEQUYyMTFFOTlDN0RCMDM3NUJEREUxQkEiPiA8eG1wTU06RGVyaXZlZEZyb20gc3RSZWY6aW5zdGFuY2VJRD0ieG1wLmlpZDpBM0IwQjREM0RBRjIxMUU5OUM3REIwMzc1QkRERTFCQSIgc3RSZWY6ZG9jdW1lbnRJRD0ieG1wLmRpZDpBM0IwQjRENERBRjIxMUU5OUM3REIwMzc1QkRERTFCQSIvPiA8L3JkZjpEZXNjcmlwdGlvbj4gPC9yZGY6UkRGPiA8L3g6eG1wbWV0YT4gPD94cGFja2V0IGVuZD0iciI/PmicMDYAAAe9SURBVHja5JsvVBRB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"  width="63" height="69" style="position: absolute; margin-top: -28px;" /><span id="spanGipFio">________ ________________</span></td>
    </tr>
    <tr>
        <td style="font-size: 10px" valign="top">подпись                       инициалы, фамилия</td>
        <td style="font-size: 10px" valign="top">подпись                       инициалы, фамилия</td>
    </tr>
    <tr>
        <td><span class="chisloZapolneniya">«____»</span> <span class="monthZapolneniya">  ____________</span><span class="godZapolnenoya">20___г.</span></td>
        <td><span class="chisloZapolneniya">«____»</span> <span class="monthZapolneniya">  ____________</span><span class="godZapolnenoya">20___г.</span></td>
    </tr>
        </c:otherwise>
    </c:choose>
</table>
<input type="button" value="Печать" onclick="printZadanie('#zadanieNaProekt')" style="margin: 20px 10px;"/>
<input type="button" id="saveZadanie" value="Сохранить" style="margin-left: 20px; margin-bottom: 20px;">
<input type="submit" id="toWordZadanie" value="Скачать в Word" style="margin-left: 20px; margin-bottom: 20px;">
</body>
</html>

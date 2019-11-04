<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Исходные данные</title>
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
#ishDannyeTable td{
    border: none;
    background-color: #FFFFFF;
}

        tr:nth-child(2n) {
            background: #effcff; /* Цвет фона */
        }

        tr:nth-child(1) {
           /* font-weight: bold;*/
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
    <script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/smeta.js"
            charset="utf-8"></script>
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
</head>
<body>
<jsp:include page="menu.jsp"/>
<h1 style="margin: 20px">Перечень исходных данных</h1>
<div id="tabs">
    <ul>
        <li><a href="#tabs-2">Шапка</a></li>
        <li><a href="#tabs-0">Сокращенный список</a></li>
        <li><a href="#tabs-1">По ТКП</a></li>

    </ul>
    <div id="tabs-2">
        <table class="shapka">
            <tr>
                <td>Дополнительное поле:</td>
                <td><textarea id="prilozhenie"> Приложение к договору №

 </textarea></td>
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
    <div id="tabs-0">
        <div id="checkIshDannyeDiv">
            <input class="addAll" type="button" value="Выбрать все"> <input class="removeAll" type="button" value="Очистить выбор">
            <table border="0" cellspacing="0" cellpadding="0" width="0">
                <tr>
                    <td width="58" align="center"><p align="center"><strong>Выберите</strong></td>
                    <td width="493"><p align="center"><strong>Наименование ТУ</strong></td>

                </tr>
                <tr>
                    <td width="58" align="center"><input type="checkbox" class="checkIshDannye"
                                                         value="Решение райисполкома"/></td>
                    <td width="493">Решение райисполкома</td>

                </tr>
                <tr>
                    <td width="58" align="center"><input type="checkbox" class="checkIshDannye"
                                                         value="Задание на проектирование"/></td>
                    <td width="493">Задание на проектирование</td>

                </tr>
                <tr>
                    <td width="58" align="center"><input type="checkbox" class="checkIshDannye"
                                                         value="Архитектурно-планировочное задание"/></td>
                    <td width="493">Архитектурно-планировочное задание</td>

                </tr>
                <tr>
                    <td width="58" align="center"><input type="checkbox" class="checkIshDannye"
                                                         value="Заключение с/э станции"/></td>
                    <td width="493">Заключение с/э станции</td>

                </tr>
                <tr>
                    <td width="58" align="center"><input type="checkbox" class="checkIshDannye"
                                                         value="ТУ на электричество"/></td>
                    <td width="493">ТУ на электричество</td>

                </tr>
                <tr>
                    <td width="58" align="center"><input type="checkbox" class="checkIshDannye"
                                                         value="ТУ на водоснабжение и канализацию"/></td>
                    <td width="493">ТУ на водоснабжение и канализацию</td>

                </tr>
                <tr>
                    <td width="58" align="center"><input type="checkbox" class="checkIshDannye"
                                                         value="ТУ на теплоснабжение"/></td>
                    <td width="493">ТУ на теплоснабжение</td>

                </tr>
                <tr>
                    <td width="58" align="center"><input type="checkbox" class="checkIshDannye"
                                                         value="ТУ на горячее водоснабжение"/></td>
                    <td width="493">ТУ на горячее водоснабжение</td>

                </tr>
                <tr>
                    <td width="58" align="center"><input type="checkbox" class="checkIshDannye"
                                                         value="ТУ на ИТМГО и ЧС"/>
                    </td>
                    <td width="493">ТУ на ИТМГО и ЧС</td>

                </tr>
                <tr>
                    <td width="58" align="center"><input type="checkbox" class="checkIshDannye"
                                                         value="ТУ на сети связи"/>
                    </td>
                    <td width="493">ТУ на сети связи</td>

                </tr>
                <tr>
                    <td width="58" align="center"><input type="checkbox" class="checkIshDannye" value="ТУ на ЛВС"/></td>
                    <td width="493">ТУ на ЛВС</td>

                </tr>
                <tr>
                    <td width="58" align="center"><input type="checkbox" class="checkIshDannye" value="ТУ ОГАИ РОВД"/>
                    </td>
                    <td width="493">ТУ ОГАИ РОВД</td>

                </tr>
                <tr>
                    <td width="58" align="center"><input type="checkbox" class="checkIshDannye"
                                                         value="Справка о сроках начала строительства, источнике финансирования"/>
                    </td>
                    <td width="493">Справка о сроках начала строительства, источнике финансирования</td>

                </tr>
                <tr>
                    <td width="58" align="center"><input type="checkbox" class="checkIshDannye"
                                                         value="Справка о подвозе песка и ПГС"/></td>
                    <td width="493">Справка о подвозе песка и ПГС</td>

                </tr>
                <tr>
                    <td width="58" align="center"><input type="checkbox" class="checkIshDannye"
                                                         value="Справка о вывозе мусора (асфальт, бетон, ж.бетон, шлак, дерево, рубероид, кирпич)"/>
                    </td>
                    <td width="493">Справка о вывозе мусора (асфальт, бетон, ж.бетон, шлак, дерево, рубероид, кирпич)
                    </td>

                </tr>
                <tr>
                    <td width="58" align="center"><input type="checkbox" class="checkIshDannye"
                                                         value="Акт обследования существующих инженерных сетей и благоустройства перед началом проектирования"/>
                    </td>
                    <td width="493">Акт обследования существующих инженерных сетей и благоустройства перед началом
                        проектирования
                    </td>

                </tr>
                <tr>
                    <td width="58" align="center"><input type="checkbox" class="checkIshDannye"
                                                         value="Технический паспорт с планами этажей"/></td>
                    <td width="493">Технический паспорт с планами этажей</td>

                </tr>
                <tr>
                    <td width="58" align="center"><input type="checkbox" class="checkIshDannye"
                                                         value="Техническое заключение (обследование)"/></td>
                    <td width="493">Техническое заключение (обследование)</td>

                </tr>
                <tr>
                    <td width="58" align="center"><input type="checkbox" class="checkIshDannye"
                                                         value="Инженерно-геодезические изыскания"/></td>
                    <td width="493">Инженерно-геодезические изыскания</td>

                </tr>
                <tr>
                    <td width="58" align="center"><input type="checkbox" class="checkIshDannye"
                                                         value="Инженерно-геологические изыскания"/></td>
                    <td width="493">Инженерно-геологические изыскания</td>

                </tr>
                <tr>
                    <td width="58" align="center"><input type="checkbox" class="checkIshDannye"
                                                         value="Справка по льготированию по НДС или нельготировнию в процентном отношении"/>
                    </td>
                    <td width="493">Справка по льготированию по НДС или нельготировнию в процентном отношении</td>

                </tr>
                <tr>
                    <td width="58" align="center"><input type="checkbox" class="checkIshDannye"
                                                         value="Акт государственной регистрации земельного участка (акт предварительного отвода земельного участка - в случае необходимости)"/>
                    </td>
                    <td width="493">Акт государственной регистрации земельного участка (акт предварительного отвода
                        земельного участка - в случае необходимости)
                    </td>

                </tr>
            </table>
        </div>
        <input type="button" id="ishDannyeButton" value="Добавить">
    </div>
    <div id="tabs-1">
        <div id="checkIshDannyeTKPDiv">
            <input class="addAll" type="button" value="Выбрать все"> <input class="removeAll" type="button" value="Очистить выбор">

            <table cellspacing="0" cellpadding="0">

                <tr>
                    <td width="58">Выберите<br>нужное</td>
                    <td width="998">Перечень исходных данных</td>
                </tr>

                <tr>
                    <td width="58" align="center"><input type="checkbox" class="checkIshDannyeTKP"
                                                         value="Копия технического паспорта здания с инвентаризационными    поэтажными планами с вентиляционными каналами"/>
                    </td>
                    <td width="493">Копия технического паспорта здания с инвентаризационными поэтажными планами с
                        вентиляционными каналами
                    </td>
                </tr>
                <tr>
                    <td width="58" align="center"><input type="checkbox" class="checkIshDannyeTKP"
                                                         value="Архитектурно-планировочное задание"/></td>
                    <td width="493">Архитектурно-планировочное задание</td>
                </tr>
                <tr>
                    <td width="58" align="center"><input type="checkbox" class="checkIshDannyeTKP"
                                                         value="Заключение Минздрава (Центра гигиены, эпидемиологии и общественного здоровья)"/>
                    </td>
                    <td width="493">Заключение Минздрава (Центра гигиены, эпидемиологии и общественного здоровья)</td>
                </tr>
                <tr>
                    <td width="58" align="center"><input type="checkbox" class="checkIshDannyeTKP"
                                                         value="Заключение МЧС (Государственного пожарного надзора)"/>
                    </td>
                    <td width="493">Заключение МЧС (Государственного пожарного надзора)</td>
                </tr>
                <tr>
                    <td width="58" align="center"><input type="checkbox" class="checkIshDannyeTKP"
                                                         value="Технические условия Госавтоинспекции (ГАИ)"/></td>
                    <td width="493">Технические условия Госавтоинспекции (ГАИ)</td>
                </tr>
                <tr>
                    <td width="58" align="center"><input type="checkbox" class="checkIshDannyeTKP"
                                                         value="Технические условия на теплоснабжение с указанием гидравлических параметров теплоносителя Р1/Р2, Т1/T2"/>
                    </td>
                    <td width="493">Технические условия на теплоснабжение с указанием гидравлических параметров
                        теплоносителя Р1/Р2, Т1/T2
                    </td>
                </tr>
                <tr>
                    <td width="58" align="center"><input type="checkbox" class="checkIshDannyeTKP"
                                                         value="Технические условия на хозяйственно-питьевое и производственное водоснабжение с указанием гарантированного напора в сетях"/>
                    </td>
                    <td width="493">Технические условия на хозяйственно-питьевое и производственное водоснабжение с
                        указанием гарантированного напора в сетях
                    </td>
                </tr>
                <tr>
                    <td width="58" align="center"><input type="checkbox" class="checkIshDannyeTKP"
                                                         value="Технические условия на хозяйственно-бытовую и производственную канализацию"/>
                    </td>
                    <td width="493">Технические условия на хозяйственно-бытовую и производственную канализацию</td>
                </tr>
                <tr>
                    <td width="58" align="center"><input type="checkbox" class="checkIshDannyeTKP"
                                                         value="Технические условия на электроснабжение"/></td>
                    <td width="493">Технические условия на электроснабжение</td>
                </tr>
                <tr>
                    <td width="58" align="center"><input type="checkbox" class="checkIshDannyeTKP"
                                                         value="Технические условия Энергосбыта"/></td>
                    <td width="493">Технические условия Энергосбыта</td>
                </tr>
                <tr>
                    <td width="58" align="center"><input type="checkbox" class="checkIshDannyeTKP"
                                                         value="Технические условия на газоснабжение (природный газ или пропан-бутан)"/>
                    </td>
                    <td width="493">Технические условия на газоснабжение (природный газ или пропан-бутан)</td>
                </tr>
                <tr>
                    <td width="58" align="center"><input type="checkbox" class="checkIshDannyeTKP"
                                                         value="Технические условия на радиофикацию"/></td>
                    <td width="493">Технические условия на радиофикацию</td>
                </tr>
                <tr>
                    <td width="58" align="center"><input type="checkbox" class="checkIshDannyeTKP"
                                                         value="Технические условия на телефонизацию"/></td>
                    <td width="493">Технические условия на телефонизацию</td>
                </tr>
                <tr>
                    <td width="58" align="center"><input type="checkbox" class="checkIshDannyeTKP"
                                                         value="Технические условия на телефикацию"/></td>
                    <td width="493">Технические условия на телефикацию</td>
                </tr>
                <tr>
                    <td width="58" align="center"><input type="checkbox" class="checkIshDannyeTKP"
                                                         value="Технические условия на благоустройство и ливневую канализацию"/>
                    </td>
                    <td width="493">Технические условия на благоустройство и ливневую канализацию</td>
                </tr>
                <tr>
                    <td width="58" align="center"><input type="checkbox" class="checkIshDannyeTKP"
                                                         value="Технические условия на озеленение"/></td>
                    <td width="493">Технические условия на озеленение</td>
                </tr>
                <tr>
                    <td width="58" align="center"><input type="checkbox" class="checkIshDannyeTKP"
                                                         value="Справка службы гражданской обороны о наличии специальных помещений, условиях прохождения через них инженерных сетей здания и объемах ремонтных работ"/>
                    </td>
                    <td width="493">Справка службы гражданской обороны о наличии специальных помещений, условиях
                        прохождения через них инженерных сетей здания и объемах ремонтных работ
                    </td>
                </tr>
                <tr>
                    <td width="58" align="center"><input type="checkbox" class="checkIshDannyeTKP"
                                                         value="Справки эксплуатирующих организаций о состоянии лифтов, объединенных диспетчерских систем (ОДС), центральных тепловых пунктов (ЦТП) и др."/>
                    </td>
                    <td width="493">Справки эксплуатирующих организаций о состоянии лифтов, объединенных диспетчерских
                        систем (ОДС), центральных тепловых пунктов (ЦТП) и др.
                    </td>
                </tr>
                <tr>
                    <td width="58" align="center"><input type="checkbox" class="checkIshDannyeTKP"
                                                         value="Акт о состоянии вентиляционных каналов и коробов"/></td>
                    <td width="493">Акт о состоянии вентиляционных каналов и коробов</td>
                </tr>
                <tr>
                    <td width="58" align="center"><input type="checkbox" class="checkIshDannyeTKP"
                                                         value="Технические условия на инженерное обеспечение на период строительства"/>
                    </td>
                    <td width="493">Технические условия на инженерное обеспечение на период строительства</td>
                </tr>
                <tr>
                    <td width="58" align="center"><input type="checkbox" class="checkIshDannyeTKP"
                                                         value="Условия приема стоков в канализацию (предельно допустимые концентрации загрязнения сточных вод, принимаемых городской канализацией)"/>
                    </td>
                    <td width="493">Условия приема стоков в канализацию (предельно допустимые концентрации загрязнения
                        сточных вод, принимаемых городской канализацией)
                    </td>
                </tr>
                <tr>
                    <td width="58" align="center"><input type="checkbox" class="checkIshDannyeTKP"
                                                         value="Другие требования (при необходимости)"/></td>
                    <td width="493">Другие требования (при необходимости)</td>
                </tr>
                <tr>
                    <td width="58" align="center"><input type="checkbox" class="checkIshDannyeTKP"
                                                         value="Информация о проведенных закупках оборудования, намеченных конкурсах на закупку с указанием стоимости оборудования"/>
                    </td>
                    <td width="493">Информация о проведенных закупках оборудования, намеченных конкурсах на закупку с
                        указанием стоимости оборудования
                    </td>
                </tr>
                <tr>
                    <td width="58" align="center"><input type="checkbox" class="checkIshDannyeTKP"
                                                         value="Решение органа исполнительной власти на право производства проектно-изыскательских работ, иная разрешительная документация"/>
                    </td>
                    <td width="493">Решение органа исполнительной власти на право производства проектно-изыскательских
                        работ, иная разрешительная документация
                    </td>
                </tr>
                <tr>
                    <td width="58" align="center"><input type="checkbox" class="checkIshDannyeTKP"
                                                         value="Отчеты о выбросах загрязняющих веществ в атмосферу (при капитальном ремонте и (или) модернизации)"/>
                    </td>
                    <td width="493">Отчеты о выбросах загрязняющих веществ в атмосферу (при капитальном ремонте и (или)
                        модернизации)
                    </td>
                </tr>
                <tr>
                    <td width="58" align="center"><input type="checkbox" class="checkIshDannyeTKP"
                                                         value="Отчеты об использовании воды (при капитальном ремонте и (или) модернизации)"/>
                    </td>
                    <td width="493">Отчеты об использовании воды (при капитальном ремонте и (или) модернизации)</td>
                </tr>
                <tr>
                    <td width="58" align="center"><input type="checkbox" class="checkIshDannyeTKP"
                                                         value="Техническое заключение по результатам обследования объектов реконструкции и капитального ремонта в соответствии с ТКП 45-1.02-104"/>
                    </td>
                    <td width="493">Техническое заключение по результатам обследования объектов реконструкции и
                        капитального ремонта в соответствии с ТКП 45-1.02-104
                    </td>
                </tr>
                <tr>
                    <td width="58" align="center"><input type="checkbox" class="checkIshDannyeTKP"
                                                         value="Ведомость нагрузок на инженерные сети"/></td>
                    <td width="493">Ведомость нагрузок на инженерные сети</td>
                </tr>
                <tr>
                    <td width="58" align="center"><input type="checkbox" class="checkIshDannyeTKP"
                                                         value="Дефектные акты в соответствии с требованиями ТКП 45-1.02-104 (6.5)"/>
                    </td>
                    <td width="493">Дефектные акты в соответствии с требованиями ТКП 45-1.02-104 (6.5)</td>
                </tr>
            </table>
        </div>
        <input type="button" id="ishDannyeTKPButton" value="Добавить">
    </div>
</div>
<table border="0" cellspacing="0" cellpadding="0" id="ishDannyeTable">
    <tr>
        <td></td>
        <td width="196" valign="bottom"></td>
        <td valign="bottom"></td>
        <td colspan="2"><p align="right">Приложение 4<br>
            к  договору  № 17/19 от 19.03.2019г.</p></td>
        <td></td>
    </tr>
    <tr>
        <td width="82" style="border: 1px solid black;" align="center"><strong>№ п.п.</strong></td>
        <td colspan="2" align="center"  style="border: 1px solid black;"><strong>Наименование ТУ</strong></td>
        <td width="275" style="border: 1px solid black;" align="center"><strong>Номер</strong></td>
        <td width="292" style="border: 1px solid black;" align="center"><strong>Дата выдачи</strong></td>
        <td width="292"></td>
    </tr>

    <tbody id="ishDannyeTBody"></tbody>
    <tr>
        <td></td>
        <td colspan="2"></td>
        <td></td>
        <td></td>
        <td></td>
    </tr>
    <tr>
        <td><p> </p></p> </td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
    </tr>
    <tr>
        <td colspan="2"><p><strong>Исходные данные передал: </strong><br></p></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
    </tr>
    <tr>
        <td colspan="4" style="height: 4em;"><strong>ЗАКАЗЧИК:                                           </strong></td>
        <td></td>
        <td></td>
    </tr>
    <tr>
        <td colspan="2" id="footerZakazchikDolzhnost"></td>
        <td width="195" style="text-align: center">________________</td>
        <td id="footerZakazchikFIO"></td>
        <td></td>
        <td></td>
    </tr>
    <tr>
        <td style="text-align: center">м.п.</td>
        <td colspan="2"></td>
        <td></td>
        <td></td>
        <td></td>
    </tr>
    <tr>
        <td colspan="3"></td>
        <td></td>
        <td></td>
        <td></td>
    </tr>
    <tr>
        <td colspan="3" style="height: 4em;">«___»_____________2019г.<br></td>
        <td></td>
        <td></td>
        <td></td>
    </tr>
    <tr>
        <td colspan="3"></td>
        <td></td>
        <td></td>
        <td></td>
    </tr>
    <tr>
        <td colspan="3"><p><strong>Исходные данные получил:</strong></p></td>
        <td></td>
        <td></td>
        <td></td>
    </tr>
    <tr>
        <td colspan="5">в полном/ неполном объеме (не нужное зачеркнуть)<br>
            (в случае непредоставления полного пакета исходных данных в соответствии с перечнем Заказчик передает
            исходные данные по накладной, подписанной сторонами, по факту их передачи проектировщику)<br>
            </td>
        <td></td>
    </tr>
    <tr>
        <td colspan="2" style="height: 4em;">ГИП   ________________</td>
        <td>И.Е.Желтов</td>
        <td></td>
        <td></td>
        <td></td>
    </tr>
</table>
<input type="button" id="toExcel" value="Скачать в Excel" style="margin-left: 20px; margin-bottom: 20px;"
       onclick="tableToExcel('ishDannyeTable','Исходные данные', 'исхданные.xls')">
<input type="button" value="Печать" onclick="PrintElem('#ishDannyeTable')"/>
</body>
</html>

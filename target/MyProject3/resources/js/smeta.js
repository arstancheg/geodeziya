$(document).on("click", "#printTable", function () {
    /*   normTable('#fullSmetaTable').show();
       window.print();*/
    normTableObj("#fullSmetaTable").printThis();
})

function PrintElem(elem) {

    Popup(normTable(elem));
}


function Popup(data) {

    var mywindow = window.open('', 'my div', 'height=1024,width=768');

    mywindow.document.write('<html><head><title></title>');

    /*optional stylesheet*/ //mywindow.document.write('<link rel="stylesheet" href="main.css" type="text/css" />');

    mywindow.document.write('</head><body >');

    mywindow.document.write(data);

    mywindow.document.write('</body></html>');


    mywindow.document.close(); // necessary for IE >= 10

    mywindow.focus(); // necessary for IE >= 10


    mywindow.print();

    mywindow.close();


    return true;

}


var tableToExcel = (function () {

    var uri = 'data:application/vnd.ms-excel;base64,'
        ,
        template = '<html xmlns:o="urn:schemas-microsoft-com:office:office" xmlns:x="urn:schemas-microsoft-com:office:excel" xmlns="http://www.w3.org/TR/REC-html40"><head><!--[if gte mso 9]><xml><x:ExcelWorkbook><x:ExcelWorksheets><x:ExcelWorksheet><x:Name>{worksheet}</x:Name><x:WorksheetOptions><x:DisplayGridlines/></x:WorksheetOptions></x:ExcelWorksheet></x:ExcelWorksheets></x:ExcelWorkbook></xml><![endif]--><meta http-equiv="content-type" content="text/plain; charset=UTF-8"/></head><body><table>{table}</table></body></html>'
        , base64 = function (s) {
            return window.btoa(unescape(encodeURIComponent(s)))
        }
        , format = function (s, c) {
            return s.replace(/{(\w+)}/g, function (m, p) {
                return c[p];
            })
        }
        , downloadURI = function (uri, name) {
            var link = document.createElement("a");
            link.download = name;
            link.href = uri;
            link.click();
        }

    return function (table, name, fileName) {
        var tab = normTable("#" + table).replace(/([\d]+?)\.([\d]+?)/g, "$1,$2");

        if (!table.nodeType) table = tab;
        var ctx = {worksheet: name || 'Worksheet', table: table}
        var resuri = uri + base64(format(template, ctx))
        downloadURI(resuri, fileName);
    }
})();
/*var tableToExcel = (function() {
    var uri = 'data:application/vnd.ms-excel;base64,'
        , template = '<html xmlns:o="urn:schemas-microsoft-com:office:office" xmlns:x="urn:schemas-microsoft-com:office:excel" xmlns="http://www.w3.org/TR/REC-html40"><head><!--[if gte mso 9]><xml><x:ExcelWorkbook><x:ExcelWorksheets><x:ExcelWorksheet><x:Name>{worksheet}</x:Name><x:WorksheetOptions><x:DisplayGridlines/></x:WorksheetOptions></x:ExcelWorksheet></x:ExcelWorksheets></x:ExcelWorkbook></xml><![endif]--><meta http-equiv="content-type" content="text/plain; charset=UTF-8"/></head><body><table>{table}</table></body></html>'
        , base64 = function(s) { return window.btoa(unescape(encodeURIComponent(s))) }
        , format = function(s, c) {
        return s.replace(/{(\w+)}/g, function(m, p) { return c[p]; })
    }
        , downloadURI = function(uri, name) {
        var link = document.createElement("a");
        link.download = name;
        link.href = uri;
        link.click();
    }

    return function(table, name, fileName) {
        if (!table.nodeType) table = document.getElementById(table)
        var ctx = {worksheet: name || 'Worksheet', table: table.innerHTML}
        var resuri = uri + base64(format(template, ctx))
        downloadURI(resuri, fileName);
    }
})();*/

$(document).on("click", "#toExcel", function () {
    normTableObj("#fullSmetaTable").tableExport();
})

function vidZdaniya() {
    var vidSelect = "<select id=\"selectVidZdaniya\">\n" +
        "                <option value=\"1\">Административные здания</option>\n" +
        "                <option value=\"2\">Бассейны</option>\n" +
        "                <option value=\"3\">Гостиницы, общежития, пансионаты</option>\n" +
        "                <option value=\"4\">Жилые здания</option>\n" +
        "                <option value=\"5\">Комплексы больниц, лечебные корпуса, диспансеры, поликлиники, здания вне комплекса</option>\n" +
        "                <option value=\"6\">Лабораторные корпуса НИИ</option>\n" +
        "                <option value=\"7\">НИИ и ВЦ</option>\n" +
        "                <option value=\"8\">Общеобразовательные школы, дошкольные учреждения, интернаты, ПТУ</option>\n" +
        "                <option value=\"16\">Предприятия бытового обслуживания</option>\n" +
        "                <option value=\"9\">Предприятия общественного питания</option>\n" +
        "                <option value=\"15\">Санатории, профилактории, дома отдыха</option>\n" +
        "                <option value=\"10\">Спортивные залы</option>\n" +
        "                <option value=\"11\">Театры, кинотеатры, клубы</option>\n" +
        "                <option value=\"12\">Универмаги, магазины, крытые рынки</option>\n" +
        "                <option value=\"13\">Учебные корпуса ВУЗов</option>\n" +
        "                <option value=\"14\">Хоз. Корпуса больниц, пищеблок, прачечная, аптека, ПАК, станции скорой помощи, СЭС, молочные кухни</option>\n" +
        "            </select>";
    return vidSelect;
}

//Добавление выбора вида здания для распределения
$(document).on("change", "input[name=raspredelenie]", function () {
    var raspredelenie = $('input[name="raspredelenie"]:checked').val();
    if (raspredelenie == "yes") {
        var vidZdaniyaId = 0;
        var nztTableId = $("#nztTableId").val();
        /*alert("nztTableid=" + nztTableId);*/
        switch (nztTableId) {
            case "21":
                vidZdaniyaId = 4;
                break;
            case "22":
                vidZdaniyaId = 8;
                break;
            case "23":
                vidZdaniyaId = 3;
                break;
            case "24":
                vidZdaniyaId = 10;
                break;
            case "25":
                vidZdaniyaId = 12;
                break;

            case "26":
                vidZdaniyaId = 11;
                break;
            case "27":
                vidZdaniyaId = 5;
                break;

            case "28":
                vidZdaniyaId = 16;
                break;
            case "29":
                vidZdaniyaId = 1;
                break;

        }
        /* alert("vidZdaniya=" + vidZdaniyaId);*/
        $("#vidZdaniya").html(vidZdaniya());
        $("#selectVidZdaniya option[value=" + vidZdaniyaId + "]").prop("selected", true);

    } else {
        $("#selectVidZdaniya").remove();
    }
})

function getIdOrganization() {
    $.ajax({
        //url: '${pageContext.request.contextPath }/searchid',
        url: '/searchid',
        dataType: 'html',
        data: 'nameOrg=' + $('#nameOrganization').val(),
        success: function (data) {
            $('#idOrganization').val(data);

        }
    });
};

//добавляем таблицу с нормами для конкретного наименования объекта проектирования для наглядности
$(document).on("change", "#nztNorm", function () {


    $.ajax({
        //url: '${pageContext.request.contextPath }/searchid',
        url: '/searchminmaxtable',
        dataType: 'html',
        data: 'nztNorm=' + $("#nztNorm").val() + '&nztIdTable=' + $("#nztTableId").val(),
        success: function (data) {
            $('#nztNormMinMaxTable').html(data);

        }
    });

});

$(document).ready(function () {
    $('#nameOrganization').autocomplete({
        //  source: '${pageContext.request.contextPath }/search',
        source: '/search',

    });




    //удаление слова стоимость в инпут
    $(document).on('focus', '#SubGeoStoimost, #SubStoimost', function () {
        if ($(this).val() == "Стоимость") {
            $(this).val("");
        }
    })
    $(document).on('blur', '#SubGeoStoimost, #SubStoimost, .itogoKoef, .inpZnKoefDrugoy', function () {
        $(this).val($(this).val().replace(',', '.'));
    })


    //сохранение сметы
    $(document).on('click', '#saveSmeta', function () {
        $('input').each(function () {
            $(this).attr('value', $(this).val())

        })
        $("textarea").each(function () {
            $(this).text($(this).val());
        });

        var smeta = $('#fullSmetaTable').html();
        if ($("#idZakazchik").html()) {
            var idZakazchik = $("#idZakazchik").html();
        } else {
            var idZakazchik = 41;
        }
        if ($("#nameSmeta").val()) {
            var nomerSmety = $("#nameSmeta").val();
        } else {
            var nomerSmety = "-";
        }
        if ($("#nameObject").val()) {
            var nameObject = $("#nameObject").val();
        } else {
            var nameObject = "-";
        }
        if ($("#inpNomerDogovora").val()) {
            var nomerObject = $("#inpNomerDogovora").val();
        } else {
            var nomerObject = "-";
        }
        if ($("#taxtareaPrimechanie").html()) {
            var primechanie = $("#taxtareaPrimechanie").html();
        } else {
            var primechanie = "-";
        }
        if ($("#dateBegin").val()) {
            var dateBegin = $("#dateBegin").val();

        } else {
            var dateBegin = "0000-00-00";
        }
        var idSmeta = $("#idSmeta").val();
        var userObj = {
            "smetaTable": smeta,
            "idZakazchik": idZakazchik,
            "nomerSmety": nomerSmety,
            "nameObject": nameObject,
            "idSmeta": idSmeta,
            "dateBegin": dateBegin,
            "nomerObject":nomerObject,
            "primechanie": primechanie

        };


        $.ajax({
            // url: '${pageContext.request.contextPath }/savesmeta',
            url: '/savesmeta',
            method: "post",
            contentType: "application/json",
            data: JSON.stringify(userObj),
            dataType: 'json',
            error: function (message) {
                console.log(message);
            },
            success: function (data) {
                $("#idSmeta").val(data);
                alert("Смета сохранена");
                console.log(data);
                // window.open('/', '_blank');
            }
        });
        /*  $('#smetaTableInp').val(smeta);
          $('#idZakazchikInp').val(idZakazchik);
          $('#nomerSmetyInp').val(nomerSmety);
          $('#nameObjectInp').val(nameObject);
          $('#formWord').attr("target","_blank");
          $('#formWord').submit();*/
    })

    //получение должности и имени заказчика
    $(document).on('change', '#nameOrganization', function () {

        $.ajax({
            //    url: '${pageContext.request.contextPath }/searchzakazchik',
            url: '/searchzakazchik',
            method: "get",
            dataType: 'html',
            data: 'nameOrg=' + $('#nameOrganization').val(),
            success: function (data) {
                // alert(data);
                asd = JSON.parse(data);
                // alert(asd);
                $("#positionZakazchik").val(asd.position);
                $("#fullNameZakazchik").val(asd.name);
                $("#idZakazchik").html(asd.id);
                if ($("#rekvizity").length > 0) {
                    $("#rekvizity").val(asd.rekvizit);
                }


            }
        })
    })

    //добавление дополнительных видов работ
    $("#dopButton").click(function () {
        if ($("#dateBegin").val()) {
            var tBodyDop = "";
            var nazvRabot = "";
            $('#dop input:checkbox:checked').each(function () {
                //  alert($(this).val());
                if ($(this).val() == "otherDop") {
                    nazvRabot = "<td  rowspan=\"4\" style=\"border: 1px solid black;\"><textarea id=\"nazvDopRabot\" style='width: 300px; height: 50px'></textarea></td>";


                } else {
                    nazvRabot = "<td  rowspan=\"4\" style=\"border: 1px solid black;\">" + $(this).val() + "</td>";

                }
                tBodyDop += dop(nazvRabot);
            });
            $('#dopProectnyeRaboty').before(tBodyDop);
        } else {
            alert("Не указана дата");
        }
    });


    //добавление налога
    $("#nalogButton").click(function () {
        $("idNalog").remove();
        var tBodyNalog = "";
        tBodyNalog = $("#nalogSpisok input:radio:checked").val();
        $('#nalogTBody').before(nalog(tBodyNalog));
    });


    //добавление коэффициентов
    $("#koefButton").click(function () {
        var tBodyKoef = "";
        $('#koefSpisok input:checkbox:checked').each(function () {
            //  alert($(this).val());
            tBodyKoef += koef($(this).val());
        });
        $('#koefTBody').before(tBodyKoef);
    });

    //Добавление субподряда
    $("#subpodryadButton").click(function () {
        var tBodySubGeo = "";
        var tBodySub = "";

        $('#subpodryadGeo input:checkbox:checked').each(function () {
            //  alert($(this).val());
            tBodySubGeo += subpodryad('SubGeoStoimost', $(this).val(), 'SubGeoStoimost');
        });
        $('#subpodryad input:checkbox:checked').each(function () {
            //  alert($(this).val());
            tBodySub += subpodryad('SubStoimost', $(this).val(), 'SubStoimost');
        });
        $('#subpodryadDrugoe input:checkbox:checked').each(function () {
            //  alert($(this).val());
            tBodySub += subpodryad('SubStoimost', '<input type="text" id="IdNameDrugoeSub" value="Другое">', 'SubStoimost');
        });


        $('#subpodryadGeoTBody').before(tBodySubGeo);
        $('#subpodryadTBody').before(tBodySub);
    });


    //Добавление исходных данных
    $("#ishDannyeButton").click(function () {
        var ishDannyeNew = "";
        var i = 0;

        $('#checkIshDannyeDiv input:checkbox:checked').each(function () {
            //  alert($(this).val());
            ishDannyeNew += ishDannye($(this).val());
        });

        $('#ishDannyeTBody').before(ishDannyeNew);

        $('.numberIshDannye').each(function () {
            i++;
            $(this).html(i);
        })
    });

    //Добавление исходных данных по ТКП
    $("#ishDannyeTKPButton").click(function () {
        var ishDannyeNew = "";
        var i = 0;

        $('#checkIshDannyeTKPDiv input:checkbox:checked').each(function () {
            //  alert($(this).val());
            ishDannyeNew += ishDannye($(this).val());
        });

        $('#ishDannyeTBody').before(ishDannyeNew);
        $('.numberIshDannye').each(function () {
            i++;
            $(this).html(i);
        })

    });

    $(".addAll").click(function () {
        $(this).closest("div").find("input:checkbox").prop('checked', true);
    })
    $(".removeAll").click(function () {
        $(this).closest("div").find("input:checkbox").prop('checked', false);
    })


    $(document).on('click', '#delTBody, #delKoef, #delSub, #delNalog', function () {

        //alert("Удалено");
        $(this).closest("tbody").remove();
    });
    $(document).on('click', '.delIsh', function () {
        var i = 0;
        $(this).closest("tbody").remove();
        $('.numberIshDannye').each(function () {
            i++;
            $(this).html(i);
        })
    });
    $(document).on('change', '#dopT, #dopK', function () {
        // alert($(this).closest("tbody").find("#dopK").val());
        // alert($(this).closest("tbody").find("#dopT").val());
        $(this).val($(this).val().replace(',', '.'));
        var vr = $('#vrHide').html();
        var formula = "C=";
        var K = 1;
        var T = 1;
        if ($(this).closest("tbody").find("#dopK").val()) {
            K = $(this).closest("tbody").find("#dopK").val();
            //  alert(K);
        }
        if ($(this).closest("tbody").find("#dopT").val()) {
            T = $(this).closest("tbody").find("#dopT").val();
            // alert(T);
        }
        formula += T + "*" + K + "*" + vr + "=";
        // alert(formula);
        $(this).closest("tbody").find("#dopFormula").html(formula);
        var itogo = K * T * vr;
        // alert(itogo);
        $(this).closest("tbody").find("#dopItogo").html(Math.round(itogo * 100) / 100);
    });
});

/*  function raspredelenie() {
      var itogoTrudozatraty = document.getElementById("itogoTrudozatrat").innerHTML;
      //alert("itogoTrudozatrat=" + itogoTrudozatraty);
      var count = document.getElementsByName('valueRaspredelenie').length;
      //alert("count =" + count);
      var n = 0;
      for (var i = 0; i < count; i++) {
          // alert('valueRaspredelenie' + i);
          var valueRaspredelenie = document.getElementById('valueRaspredelenie' + i).value;
          //   alert("valueRaspredelenie=" + valueRaspredelenie);
          document.getElementById("valueRaspredelenieItogo" + i).innerHTML = Math.round(itogoTrudozatraty / 100 * valueRaspredelenie * 100) / 100;
          if (valueRaspredelenie > 0) {
              n += itogoTrudozatraty / 100 * valueRaspredelenie;
          }
      }
      document.getElementById("itogoRaspredelenoeZatrat").innerHTML = Math.round(n * 100) / 100;
      var Vr = document.getElementById("vr").innerHTML;
      var stoimostPSDFormula = Vr + " * " + Math.round(n * 100) / 100 + " = ";
      document.getElementById("stoimostPSDFormula").innerHTML = stoimostPSDFormula;
      //document.getElementById("stoimostPSD").innerHTML = Math.round((Vr * Math.round(n * 100) / 100) * 100) / 100;
      $(this).closest("tbody").find("#stoimostPSD").html(Math.round((Vr * Math.round(n * 100) / 100) * 100) / 100);
  }*/

$(document).on('change', '.valueRaspredelenie', function () {
    $(this).val($(this).val().replace(',', '.'));
    var sum = 0;
    var Vr = parseFloat($("#vr").html());
    var itogoTrudozatraty = parseFloat($(this).closest("Tbody").find("#itogoTrudozatrat").html());
    //alert(itogoTrudozatraty);
    $(this).closest("tr").find(".valueRaspredelenieItogo").html(Math.round(itogoTrudozatraty / 100 * $(this).val() * 100) / 100);
    $(this).closest("tbody").find(".valueRaspredelenieItogo").each(function () {
        if ($.isNumeric(parseFloat($(this).html()))) {
            sum += parseFloat($(this).html());
        }
        //alert("sum=" + sum + " this.val=" + $(this).html());
    });
    sum = sum.toFixed(2);
    $(this).closest("tbody").find("#itogoRaspredelenoeZatrat").html(sum);
    var stoimostPSDFormula = Vr + " * " + Math.round(sum * 100) / 100 + " = ";
    $(this).closest("tbody").find("#stoimostPSDFormula").html(stoimostPSDFormula);
    $(this).closest("tbody").find("#stoimostPSD").html(Math.round((Vr * Math.round(sum * 100) / 100) * 100) / 100);
})


function getNztTable() {
    var selind = document.getElementById("nztId").options.selectedIndex;
    var val = document.getElementById("nztId").options[selind].value;
    $.ajax({
        // url: '${pageContext.request.contextPath }/searchNztTable',
        url: '/searchNztTable',
        dataType: 'html',
        data: 'tableId=' + val,
        success: function (data) {

            $('#nztTableSpan').html(data);

        }
    });
};

function getNztNorm() {
    var selind = document.getElementById("nztTableId").options.selectedIndex;
    var val = document.getElementById("nztTableId").options[selind].value;
    if (val > 20 && val < 30) {
        $("#divRaspredelenie").css("display", "block");
        $("input[name=raspredelenie]").prop("checked", false);
    } else {
        $("#divRaspredelenie").css("display", "none")
    }
    if (val == 153) {
        $("#paralProkladkaP").css("display", "block");
    } else $("#paralProkladkaP").css("display", "none");
    if (val > 126 && val < 176) {
        $("#divDopKoef").css("display", "block");
        $("#divDopKoef").html(getKoef22Sbornik(val * 1));

    } else if ((val > 15 && val < 30) || val == 207) {
        $("#divDopKoef").css("display", "block");
        $("#divDopKoef").html(getKoef20Sbornik(val * 1));
    } else {
        $("#divDopKoef").css("display", "none");
        $("#divDopKoef").empty();
    }


    $.ajax({
        //  url: '${pageContext.request.contextPath }/searchnztnorm',
        url: '/searchnztnorm',
        dataType: 'html',
        data: 'tableId=' + val,
        success: function (data) {
            $('#nztNormSpan').html(data);

        }
    });
};


function getVr() {
    var dateVr = document.getElementById("dateBegin").value;

    $.ajax({
        // url: '${pageContext.request.contextPath }/vr',
        url: '/vr',
        dataType: 'html',
        data: 'dateVr=' + dateVr,
        success: function (data) {
            $('#vrHide').html(data);

            $('.vr').each(function () {
                $(this).html(data);
                // var $objNzt=$(this).closest("tbody#nzt");
                console.log("nzt = " + $(this).closest("tbody").is("#nzt"));

                if($(this).closest("tbody").is("#nzt")) {
                 var raspredelenie=$(this).closest("tbody#nzt").find(".vidRabot").attr("data-raspredelenie");
                 if (raspredelenie=="yes"){
                     var itogoTrudozatrat=parseFloat($(this).closest("tbody#nzt").find("#itogoRaspredelenoeZatrat").html());
                     var itogo=Math.round(itogoTrudozatrat*data * 100) / 100;
                     $(this).closest("tbody#nzt").find("#stoimostPSD").html(itogo);
                     var formula=data+"*"+itogoTrudozatrat+"=";
                     $(this).closest("tbody#nzt").find("#stoimostPSDFormula").html(formula);

                 } else{
                     var itogoTrudozatrat=parseFloat($(this).closest("tbody#nzt").find("#itogoTrudozatrat").html());
                     var itogo=Math.round(itogoTrudozatrat*data * 100) / 100;
                     $(this).closest("tbody#nzt").find("#stoimostPSD").html(itogo);
                     var formula=data+"*"+itogoTrudozatrat+"=";
                     $(this).closest("tbody#nzt").find("#stoimostPSDFormula").html(formula);
                 }
                }
                if($(this).closest("tbody").is(".dopTbody")) {
                 var dopT=$(this).closest("tbody.dopTbody").find("#dopT").val();
                 var dopK=$(this).closest("tbody.dopTbody").find("#dopK").val();
                 var itogoDop=Math.round(dopT*dopK*data*100)/100;
                 var formulaDop="C="+dopT+"*"+dopK+"*"+data+"=";
                    $(this).closest("tbody.dopTbody").find("#dopItogo").html(itogoDop);
                    $(this).closest("tbody.dopTbody").find("#dopFormula").html(formulaDop);
                }
            });


        }
    });
};

function getNztNormByName() {
    if ($("#dateBegin").val()) {
        var selind = document.getElementById("nztTableId").options.selectedIndex;
        var val = document.getElementById("nztTableId").options[selind].value;
        var normObject = document.getElementById("nztNorm").options.selectedIndex;
        var nameNormObject = document.getElementById("nztNorm").options[normObject].value;
        var valueNormObject = document.getElementById("valueNzt").value;
        var dateBegin = document.getElementById("dateBegin").value;
        var koefVidStroitelstva = document.getElementById("koefVidStroitelstva").options.selectedIndex;
        var valKoefVidStroitelstva = document.getElementById("koefVidStroitelstva").options[koefVidStroitelstva].value;
        var paralProkladka = 0;
        if ($("#paralProkladka").prop("checked")) {
            paralProkladka = 1;
        }
        var withRaspredelenie = "no";
        var vidZdaniya = 0;
        var nztTableId = $("#nztTableId").val();
        if (nztTableId > 20 && nztTableId < 30) {
            withRaspredelenie = $("input[name=raspredelenie]:checked").val();
            if (withRaspredelenie == "yes") {
                vidZdaniya = $("#selectVidZdaniya").val();
            }
        }

        $.ajax({
            // url: '${pageContext.request.contextPath }/smetaResult',
            url: '/smetaResult',
            dataType: 'html',
            data: 'tableId=' + val + '&NormName=' + nameNormObject + '&valueNormObject=' + valueNormObject + '&koefVidStroitelstva=' + valKoefVidStroitelstva + '&dateBegin=' + dateBegin + '&vidZdaniya=' + vidZdaniya + '&withRaspredelenie=' + withRaspredelenie + '&paralProkladka=' + paralProkladka,
            success: function (data) {
                var $dat = $(data).clone();
                var obosnovanie = $dat.find(".tdObosnovanie").text();
                var raschet = $dat.find(".tdRsachet").text();
                var trudozatraty = parseFloat($dat.find(".tdTrudozatraty").text());
                var itogoTrudozatrat = parseFloat($dat.find(".tdItogoTrudozatrat").text());
                var vr = parseFloat($dat.find("#vr").text());
                var n = 0;
                var koef = "";
                $('#divDopKoef input:checkbox:checked').each(function () {
                    n++;
                    if (n == 1) {
                        raschet = "(" + raschet + ")";
                        koef = $(this).val();
                    } else {
                        koef = koef + "*" + $(this).val();
                    }
                    obosnovanie = obosnovanie + "; " + $(this).parent("label").text();
                    raschet = raschet + "*" + $(this).val();

                    trudozatraty = trudozatraty * $(this).val();
                    itogoTrudozatrat = itogoTrudozatrat * $(this).val();
                    //  alert($(this).val());
                    // alert ($(this).parentNode.textContent);
                    // alert($(this).parent("label").text());
                })
                itogoTrudozatrat = Math.round(itogoTrudozatrat * 100) / 100;
                $dat.find(".tdObosnovanie").text(obosnovanie);
                $dat.find(".tdRsachet").text(raschet);
                $dat.find(".tdTrudozatraty").text(Math.round(trudozatraty * 100) / 100);
                $dat.find(".tdItogoTrudozatrat").text(itogoTrudozatrat);
                $dat.find("#stoimostPSDFormula").text(vr + "*" + itogoTrudozatrat);
                $dat.find("#stoimostPSD").text(Math.round(itogoTrudozatrat * vr * 100) / 100);
                $dat.find(".vidRabot").attr("data-koef", koef);

                $('#result').before($dat);

            }
        });
    } else {
        alert("Не указана дата");
    }
};
//добавление номера договора в дополнительное поле
$(document).on("change", "#inpNomerDogovora", function () {
    $("#prilozhenie").html("Приложение к договору № " + $(this).val());

})

//изменение НЗТ в таблице через Input
$(document).on("change", ".inpValueNormObject", function () {
    if ($("#dateBegin").val()) {
        var obosnovanieFull = $(this).closest("tr").find(".tdObosnovanie").text();
        console.log("обоснование = " + obosnovanieFull);
        var val = $(this).parent("td").attr("data-idtable");
        var nameNormObject = $(this).parent("td").text().slice(0, -1);
        var valueNormObject = $(this).val();
        var dateBegin = document.getElementById("dateBegin").value;
        var valKoefVidStroitelstva = $(this).closest("tr").find(".koefVidStroitelstva").html();
        var paralProkladka = 0;
        var withRaspredelenie = $(this).parent("td").attr("data-raspredelenie");
        var vidZdaniya = $(this).parent("td").attr("data-vidZdaniya");
        var koefFull = $(this).parent("td").attr("data-koef");
        var arrKoef = koefFull.split("*");
        var $oldTBody = $(this).closest("tbody");
        $.ajax({
            // url: '${pageContext.request.contextPath }/smetaResult',
            url: '/smetaResult',
            dataType: 'html',
            data: 'tableId=' + val + '&NormName=' + nameNormObject + '&valueNormObject=' + valueNormObject + '&koefVidStroitelstva=' + valKoefVidStroitelstva + '&dateBegin=' + dateBegin + '&vidZdaniya=' + vidZdaniya + '&withRaspredelenie=' + withRaspredelenie + '&paralProkladka=' + paralProkladka,
            success: function (data) {
                var $dat = $(data).clone();

                var raschet = $dat.find(".tdRsachet").text();
                var trudozatraty = parseFloat($dat.find(".tdTrudozatraty").text());
                var itogoTrudozatrat = parseFloat($dat.find(".tdItogoTrudozatrat").text());
                var vr = parseFloat($dat.find("#vr").text());
                var n = 0;
                var koef = "";

                if (koefFull) {
                    $.each(arrKoef, function (index, value) {
                        n++;
                        if (n == 1) {
                            raschet = "(" + raschet + ")";
                            koef = value;
                        } else {
                            koef = koef + "*" + value;
                        }

                        raschet = raschet + "*" + value;

                        trudozatraty = trudozatraty * value;
                        itogoTrudozatrat = itogoTrudozatrat * value;

                    })
                }
                itogoTrudozatrat = Math.round(itogoTrudozatrat * 100) / 100;
                $dat.find(".tdObosnovanie").text(obosnovanieFull);
                $dat.find(".tdRsachet").text(raschet);
                $dat.find(".tdTrudozatraty").text(Math.round(trudozatraty * 100) / 100);
                $dat.find(".tdItogoTrudozatrat").text(itogoTrudozatrat);
                $dat.find("#stoimostPSDFormula").text(vr + "*" + itogoTrudozatrat);
                $dat.find("#stoimostPSD").text(Math.round(itogoTrudozatrat * vr * 100) / 100);
                $dat.find(".vidRabot").attr("data-koef", koefFull);
                $oldTBody.replaceWith($dat);
                // $('#result').before($dat);

            }
        });
    } else {
        alert("Не указана дата");
    }
});

//значения коэффициентов для 22 сборника по id таблицы
function getKoef22Sbornik(id) {
    var obshKoef = " <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1\">1.0 - 1 категория сложности</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.15\">1.15 - 2 категория сложности</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.25\">1.25 - 3 категория сложности</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.35\">1.35 - 4 категория сложности</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.45\">1.45 - 5 категория сложности</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.2\">1.2 - зона просадочных, набухающих грунтов</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.2\">1.2 - зона метрополитена</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.2\">1.2 - историческая зона</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.2\">1.2 - зона охраняемого ландшафта</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.2\">1.2 - полоса отвода ЖД</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.5\">1.5 - оползневые и карстовые участки</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"0.3\">0.3 - ликвидация инженерных коммуникаций</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"0.8\">0.8 - разработка второго варианта</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"0.6\">0.6 - разработка третьего или последующего варианта</label></p>";
// 2.1 - Улицы и транспортные узлы
    var koef2_1 = "<p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.2\">1.2 - развязка в трех и более уровнях</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.15\">1.15 - увеличение количества полос на одну</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.4\">1.4 - увеличение на две полосы и более</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"0.7\">0.7 - для тротуаров</label></p>";
    // 3.1 - Организация дорожного движения
    var koef3_1 = "<p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.2\">1.2 - для существующей организации дорожного движения</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.3\">1.3 - число полос более 6</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.3\">1.3 - улицы с местными проездами</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.8\">1.8 - улицы с линиями рельсового транспорта</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"0.3\">0.3 - применение схем ОДД</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.2\">1.2 - демонтаж и установка светофорных объектов</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"0.75\">0.75 - менее четырех улиц в узле</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.2\">1.2 - более четырех улиц в узле</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.3\">1.3 - узел с круговым движением</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"2.0\">2.0 - узел с линиями рельсового транспорта</label></p>";

// 3.2 - Автоматизированные системы управления дорожным движением
    var koef3_2 = "<p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.3\">1.3 - наличие рельсового транспорта</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.3\">1.3 - наличие узлов с круговым движением</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.2\">1.2 - наличие узлов с числом сходящихся улиц более четырех</label></p>";

// 4.1 - Подземные пешеходные переходы
    var koef4_1 = "<p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"0.8\">0.8 - для габионных конструкций</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.3\">1.3 - для ПП с пустотелым перекрытием для пропуска ИК в продольном направлении</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"0.8\">0.8 - сооружения из серийных типовых конструкции</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"0.8\">0.8 - для набережных с вертикальными стенами</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"0.4\">0.4 - для откосных набережных на естественных основаниях</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"0.15\">0.15 - для спец. вспомогательных сооружений и устройств, сооружаемых откр. способом на стадии А</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"0.35\">0.35 - для спец. вспомогательных сооружений и устройств, сооружаемых откр. способом на стадии С</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"0.5\">0.5 - для спец. вспомогательных сооружений и устройств, сооружаемых откр. способом на стадии СсАС</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.2\">1.2 - для пересечений набережнымх с дюкерами</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.2\">1.2 - для освещения с повышенными светотехническими требованиями</label></p>";
// 4.2 подземные коммуникационные тоннели
    var koef4_2 = "<p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.4\">1.4 - для узлов и камер на коллекторах, сооружаемых закрытым способом</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.3\">1.3 - для узлов и камер при глубине заложения более 4м</label></p>";
// 6
    var koef6 = "<p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.5\">1.5 - для переходов трубопроводов через естественные препятсвия дюкерами и эстакадами</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.1\">1.1 - для трубопроводов из неметаллических труб</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.15\">1.15 - на стадии С по геодезическим планам в масштабе 1:200</label></p>"

// 6.1 Сети водопровода, сооружаемые открытым способом
    var koef6_1 = "<p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.2\">1.2 - для искусственного основания под трубопроводы или сооружения</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"0.3\">0.3 - при прокладке трубопроводов одного назначения с количеством нитей более одной для каждой последующей нити </label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"0.6\">0.6 - при прокладке трубопроводов в коллекторах </label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.0\">1.0 - при прокладке трубопроводов в футлярах, укладываемых открытым способом до 5% от протяженности основной сети</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.05\">1.05 - при прокладке трубопроводов в футлярах, укладываемых открытым способом от 5% до 10% от протяженности основной сети</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.10\">1.10 - при прокладке трубопроводов в футлярах, укладываемых открытым способом свыше 10% от протяженности основной сети</label></p>\n" +
        "    ";
    // 6.2 Канализационные сети и коллекторы
    var koef6_2 = "<p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.2\">1.2 - для искусственного основания под трубопроводы или сооружения </label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.5\">1.5 - для щитовых проходок глубиной более 20 м </label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.2\">1.2 - для щитовых проходок диаметром более 2,6 м </label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.05\">1.05 - для врезки в существующий коллектор диаметром более 1000 мм</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.0\">1.0 - при прокладке трубопроводов в футлярах, укладываемых открытым способом до 5% от протяженности основной сети</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.05\">1.05 - при прокладке трубопроводов в футлярах, укладываемых открытым способом от 5% до 10% от протяженности основной сети</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.10\">1.10 - при прокладке трубопроводов в футлярах, укладываемых открытым способом свыше 10% от протяженности основной сети</label></p>";
// 6.3 Водозаборные сооружения из поверхностных источников с насосной станцией I подъема
    var koef6_3 = "<p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.2\">1.2 - при установке на объектах высоко напорных насосных агрегатов </label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.03\">1.03 - при установке на объектах регулируемого электропривода</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.04\">1.04 - при установке на объектах микропроцессорных контроллеров и других новых средств автоматизации </label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.0\">1.0 - в зависимости от амплитуд колебания уровней воды, до 6 м</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.1\">1.1 - в зависимости от амплитуд колебания уровней воды, от 6 до 12 м</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.15\">1.15 - в зависимости от амплитуд колебания уровней воды, свыше 12 м</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.05\">1.05 - при разработке мероприятий по рыбозащите </label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.05\">1.05 - при разработке мероприятий по борьбе с наносами и шугой</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.2\">1.2 - при разработке проектной документации для сооружений, строительство которых будет осуществляться опускным способом </label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.0\">1.0 - в зависимости от глубины заглубления насосных станций 1-го подъема, до 1.5 м</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.1\">1.1 - в зависимости от глубины заглубления насосных станций 1-го подъема, свыше 1.5 до 3 м</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.2\">1.2 - в зависимости от глубины заглубления насосных станций 1-го подъема, свыше 3 до 4.5 м</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.3\">1.3 - в зависимости от глубины заглубления насосных станций 1-го подъема, свыше 4.5 м</label></p>";
// 6.4 Водозаборы из подземных источников
    var koef6_4 = "<p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.02\">1.02 - для лучевого водозабора, каптажа ключей, горизонтального водозабора или подруслового водозабора</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"0.8\">0.8 - для водозабора без надземного павильона</label></p>";
// 6.5 Водопроводные очистные сооружения
    var koef6_5 = "<p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.2\">1.2 - для сооружений на площадках с коэффициентом застройки 0,5 и более</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.03\">1.03 - при применении четырех видов реагентов к поз. 2260503, 2260504, 2260506</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.06\">1.06 - при применении пяти видов реагентов к поз. 2260503, 2260504, 2260506</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.09\">1.09 - при применении шести видов реагентов к поз. 2260503, 2260504, 2260506</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.12\">1.12 - при применении семи видов реагентов к поз. 2260503, 2260504, 2260506</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.15\">1.15 - при применении восьми и более видов реагентов к поз. 2260503, 2260504, 2260506</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"0.8\">0.8 - поз. 2260509 при 3 реагентах</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"0.6\">0.6 - поз. 2260509 при 2 реагентах</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"0.4\">0.4 - поз. 2260509 при 1 реагенте</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.04\">1.04 - при применении регулируемого электропривода</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.07\">1.07 - при применении микропроцессорных контроллеров или других новых средств автоматизации при производительности до 80 тыс. м3/сут </label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.11\">1.11 - при применении микропроцессорных контроллеров или других новых средств автоматизации при производительности более 80 тыс. м3/сут </label></p>";
// 6.6 Насосная станция II подъема, подкачки или систем оборотного водоснабжения
    var koef6_6 = "<p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.2\">1.2 - для насосной станции с высоконапорными агрегатами</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.09\">1.09 - при применении микропроцессорных контроллеров или других новых средств автоматизации</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.08\">1.08 - при применении регулируемого электропривода</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.1\">1.1 - для насосных станций во взрывозащищенном исполнении</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.0\">1.0 - для заглубленных насосных станций в зависимости от глубины заглубления, до 1,5 м включительно</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.1\">1.1 - для заглубленных насосных станций в зависимости от глубины заглубления, свыше 1,5 до 3,0 м включительно</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.2\">1.2 - для заглубленных насосных станций в зависимости от глубины заглубления, свыше 3,0 до 4,5 м включительно</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.3\">1.3 - для заглубленных насосных станций в зависимости от глубины заглубления, свыше 4,5 до 6,0 м включительно</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.4\">1.4 - для заглубленных насосных станций в зависимости от глубины заглубления, свыше 6,0 до 7,5 м включительно</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.5\">1.5 - для заглубленных насосных станций в зависимости от глубины заглубления, свыше 7,5 м включительно</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.2\">1.2 - для отдельно стоящих камер фильтров-поглотителей</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.1\">1.1 - в случае устройства резервуаров без обвалования и необходимости дополнительного проектирования отвода поверхностного стока и ограждения резервуара</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"0.6\">0.6 - при разработке встроенных повысительных насосных станций</label></p>";

// 6.7 Вентиляторные градирни
    var koef6_7 = "<p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.2\">1.2 - для градирен с высоковольтными двигателями</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.0\">1.0 - 1 секция в градирне</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.1\">1.1 - 2 секции в градирне</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.2\">1.2 - 3 секции в градирне</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.3\">1.3 - 4 секции в градирне</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.4\">1.4 - 5 секций в градирне</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.5\">1.5 - 6 и более секций в градирне</label></p>";
// 6.9 Станции перекачки сточных вод
    var koef6_9 = "<p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.0\">1.0 - для канализационных насосных станций в зависимости от глубины заложения подводящего коллектора, до 4.0 м включительно</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.1\">1.1 - для канализационных насосных станций в зависимости от глубины заложения подводящего коллектора, свыше 4.0 до 5.5 м включительно</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.2\">1.2 - для канализационных насосных станций в зависимости от глубины заложения подводящего коллектора, свыше 5.5 до 7.0 м включительно</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.3\">1.3 - для канализационных насосных станций в зависимости от глубины заложения подводящего коллектора, свыше 7.0 до 8.5 м включительно</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.4\">1.4 - для канализационных насосных станций в зависимости от глубины заложения подводящего коллектора, свыше 8.5 до 10.0 м включительно</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.5\">1.5 - для канализационных насосных станций в зависимости от глубины заложения подводящего коллектора, свыше 10.0 м </label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.2\">1.2 - для канализационных насосных станций, строительство которых будет осуществляться опускным способом </label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.2\">1.2 - для канализационных насосных станций, перекачивающих агрессивные сточные воды</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.1\">1.1 - для канализационных насосных станций, перекачивающих взрывоопасные сточные воды</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.18\">1.18 - при применении микропроцессорных контроллеров или других новых средств автоматизации</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.14\">1.14 - при применении регулируемого электропривода</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"0.7\">0.7 - для канализационных насосных станций без наземной части</label></p>";
// 6.10 Сооружения для очистки сточных вод
    var koef6_10 = "<p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.2\">1.2 - для зданий и сооружений на площадках с коэффициентом застройки 0,5 и более </label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.1\">1.1 - при применении микропроцессорных контроллеров или других новых средств автоматизации </label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"0.2\">0.2 - для площадки для складирования снега  </label></p>";
// 6.11 Сооружения для обработки осадка сточных вод
    var koef6_11 = "<p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"0.5\">0.5 - для нескольких метантеков, для второго и каждого последующего </label></p>\n";
// 6.12 Иловые площадки, накопители и пруды очистных сооружений водоснабжения и канализации
    var koef6_12 = "<p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"0.8\">0.8 - 1 группа инженерно-геологических условий  </label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.0\">1.0 - 2 группа инженерно-геологических условий  </label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.2\">1.2 - 3 группа инженерно-геологических условий  </label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"0.9\">0.9 - при отсутствии противофильтрационного экрана</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"0.8\">0.8 - при отсутствии дренажа для иловых площадок на искусственном основании</label></p>";
// 6.13 Пульпонасосные станции
    var koef6_13 = "<p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.06\">1.06 - при применении микропроцессорных контроллеров или других новых средств автоматизации </label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.06\">1.06 - при применении регулируемого электропривода</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.1\">1.1 - при разработке мероприятий противоаварийного затопления </label></p>";
// 6.14 Водонапорные башни
    var koef6_14 = "<p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"0.61\">0.61 - ствол до 6 м включительно</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"0.74\">0.74 - ствол свыше 6 м до 12 м включительно</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"0.87\">0.87 - ствол свыше 12 м до 18 м включительно</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.0\">1.0 - ствол свыше 18 м до 30 м включительно</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.15\">1.15 - ствол свыше 30 м до 36 м включительно</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.3\">1.3 - ствол свыше 36 м до 42 м включительно</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.42\">1.42 - ствол свыше 42 м </label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"0.85\">0.85 - для башен с кирпичным стволом или стволом из монолитного железобетона</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"0.8\">0.8 - для башен со стальным стволом</label></p>";
// 6.15 Дренаж
    var koef6_15 = "<p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.2\">1.2 - сложная конфигурация фундамента</label></p>";
// 7.1 Тепловые сети, узлы учета и управления
    var koef7_1 = "<p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.1\">1.1 - для бесканальной прокладки тепловых сетей в ППУ</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"0.8\">0.8 - при прокладке тепловой сети одним трубопроводом </label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.15\">1.15 - для высоких опор (высота >= 2,5м) </label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.10\">1.10 - для низких опор (высота < 2,5 м)  </label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.2\">1.2 - для искусственного основания под трубопроводы или сооружения</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"0.6\">0.6 - для прокладки коммуникаций в коллекторах</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.2\">1.2 - для паропроводов </label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"0.7\">0.7 - при совместной прокладке более двух трубопроводов для каждых двух последующих трубопроводов </label></p>";
// 7.2 Центральные и индивидуальные тепловые пункты
    var koef7_2 = "<p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"0.7\">0.7 - для ИТП с количеством узлов присоединения систем отопления или теплоснабжения приточной вентиляции и кондиционирования воздуха более одного на второй и каждый последующий</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"0.7\">0.7 - для ИТП с количеством узлов присоединения систем горячего водоснабжения более одного на второй и каждый последующий</label></p>";
// 8.1 Сети газоснабжения
    var koef8_1 = "<p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.3\">1.3 - для прокладки газопроводов СУГ </label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.2\">1.2 - для прокладки газопроводов с надземной прокладкой (кроме газопроводов СУГ)</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"0.7\">0.7 - для прокладки газопроводов по фасадам зданий</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"0.6\">0.6 - для подводящих газопроводов-вводов для газификации жилых домов</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.1\">1.1 - для технических газопроводов (кислородо-, азото-, аргонопроводов и т.д.) </label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.2\">1.2 - для газопроводов в зависимости от диаметра, более 600 мм </label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.3\">1.3 - для газопроводов в зависимости от диаметра, более 1000 мм </label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"0.8\">0.8 - для второго газопровода в одной траншее с основным газопроводом </label></p>";
// 8.2 Газораспределительные станции и газорегуляторные пункты
    var koef8_2 = "<p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"0.5\">0.5 - для объемно-блочного ГРП  </label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"0.2\">0.2 - для ШРП</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.2\">1.2 - для ГРП, ШРП и ГРУ с узлом учета расхода газа</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"0.5\">0.5 - для ГРС блочного типа</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.2\">1.2 - для сооружений (объектов) с чердаками</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"0.6\">0.6 - для ГРУ</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"0.3\">0.3 - для узла учета расхода газа</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"0.5\">0.5 - для ГРП, ШРП и ГРУ с 3-мя и более нитками регулирования</label></p>";
// 8.3 Газооборудование существующих жилых домов
    var koef8_3 = "<p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"0.9\">0.9 - при площади дома до 100 м2</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.0\">1.0 - при площади дома до 150 м2</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.3\">1.3 - при площади дома до 300 м2</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.5\">1.5 - при площади дома свыше 300 м2 </label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"0.5\">0.5 - в случае необходимости внесения изменения в ранее выпущенный проект  </label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.1\">1.1 - при установке в домах более 3-х приборов,  на четвертый и каждый последующий прибор </label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"0.5\">0.5 - выполнение проектных работ по второй и каждой последующей типовой квартире</label></p>";
// 8.5 Переходы газопроводов
    var koef8_5 = "<p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.3\">1.3 - для надземного перехода через автомобильные и железные дороги </label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.2\">1.2 - для надземного перехода через мосты </label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"0.8\">0.8 - для нескольких переходов для второго и каждого последующего перехода</label></p>";
// 8.7 Резервуары хранения для сжиженного углеводородного газа
    var koef8_7 = "<p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"0.3\">0.3 - для второго и каждого последующего резервуара с одинаковыми характеристиками</label></p>";
// 9.1 Электрическая защита подземных сооружений от коррозии
    var koef9_1 = "<p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"0.5\">0.5 - для протекторной (гальванической) защиты или диодно-резисторного блока (совместной) защиты</label></p>";
// 9.2 Наружное освещение
    var koef9_2 = "<p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.2\">1.2 - для автотранспортных тоннелей длиной более 60 м</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"0.7\">0.7 - для второго и каждого последующего ряда опор</label></p>";
    // 9.5 Распределительные сети 0,4-10 кВ
    var koef9_5 = "<p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.5\">1.5 - для двухцепных воздушных линий</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"2.0\">2.0 - для трехцепных воздушных линий</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.5\">1.5 - при совместной подвеске воздушных линий и линий наружного освещения</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.5\">1.5 - при совместной подвеске воздушных линий до 1 кВ и воздушных линий свыше 1 кВ</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.45\">1.45 -  для кабельных линий и линий наружного освещения одним изолированным проводом</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.4\">1.4 -  для воздушных линий с изолированными проводами</label></p>";
    // 9.6 Распределительные сети 0,4-10 кВ
    var koef9_6 = "<p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.2\">1.2 - при прокладке кабелей в коллекторе</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"4.5\">4.5 - при прокладке кабелей по эстакадам</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"2.5\">2.5 - при прокладке кабелей по зданиям и сооружениям </label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"4.0\">4.0 - при прокладке кабелей в кабельных каналах, в кабельной канализации</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"0.3\">0.3 - для нескольких параллельно прокладываемых кабелей, прокладываемых в одной траншее, для второго и каждого последующего кабеля</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.2\">1.2 - для линий напряжением 35 кВ</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.0\">1.0 - для линий напряжением 0,4 кВ</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"0.8\">0.8 - для линий напряжением до 0,4 кВ</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"0.6\">0.6 - для контрольных кабелей</label></p>";
// 9.7 Трансформаторные подстанции
    var koef9_7 = "<p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"0.8\">0.8 - для ЗТП с одним трансформатором </label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"0.2\">0.2 - для ЗТП с количеством трансформаторов более двух для третьего и каждого последующего трансформатора </label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.07\">1.07 - для ТП с тепловой защитой </label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"0.80\">0.80 - для ТП с мощностью трансформатора 400 кВ*A и ниже</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"0.1\">0.1 - для ТП и РП с ячейками РУВН с вакуумными, элегазовыми или аналогичными выключателями для каждой такой ячейки</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"0.2\">0.2 - для закрытого РП с количеством секций 6-10 кВ более двух для третьей и каждой последующей секции </label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.08\">1.08 - для раздела ЭС</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.15\">1.15 - ТП и РП с импортным оборудованием</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.06\">1.06 - РТП с максимальной направленной защитой на вводах</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"0.50\">0.50 - комплектной трансформаторной подстанции (КТП)</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.10\">1.10 - ТП с РУВН до 16 шкафов </label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.3\">1.3 - для комплектной трансформаторной подстанции (КТПП) </label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"0.05\">0.05 - для РП с количеством шкафов сверх указанных в таблице 9.7 для каждого последующего шкафа</label></p>";
// 9.10 Разработка индивидуальных низковольтных комплектных устройств (НКУ), пультов и шкафов КИПиА
    var koef9_10 = "<p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.0\">1.0 - при ширине шкафа до 600 мм </label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.3\">1.3 - при ширине шкафа от 601 до 800 мм </label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.5\">1.5 - при ширине шкафа от 801 до 1000 мм </label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.8\">1.8 - при ширине шкафа от 1001 до 1200 мм </label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.0\">1.0 - -\tпри глубине шкафа до 600 мм </label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.1\">1.1 - при глубине шкафа от 600 до 800 мм </label></p>";
// 9.11 Городской электрифицированный транспорт (трамвай, троллейбус)
    var koef9_11 = "<p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.5\">1.5 - при продольных уклонах до 25% </label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"2.0\">2.0 - при продольных уклонах 25% и более</label></p>";
// Таблица 9.12 - Контактные сети и транспортные узлы
    var koef9_12 = "<p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"0.3\">0.3 - для работ по демонтажу контактной сети</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"0.4\">0.4 - для расстановки опорных конструкций на улицах с перспективной организацией троллейбусного движения к поз. 2291201-2291202, 2291204-2291205 </label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"0.5\">0.5 - для расстановки опорных конструкций на улицах с перспективной организацией троллейбусного движения к поз. 2291203</label></p>";
// 9.14 - Кабельная канализация кабельных линий, кабелей электросвязи и волоконно-оптических кабелей
    var koef9_14 = "<p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"0.7\">0.7 - 9.9.6\tПри прокладке кабелей электросвязи с металлическими проводниками в грунте на городских и загородных участках к затратам трудовых ресурсов позиции 2291401</label></p>";
    var result = "<p>Другие коэффициенты</p>";
    switch (id) {
        case 127:
            result = obshKoef + koef2_1;
            break;
        case 128:
            result = obshKoef + koef3_1;
            break;
        case 129:
            result = obshKoef + koef3_2;
            break;
        case 130:
            result = obshKoef + koef4_1;
            break;
        case 131:
            result = obshKoef + koef4_2;
            break;
        case 136:
            result = obshKoef + koef6 + koef6_1;
            break;
        case 137:
            result = obshKoef + koef6 + koef6_2;
            break;
        case 138:
            result = obshKoef + koef6 + koef6_3;
            break;
        case 139:
            result = obshKoef + koef6 + koef6_4;
            break;
        case 140:
            result = obshKoef + koef6 + koef6_5;
            break;
        case 141:
            result = obshKoef + koef6 + koef6_6;
            break;
        case 142:
            result = obshKoef + koef6 + koef6_7;
            break;
        case 143:
            result = obshKoef + koef6;
            break;
        case 144:
            result = obshKoef + koef6 + koef6_9;
            break;
        case 145:
            result = obshKoef + koef6 + koef6_10;
            break;
        case 146:
            result = obshKoef + koef6 + koef6_11;
            break;
        case 147:
            result = obshKoef + koef6 + koef6_12;
            break;
        case 148:
            result = obshKoef + koef6 + koef6_13;
            break;
        case 149:
            result = obshKoef + koef6 + koef6_14;
            break;
        case 150:
            result = obshKoef + koef6 + koef6_15;
            break;
        case 151:
            result = obshKoef + koef6;
            break;
        case 152:
            result = obshKoef + koef6;
            break;
        case 153:
            result = obshKoef + koef7_1;
            break;
        case 154:
            result = obshKoef + koef7_2;
            break;
        case 155:
            result = obshKoef + koef8_1;
            break;
        case 156:
            result = obshKoef + koef8_2;
            break;
        case 157:
            result = obshKoef + koef8_3;
            break;
        case 159:
            result = obshKoef + koef8_5;
            break;
        case 161:
            result = obshKoef + koef8_7;
            break;
        case 162:
            result = obshKoef + koef9_1;
            break;
        case 163:
            result = obshKoef + koef9_2;
            break;
        case 166:
            result = obshKoef + koef9_5;
            break;
        case 167:
            result = obshKoef + koef9_6;
            break;
        case 168:
            result = obshKoef + koef9_7;
            break;
        case 171:
            result = obshKoef + koef9_10;
            break;
        case 172:
            result = obshKoef + koef9_11;
            break;
        case 173:
            result = obshKoef + koef9_12;
            break;
        case 175:
            result = obshKoef + koef9_14;
            break;


        default:
            result = obshKoef;
            break;

    }
    return result;
}

//значения коэффициентов для 22 сборника по id таблицы
function getKoef20Sbornik(id) {
    var obshKoef = " <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1\">1.0 - 1 категория сложности</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.05\">1.05 - 2 категория сложности</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.10\">1.10 - 3 категория сложности</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.15\">1.15 - 4 категория сложности</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.20\">1.20 - 5 категория сложности</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.02\">1.02 - здания с вентилируемыми фасадами</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.15\">1.15 - для одно- и двухэтажных зданий с чердаками</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.10\">1.10 - для 3-5 этажных зданий с чердаками</label></p>\n" +
        "    <p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.05\">1.05 - для 6 этажных и большей этажности зданий с чердаками</label></p>";

// 2.1 — Благоустройство и озеленение территории
    var koef2_1 = "<p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.30\">1.30 - для объекта в составе исторической застройки, на территории историко-культурной ценности </label></p>\n" +
        "<p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.20\">1.20 - для объекта в зоне охраняемого ландшафта</label></p>\n" +
        "<p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.05\">1.05 - при наличии уклона поверхности территории до 5% или свыше 40% более чем на 30% площади </label></p>\n" +
        "<p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.20\">1.20 - для объектов на территории со сложными гидрологическими условиями</label></p>\n";

    // 2.2 - Парки, скверы, бульвары
    var koef2_2 = "<p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.30\">1.30 - для объекта в составе исторической застройки, на территории историко-культурной ценности</label></p>\n" +
        "<p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.20\">1.20 - для объекта в зоне охраняемого ландшафта</label></p>\n" +
        "<p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.30\">1.30 - для объекта с существующей сохраняемой застройкой на более 30% планируемой территории</label></p>\n";

    // Таблица 2.3 — Малые архитектурные формы и элементы благоустройства
    var koef2_3 = "<p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"0.50\">0.50 - объекты прямоугольных очертаний, из однородных материалов, без цветовых решений и орнаментальной или пластической обработки поверхности</label></p>\n" +
        "<p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.00\">1.00 - объекты прямоугольных очертаний с частичными криволинейными формами, из однородных материалов с цветовыми решениями усложненной пластической обработки поверхности</label></p>\n" +
        "<p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.00\">1.00 - объекты сложных криволинейных объемно-пространственных очертаний, сборно-разборных унифицированных конструкций, из ценных естественных или экспериментальных отделочных материалов, сложных по цветовым или пластически-орнаментальным решениям поверхности</label></p>\n";

    // 3.1 - Генеральный план застройки
    var koef3_1 = "<p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.20\">1.20 - участки в составе исторической застройки</label></p>\n" +
        "<p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.10\">1.10 - участки в зоне охраняемого ландшафта</label></p>\n" +
        "<p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.00\">1.00 - участки с плотностью застройки до 2,5 тыс.м2 общей площади/га</label></p>\n" +
        "<p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.20\">1.20 - участки с плотностью застройки от 2,5 до 5,0 тыс.м2 общей площади/га</label></p>\n" +
        "<p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.40\">1.40 - участки с плотностью застройки св. 5,0 тыс.м2 общей площади/га</label></p>\n" +
        "<p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.20\">1.20 - участки реконструируемых территорий</label></p>\n" +
        "<p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.10\">1.10 - участки объектов МЧС </label></p>\n" +
        "<p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.25\">1.25 - участки детских дошкольных учреждений</label></p>\n" +
        "<p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.25\">1.25 - участки школ</label></p>\n" +
        "<p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.2\">1.20 - участки торговых, коммунально-бытовых, административных, кредитно-финансовых учреждений, общественного питания, медицинского обслуживания</label></p>\n" +
        "<p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.2\">1.20 - участки гаражей и охраняемых автостоянок на количество машин более 50</label></p>\n" +
        "<p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.1\">1.10 - участки инженерно-технических объектов</label></p>\n";


    // Таблица 4.1 - Жилые здания
    var koef4_1 = "<p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"0.95\">0.95 - общежития с общими кухнями и санузлами</label></p>\n" +
        "<p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.05\">1.05 - жилые дома типовых потребительских качеств с улучшенной планировкой</label></p>\n" +
        "<p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.05\">1.05 - жилые дома для инвалидов и престарелых</label></p>\n" +
        "<p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.10\">1.10 - жилые дома повышенной комфортности</label></p>\n" +
        "<p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.10\">1.10 - террасные жилые дома</label></p>\n" +
        "<p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.10\">1.10 - для жилых домов до 5 этажей включительно с размещением в подвале здания сараев, подсобных помещений, подполья (подпольных каналов для пропуска инженерных коммуникаций) при наличии в доме технического этажа </label></p>\n" +
        "<p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.05\">1.05 - для жилых домов от 6 до 9 этажей с размещением в подвале здания сараев, подсобных помещений, подполья (подпольных каналов для пропуска инженерных коммуникаций) при наличии в доме технического этажа </label></p>\n" +
        "<p><label><input type=\"checkbox\" class=\"inpDopKoef\" value=\"1.025\">1.025 - для жилых домов свыше 9 этажей с размещением в подвале здания сараев, подсобных помещений, подполья (подпольных каналов для пропуска инженерных коммуникаций) при наличии в доме технического этажа </label></p>\n";

    var result = "<p>Другие коэффициенты</p>";
    switch (id) {
        case 16:
            result = obshKoef + koef2_1;
            break;
        case 17:
            result = obshKoef + koef2_2;
            break;
        case 18:
            result = obshKoef + koef2_3;
            break;
        case 20:
            result = obshKoef + koef3_1;
            break;
        case 21:
            result = obshKoef + koef4_1;
            break;
        default:
            result = obshKoef;
            break;

    }
    return result;
}

function subpodryad(classSubpodryd, nameSubpodryad, id) {
    var str = " <tbody style=\"border: 1px solid black;\"> <tr>" +
        "    <td style=\"border: 1px solid black;\" class=\"nomerPP\"></td>" +
        "    <td colspan=\"4\" style=\"border: 1px solid black;\">" + nameSubpodryad + "</td>" +
        "    <td colspan=\"3\"  style=\"border: 1px solid black;\"><input type=\"text\" id=\"SubNameDoc\" value=\"Документ\"></td>" +
        "    <td align=\"right\" style=\"border: 1px solid black;\"><input class=\"" + classSubpodryd + "\" type=\"text\" id=\"" + id + "\" value=\"Стоимость\"></td>" +
        "    <td style=\"border: 1px solid black;\">рублей</td>" +
        "    <td style=\"border: 1px solid black;\"><input type=\"button\" value=\"Удалить\" id=\"delSub\"></td>  " +
        "  </tr> </tbody>";
    return str;

}


function ishDannye(nameIshDannye) {
    var str = " <tbody>" +
        "<tr>" +
        "        <td width=\"82\" align=\"center\" class='numberIshDannye' style=\"border: 1px solid black;\"></td>" +
        "        <td colspan=\"2\" style=\"border: 1px solid black;\">" + nameIshDannye + "</td>\n" +
        "        <td width=\"275\" style=\"border: 1px solid black;\"></td>" +
        "        <td width=\"292\" style=\"border: 1px solid black;\"></td>" +
        "        <td width=\"292\" style=\"border: 0;\"><input type=\"button\" value=\"Удалить\" class=\"delIsh\"></td>\n" +
        "    </tr>" +
        "</tbody>";
    return str;
}

function koef(nameKoef) {
    console.log("коэфиц="+nameKoef);
    var str="";
    if (nameKoef=="drKoef"){
        console.log("drKoef="+nameKoef);
     str = " <tbody style=\"border: 1px solid black;\"> <tr>\n" +
        "    <td style=\"border: 1px solid black;\"></td>\n" +
        "    <td colspan=\"7\" align=\"right\" style=\"border: 1px solid black;\"><input type='text' class='inputNameKoeficient' style='width: 100%;'/></td>" +
        "    <td align=\"center\" id=\"stoimostSKoef\" style=\"border: 1px solid black;\"><input type='text' class='inpZnKoefDrugoy'></td>" +
        "    <td style=\"border: 1px solid black;\">рублей</td>" +
        " <td style=\"border: 1px solid black;\"><input type=\"button\" value=\"Удалить\" id=\"delKoef\"></td>\n" +
        "  </tr> </tbody>";} else
    {
         str = " <tbody style=\"border: 1px solid black;\"> <tr>\n" +
            "    <td style=\"border: 1px solid black;\"></td>\n" +
            "    <td colspan=\"5\" align=\"right\" style=\"border: 1px solid black;\">" + nameKoef + "</td>" +
            "    <td align=\"right\" style=\"border: 1px solid black;\">k=</td>\n" +
            "    <td align=\"center\" style=\"border: 1px solid black;\"><input type=\"text\" id=\"itogoKoef\" class=\"itogoKoef\" ></td>" +
            "    <td align=\"center\" id=\"stoimostSKoef\" style=\"border: 1px solid black;\"></td>" +
            "    <td style=\"border: 1px solid black;\">рублей</td>" +
            " <td style=\"border: 1px solid black;\"><input type=\"button\" value=\"Удалить\" id=\"delKoef\"></td>\n" +
            "  </tr> </tbody>";
    }
    return str;
}

function nalog(nameNalog) {
    var str = " <tbody id=\"idNalog\" style=\"border: 1px solid black;\"> <tr>" +
        "    <td style=\"border: 1px solid black;\"></td>" +
        "    <td colspan=\"5\" align=\"right\" style=\"border: 1px solid black;\">" + nameNalog + "</td>" +
        "    <td colspan=\"2\" align=\"center\" id=\"nalog\" style=\"border: 1px solid black;\">5%</td>" +
        "    <td align=\"center\" id=\"nalogItogo\" style=\"border: 1px solid black;\"></td>" +
        "    <td style=\"border: 1px solid black;\">рублей</td>" +
        "<td style=\"border: 1px solid black;\"><input type=\"button\" value=\"Удалить\" id=\"delNalog\"></td>" +
        "  </tr></tbody>";
    return str;
}


function dop(nameDop) {
    var vr = document.getElementById("vrHide").innerHTML;
    var str = "<tbody style=\"border: 1px solid black;\" class=\"dopTbody\"> <tr>\n" +
        "      <td rowspan=\"4\" style=\"border: 1px solid black;\" class=\"nomerPP\"></td>\n" + nameDop +

        "      <td  rowspan=\"4\" style=\"border: 1px solid black;\">По трудозатратам </td>\n" +
        "      <td style=\"border: 1px solid black;\"><label for=\"textfield\">Тр=</label></td>\n" +
        "      <td style=\"border: 1px solid black;\">\n" +
        "      <input type=\"text\" name=\"textfield\" id=\"dopT\" ></td>\n" +
        "      <td style=\"border: 1px solid black;\">факт.    Труд-ты</td>\n" +
        "     \n" +
        "      <td colspan=\"2\" rowspan=\"4\" id=\"dopFormula\" style=\"border: 1px solid black;\"></td>\n" +
        "      <td rowspan=\"4\" id=\"dopItogo\" style=\"border: 1px solid black;\"></td>\n" +
        "      <td  rowspan=\"4\" style=\"border: 1px solid black;\">рублей</td>\n" +
        "      <td  rowspan=\"4\" style=\"border: 1px solid black;\"><input type=\"button\" value=\"Удалить\" id=\"delTBody\"></td>\n" +
        "    </tr>\n" +
        "    <tr>\n" +
        "      <td style=\"border: 1px solid black;\"><label for=\"textfield2\">К1=</label></td>\n" +
        "      <td style=\"border: 1px solid black;\">\n" +
        "      <input type=\"text\" name=\"textfield2\" id=\"dopK\" ></td>\n" +
        "      <td style=\"border: 1px solid black;\">Т.1 МУ    2013</td>\n" +
        "    </tr>\n" +
        "    <tr>\n" +
        "      <td rowspan=\"2\" style=\"border: 1px solid black;\">Вр=</td>\n" +
        "      <td rowspan=\"2\" id=\"vr\" class=\"vr\" style=\"border: 1px solid black;\">" + vr + "</td>\n" +
        "      <td style=\"border: 1px solid black;\">Приказ    МАИС</td>\n" +
        "    </tr>\ n" +
        "    <tr>\n" +
        "      <td style=\"border: 1px solid black;\">п.33 МУ    2013</td>\n" +
        "    </tr></tbody>";
    return str;
}

function normTable(id) {
    var $smetaTable = $(id).clone();
    $smetaTable.find("input, textarea, select").each(function () {
        $(this).replaceWith($(this).val());
    });

    $smetaTable.find("tr").each(function () {
        if ((!$(this).find("td").last().html()) || ($(this).find("td").last().html() == "Удалить")) {
            $(this).find("td").last().remove();
        }
    });

    var smeta = "<table cellspacing=\"0\" cellpadding=\"0\" style=\"border:none; border-spacing:0; width: 700px; word-break: break-all;\">" + $smetaTable.html() + "</table>";
    return smeta;
}

function normTableObj(id) {
    var $smetaTable = $(id).clone();
    $smetaTable.find("input, textarea").each(function () {
        $(this).replaceWith($(this).val());
    });
    $smetaTable.find("tr").each(function () {
        if ((!$(this).find("td").last().html()) || ($(this).find("td").last().html() == "Удалить")) {
            $(this).find("td").last().remove();
        }
    });

    $smetaTable.after("</body>");
    $smetaTable.before("<table cellspacing=\"0\" cellpadding=\"0\" style=\"border:none; border-spacing:0;\">");
    return $smetaTable;
}

//формирование документа Word
$(document).on('click', '#toWord', function () {

    var smeta = normTable('#fullSmetaTable');

    var userObj = {"smetaTable": smeta};


    $.ajax({
        url: '/smetatabletoword',
        //url: '${pageContext.request.contextPath }/smetatabletoword',
        method: "post",
        contentType: "application/json",
        data: JSON.stringify(userObj),
        dataType: 'json',
        error: function (message) {
            console.log(message);
        },
        success: function (data) {
            window.open('/saveword', '_blank');
            console.log(data);
        }
    });
})





//добавление шапки
$(document).on('click', '#prilozhenieButton', function () {
    var tbody = "<tbody><tr style=\"border: none;\">" +
        "    <td colspan=\"7\" style=\"background-color: #ffffff; border: none;\"></td>n" +
        "    <td colspan=\"3\" style=\"background-color: #ffffff; border: none;\">" + $('#prilozhenie').val() + "</td>" +
        "    <td style=\"background-color: #ffffff; border: none;\"><input type=\"button\" value=\"Удалить\" id=\"delTBody\"></td>" +
        "  </tr>" +
        "  <tr>" +
        "    <td colspan=\"10\" align=\"center\" style=\"background-color: #ffffff; border: none;\">" + $('#nameSmeta').val() + "</td>" +
        "    <td></td>" +
        "  </tr>" +
        "  <tr>" +
        "    <td colspan=\"2\" align=\"right\" style=\"background-color: #ffffff; border: none;\">Наименование объекта:</td>" +
        "    <td colspan=\"8\" style=\"background-color: #ffffff; border: none;\">" + $('#nameObject').val() + "</td>" +
        "    <td></td>" +
        "  </tr>" +
        "  <tr>" +
        "    <td colspan=\"2\" align=\"right\" style=\"background-color: #ffffff; border: none;\">Заказчик:</td>" +
        "    <td colspan=\"8\" style=\"background-color: #ffffff; border: none;\">" + $('#nameOrganization').val() + "</td>" +
        "    <td></td>" +
        "  </tr>" +
        "  <tr>" +
        "    <td colspan=\"2\" align=\"right\" style=\"background-color: #ffffff; border: none;\">Подрядчик:</td>" +
        "    <td colspan=\"8\" style=\"background-color: #ffffff; border: none;\">ЧСУП  ВотерСеверейдж </td>" +
        "    <td style=\"background-color: #ffffff; border: none;\"></td>" +
        "  </tr>" +
        "</tbody>";
    $('#shapkaTbody').before(tbody);
    var dolzhnost = $("#positionZakazchik").val();
    var dolzhnostUp = dolzhnost.charAt(0).toUpperCase() + dolzhnost.substr(1);

    $("#footerZakazchikDolzhnost").html(dolzhnostUp);
    var fio = $("#fullNameZakazchik").val();
    $("#footerZakazchikFIO").html(fio);
})

//пересчет
$(document).on('click', '#pereschet', function () {
    var stoimost = 0;
    var nalog = 0;
    if ($('.nomerPP').length) {
        var i = 0;
        $('.nomerPP').each(function () {
            i++;
            $(this).html(i);
        });
    }

    if ($('#stoimostPSD, #dopItogo').length) {
        $('#stoimostPSD, #dopItogo').each(function () {
            // alert($(this).html());
            stoimost += parseFloat($(this).html());
        });
    }
    $("#sumPsdAndDop").html(stoimost.toFixed(2));

    if ($('#nalog').length) {
        nalog = stoimost * parseFloat($('#nalog').html()) / 95;
        $("#nalogItogo").html(nalog.toFixed(2));
        stoimost = (stoimost + nalog).toFixed(2);
    }
    //alert(stoimost);
    if ($('.SubGeoStoimost').length) {
        $('.SubGeoStoimost').each(function () {
            // alert(parseFloat($(this).val()));
            stoimost = 1 * stoimost + parseFloat($(this).val());

        });
    }
    //alert(stoimost);
    $("#vsegoNormStoimost").html(parseFloat(stoimost).toFixed(2));

    if ($('.SubStoimost').length) {
        $('.SubStoimost').each(function () {
            stoimost = 1 * stoimost + parseFloat($(this).val());
            stoimost = Math.round(stoimost * 100) / 100;
        });

    }
    $("#itogoFull").html(parseFloat(stoimost).toFixed(2));

    if ($('.itogoKoef').length) {
        $('.itogoKoef').each(function () {
            stoimost = stoimost * parseFloat($(this).val());
            stoimost = stoimost.toFixed(2);
            $(this).closest("tbody").find("#stoimostSKoef").html(parseFloat(stoimost).toFixed(2));
            //  alert("stoimost=" + stoimost + " коэффициент=" + $(this).val())
        });


    }
    if($('.inpZnKoefDrugoy').length){
        console.log("другой коэф ="+$(".inpZnKoefDrugoy").val());
        stoimost=parseFloat($(".inpZnKoefDrugoy:last").val());
    } else {console.log("другой коэф отсутсвует");}
    $("#oplata").html(parseFloat(stoimost).toFixed(2));

    $.ajax({
        // url: '${pageContext.request.contextPath }/valtosrt',
        url: '/valtosrt',
        dataType: 'html',
        data: 'val=' + parseFloat(stoimost).toFixed(2),
        success: function (data) {
            $('#stoimostStr').html(data);

        }
    });

})
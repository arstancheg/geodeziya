$(document).on('blur', '#polevoiTarif, #kamerTarif, #obem, #transportnye, #koefPerescheta', function () {
    $(this).val($(this).val().replace(',', '.'));
})
function getKoefByDate(month, year) {

    var koef = 1;
    if (year == 2019) {
        koef = 1.5546 * Math.pow(1.0053, month - 1);

    } else if (year == 2020) {
        koef = 1.6562 * Math.pow(1.0057, month - 1);
    }
    return Math.round(koef * 10000) / 10000;
}

$(document).on("change", "#dataDogovara", function () {
    console.log("новая дата: " + $("#dataDogovara").val());
    var year = $("#dataDogovara").val().substr(0, 4);
    var month = $("#dataDogovara").val().substr(5, 2);
    console.log("месяц=" + month + " год=" + year);
    $("#koefPerescheta").val(getKoefByDate(month * 1, year * 1));
})
$(document).on("change", "#rasstoyanie", function () {
    $(this).val($(this).val().replace(',', '.'));
    var rashody = 0;
    var rast = $("#rasstoyanie").val();
    if (rast <= 5) {
        rashody = 8.75;
    } else if (rast > 5 & rast <= 10) {
        rashody = 11.25;
    } else if (rast > 10 & rast <= 15) {
        rashody = 13.75;
    } else if (rast > 15 & rast <= 20) {
        rashody = 16.25;
    } else if (rast > 20 & rast <= 30) {
        rashody = 18.75;
    } else if (rast > 30 & rast <= 40) {
        rashody = 21.25;
    } else if (rast > 40 & rast <= 50) {
        rashody = 23.75;
    } else if (rast > 50 & rast <= 100) {
        rashody = 26.25;
    }
$("#transportnye").val(rashody);
})
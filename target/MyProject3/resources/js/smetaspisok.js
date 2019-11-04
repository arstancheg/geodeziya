//объединение смет
$(document).on('click', '#joinSmetaIdButton', function () {

    var checks = new Array();
    $("input[name='joinSmeta']:checked").each(function() {checks.push($(this).val());});

     var znId={"id":checks};


    console.log(znId);
    $.ajax({
        url: '/joinsmeta',
        method: "post",
        contentType: "application/json",
        data: JSON.stringify(znId),
        dataType: 'json',
        error: function (message) {
            console.log(message);
        },
        success: function (data) {

            console.log(data);
        }
    });
});
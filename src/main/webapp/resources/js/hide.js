function hideFieldsAvans(hide) {
    document.getElementById('avans_yes').style.display = hide ? 'block' : 'none';
    document.getElementById('avans_no').style.display = hide ? 'none' : 'block';
}

function hideFieldsDateEnd(hide) {
    document.getElementById('date_okonchaniya').style.display = hide ? 'block' : 'none';
    document.getElementById('srok_okonchaniya').style.display = hide ? 'none' : 'block';
    if (hide) {
        document.getElementById('srok').removeAttribute("name");
        document.getElementById('date_end').removeAttribute("name");
        document.getElementById('date_end').setAttribute("name", "dateEnd");
    } else {

        document.getElementById('date_end').removeAttribute("name");
        document.getElementById('srok').removeAttribute("name");
        document.getElementById('srok').setAttribute("name", "termEnd");


    }


}

function opwin(targetUrl) {
    var otherWindow = window.open();

    otherWindow.opener = null;
    otherWindow.location = targetUrl;
}


function drugayaDolzhnost() {
    var selind = document.getElementById("dolzhnost").options.selectedIndex;
    // var txt= document.getElementById("SelectMyLove").options[selind].text;
    var val = document.getElementById("dolzhnost").options[selind].value;
    document.getElementById("dolzhnostrod").options[selind].selected=true;
    if (val == 'drugaya') {
        document.getElementById('spdrugayadolzhnost').style.display = 'inline-block';
        document.getElementById('dolzhnost').removeAttribute("name");
        document.getElementById('drugayadolzhnost').removeAttribute("name");
        document.getElementById('drugayadolzhnost').setAttribute("name", "position");

        document.getElementById('spdrugayadolzhnostrod').style.display = 'inline-block';
        document.getElementById('dolzhnostrod').removeAttribute("name");
        document.getElementById('drugayadolzhnostrod').removeAttribute("name");
        document.getElementById('drugayadolzhnostrod').setAttribute("name", "positionRodPadezh");

    } else {


        document.getElementById('spdrugayadolzhnost').style.display = 'none';
        document.getElementById('drugayadolzhnost').removeAttribute("name");
        document.getElementById('dolzhnost').removeAttribute("name");
        document.getElementById('dolzhnost').setAttribute("name", "position");

        document.getElementById('spdrugayadolzhnostrod').style.display = 'none';
        document.getElementById('drugayadolzhnostrod').removeAttribute("name");
        document.getElementById('dolzhnostrod').removeAttribute("name");
        document.getElementById('dolzhnostrod').setAttribute("name", "positionRodPadezh");
    }

}

function myOptionStartConditionYes() {
    var selind = document.getElementById("prepayment_yes_begin").options.selectedIndex;
    var val = document.getElementById("prepayment_yes_begin").options[selind].value;
    if (val == 'myoption') {
        document.getElementById('prepayment_yes_begin').removeAttribute("name");
        document.getElementById('myoptionstart').removeAttribute("name");
        document.getElementById('avans_my_option').style.display = 'inline-block';
        document.getElementById('myoptionstart').setAttribute("name", "startCondition");
    } else {
        document.getElementById('avans_my_option').style.display = 'none';
        document.getElementById('myoptionstart').removeAttribute("name");
        document.getElementById('prepayment_yes_begin').removeAttribute("name");
        document.getElementById('prepayment_yes_begin').setAttribute("name", "startCondition");
    }
}

function myOptionStartConditionNo() {
    var selind = document.getElementById("prepayment_no_begin").options.selectedIndex;
    var val = document.getElementById("prepayment_no_begin").options[selind].value;
    if (val == 'myoption') {
        document.getElementById('prepayment_no_begin').removeAttribute("name");
        document.getElementById('myoptionstart').removeAttribute("name");
        document.getElementById('avans_my_option').style.display = 'inline-block';
        document.getElementById('myoptionstart').setAttribute("name", "startCondition");
    } else {
        document.getElementById('avans_my_option').style.display = 'none';
        document.getElementById('myoptionstart').removeAttribute("name");
        document.getElementById('prepayment_no_begin').removeAttribute("name");
        document.getElementById('prepayment_no_begin').setAttribute("name", "startCondition");
    }


}
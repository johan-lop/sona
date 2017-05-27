$(document).ready(function () {
    calcularIframe();
});
$(window).resize(function() {
    calcularIframe();
});

function calcularIframe(){
    var width=$(window).width()-10;
    var height=$(window).height()-$('.content-header').height()-$('.content-footer').height()-25;
    $('#iframeContenido').width(width);
    $('#iframeContenido').height(height);
}

function accionMenu(url){
    $('#iframeContenido').attr('src',url);
}

function getParameterByName(name, url) {
    if (!url) {
      url = window.location.href;
    }
    name = name.replace(/[\[\]]/g, "\\$&");
    var regex = new RegExp("[?&]" + name + "(=([^&#]*)|&|#|$)"),
        results = regex.exec(url);
    if (!results) return null;
    if (!results[2]) return '';
    return decodeURIComponent(results[2].replace(/\+/g, " "));
}

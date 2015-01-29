$(function () {
    $('.popbox').popbox();
    $('#logout').click(function () {
        $.post( "/logout", { status: "logout" })
    });
});
$(function () {
    $('.popbox').popbox();
    $('#logout').click(function () {
        $.post( "/logout", function(data){
             if(console){
                 console.log(data);
             }
        });
    });
});
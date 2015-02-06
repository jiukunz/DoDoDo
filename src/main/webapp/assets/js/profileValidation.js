$(function(){
    $('form').validate({
        rules:{
            firstName: "required",
            lastName: "required"
        },
        messages: {
            firstName: "Please enter your first name",
            lastName: "Please enter your last name"
        }
    });
});

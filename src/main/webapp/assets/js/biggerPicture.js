$(document).ready(function(){
    $(".smallImage").on("click", function(){
        $.ajax('/picture/data',{
            success: function(response){
                $(".pictureCaption").text(response.caption);
                $(".pictureKeyword").text(response.keyword);
                $(".pictureLocation").text(response.location);
                $(".picturePrice").text(response.price);

//              console.log(response.caption);
            },
            data: {"pictureId": this.alt}
        });

    });
});

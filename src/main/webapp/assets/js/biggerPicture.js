$(document).ready(function(){
    $(".smallImage").on("click", function(){
        $(".biggerImage").attr("src", "http://7u2rkn.com1.z0.glb.clouddn.com/"+this.alt);

        $.ajax('/home/data',{
            success: function(response){
                console.log(response);
                $(".pictureCaption").text(response.caption);
                $(".pictureKeyword").text(response.keyword);
                $(".pictureLocation").text(response.location);
                $(".picturePrice").text(response.price);
            },
            data: {"pictureId": this.alt}
        });

    });
});

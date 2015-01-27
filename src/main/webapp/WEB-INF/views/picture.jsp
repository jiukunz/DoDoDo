<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Picture</title>
  <link rel="stylesheet" href="/assets/css/thickbox.css" />

</head>
<body>
${message}

  <div class="anchor">
    <ul>
      <li><a class="thickbox" href="#TB_inline?height=300&amp;width=600&amp;inlineId=pictureContent">
        <img class="smallImage" src="/assets/img/smalltw1.jpg"/></a>
      </li>
      <li>
        <a class="thickbox" href="#TB_inline?height=300&amp;width=600&amp;inlineId=pictureContent">
          <img class="smallImage" src="/assets/img/smalltw2.jpg"/>
        </a>
      </li>
    </ul>

  </div>

  <div id="pictureContent" style="display: none">
      <img class="biggerImage" src="" />
      <div class = "pictureInformation">
        商品名:<p></p>
        商品价格:<p></p>
        <button type="button">Add Cart</button>
      </div>

  </div>


  <script type="text/javascript" src="/assets/js/jquery.js"></script>
  <script type="text/javascript" src="/assets/js/thickbox.js"></script>
  <script type="text/javascript">
    $(document).ready(function(){
      $(".smallImage").on("click", function(){
        //缩略图click之后，发送ajax请求
        $.ajax('/picture/data',{
          success: function(response){
            $(".biggerImage").attr("src", "/assets/img/tw1.jpg");
//            alert(response);
          },
          data: {"imageName": "tw1.jpg"}
        });

      });
    });

  </script>

</body>
</html>

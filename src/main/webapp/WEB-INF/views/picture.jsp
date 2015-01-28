<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Picture</title>
  <link rel="stylesheet" href="/assets/css/thickbox.css" />

</head>
<body>

  <div class="anchor">
    <ul>
      <li><a class="thickbox" href="#TB_inline?height=300&amp;width=600&amp;inlineId=pictureContent">
        <img class="smallImage" alt="1"  src="/assets/img/smalltw1.jpg"/></a>
      </li>
      <li>
        <a class="thickbox" href="#TB_inline?height=300&amp;width=600&amp;inlineId=pictureContent">
          <img class="smallImage" alt="2" src="/assets/img/smalltw2.jpg"/>
        </a>
      </li>
    </ul>

  </div>

  <div id="pictureContent" style="display: none">
      <%--<img class="loading" src="/assets/img/loadingAnimation.gif" />--%>
      <%--<div class="imageContent">--%>
      <img class="biggerImage" src="/assets/img/picture1.jpg" />
      <%--</div>--%>

      <div class="pictureInformation">
          商品名:<p class="pictureName"></p>
          商品价格:<p class="picturePrice"></p>
        <button type="button">Add Cart</button>
      </div>

  </div>


  <script type="text/javascript" src="/assets/js/jquery.js"></script>
  <script type="text/javascript" src="/assets/js/thickbox.js"></script>
  <script type="text/javascript">
    $(document).ready(function(){
      $(".smallImage").on("click", function(){
        $.ajax('/picture/data',{
          success: function(response){
//              alert(response);
              $(".pictureName").text(response);
          },
          data: {"pictureId": this.alt}
        });

      });
    });

  </script>

</body>
</html>

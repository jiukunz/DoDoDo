<%--
  Created by IntelliJ IDEA.
  User: qnxu
  Date: 1/27/15
  Time: 9:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Picture</title>
  <link rel="stylesheet" href="/assets/css/thickbox.css" />

  <script type="text/javascript">
    function loadPicture(){

    }
  </script>

</head>
<body>


  <div class="anchor">
    <a class="thickbox" onclick="loadPicture()" href="#TB_inline?height=300&amp;width=600&amp;inlineId=pictureContent"><img src="/assets/img/smalltw1.jpg"/></a>



    <ul>
      <li><a class="thickbox" rel="gallery-plants" href="/assets/img/tw1.jpg" ><img src="/assets/img/smalltw1.jpg" /></a></li>
      <li><a class="thickbox" rel="gallery-plants" href="/assets/img/tw2.png" ><img src="/assets/img/smalltw2.jpg" /></a></li>
      <li><a class="thickbox" rel="gallery-plants" href="/assets/img/tw3.png" ><img src="/assets/img/smalltw3.jpg" /></a></li>
    </ul>

  </div>

  <div id="pictureContent" style="display: none">
      <img src="/assets/img/tw1.jpg" />
      <p style="display: inline">这是一张图片</p>
  </div>


  </div>


</body>

<script type="text/javascript" src="/assets/js/jquery-1.2.6.pack.js"></script>
<script type="text/javascript" src="/assets/js/thickbox.js"></script>


</html>

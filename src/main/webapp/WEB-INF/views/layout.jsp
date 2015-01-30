<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<html>
<head>
    <title><tiles:insertAttribute name="title"/></title>
    <script type='text/javascript' charset='utf-8' src="/assets/js/libs/jquery.min.js"></script>
    <tiles:insertAttribute name="css"/>
    <tiles:insertAttribute name="commonCss"/>
</head>
<body>
<tiles:insertAttribute name="header"/>
<tiles:insertAttribute name="body"/>

<tiles:insertAttribute name="commonScript"/>
<tiles:insertAttribute name="script"/>
</body>
</html>

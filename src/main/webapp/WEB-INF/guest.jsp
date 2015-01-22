<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>JPA Web Application Tutorial</title>
</head>
<body>
<c:forEach var="guest" items="${guests}">
    ${guest.name}
</c:forEach>
<form action="guest">
    <input name="name">
    <input type="submit" value="submit">
</form>
</body>
</html>

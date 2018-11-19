<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
</head>
<body>
<p>Hello Spring MVC!</p>
<p>
    服务器时间:<fmt:formatDate value="${now}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate>
</p>
</body>
</html>

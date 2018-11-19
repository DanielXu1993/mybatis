<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>字典信息</title>
    <c:set var="path" value="${pageContext.request.contextPath}"/>
    <script src="${path}/static/jquery.js"></script>
</head>
<body>
<form action="${path}/dicts/add" method="post">
    <input type="hidden" name="id" value="${model.id}">
    <table>
        <c:if test="${msg!=null}">
            <tr>
                <th colspan="2" style="color:red;max-width:400px;">${msg}</th>
            </tr>
        </c:if>
        <tr>
            <th colspan="2">字典维护</th>
        </tr>
        <tr>
            <th>类别名</th>
            <td><input type="text" name="code" value="${model.code}"></td>
        </tr>
        <tr>
            <th>字典名</th>
            <td><input type="text" name="name" value="${model.name}"></td>
        </tr>
        <tr>
            <th>字典值</th>
            <td><input type="text" name="value" value="${model.value}"></td>
        </tr>
        <tr>
            <th colspan="2">
                <input type="submit" value="保存">
                <input type="reset" value="取消">
            </th>
        </tr>
    </table>
</form>
</body>
</html>

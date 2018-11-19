<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>字典信息</title>
    <c:set var="path" value="${pageContext.request.contextPath}"/>
    <script src="${path}/static/jquery.js"></script>
</head>
<body>
<table>
    <tr>
        <th colspan="4">字典管理</th>
    </tr>
    <tr>
        <th>类别名</th>
        <th>字典名</th>
        <th>字典值</th>
        <th>操作[<a href="${path}/dicts/add">新增</a>]</th>
    </tr>
    <c:forEach items="#{dicts}" var="dict">
        <tr id="dict-${dict.id}">
            <td>${dict.code}</td>
            <td>${dict.name}</td>
            <td>${dict.value}</td>
            <td>
                [<a href="${path}/dicts/add?id=${dict.id}">编辑</a> ]
                [<a href="javascript:;" onclick="deleteById(${dict.id},'${dict.name}')">删除</a> ]
            </td>
        </tr>
    </c:forEach>
</table>
<script>
    function deleteById(id, label) {
        var r = confirm("确定删除" + label + "吗?");
        if (r) {
            $.ajax({
                url: '${path}/dicts/delete',
                data: {id: id},
                dataType: "json",
                type: "post",
                success: function (data) {
                    if (data.success) {
                        $('#dict-' + id).remove();
                    } else {
                        alert(data.msg);
                    }
                }
            })
        }
    }
</script>
</body>
</html>

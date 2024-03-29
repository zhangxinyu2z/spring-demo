<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>查询商品列表</title>
</head>
<body>
<%--  ${pageContext.request.contextPath }  --%>
<form action="<c:url value='/items/queryItems'/>" method="post">
    查询条件：
    <table width="100%" border=1 cellspacing="0">
        <tr>
            <td><input type="submit" value="查询"/></td>
        </tr>
    </table>
    商品列表：
    <table width="800px" align="center" border=1 cellspacing="0" height="160px">
        <tr>
            <td>商品名称</td>
            <td>商品价格</td>
            <td>生产日期</td>
            <td>商品描述</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${itemList }" var="item">
            <tr>
                <td>${item.name }</td>
                <td>${item.price }</td>
                <td><fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                <td>${item.detail }</td>
                <td>
                    <c:if test="${item.pic !=null}">
                        <img src="/pic/${item.pic}" style="max-width: 90px;max-height: 81px;"/><br/>
                    </c:if>
                </td>

                <td><a href="<c:url value='/items/itemsDetail?id=${item.id}'/>">修改</a></td>
            </tr>
        </c:forEach>
    </table>
</form>
</body>

</html>
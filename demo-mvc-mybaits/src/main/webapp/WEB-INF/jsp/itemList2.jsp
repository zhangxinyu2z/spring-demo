<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>查询商品列表</title>
    <script type="text/javascript" src="${pageContext.request.contextPath }/jquery/jquery-1.8.3.min.js"></script>
</head>
<body>
<form id="intro" action="${pageContext.request.contextPath }/items/queryItems2.action" method="post">
    查询：
    <table width="100%" border=1 cellspacing="0">
        <tr>
            <td><input type="submit" value="查询"/></td>
        </tr>
    </table>
    商品列表：
    <table width="800px"  border=1 cellspacing="0" height="200px">
        <tr>
            <td>选择</td>
            <td>商品名称</td>
            <td>商品价格</td>
            <td>生产日期</td>
            <td>商品图片</td>
            <td>商品描述</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${itemList }" var="item" varStatus="v">
            <tr>
<%--                <td><input type="checkbox" name="ids" value="${item.id}"/></td>--%>
                <td><input type="checkbox" name="itemsList[${v.index}].id" value="${item.id}"/></td>
                <td><input type="text" name="itemsList[${v.index}].name" value="${item.name}"/></td>
                <td><input type="text" name="itemsList[${v.index}].price" value="${item.price}"/></td>
                <td>
                    <input type="text" name="itemsList[${v.index}].createtime" value="<fmt:formatDate value='${item.createtime}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
                </td>
                <td>
                    <c:if test="${item.pic != null}">
                        <input type="hidden" name="itemsList[${v.index}].pic" value="${item.pic}"/>
                        <img src="/pic/${item.pic}" style="max-width: 100%;max-height: 100%;"/>
                    </c:if>
                </td>
                <td><input type="text" name="itemsList[${v.index}].detail" value="${item.detail}"/></td>
                <td>
                    <a href="${pageContext.request.contextPath }/items/itemsEdit.action?id=${item.id}">修改</a>
                    <a href="${pageContext.request.contextPath }/items/itemsDelete.action?id=${item.id}">删除</a>
                </td>
            </tr>
        </c:forEach>

    </table>
    <input type="submit" value="删除" onclick="operate('delete')"/><br/>
    <input type="submit" value="修改" onclick="operate('editMultiply')"/>
</form>

<script type="text/javascript">
    function operate(data) {
        let f = document.getElementById("intro");
        console.log(f);
        if (data == "editMultiply") {
            // 获取所有勾选的items  没写呢
            f.action = "<c:url value='/items/itemsEdit'/>";
        } else {
            f.action = "<c:url value='/items/itemsDelete'/> ";
        }
    }

</script>
</body>

</html>
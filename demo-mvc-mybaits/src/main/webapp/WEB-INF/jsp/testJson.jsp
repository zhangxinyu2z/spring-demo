<%--
  Created by IntelliJ IDEA.
  User: zxy
  Date: 2021/11/30
  Time: 21:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试使用@RequestBody接收Json数据</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/jquery/jquery-1.8.3.min.js"></script>

    <script type="text/javascript">
        //页面加载后自动执行，不需要按钮或事件触发 window.load=function(){}
        $(document).ready(function () {
            //let params = '{"id": 1,"name": "测试商品","price": 99.9,"detail": "测试商品描述","pic": "123456.jpg"}';
            let params = '{\n' +
                '  "itemsList": [\n' +
                '    {"id": 1,"name": "测试商品1","price": 99.9,"detail": "测试商品描述1","pic": "1123456.jpg"},\n' +
                '    {"id": 2,"name": "测试商品2","price": 99.9,"detail": "测试商品描述2","pic": "1223456.jpg"}\n' +
                '  ],\n' +
                '  "ids": [1,2]\n' +
                '}';
            $.ajax({
                async: true,
                url: "${pageContext.request.contextPath}/items3/testJson.action",
                data:params,   // 发送的参数
                contentType: "application/json;charset=utf-8", // 发送的数据格式
                type: "post",
                dataType: "json", // 响应的数据格式
                success: function (data) {
                    alert(data.name);
                }
            });
        })
    </script>
</head>
<body>
end
</body>
</html>

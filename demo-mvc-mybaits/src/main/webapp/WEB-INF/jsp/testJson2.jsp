<%--
  Created by IntelliJ IDEA.
  User: zxy
  Date: 2021/12/1
  Time: 12:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="<c:url value='/jquery/jquery-1.8.3.min.js'/> "></script>
    <script type="text/javascript">
        var DataDeal = {
            //将从form中通过$('#form').serialize()获取的值转成json格式的字符串
            toJsonString: function (formData) {
                // 全局匹配&和=，分别替换为 ","  ":"
                formData = formData.replace(/\&/g, "\",\"");
                formData = formData.replace(/\=/g, "\":\"");
                formData = "{\"" + formData + "\"}";
                console.log("::::" + formData);
                return formData;
            }
        }

        function getData() {
            // serialize会将input中输入的空格转义成+号，然后使用&拼接成key=value的格式
            // 默认调用encodeURIComponent()进行编码
            let formData = $("#form_id").serialize();
            // 全局匹配+号，替换为""
            formData = formData.replace(/\+/g,"");
            // 防止中文乱码,就是把encode的中文的 %+16进制的格式恢复
            formData = decodeURIComponent(formData);
            let s = DataDeal.toJsonString(formData);

            // 方式一：提交一个JSON对象，无需指定content-type，默认为x-www-form-urlencoded，Controller使用@RequestParam且必须存在
         /*   $.ajax({
                url: "<c:url value='/items/testJson3'/>",
                type: "post",
                dataType: "json",
                data:{"jsonData": s},
                success:function (data) {
                }
            });*/

            // 方式二：发送json字符串，必须指定content-type为application/json,且必须使用@RequestBody接收
            $.ajax({
                url: "<c:url value='/items/testJson4'/>",
                type: "post",
                dataType: "json",
                contentType: 'application/json;charset=utf-8',
                data: s,
                success:function (data) {

                }
            });
        }
    </script>
</head>
<body>
<form id="form_id">
    姓名：<input type="text" name="username"/>
    <br/>
    年龄：<input type="text" name="age"/>
    <br/>
    型号：
    <select name="car">
        <option value="volvo">Volvo</option>
        <option value="saab">Saab</option>
        <option value="opel">Opel</option>
        <option value="audi">Audi</option>
    </select>
    <br/>
    <input type="button" value="提交" onclick="getData()"/>
</form>

<hr/>

<form class="layui-form" method="post" action="${pageContext.request.contextPath}/items3/testJson5">
    <div class="layui-inline">
        <input type="text" value="" name="s_username" placeholder="输入角色名" class="layui-input search_input">
        <input type="text" value="" name="s_address" placeholder="输入昵称" class="layui-input search_input">
    </div>
    <input type="submit" value="提交"/>
</form>
</body>
</html>

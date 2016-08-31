
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<header>
    <script src="static/jquery-easyui-1.4.5/jquery.min.js" type="text/javascript"></script>
    <script src="static/jquery-easyui-1.4.5/jquery.easyui.min.js" type="text/javascript"></script>
    <link href="static/jquery-easyui-1.4.5/themes/default/easyui.css" rel="stylesheet" type="text/css" />
    <link href="static/jquery-easyui-1.4.5/themes/icon.css" rel="stylesheet" type="text/css" />
    <script src="static/jquery-easyui-1.4.5/locale/easyui-lang-zh_CN.js" type="text/javascript"></script>
    <meta http-equiv="content-type" content="text/html;charset=UTF-8" />

</header>
<body>
<h2>Hello World!</h2>
<script type="application/javascript">

</script>
<%--<div id="dialog" class="easyui-dialog" title="弹出框" style="width:300px;height:200px;">--%>
    <%--弹出框内容--%>
<%--</div>--%>
<%--<a href="#" class="easyui-tooltip" title="只是内容">hover me</a>--%>
<form method="post" action="">
 <p> <input type="text" name="username" class="easyui-validatebox" data-options="required:true"> </p>
    <p> <input type="text" name ="email"   class="easyui-validatebox" data-options="required:true"></p>
    <button type="submit" value="提交"/>
</form>
</body>
</html>

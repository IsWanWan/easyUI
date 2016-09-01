<%--
  Created by IntelliJ IDEA.
  User: wanwan
  Date: 16/9/1
  Time: 上午9:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>lalyout布局</title>

    <link rel="stylesheet" type="text/css" href="/static/jquery-easyui-1.4.5/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="/static/jquery-easyui-1.4.5/themes/icon.css" />

    <script type="text/javascript">
     function mmopen() {
         $('#mm').menu('show',{
             left:10,
             top:100

         })
     }
    </script>
</head>
<body id="box" class="easyui-layout">
  <div region="north" noheader="true"  style="height: 30px;
       background: url('/static/images/layout-browser-hd-bg.gif') #7f99be repeat-x center 50%;
       line-height: 20px; color:white;font-family:Verdana, 微软雅黑,黑体 ">
      <div style="float:right; padding-right:20px;">欢迎您绾绾,<a href="#" style="color: white" >退出登录</a></div>
      <div style="padding-left: 10px; font-size: 16px; line-height: 20px;"  ><img src="/static/images/blocks.gif" width="20" height="20" align="absmiddle" />后台管理系统</div>
  </div>
  <div region="south" style="height: 30px;"  line-hight:30px; align="center" noheader="true" title="footer" >
       www.taobao.com淘宝吧
  </div>
  <div region="west" style="width: 150px;" title="west">

      <div class="easyui-accordion" style="width:150px;height:500px;">
          <div title="About Accordion" iconCls="icon-edit"  style="overflow:auto;padding:10px;" onclick="mmopen()">
              <div id="mm" class="easyui-menu" style="width:120px;">
                  <div onclick="javascript:alert('new')" style="width:80px;">New</div>
                  <div icon="icon-save">Save</div>
                  <div class="menu-sep">编辑</div>
                  <div>Exit</div>
              </div>


          </div>
          <div title="About easyui" iconCls="icon-edit"  style="padding:10px;">
              easyui help you build your web page easily
          </div>
          <div title="Tree Menu">
              <ul id="tt1" class="easyui-tree">
                  <li>
                      <span>Folder1</span>
                      <ul>
                          <li>
                              <span>Sub Folder 1</span>
                              <ul>
                                  <li><span>File 11</span></li>
                                  <li><span>File 12</span></li>
                                  <li><span>File 13</span></li>
                              </ul>
                          </li>
                          <li><span>File 2</span></li>
                          <li><span>File 3</span></li>
                      </ul>
                  </li>
                  <li><span>File2</span></li>
              </ul>
          </div>
      </div>


  </div>
  <%--<div region="east" style="width: 100px;" title="east"></div>div--%>
  <div id="content" region="center" title="Language" style="padding:5px;">
  </div>

  <script type="text/javascript" src="/static/jquery-easyui-1.4.5/jquery.min.js"></script>
  <script type="text/javascript" src="/static/jquery-easyui-1.4.5/jquery.easyui.min.js"></script>
  <script type="text/javascript" src="/static/jquery-easyui-1.4.5/locale/easyui-lang-zh_CN.js"></script>
</body>
</html>

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
        $(".easyui-accordion").click(function () {
            alert("11");
            var url = '/admin/index';
            var title = '新的选项卡';
            addTab(title, url);

        })

        function addTab(title, url){
            if ($('#tab').tabs('exists', title)){
                $('#tab').tabs('select', title);
            } else {
                var content = '<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>';
                $('#tab').tabs('add',{
                    title:title,
                    content:content,
                    closable:true
                });
            }
        }


    </script>
</head>
<body id="box" class="easyui-layout">
  <div region="north" noheader="true"  style="height: 30px;
       background: url('/static/images/layout-browser-hd-bg.gif') #7f99be repeat-x center 50%;
       line-height: 20px; color:white;font-family:Verdana, 微软雅黑,黑体 ">
      <div style="float:right; padding-right:20px;" >欢迎您 绾绾,<a href="#" style="color: white" >退出登录</a></div>
      <div style="padding-left: 10px; font-size: 16px; line-height: 20px;"  ><img src="/static/images/blocks.gif" width="20" height="20" align="absmiddle" />后台管理系统</div>
  </div>
  <div region="south" style="height: 30px;"  line-hight:30px; align="center" noheader="true" title="footer" >
       www.taobao.com淘宝吧
  </div>
  <%-- ----------------------------------------导航-------------------------------------------------------%>
  <div region="west" style="width: 150px;" title="west" iconCls="icon-house">

      <div class="easyui-accordion" style="width:150px;height:500px;">
          <div title="About Accordion" iconCls="icon-edit"  style="overflow:auto;padding:10px;" >
                  <div><a iconCls="icon-add" url="admin/index">添加</a></div>
                  <div><a iconCls="icon-edit" url="admin/index">修改</a></div>
          </div>
          <div title="About easyui" iconCls="icon-edit"  style="padding:10px;">
              <ul id="tt" class="easyui-tree">
                  <li><a href="/admin/index">员工管理</a></li>
                  <li>
                      <span><a>商品管理</a></span>
                      <ul>
                          <li><span iconCls="icon-add">添加商品</span></li>
                          <li><span>编辑商品</span></li>
                          <li><span>删除商品</span></li>
                      </ul>
                  </li>
                  <li>系统管理</li>
              </ul>
          </div>
          <div title="Tree Menu">
              <ul id="tt1" class="easyui-tree">
                  <li>
                      <span>Folder1</span>
                      <ul>
                          <li>
                              <span>Sub Folder 1</span>
                              <ul>
                                  <li><span iconCls="icon-man">File 11</span></li>
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
  <div id="content" region="center" title="Language" style="padding:5px;" tab="true" iconCls="icon-users">
     <div id="tab" class="easyui-tabs">
         <div title="tab1" closable="true" iconCls="icon-man" style="padding: 10px;">
           <h1>welcome to tab1</h1>
         </div>

     </div>
  </div>

  <script type="text/javascript" src="/static/jquery-easyui-1.4.5/jquery.min.js"></script>
  <script type="text/javascript" src="/static/jquery-easyui-1.4.5/jquery.easyui.min.js"></script>
  <script type="text/javascript" src="/static/jquery-easyui-1.4.5/locale/easyui-lang-zh_CN.js"></script>
</body>
</html>

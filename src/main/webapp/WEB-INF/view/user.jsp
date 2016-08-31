<%--
  Created by IntelliJ IDEA.
  User: wanwan
  Date: 16/8/22
  Time: 下午3:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>table</title>
    <link rel="stylesheet" type="text/css" href="/static/jquery-easyui-1.4.5/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="/static/jquery-easyui-1.4.5/themes/icon.css" />
    <script type="text/javascript" src="/static/jquery-easyui-1.4.5/jquery.min.js"></script>
    <script type="text/javascript" src="/static/jquery-easyui-1.4.5/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="/static/jquery-easyui-1.4.5/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript">
      $(function () {
          $('#adminTable').datagrid({
              url: '/admin/listPage',
              method: 'POST',
              title:'用户列表',
              idField: 'id',
              striped: true,  //斑马线效果
              fitColumns: true,  //自适应
              singleSelect: true,
              rownumbers: true,
              pagination: true,  //分页
              nowrap: false,
              toolbar:'#tb',
              pageSize: 10,
              pageList: [5, 10, 15, 20, 25, 30],
              remoteSort:false,
              columns: [[
                 { field: 'id',checkbox:'true',width:50},
           //       { field: 'id', title: 'id', width: 180, align: 'left' ,sortable:true},
                  { field: 'username', title: '用户名', width: 150, align: 'left' },
                  { field: 'nickname', title: '昵称', width: 100, align: 'left' },
                  { field: 'name', title: '名称', width: 100, align: 'left' },
                  { field: 'age', title: '年龄', width: 100, align: 'right' },
                  { field: 'address', title: '地址', width: 100, align: 'right' },
                  { field: 'mobile', title: '电话', width: 100, align: 'right' }

              ]]

          });

      });

        function add(){
           // alert('添加');
            $('#win').window("open");
        }
      /***
       * 获取选中行的的id
       */
      function check(){
            var ids=[];
            var rows = $('#tb').datagrid('getSelections');
            for(var i=0;i<rows.length;i++){
                ids.push(rows[i].itemid);

            }
            alert(ids);
        }
      /***
       * 删除
       * */
      function del(){
          var row = $('#adminTable').datagrid('getSelected');
          if(row){
              $('#del').window("open");
              $('#delid').val(row.id);
          }else{
              parent.$.messager.alert('提示', "请选择");
              return false;
          }
      }
      function  cancel() {
          $('#del').window("close");
      }
      /****
       *
       * */
      function delSubmit() {
          $("#delform").form({
              success:function (data) {
                  var result = eval('('+data+')');
                  $('#del').window("close");
                  parent.$.messager.alert('提示', result.message);
                  $('#adminTable').datagrid('reload');

              }
          })

      }


      /***
       * 编辑
       */
      function edit() {

          var row = $('#adminTable').datagrid('getSelected');
          if (row){
              $('#edit').window("open");
              $("#editid").val(row.id);
              $("#eidtUsername").val(row.username);
              $("#editage").val(row.age);
              $("#editmobile").val(row.mobile);
          }else{
              parent.$.messager.alert('提示', "其选择");
              return false;
          }

      }
      /***
       * 编辑后提交
       */
      function  editSubmit() {
          $('#editform').form({
              onSubmit:function () {
                  return $('#editform').form('validate');
              },
              success:function(data){
                  var result = eval('('+data+')');
                  $('#edit').window("close");
                  parent.$.messager.alert('提示', result.message);
                  $('#adminTable').datagrid('reload');
              }
          });
      }
         //查询
        function doSearch(){
            $('#adminTable').datagrid('load',{
                username:$.trim($('#username').val())
            })
        }
      /**
       * 添加提交
       */
        function tijiao(){
            $('#ff').form({
                onSubmit:function () {
                    return $('#ff').form('validate');
                },
                success:function(data){
                  var result = eval('('+data+')');
                    $('#win').window("close");
                    parent.$.messager.alert('提示', result.message);
//                    $.messager.alert(result.code);

                }
            });
        }
    </script>
</head>
<BODY>


   <table id="adminTable" style="width:auto" >

   </table>
   <div id="tb">
    <div>
        <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="add()">添加</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="del()">删除</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="edit()">修改</a>
   </div>
       <div style="padding: 2px;">
           用户名:<input type="text" class="textbox" name="username" id="username">
           开始日期:<input type="text" class="easyui-datetimebox" name="dataform" editable="false" size ="30">
           结束日期:<input type="text" class="easyui-datetimebox" name="dataTo" editable="false" size="30">
           <a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="doSearch()">查询</a>
       </div>

   </div>
<%-- ----------------------------------------------添加------------------------------------------------------------%>
   <div id="win" class="easyui-window" title="Login" style="width:300px;height:180px;" closed="true"; >
       <form  id="ff" style="padding:10px 20px 10px 40px;" method="post" action="/admin/add">
           <p>name: <input type="text" name="username" class="easyui-validatebox" required="true" validType="email"></p>
           <p>password: <input type="password" name="password" class="easyui-validatebox" required="true" ></p>
           <button  class="easyui-linkbutton" icon="icon-ok"  onclick="tijiao()">ok</button>
           <button  class="easyui-linkbutton" icon="icon-cancel"  type="reset">canel</button>
       </form>
   </div>
   <%-- ----------------------------------------------编辑------------------------------------------------------------%>
<div id="edit" class="easyui-window" title="编辑" style="width:300px;height: 200px;" closed="true">
    <form  id="editform" style="padding:10px 20px 10px 40px;" method="post" action="/admin/updateAdmin">
        <p><input type="hidden" name="id" id="editid"></p>
        <p>name: <input type="text" name="username" id="eidtUsername" class="easyui-validatebox" required="true" validType="email"></p>
        <p>age: <input type="text" name="age" id="editage" class="easyui-validatebox" required="true" ></p>
        <p>mobile: <input type="text" name="mobile" id="editmobile" class="easyui-validatebox" required="true" ></p>

        <button  class="easyui-linkbutton" icon="icon-ok"  onclick="editSubmit()">ok</button>
        <button  class="easyui-linkbutton" icon="icon-cancel"  type="reset">canel</button>
    </form>

</div>

   <%-- ----------------------------------------------编辑------------------------------------------------------------%>
<div id="del" class="easyui-window" title="删除" style="width:200px;height: 150px;" closed="true">
    <form id="delform" style="padding:10px 20px 10px 40px;" method="post" action="/admin/delete">
        <p>你确认删除本条记录吗</p>
        <p><input type="hidden" id="delid" name ="adminId" ></p>
        <button  class="easyui-linkbutton" icon="icon-ok"  onclick="delSubmit()">删除</button>
        <button  class="easyui-linkbutton" icon="icon-cancel"  type="button" onclick="cancel()" >取消</button>
    </form>
</div>

</BODY>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
    <title></title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="../Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="../Css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="../Css/style.css" />
    <script type="text/javascript" src="../Js/jquery.js"></script>
    <script type="text/javascript" src="../Js/jquery.sorted.js"></script>
    <script type="text/javascript" src="../Js/bootstrap.js"></script>
    <script type="text/javascript" src="../Js/ckform.js"></script>
    <script type="text/javascript" src="../Js/common.js"></script>

    <style type="text/css">
        body {
            padding-bottom: 40px;
        }
        .sidebar-nav {
            padding: 9px 0;
        }

        @media (max-width: 980px) {
            /* Enable use of floated navbar text */
            .navbar-text.pull-right {
                float: none;
                padding-left: 5px;
                padding-right: 5px;
            }
        }


    </style>
</head>
<body>
<form class="form-inline definewidth m20" action="index.html" method="get">
    菜品名称：
    <input type="text" name="menuname" id="menuname"class="abc input-default" placeholder="" value="">&nbsp;&nbsp; 
    <button type="submit" class="btn btn-primary">查询</button>&nbsp;&nbsp; <button type="button" class="btn btn-success" id="addnew">新增菜品</button>
    <!-- <a href="../FoodServelet"><input type="button" class="btn btn-primary" value="刷新"></a> -->
    <button type="button" class="btn btn-primary" id="reflesh">刷新</button>
</form>
<table class="table table-bordered table-hover definewidth m10">
    <thead>
    <tr>
        <th>菜品编号</th>
        <th>菜名</th>
        <th>菜品种类</th>
        <th>图片路径</th>
        <th>菜品简介</th>
        <th>菜品价格</th>
        <th>操作</th>
    </tr>
    </thead>
    <c:forEach var="sp" items="${food }">
    	<tr>
    		<td>${sp.fid }</td>
    		<td>${sp.fname }</td>
    		<td>${sp.foodtype }</td>
    		<td>${sp.picture }</td>
    		<td>${sp.fdetial }</td>
    		<td>${sp.fprice }</td>
    		<td><a href="../EditfoodServlet?fid=${sp.fid }" >编辑</a>&nbsp;|&nbsp;<a href="../DeletefoodServlet?fid=${sp.fid }" >删除</a></td>
    		<td></td>
    	</tr>
    </c:forEach>
	     </table>
		<div class="inline pull-right page">
	         ${sessionScope.totalnum } 条记录 ${currentpage }/${sessionScope.totalpage } 页   
	         <a href="../FoodServelet?currentpage=${currentpage-1 }">上一页</a>  <a href="../FoodServelet?currentpage=${currentpage+1 }">下一页</a>     
	         <!-- <span class='current'>1</span><a href='#'>2</a><a href='/chinapost/index.php?m=Label&a=index&p=3'>3</a><a href='#'>4</a><a href='#'>5</a> -->
	         <c:forEach var="ys" begin="1" end="${sessionScope.totalpage }">
	         	<a class="fenye" href="../FoodServelet?currentpage=${ys }">${ys }</a>
	         </c:forEach>
	         <a href="../FoodServelet?currentpage=${sessionScope.totalpage }" >最后一页</a>    
         </div>
</body>
</html>

<script>
    $(function () {
		$('#addnew').click(function(){

				window.location.href="add.jsp";
		 });
		 $('#reflesh').click(function(){

				window.location.href="../FoodServelet?currentpage=1";
		 });
    });
    //jQuery 代码(将所有的p标记换成b标记）:
	//$("p").replaceWith("<b>Paragraph. </b>");
    var currentpage="${currentpage }";
	//如果刚好在当前页，则变为红色span标签
	alert($(".fenye").html);
	alert($(".fenye:contains(currentpage)"));
	alert($(".fenye:contains(currentpage)").val());
	//$(".fenye[text='currentpage']").replaceWith("<span class='current'>"+currentpage+"</span>");
</script>
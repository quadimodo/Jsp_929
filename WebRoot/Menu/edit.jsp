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
<form name="form3" action="../FoodInsertServelet" method="post" class="definewidth m20" accept-charset="UTF-8">
<table class="table table-bordered table-hover m10">
	<%
		
	 %>
   <tr>
        <td width="10%" class="tableleft">种类</td>
        <td>
        	<!-- 通过循环遍历，再用if判断是否和输入的ftid相同，相同就直接设置为默认值 -->
			<select name="ftid" id="select_1">
			      <c:forEach items="${sessionScope.typelist}" var="typelist">
			          <option <c:if test="${typelist.ftid==foodbean.foodtype}">selected="selected"</c:if> value="${typelist.ftid}">${typelist.ftname}</option>
			      </c:forEach>
			</select>
        	
        </td>
    </tr>
    <tr>
        <td class="tableleft">图片名</td>
        <td><input type="text" name="pname" required="required" value="${picturebean.pname }"/></td>
    </tr>
    <tr>
        <td class="tableleft">图片路径</td>
        <td><input type="text" name="ppath" required="required" value="${picturebean.ppath }"/></td>
    </tr>
     <tr>
        <td class="tableleft">画廊显示</td>
        <td>
            <input type="radio" name="pdisplay" value="1" <c:if test="${picturebean.pdisplay==1}">checked</c:if> /> 显示
            <input type="radio" name="pdisplay" value="0" <c:if test="${picturebean.pdisplay==0}">checked</c:if>  />禁用
        </td>
    </tr>
    <tr>
        <td class="tableleft">菜名</td>
        <td><input type="text" name="fname" required="required" value="${foodbean.fname }"/></td>
    </tr>
    <tr>
        <td class="tableleft">简介</td>
        <td><input type="text" name="fdetial" required="required" value="${foodbean.fdetial }"/></td>
    </tr>
    <tr>
        <td class="tableleft">价格</td>
        <td><input type="text" name="fprice" required="required" value="${foodbean.fprice }"/></td>
    </tr>
    <tr>
        <td class="tableleft"></td>
        <td>
            <button class="btn btn-primary" >修改</button> &nbsp;&nbsp;<button type="button" class="btn btn-success" name="backid" id="backid">返回列表</button>
        </td>
    </tr>
</table>
</form>
</body>
</html>
<script>
    $(function () {       
		$('#backid').click(function(){
				window.location.href="index.jsp";
		 });

    });
     $(function () {       
		$("button.btn-primary").click(function(){
			//获取ftid
			var jdgval=new array();
			var ftid=$("#select_1").val();
			//获取pname
			var pname=$("input[name=pname]").attr("value");
			//获取ppath
			var ppath=$("input[name=ppath]").attr("value");
			//获取pdisplay
			var pdisplay=$("input:radio:checked").val();
			//获取fname
			var fname=$("input[name=fname]").attr("value");
			//获取fdetial
			var fdtial=$("input[name=fdetial]").attr("value");
			//获取fprice
			var fprice=$("input[name=fprice]").attr("value");
			//var fff=${foodbean.foodtype };
			//jdgval[0]=fff==ftid;
			alert("dkjsdjf");
			//alert(jdgval[0]);
			//document.form3.submit();
		 });

    });
    
</script>
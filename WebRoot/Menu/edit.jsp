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
<form action="../FoodInsertServelet" method="post" class="definewidth m20" accept-charset="UTF-8">
<table class="table table-bordered table-hover m10">
	<%
		
	 %>
   <tr>
        <td width="10%" class="tableleft">种类</td>
        <td>
        	
			<select name="ftid" id="select_1">
			      <c:forEach items="${sessionScope.typelist}" var="typelist">
			          <option <c:if test='${typelist.ftid == list.deptNo}'>selected="selected"</c:if> value="${typelist.ftid}">${typelist.ftname}</option>
			      </c:forEach>
			</select>
        	
            <!-- <select name="ftid" id="select_1">
            <option value="1">Pasta Plates</option><option value='2'   />&nbsp;Starters</option><option value='3'   />&nbsp;Salads</option><option value="4">Chef's Specials</option><option value='5'   />&nbsp;Fast Food</option><option value='6'   />&nbsp;Seafood Specials</option>             
            </select> -->
        </td>
    </tr>
    <tr>
        <td class="tableleft">图片名</td>
        <td><input type="text" name="pname"/></td>
    </tr>
    <tr>
        <td class="tableleft">图片路径</td>
        <td><input type="text" name="ppath"/></td>
    </tr>
     <tr>
        <td class="tableleft">画廊显示</td>
        <td>
            <input type="radio" name="pdisplay" value="1" /> 显示
            <input type="radio" name="pdisplay" value="0" checked/> 禁用
        </td>
    </tr>
    <tr>
        <td class="tableleft">菜名</td>
        <td><input type="text" name="fname"/></td>
    </tr>
    <tr>
        <td class="tableleft">简介</td>
        <td><input type="text" name="fdetial"/></td>
    </tr>
    <tr>
        <td class="tableleft">价格</td>
        <td><input type="text" name="fprice"/></td>
    </tr>
    <tr>
        <td class="tableleft"></td>
        <td>
            <button type="submit" class="btn btn-primary" type="button">修改</button> &nbsp;&nbsp;<button type="button" class="btn btn-success" name="backid" id="backid">返回列表</button>
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
    
</script>
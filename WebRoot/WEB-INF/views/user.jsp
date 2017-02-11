<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="scripts/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
$(function(){
	   $(".delete").click(function(){
		   var href=$(this).attr("href");
		   $("form").attr("action",href).submit();
		   return false;
	   });
})

</script>

</head>
  <body>
  <!--该name属性值交给springmvc的dispatcher处理 -->
  <form action="" method="POST">
    <input type="hidden" name="_method" value="DELETE">
  </form>
  
  
    <a href="insert">增加</a>&nbsp;&nbsp;&nbsp;&nbsp;
    <form action="find">
         姓名:<input type="text" name="userName">
         地址:<input type="text" name="address">
        年龄在  <input type="text" name="minAge">-
          <input type="text" name="maxAge">之间范围
    <input type="submit" value="查询">
    </form>
    
    
    <table border="1" cellpadding="1" cellspacing="1">
        <tr>
           <td>userId</td>
           <td>userName</td>
           <td>password</td>
           <td>address</td>
           <td>nation</td>
           <td>age<td>
           <td>操作<td>
        </tr>
    <c:forEach items="${userList}" var="user">
        <tr>
           <td>${user.userId}</td>
           <td>${user.userName}</td>
           <td>${user.password}</td>
           <td>${user.address}</td>
           <td>${user.nation}</td>
           <td>${user.age}<td>
    	   <td>
    	       <a href="insert/${user.userId}">编辑</a>  
    	       <a class="delete" href="delete/${user.userId}">删除</a>   
    	   <td>
    	</tr>
    </c:forEach>
    </table>
    
  </body>
</html>

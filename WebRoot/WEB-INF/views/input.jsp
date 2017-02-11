<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form action="${pageContext.request.contextPath}/insert" method="POST" modelAttribute="user">
      
        <!-- 若为修改隐藏userId值 ,其中请求的方式是PUT方式-->
       <c:if test="${user.userId!=nullU&&user.userId>0}">
           <form:hidden path="userId"/><br>
           <input type="hidden" name="_method" value="PUT">
        </c:if> 
       
         userName:<form:input path="userName" />
		<br>
        password:<form:input path="password" />
		<br>
        address:<form:input path="address" />
		<br>
         nation:<form:input path="nation" />
		<br>
         age:<form:input path="age" />
		<br>
		<input type="submit" value="添加">
	</form:form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	 <%
		String name = request.getParameter("username");
		out.print("Chao ban" + name);
		session.setAttribute("user", name);
		
	
	%>
	<a href="second.jsp"> mo trang 2 </a>
		
</body>
</html>
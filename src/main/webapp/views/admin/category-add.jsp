<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<form action="<c:url value="/admin/category/add"/>" method="post"
	enctype='multipart/form-data'>
	
	<label for="categoryname">Category name:</label><br> <input
		type="text" id="fname" name="categoryname"><br> <label
		for="image">Images</label><br>
	<c:if test="${cate.images.substring(0, 5) == 'https'}">
		<c:url value="${cate.images}" var="imgUrl"></c:url>
	</c:if>

	<c:if test="${cate.images.substring(0, 5) != 'https'}">
		<c:url value="/image?fname=${cate.images}" var="imgUrl"></c:url>
	</c:if>

	<img id="imagess" height="150" width="200" src="" /> <input
		type="file" onchange="chooseFile(this)" id="image" name="images">
	<p>Status:</p>
	  <input type="radio" id="ston" name="status" value="1">   <label
		for="html">Đang hoạt động</label><br>   <input type="radio"
		id="css" name="status" value="0">   <label for="css">Khóa</label><br>
	<input type="submit" value="Submit">
</form>
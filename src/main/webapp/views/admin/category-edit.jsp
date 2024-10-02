<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <form action="<c:url value='/admin/category/update'/>" method="post" enctype='multipart/form-data'>

    <label for="categoryname">Category Name:</label><br>
    <input type="text" id="categoryname" name="categoryname" value="${cate.categoryname}" required><br>

    <label for="images">Images:</label><br>
	    <c:if test="${cate.images.substring(0, 5) == 'https'}">
			<c:url value="${cate.images}" var="imgUrl"></c:url>
		</c:if>
	
		<c:if test="${cate.images.substring(0, 5) != 'https'}">
			<c:url value="/image?fname=${cate.images}" var="imgUrl"></c:url>
		</c:if>
	
		<img alt="images" id="imagess" height="150" width="200" src="${imgUrl}" />
    <input type="file" onchange="chooseFile(this)" id="images" name="images"><br>

    <p>Status:</p>
    <input type="radio" id="active" name="status" value="1" ${cate.status == 1 ? 'checked' : ''}>
    <label for="active">Đang hoạt động</label><br>
    <input type="radio" id="inactive" name="status" value="0" ${cate.status != 1 ? 'checked' : ''}>
    <label for="inactive">Khóa</label><br>
    
    <input type="hidden" name="categoryid" value="${cate.categoryid}"> 
    <input type="submit" value="Submit">
</form>
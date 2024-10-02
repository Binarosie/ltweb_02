<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<c:url value="/" var="URL"></c:url>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<sitemesh:write property='body' />
	<script src="${URL}assets/global/plugins/jquery.min.js"
		type="text/javascript">
	</script>
	<script>
		function chooseFile(fileInput) {
			// Check if a file is selected
			if (fileInput.files && fileInput.files[0]) {
				var reader = new FileReader(); // Create a new FileReader object

				// Define what happens when the file is loaded
				reader.onload = function(e) {
					// Set the 'src' attribute of the img with id 'imagess' to the file's URL
					$('#imagess').attr('src', e.target.result);
				}

				// Read the file as a Data URL
				reader.readAsDataURL(fileInput.files[0]);
			}
		}
	</script>
</body>
</html>
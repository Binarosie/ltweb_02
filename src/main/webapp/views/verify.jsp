<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Verify Code</title>
</head>
<body>
	<span>Hệ thống đã gửi mã kích hoạt đến mail của bạn</span>
	<span>Xin vui lòng kiểm tra mail của bạn</span>
	<br />
	<div>
		<form action="/JBDC/verifyCode" method="post">
			<div class="container">
				<label for="uname"><b>Your code</b></label> 
				<input type="text"
					placeholder="Enter code" name="authcode" class="form-control margin-top-20">
			</div>
			<input type="submit" value="Kích hoạt" class="btn-u btn-u-sea-shop margin-top-20">
		</form>
	</div>
</body>
</html>
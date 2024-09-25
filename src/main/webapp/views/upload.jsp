<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cập nhật profile</title>

<!-- Bootstrap CSS for improved styling -->
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">

<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f8f9fa;
        padding: 20px;
    }
    .container {
        max-width: 600px;
        margin: 0 auto;
        background: #ffffff;
        padding: 20px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        border-radius: 10px;
    }
    .form-group label {
        font-weight: bold;
    }
    .form-control {
        border-radius: 5px;
    }
    .btn-primary {
        border-radius: 5px;
        padding: 10px 20px;
    }
</style>

</head>
<body>

	<div class="container">
		<h3 class="text-center">Cập nhật Profile</h3>
		<hr>

		<form method="post" action="/JBDC/multiPartServlet"
			class="form-horizontal" role="form"
			enctype="multipart/form-data">

			<!-- File Upload -->
			<div class="form-group">
				<label for="multiPartServlet">Choose a file</label>
				<input type="file" class="form-control-file" id="multiPartServlet" name="multiPartServlet" />
			</div>

			<!-- Full Name Field -->
			<div class="form-group">
				<label for="fullName">Full Name</label>
				<input type="text" class="form-control" id="fullName" name="fullName" required>
			</div>

			<!-- Phone Field -->
			<div class="form-group">
				<label for="phone">Phone</label>
				<input type="text" class="form-control" id="phone" name="phone" required>
			</div>

			<!-- Submit Button -->
			<div class="form-group text-center">
				<button type="submit" class="btn btn-primary">Submit</button>
			</div>

		</form>
	</div>

<!-- Include Bootstrap JS and dependencies (optional) -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
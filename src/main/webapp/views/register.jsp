<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<%@ taglib prefix="fn" uri="jakarta.tags.functions"%>
<%-- <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign up</title>
</head>
<style>
body {
	font-family: Arial, Helvetica, sans-serif;
}

* {
	box-sizing: border-box
}

/* Full-width input fields */
input[type=text], input[type=password] {
	width: 100%;
	padding: 15px;
	margin: 5px 0 22px 0;
	display: inline-block;
	border: none;
	background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
	background-color: #ddd;
	outline: none;
}

hr {
	border: 1px solid #f1f1f1;
	margin-bottom: 25px;
}

/* Set a style for all buttons */
button {
	background-color: #04AA6D;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
	opacity: 0.9;
}

button:hover {
	opacity: 1;
}

/* Extra styles for the cancel button */
.cancelbtn {
	padding: 14px 20px;
	background-color: #f44336;
}

/* Float cancel and signup buttons and add an equal width */
.cancelbtn, .signupbtn {
	float: left;
	width: 50%;
}

/* Add padding to container elements */
.container {
	padding: 16px;
}

/* Clear floats */
.clearfix::after {
	content: "";
	clear: both;
	display: table;
}

/* Change styles for cancel button and signup button on extra small screens */
@media screen and (max-width: 300px) {
	.cancelbtn, .signupbtn {
		width: 100%;
	}
}
</style>
<body>
	<form action="/JBDC/register" method="post"
		style="border: 1px solid #ccc">
		<div class="container">
			<div class="row">
				<div class="col">
					<c:if test="${not empty error}">
						<div class="alert alert-danger">${error}</div>
					</c:if>
				</div>
			</div>
		</div>
		<div class="container">
			<h1>Sign Up</h1>
			<hr>

			<label for="username"><b>Username</b></label> <input type="text"
				placeholder="Enter Username" name="username" required> <label
				for="password"><b>Password</b></label> <input type="password"
				placeholder="Enter Password" name="password" required> <label
				for="fullName"><b>Full Name</b></label> <input type="text"
				placeholder="Enter FullName" name="fullName" required> <label
				for="email"><b>Email</b></label> <input type="text"
				placeholder="Enter Email" name="email" required> <label
				for="phone"><b>Phone</b></label> <input type="text"
				placeholder="Enter Phone" name="phone" required>

			<div class="clearfix">
				<button type="button" class="cancelbtn">Cancel</button>
				<button type="submit" class="signupbtn">Sign Up</button>
			</div>
		</div>
	</form>

</body>
</html> --%>

<div class="main">
	<div class="container">
		          <div class="col-md-9 col-sm-9">
            <h1>Create an account</h1>
            <div class="content-form-page">
              <div class="row">
                <div class="col-md-7 col-sm-7">
                  <form action="/JBDC/register" method="post" class="form-horizontal" role="form">
                 	<div class="col">
						<c:if test="${not empty error}">
							<div class="alert alert-danger">${error}</div>
						</c:if>
					</div>
                    <fieldset>
                      <legend>Your personal details</legend>
                      <div class="form-group">
                        <label for="fullName" class="col-lg-4 control-label">Full Name <span class="require">*</span></label>
                        <div class="col-lg-8">
                          <input type="text" name="fullName" class="form-control" id="fullName">
                        </div>
                      </div>
                      
                      <div class="form-group">
                        <label for="username" class="col-lg-4 control-label">Username <span class="require">*</span></label>
                        <div class="col-lg-8">
                          <input type="text" name="username" class="form-control" id="username">
                        </div>
                      </div>
              
                      <div class="form-group">
                        <label for="email" class="col-lg-4 control-label">Email <span class="require">*</span></label>
                        <div class="col-lg-8">
                          <input type="text" name="email" class="form-control" id="email">
                        </div>
                      </div>
                      
                       <div class="form-group">
                        <label for="phone" class="col-lg-4 control-label">Phone <span class="require">*</span></label>
                        <div class="col-lg-8">
                          <input type="text" name="phone" class="form-control" id="phone">
                        </div>
                      </div>
                    </fieldset>
                    <fieldset>
                      <legend>Your password</legend>
                     </fieldset>
                      <div class="form-group">
                        <label for="password" class="col-lg-4 control-label">Password <span class="require">*</span></label>
                        <div class="col-lg-8">
                          <input type="text" name="password" class="form-control" id="password">
                        </div>
                      </div>
                    <div class="row">
                      <div class="col-lg-8 col-md-offset-4 padding-left-0 padding-top-20">                        
                        <button type="submit" class="btn btn-primary">Create an account</button>
                        <button type="button" class="btn btn-default">Cancel</button>
                      </div>
                    </div>
                  </form>
                </div>
                <div class="col-md-4 col-sm-4 pull-right">
                  <div class="form-info">
                    <h2><em>Important</em> Information</h2>
                    <p>Lorem ipsum dolor ut sit ame dolore  adipiscing elit, sed sit nonumy nibh sed euismod ut laoreet dolore magna aliquarm erat sit volutpat. Nostrud exerci tation ullamcorper suscipit lobortis nisl aliquip  commodo quat.</p>

                    <p>Duis autem vel eum iriure at dolor vulputate velit esse vel molestie at dolore.</p>

                    <button type="button" class="btn btn-default">More details</button>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <!-- END CONTENT -->
	</div>
</div>

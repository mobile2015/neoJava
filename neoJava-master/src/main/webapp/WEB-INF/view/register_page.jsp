<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>

<!DOCTYPE html>
<!--[if IE 9]><html class="lt-ie10" lang="en" > <![endif]-->
<html class="no-js" lang="en">

<head>
<meta charset="utf-8">
<!-- If you delete this meta tag World War Z will become a reality -->
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>neo</title>

<meta name="description" content="tech_mob">
<meta charset="UTF-8" />

<link rel="stylesheet" href="<c:url value="/resources/css/app.css"/>">
</head>
<body>
	<h1>Register page.</h1>

	<form id="register-form"
		action="${pageContext.request.contextPath}/register" method="POST">
		<label>E-mail<input type="email" placeholder="E-mail"
			name="email" />
		</label> <br /> <label>Password <input type="password"
			id="register-password" name="password" placeholder="Password"
			pattern=".{6,}" />
		</label> <br /> <label>Repeat Password<input type="password"
			placeholder="Repeat password" pattern=".{6,}" name="repeatedPassword" />
		</label> <br /> <label>First name<input type="text"
			placeholder="First Name" required name="firstName" />
		</label> <br /> <label>Last name<input type="text"
			placeholder="Last name" name="lastName" required />
		</label> <br />
		<button type="submit">Register</button>
	</form>


	<h4>
		<a href="${pageContext.request.contextPath}/">Home</a>
	</h4>
	<h4>
		<a href="${pageContext.request.contextPath}/login/page">Login</a>
	</h4>
</body>
</html>
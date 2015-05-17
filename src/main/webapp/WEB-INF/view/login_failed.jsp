<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>

<!DOCTYPE html>
<!--[if IE 9]><html class="lt-ie10" lang="en" > <![endif]-->
<html class="no-js" lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>neo</title>

<meta name="description" content="tech_mob">
<meta charset="UTF-8" />

<link rel="stylesheet" href="<c:url value="/resources/css/app.css"/>">
</head>
<body>
<h1>Error! Could not log you in.</h1>


<h4><a href="${pageContext.request.contextPath}/login/page">Login</a></h4>
<h4><a href="${pageContext.request.contextPath}/register/page">Reqister</a></h4>
</body>
</html>
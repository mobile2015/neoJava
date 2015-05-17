<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

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
<h1>Hello! This is home page.</h1>
<sec:authorize access="isAuthenticated()">
<h2>You are logged in as <sec:authentication property="principal.username" />   </h2>
<h4>Write a query <a href="${pageContext.request.contextPath}/query">Query</a></h4>


</sec:authorize>

<sec:authorize access="isAuthenticated()">
<h4><a href="${pageContext.request.contextPath}/logout">Logout</a></h4>
</sec:authorize>
<sec:authorize access="!isAuthenticated()">
<h4><a href="${pageContext.request.contextPath}/login/page">Login</a></h4>
<h4><a href="${pageContext.request.contextPath}/register/page">Reqister</a></h4>
</sec:authorize>
</body>
</html>
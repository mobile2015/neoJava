<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


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

<sec:authorize access="isAuthenticated()">
<h1>Query page</h1>

<h4>Back to home <a href="${pageContext.request.contextPath}/">Home</a></h4>



<form method="post" action="${pageContext.request.contextPath}/executeQuery" >
			<spring:bind path="query"> <input id="query" name="query" type="text" value="${query }" style="width:90%"/> </spring:bind>
					<input value="Wykonaj" type="submit" class="btn btn-primary" />					

		</form>
		


${result}
</sec:authorize>



</body>
</html>
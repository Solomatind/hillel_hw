<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<fmt:setBundle basename="film_library" />

<html>
<head>
<link href="style/style.css" rel="stylesheet" type="text/css">
<title><fmt:message key="deletefilmtitle" /></title>
</head>
<body>
	<c:import url="/jspf/header.jspf"></c:import>
	<form action="deleteFilm" method="post">
		<br> <br>
		<h1>
			<fmt:message key="formheaderdelete" />
		</h1>
		<input type="number" name="years"> <input type="submit">
	</form>
	<h1 align="center">
		<fmt:message key="deleteinfo" />
		${count}
	</h1>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<fmt:setBundle basename="film_library" />

<!DOCTYPE html>
<html>
<head>
<link href="style/style.css" rel="stylesheet" type="text/css">
<title><fmt:message key="authorizationtitle" /></title>
</head>
<body>
	<div class="authorization">
		<form action="authorization" method="post">
			<h2>
				<fmt:message key="formuser" />
			</h2>
			<input type="text" name="userName">
			<h2>
				<fmt:message key="formpassword" />
			</h2>
			<input type="password" name="password"><br> <input
				type="submit">
		</form>
		<h2 align="center" class="errormesage">${incorrect}</h2>
	</div>
</body>
</html>
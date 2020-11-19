<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setBundle basename="film_library"/>

<html>
<head>
<link href="style/style.css" rel="stylesheet" type="text/css">
<title><fmt:message key="title"/></title>
</head>
<body>
	<c:import url="/jspf/header.jspf"></c:import>
	<div class="out">
		<h3>
			<c:forEach items="${films}" var="film">
        ${film}<br>
			</c:forEach>
			<c:forEach items="${actors}" var="actor">
        ${actor}<br>
			</c:forEach>
		</h3>
	</div>
</body>
</html>

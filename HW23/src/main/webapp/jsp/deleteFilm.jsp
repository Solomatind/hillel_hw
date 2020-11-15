<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link href="style/style.css" rel="stylesheet" type="text/css">
<title>Delete film</title>
</head>
<body>
	<c:import url="/jspf/header.jspf"></c:import>
	<form action="deleteFilm" method="post">
		<br>
		<br>
		<h1>Insert years:</h1>
		<input type="number" name="years"> <input type="submit">
	</form>
	<h1 align="center">Count of deleting films: ${status}</h1>
</body>
</html>
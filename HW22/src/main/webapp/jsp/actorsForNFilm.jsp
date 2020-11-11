<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link href="style/style.css" rel="stylesheet" type="text/css">
<title>Actors for N film</title>
</head>
<body>
	<c:import url="/jspf/header.jspf"></c:import>

	<form action="actorsForNFilm" method="post">
		<br> <br>
		<h1>Insert count of films:</h1>
		<input type="number" name="film"> <input type="submit">
	</form>
	<div class="out">
		<h3>
			<c:forEach items="${actors}" var="actor">
        ${actor}<br>
			</c:forEach>
		</h3>
	</div>
</body>
</html>
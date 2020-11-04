<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link href="style/style.css" rel="stylesheet" type="text/css">
<title>Actors by film</title>
</head>
<body>
	<c:import url="/jspf/header.jspf"></c:import>
	<form action="actorsByFilm" method="post">
		<br>
		<br>
		<h1>Insert film:</h1>
		<input type="text" name="film"> <input type="submit">
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
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link href="style/style.css" rel="stylesheet" type="text/css">
<title>Main page</title>
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

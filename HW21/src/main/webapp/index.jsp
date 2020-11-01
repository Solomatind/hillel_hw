<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link href="style/style.css" rel="stylesheet" type="text/css">
<title>Main page</title>
</head>
<body>
	<c:import url="/jspf/header.jspf"></c:import>
	<c:out value="${films}"></c:out>
	<c:out value="${actors}"></c:out>
</body>
</html>

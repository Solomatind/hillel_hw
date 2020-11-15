<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link href="style/style.css" rel="stylesheet" type="text/css">
<title>Authorization</title>
</head>
<body>
	<div class="authorization">
		<form action="authorization" method="post">
			<h2>User name:</h2>
			<input type="text" name="userName">
			<h2>Password:</h2>
			<input type="password" name="password"><br> <input
				type="submit">
		</form>
		<h2 align="center" class="errormesage">${incorrect}</h2>
	</div>
</body>
</html>
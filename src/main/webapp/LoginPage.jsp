<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
		<form action="/deliverytrackingsystem/login" method="post"
			onsubmit="return checkForm(this);">
			<fieldset>
				<legend>Login</legend>
				<table>
					<tr>
						<td>Email: <input type="email" name="email"
							placeholder="Email"></td>
						<td>Password: <input type="password" name="password"
							placeholder="Password"></td>
						<td>&#9;<input type="submit" value="login"></td>
					</tr>
				</table>
			</fieldset>
		</form>
	</div>
</body>
</html>
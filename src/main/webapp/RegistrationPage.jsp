<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript">
	function checkForm(form) {
		if (form.username.value == "") {
			alert("Error: Username cannot be blank!");
			form.username.focus();
			return false;
		}
		re = /^\w+$/;
		if (!re.test(form.username.value)) {
			alert("Error: Username must contain only letters, numbers and underscores!");
			form.username.focus();
			return false;
		}

		if (form.password.value != ""
				&& form.password.value == form.confirmpassword.value) {
			if (form.pwd1.value.length < 6) {
				alert("Error: Password must contain at least six characters!");
				form.pwd1.focus();
				return false;
			}
			if (form.password.value == form.username.value) {
				alert("Error: Password must be different from Username!");
				form.pwd1.focus();
				return false;
			}
			re = /[0-9]/;
			if (!re.test(form.password.value)) {
				alert("Error: password must contain at least one number (0-9)!");
				form.pwd1.focus();
				return false;
			}
			re = /[a-z]/;
			if (!re.test(form.password.value)) {
				alert("Error: password must contain at least one lowercase letter (a-z)!");
				form.pwd1.focus();
				return false;
			}
			re = /[A-Z]/;
			if (!re.test(form.password.value)) {
				alert("Error: password must contain at least one uppercase letter (A-Z)!");
				form.pwd1.focus();
				return false;
			}
		} else {
			alert("Error: Please check that you've entered and confirmed your password!");
			form.pwd1.focus();
			return false;
		}

		alert("You entered a valid password: " + form.password.value);
		return true;
	}
</script>
<title>Insert title here</title>
</head>
<body>
	<div>
		<form action="/deliverytrackingsystem/register" method="post"
			onsubmit="return checkForm(this);">
			<fieldset>
				<legend>Registration From</legend>
				<table>
					<tr>
						<td><input type="text" name="name" placeholder="Name"></td>
					</tr>
					<tr>
						<td><input type="text" name="surnname" placeholder="SurnName"></td>
					</tr>
					<tr>
						<td><input type="text" name="username" placeholder="UserName"></td>
					</tr>
					<tr>
						<td><input type="text" name="age" placeholder="Age"></td>
					</tr>
					<tr>
						<td><input type="text" name="dob" placeholder="DateOfBirth"></td>
					</tr>
					<tr>
						<td><input type="email" name="email" placeholder="Email"></td>
					</tr>
					<tr>
						<td><input type="password" name="password"
							placeholder="Password"></td>
					</tr>
					<tr>
						<td><input type="password" name="confirmpassword"
							placeholder="Confirm Password"></td>
					</tr>
					<tr>
						<td><input type="text" name="address" placeholder="Address"></td>
					</tr>
					<tr>
						<td><input type="submit" value="Register"></td>
					</tr>
				</table>
			</fieldset>
		</form>
	</div>
</body>
</html>
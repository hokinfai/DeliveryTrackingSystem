<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Package</title>
<link href="style.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<!--Header Background Part Starts -->
	<div id="header-bg">
		<!--Header Contant Part Starts -->
		<div id="header">
			<a href="index.html"><img src="images/logo.gif" alt="Package"
				width="205" height="62" border="0" class="logo" title="Package" /></a>
			<!--Login Background Starts -->
			<div id="login-bg">
				<!--Login Area Starts -->
				<div id="login-area">
					<form action="" method="post" name="Login" id="Login">
						<label>Members Login:</label> <input type="text" name="username"
							id="username" /> <input type="password" name="pass" id="pass" />
						<input type="image" src="images/login-btn.gif" class="login-btn"
							alt="Login" title="Login" /> <br class="spacer" />
					</form>
				</div>
				<!--Login Area Ends -->
			</div>
			<!--Login Background Ends -->
			<br class="spacer" />
		</div>
		<!--Header Contant Part Ends -->
	</div>
	<!--Header Background Part Ends -->
	<!--Navigation Background Part Starts -->
	<div id="navigation-bg">
		<!--Navigation Part Starts -->
		<div id="navigation">
			<ul class="mainMenu">
				<li><a href="#" title="Home">Home</a></li>
				<li><a href="#" title="Track">Track</a></li>
				<li><a href="#" title="Our Services">Services</a></li>
				<li><a href="#" title="Discount Policy">Discount</a></li>
				<li><a href="#" title="Help Us">Help</a></li>
				<li><a href="#" title="About">About</a></li>
				<li class="noBg"><a href="#" title="Contact">Contact</a></li>
			</ul>
			<a href="/deliverytrackingsystem/register.jsp" class="signup"
				title="signup now"></a> <br class="spacer" />
			<ul class="subNav">
				<li class="noBg"><a href="#" title="Our Benefits">Business
						Opportunities</a></li>
				<li><a href="#" title="What Our Future Plans">What Our
						Future Plans</a></li>
				<!--Using a graph to show how many orders that we have completed in DB -->
				<li><a href="#" title="Our Success">Our Success</a></li>
				<li><a href="#" title="News">News</a></li>
				<li><a href="#" title="FAQ">FAQ</a></li>
				<li><a href="#" title="Company Login">Company Login</a></li>
			</ul>
			<br class="spacer" />
		</div>
		<!--Navigation Part Ends -->
	</div>
	<!--Navigation Background Part Ends -->
	<!--Our Company Bacground Part Starts -->
	<div id="ourCompany-bg">
		<!--Our Company Part Starts -->
		<div id="ourCompany-part">
			<h2 class="ourCompany-hdr">Welcome to our family, Register NOW!</h2>
			<!--Our Company Left Part Starts -->

			<div id="ourCompany-rightPart">
				<form action="/deliverytrackingsystem/register" method="post"
					onsubmit="return checkForm(this);">

					<table width="400">
						<tr>
							<td><font face="Comic Sans MS">Name:</font></td>
							<td><input type="text" name="name" placeholder="Name"></td>
						</tr>
						<tr>
							<td><font face="Comic Sans MS">Surnname:</font></td>
							<td><input type="text" name="surnname"
								placeholder="SurnName"></td>
						</tr>
						<tr>
							<td><font face="Comic Sans MS">Username:</font></td>
							<td><input type="text" name="username"
								placeholder="UserName"></td>
						</tr>
						<tr>
							<td><font face="Comic Sans MS">Age:</font></td>
							<td><input type="text" name="age" placeholder="Age"></td>
						</tr>
						<tr>
							<td><font face="Comic Sans MS">Date of Birth:</font></td>
							<td><input type="text" name="dob" placeholder="DD/MM/YYYY"></td>
						</tr>
						<tr>
							<td><font face="Comic Sans MS">E-mail:</font></td>
							<td><input type="email" name="email"
								placeholder="email@example.com"></td>
						</tr>
						<tr>
							<td><font face="Comic Sans MS">Password:</font></td>
							<td><input type="password" name="password"
								placeholder="8 letters and number "></td>
						</tr>
						<tr>
							<td><font face="Comic Sans MS">Confirm password:</font></td>
							<td><input type="password" name="confirmpassword"
								placeholder="Confirm Password"></td>
						</tr>
						<tr>
							<td><font face="Comic Sans MS">Address:</font></td>
							<td><input type="text" name="address" placeholder="Address"></td>
						</tr>
						<tr>
							<td></td>
							<td>&emsp;</td>
						</tr>
					</table>
					<input type="submit" value="Register">
				</form>
			</div>
			<!--Our Company Right Part Ends -->
			<br class="spacer" />
		</div>
		<!--Our Company Part Ends -->
	</div>
	<!--Our Company Bacground Part Ends -->
	</div>
	<!--Footer Part Starts -->
	<div id="footer-bg">
		<!--Footer Menu Part Starts -->
		<div id="footer-menu">
			<ul class="footMenu">
				<li class="noDivider"><a href="#" title="Home">Home</a></li>
				<li><a href="#" title="About">About</a></li>
				<li><a href="#" title="Services">Services</a></li>
				<li><a href="#" title="Help">Help</a></li>
				<li><a href="#" title="History">History</a></li>
				<li><a href="#" title="Contact">Contact</a></li>
			</ul>
			<br class="spacer" />
			<p class="copyright">Copyright &copy; Package 2007 All Rights
				Reserved</p>
			<p class="copyright topPad">
				<a href="http://www.flashmint.com/show-type-flash.html">Flash
					Templates</a> by<a href="http://www.flashmint.com/">FlashMint</a>
			</p>
		</div>
		<!--Footer Menu Part Ends -->
	</div>
	<!--Footer Part Ends -->
</body>
</html>

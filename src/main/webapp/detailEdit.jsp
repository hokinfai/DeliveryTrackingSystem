<%@ include file="header.jsp"%>
<%
	User loginedUser = (User) session.getAttribute("user");
%>
<!--Navigation Background Part Ends -->
<!--Our Company Bacground Part Starts -->
<div id="ourCompany-bg">
	<!--Our Company Part Starts -->
	<div id="ourCompany-part">
		<h2 class="ourCompany-hdr">Update Detail:</h2>
		<!--Our Company Left Part Starts -->

		<div id="ourCompany-rightPart">
			<form action="/deliverytrackingsystem/modify" method="post"
				onsubmit="return checkForm(this);">


				<table style="width: 500px">
					<tr>
						<td><font face="Comic Sans MS">Name:</font></td>
						<td><input type="text" name="name" id="check"
							placeholder=<%=loginedUser.getName().replace(" ", "&nbsp;")%>
							style="height: 20px; font-size: 15px" size="31" required></td>
					</tr>
					<tr>
						<td><font face="Comic Sans MS">Surnname:</font></td>
						<td><input type="text" name="surnname" id="check"
							placeholder=<%=loginedUser.getSurnname().replace(" ", "&nbsp;")%>
							style="height: 20px; font-size: 15px" size="31" required></td>
					</tr>
					<tr>
						<td><font face="Comic Sans MS">Username:</font></td>
						<td><input type="text" name="username" id="check"
							placeholder=<%=loginedUser.getUsername().replace(" ", "&nbsp;")%>
							style="height: 20px; font-size: 15px" size="31" required></td>
					</tr>
					<tr>
						<td><font face="Comic Sans MS">Age:</font></td>
						<td><input type="text" name="age" id="check"
							placeholder=<%=loginedUser.getAge()%>
							style="height: 20px; font-size: 15px" size="31" required></td>
					</tr>
					<tr>
						<td><font face="Comic Sans MS">Date of Birth:</font></td>
						<td><input type="text" name="dob" id="check"
							placeholder=<%=loginedUser.getDob().replace(" ", "&nbsp;")%>
							style="height: 20px; font-size: 15px" size="31" required></td>
					</tr>

					<tr>
						<td><font face="Comic Sans MS">Address:</font></td>
						<td><textarea id="check" name="address" cols="40" rows="5"
								required><%=loginedUser.getAddress()%></textarea></td>
					</tr>
					<tr>
						<td></td>
						<td>&emsp;</td>
					</tr>
					<tr>
						<td><font face="Comic Sans MS" color="red">Confirm
								your Password:</font></td>
						<td><input type="password" name="password" id="check"
							placeholder="8 letters and number"
							style="height: 20px; font-size: 15px" size="20" required></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" value="Save Change"
							onclick="verify()"></td>
					</tr>
				</table>

			</form>
		</div>
		<!--Our Company Right Part Ends -->
		<br class="spacer" />
	</div>
	<!--Our Company Part Ends -->
</div>
<!--Our Company Bacground Part Ends -->
</div>
<%@ include file="footer.jsp"%>
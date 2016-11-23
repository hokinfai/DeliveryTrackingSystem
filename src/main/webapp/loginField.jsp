<%@ page import="com.example.model.User"%>
<%
	session = request.getSession(true);
	User user = null;
	if (session.getAttribute("user") != null) {
		user = (User) session.getAttribute("user");
		out.print("<form action=\"/deliverytrackingsystem/Logout\" method=\"post\"><input type=\"image\" src=\"images/logout-btn.png\" class=\"login-btn\" alt=\"Logout\" title=\"Logout\"  style=\"float:right;width:35px;height:35px;padding-top: 20px\" /></from>");
	} else {
		out.print("<div id=\"login-bg\"><div id=\"login-area\"><form action=\"/deliverytrackingsystem/login\" method=\"post\" name=\"Login\" id=\"Login\">");
		out.print("<label>Members Login:</label> <input type=\"text\" name=\"email\" id=\"username\" />");
		out.print("<input type=\"password\" name=\"password\" id=\"pass\" />");
		out.print("<input type=\"image\" src=\"images/login-btn.gif\" class=\"login-btn\" alt=\"Login\" title=\"Login\" />");
		out.print("<br class=\"spacer\" /> </form></div></div>");
	}
%>
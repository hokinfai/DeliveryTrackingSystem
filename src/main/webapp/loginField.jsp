
<%
	if (session.getAttribute("user") == null
			&& session.getAttribute("company") == null) {	
		out.print("<div id=\"login-bg\"><div id=\"login-area\"><form action=\"/deliverytrackingsystem/login\" method=\"post\" name=\"Login\" id=\"Login\">");
		out.print("<label>Members Login:</label> <input type=\"text\" name=\"email\" id=\"username\" required/>");
		out.print("<input type=\"password\" name=\"password\" id=\"pass\" required/>");
		out.print("<input type=\"image\" src=\"images/login-btn.gif\" class=\"login-btn\" alt=\"Login\" title=\"Login\" />");
		out.print("<br class=\"spacer\" /> </form></div></div>");
	}
%>
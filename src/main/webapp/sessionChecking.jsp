
<%
	try {
		session = request.getSession(true);
		if (session.getAttribute("user") == null
				&& session.getAttribute("company") == null) {
			response.sendRedirect("index.jsp");
		} else {
			System.out.println("User in sessionchecking: "
					+ session.getAttribute("user").toString());
		}
	} catch (Exception e) {
		response.sendRedirect("index.jsp");
	}
%>

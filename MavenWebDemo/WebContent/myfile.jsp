<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.Date"%>
<!-- spring, jstl, ...tags -->
<!--   -->  
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%! 
private String projectName = "MavenWebDemo";

public boolean validateUser(String username, String password){
	new Date();
	return true;
}
%>

<!-- code in index.jsp will show here -->
<%@ include file="index.jsp" %>

<%
out.println("my first jsp");
validateUser("root", "root");
%>

<%= "jsp expression tag will show anything here to web page"+ new Date() %>

</body>
</html>
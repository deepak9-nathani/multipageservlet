<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page 3</title>
</head>
<body>


<form action="NEWREC" method="POST" enctype="multipart/form-data" name="formUpload" onsubmit="myFunction()">
<input type="file" name="fileUpload" multiple="multiple">
<input type="submit" value="next">
</form> 
<form action="index2.jsp">
<input type="submit" value="Back">
</form> 
	<% String NoofExp = request.getParameter("NoOfExp");
String ExpInTech = request.getParameter("ExpInTech");
String lastCompName = request.getParameter("lastCompName");
Cookie NoofExpCookie = new Cookie("noofExp",NoofExp);
Cookie ExpInTechCookie = new Cookie("ExpInTech",ExpInTech);
Cookie lastCompNameCookie = new Cookie("lastComp",lastCompName);
response.addCookie(NoofExpCookie);
response.addCookie(ExpInTechCookie);
response.addCookie(lastCompNameCookie);
%>
</body>
</html>
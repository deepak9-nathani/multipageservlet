<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page 2</title>
</head>
<body>
<% 
String noOfExp = null;
String noExpTech = null;
String lastComp = null;
Cookie ck[] =  request.getCookies();
for(Cookie val: ck){
	if(val.getName().equals("noofExp")){
		noOfExp = val.getValue();
	}
	if(val.getName().equals("ExpInTech")){
		noExpTech = val.getValue();
	}
	if(val.getName().equals("lastComp")){
		lastComp = val.getValue();
	}
}
%>

<form action="index3.jsp" method="get">
No of Experience:<input type="text" name="NoOfExp" value="<% if(noOfExp != null){out.println(noOfExp);} else{out.println("");} %>">
Experience in Technology:<input type="text" name="ExpInTech" value="<% if(noExpTech != null){out.println(noExpTech);} else{out.println("");} %>">
Last Company Name:<input type="text" name="lastCompName" value="<% if(lastComp != null){out.println(lastComp);} else{out.println("");} %>">
<input type="submit" value="Next">
</form>
<form action="index.jsp" method="get">
<input type="submit" value="back">
</form>
<% 
String firstName = null;
String lastName = null;
String Email = null;
if(request.getParameter("firstName") != null){
 firstName = request.getParameter("firstName");
 lastName = request.getParameter("lastName");
 Email = request.getParameter("Email");
Cookie firstNameCookie = new Cookie("firstName",firstName);
Cookie lastNameCookie = new Cookie("lastName",lastName);
Cookie EmailCookie = new Cookie("Email",Email);
response.addCookie(firstNameCookie);
response.addCookie(lastNameCookie);
response.addCookie(EmailCookie);
}
else{
	Cookie ck1[] =  request.getCookies();
	for(Cookie val: ck1){
		if(val.getName().equals("firstName")){
			firstName = val.getValue();
			
		}
		if(val.getName().equals("lastName")){
			lastName = val.getValue();
		}
		if(val.getName().equals("Email")){
			Email = val.getValue();
		}
	}
}
%>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
String firstName = null;
String lastName = null;
String Email = null;
Cookie ck[] =  request.getCookies();
for(Cookie val: ck){
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

%>
<div id="firstDiv">
<form id="firstForm" action="index2.jsp" method="get">
	FirstName:<input type="text" name="firstName"  value=<% if(firstName != null){out.println(firstName);} else{out.println("");} %>>
	LastName:<input type="text" name="lastName"  value=<% if(lastName != null){out.println(lastName);} else{out.println("");} %>>
	Email:<input type="text" name="Email"  value=<% if(Email != null){out.println(Email);} else{out.println("");} %>>
	<input type="submit" value="Next">
	</form>
</div>	
</body>
</html>
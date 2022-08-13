<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
<%@page import="java.io.*" %>
<%@page import="java.util.ArrayList"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.IOException"%>
<%@page import="java.io.ObjectInputStream"%>
<%@page import = "com.oreilly.servlet.MultipartRequest" %>
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
String file = null;
int fileLen = 0;
String firstName = null;
String lastName = null;
String Email = null;
String NoofExp = null;
String ExpinTech = null;
String lastComp = null;
ArrayList<String> arr = new ArrayList<>();
Cookie ck[] = request.getCookies();
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
	if(val.getName().equals("lastComp")){
		lastComp = val.getValue();
	}
	if(val.getName().equals("noofExp")){
		NoofExp = val.getValue();
	}
	if(val.getName().equals("ExpInTech")){
		ExpinTech = val.getValue();
	}
	if(val.getName().contains("fileLen")){
	fileLen = Integer.parseInt(val.getValue());
	}
	for(int i=1;i<=fileLen;i++){
		if(val.getName().equals("fileName"+i)){
			arr.add(val.getValue());
		}
	}
}
%>
<form action="fileSubmit" method="post">
FirstName:<input type="text" name="firstName" value="<% if(firstName != null){out.println(firstName);} else{out.println("");} %>" disabled="disabled">
LastName:<input type="text" name="firstName" value="<% if(lastName != null){out.println(lastName);} else{out.println("");} %>" disabled="disabled">
Email:<input type="text" name="firstName" value="<% if(Email != null){out.println(Email);} else{out.println("");} %>" disabled="disabled">
No of Experience:<input type="text" name="firstName" value="<% if(NoofExp != null){out.println(NoofExp);} else{out.println("");} %>" disabled="disabled">
Experience in Technology:<input type="text" name="firstName" value="<% if(ExpinTech != null){out.println(ExpinTech);} else{out.println("");} %>" disabled="disabled"> 
Last Company:<input type="text" name="firstName" value="<% if(ExpinTech != null){out.println(ExpinTech);} else{out.println("");} %>" disabled="disabled"> 
<%
for(String s:arr){
	file = s;
%>
<span><a href="http://localhost:8081/newMultiPageCrud/fileDownload?fileName=<%=file%>">Download This <%= file %></a> </span>
<%
}
%>     
<input type="submit" value="Submit">
</form>
<form method="post" action="fileDelete">
<input type="submit" value="reset">   
</form>
<script>
function myFunction(){
	 var allCookies = document.cookie.split(';');
     // The "expire" attribute of every cookie is 
     // Set to "Thu, 01 Jan 1970 00:00:00 GMT"
     for (var i = 0; i < allCookies.length; i++)
         document.cookie = allCookies[i] + "=;expires="
         + new Date(0).toUTCString();		
}
</script>
</body>
</html>
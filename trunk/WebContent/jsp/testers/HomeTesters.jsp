<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="com.samart.etesting.bean.login.UserInfo" %>    
<%@ include file="ChkSessionTesters.jsp"%> 
    
<%
  Object obj = session.getAttribute("UserProfile");
  UserInfo usr = (UserInfo)obj;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>E-Testing</title>
</head>
<body>
<hr color="RED" width="100%">
<br>&nbsp;&nbsp;TESTER
<br>&nbsp;&nbsp;<a href="#">Logout </a>
<br>&nbsp;&nbsp;<a href="#">Go to Testing</a>
<br>&nbsp;&nbsp;<a href="ReportScoreFormAction.do">Report Score</a>
<hr color="RED" width="100%">
<br>&nbsp;&nbsp;
<table border="0" cellpadding="0" cellspacing="0">
    <tr>
	<td colspan="2"><h3>User profile</h3></td>
	</tr>
	<tr>
	<td colspan="2"><img src="images/usr_150_150.png" width="120" height="120" border="0"></td>
	</tr>
	<tr>
	<td align="left">ID </td><td align="left">:&nbsp;<%=usr.getUserId() %></td>
	</tr>
	<tr>
	<td align="left">USER ID</td><td align="left"> :&nbsp;<%=usr.getLogIn() %></td>
	</tr>
	<tr>
	<td align="left">First Name</td><td align="left">: &nbsp;<%=usr.getFirstName()%></td>
	</tr>
	<tr>
	<td align="left">Last Name</td><td align="left">: &nbsp;<%=usr.getLastName() %></td>
	</tr>
	<tr>
	<td align="left">E-mail</td><td align="left">: &nbsp;<%=usr.getEmail() %></td>
	</tr>
	<tr>
	<td align="left">Role</td><td align="left">: &nbsp;<%=usr.getRole() %></td>
	</tr>
</table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Message</title>
</head>
<body>
<form action="index.jsp">
<br><table width="50%" border="1" align="center" celpadding="0" celspacing="0" bordercolor="#000000">
<tr> 
     <td bgcolor="#ff0000"><font color="#ffffff" size=""><b>Message Errors</b></font></td>
</tr>
<tr> 
     <td bgcolor="#ece9d8">
     <br>
     <li><%=request.getAttribute("msg")%><br>
     <br><center><input type="submit" name="submit" value="กลับไปหน้าแรก" > <br>
      </center>
      </td>
</tr>
</table>
</form>
<br>
<br>
</body>
</html>
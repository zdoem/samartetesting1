<%@taglib uri="http://struts.apache.org/tags-html-el" prefix="html1"%><%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
     
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Login : E-Testing</title>

<style rel="stylesheet" type="text/css">
body {
  color: #000000;
  background-color: #ffffff;
  font-family: arial, verdana, sans-serif;
  font-size: 12pt;
}

fieldset {
  font-size: 13px;
  padding: 10px;
  width: 350px;
  /*text-align: right;
  text-align: left;*/
  text-align: right;
  
}
</style>
<script type="text/javascript">
function window.onload(){
	document.forms[0].password.value='';
	document.forms[0].userName.focus();
}

function validateLogin(){
  var frm = document.forms[0];
  if( frm.userName.value == ""){

    alert("Please input Username");
    frm.userName.focus();
    return false;
  }else if( frm.password.value == ""){
    alert("Please input Password");
    frm.password.focus();
    return false;
  }else{
     alert("submit");
    //frm.submit();
    return true;
  }
}

</script>
</head>
<body>
<html:form action="LoginAction.do"  onsubmit="return validateLogin()" >
	<p>
	<center>
	<fieldset>
		<b><a href="#">SAMART E-Testing</a></b><br></br>
		<legend>Login Form</legend>
		<%
		  if(request.getAttribute("msg")==null){
			  out.println("");
		  }else{
			  %>
			  <div align="center"><h4><font color="RED"><%=request.getAttribute("msg") %></font></h4></div>
			  <%
		  }
		%>
		<br>
		ผู้ใช้งาน :<html:text property="userName" size="25" maxlength="80"/> <br/><br>
	         รหัสผ่าน :<html:password property="password" size="27" maxlength="80" value=""/><br/><br>
		 <html:submit property="submit" value=" เข้าสู่ระบบ  "  style="width: 80px;" ></html:submit>
		 &nbsp;&nbsp;&nbsp;
		 <html:reset property="reset" value=" ยกเลิก  " style="width: 80px; "></html:reset> &nbsp; 		  
	</fieldset>
	</center>
</html:form>
</body>
</html>
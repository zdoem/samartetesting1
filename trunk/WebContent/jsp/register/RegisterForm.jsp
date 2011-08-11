<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Register FORM</title>
<html:base/>
</head>
<body>

<%-- <html:messages id=“err_age” property=“age”>
				<bean:write name=“err_age” /><br />
</html:messages> --%>

<html:form action="RegisterAction.do"  >

<font color="#FF0000"><html:errors  /></font>

  <table width="600px">
      <tr  valign="top" bgcolor="#476c0c">
      <td align="left" colspan="2"><font color="#FFFFFF">Register Form ::::::</font></td>
    </tr>
    <tr>
     <td colspan="2">&nbsp;</td>
    </tr>
    <tr  valign="top">
       <td align="right">User Name:</td>
       <td align="left">
        <html:text property="userName" size="30" maxlength="80"/><font color="#FF0000">*</font> 
        <br>

       </td>
    </tr>
    <tr  valign="top">
       <td align="right">Password:</td> 
      <td align="left">
      <html:password property="password" size="30" maxlength="80"/><font color="#FF0000">*</font>  
      <br>

      </td>
    </tr>
    <tr align="right" valign="top">
      <td align="right">ชื่อ:</td> 
      <td align="left">
      <html:text property="fname" size="30" maxlength="80"/><font color="#FF0000">*</font> 
      </td>
    </tr>
    <tr align="center" valign="top">
      <td align="right">สกุล:</td> 
      <td align="left">
      <html:text property="lname" size="30" maxlength="80"/><font color="#FF0000">*</font> 
      </td>
    </tr>
    <tr align="center" valign="top">
      <td align="right">E-mail:</td> 
      <td align="left">
      <html:text property="email" size="30" maxlength="80"/><font color="#FF0000">*</font> 
      </td>
    </tr>

    <tr  valign="top">
      <td align="left" colspan="2"> 
         <html:submit property="submit" value=" Register "></html:submit> 
         <html:reset property="reset" value=" Reset "></html:reset>   
      </td>
    </tr>
  </table>
</html:form>

</body>
</html>
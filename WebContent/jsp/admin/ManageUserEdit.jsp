<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>User Edit FORM</title>
</head>
<body>

<html:errors/>
<html:form action="EditManageUserAction.do"  >
<html:hidden property="refId" />
<html:hidden property="command" value="EDIT"/>

  <table width="600px">
      <tr  valign="top" bgcolor="#476c0c">
      <td align="left" colspan="2"><font color="#FFFFFF">User Edit FORM ::::::</font></td>
    </tr>
    <tr>
     <td colspan="2">&nbsp;</td>
    </tr>
    <tr  valign="top">
       <td align="right">User Name:</td>
       <td align="left">
        <html:text property="userInfo.logIn"  size="30" maxlength="80"  disabled="true"/> 
        <br>

       </td>
    </tr>
    <tr  valign="top">
       <td align="right">Password:</td> 
      <td align="left">
      <html:password property="userInfo.password"  size="30" maxlength="80"/>
      <br>

      </td>
    </tr>
    <tr align="right" valign="top">
      <td align="right">ชื่อ:</td> 
      <td align="left">
      <html:text property="userInfo.firstName"   size="30" maxlength="80" />
      </td>
    </tr>
    <tr align="center" valign="top">
      <td align="right">สกุล:</td> 
      <td align="left">
      <html:text property="userInfo.lastName"  size="30" maxlength="80" />
      </td>
    </tr>
    <tr align="center" valign="top">
      <td align="right">E-mail:</td> 
      <td align="left">
      <html:text property="userInfo.email"  size="30" maxlength="80" />
      </td>
    </tr>

    <tr  valign="top">
      <td align="left" colspan="2"> 
         <html:submit property="submit" value=" Update "></html:submit> 
         <html:reset property="reset" value=" Reset "></html:reset>   
      </td>
    </tr>
  </table>
</html:form>

</body>
</html>
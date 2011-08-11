<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>


<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>User View FORM</title>
</head>


<html:errors/>

<html:form action="MasterUserAction.do" >
<logic:iterate name="masUserForm" property="userInfoList" id="result">
  <table width="600px">
      <tr  valign="top" bgcolor="#476c0c">
      <td align="left" colspan="2"><font color="#FFFFFF">User View FORM ::::::</font></td>
    </tr>
    <tr>
     <td colspan="2">&nbsp;</td>
    </tr>
    <tr  valign="top">
       <td align="right">User Name:</td>
       <td align="left">
        <html:text property="result.logIn" value="${result.logIn}" size="30" maxlength="80" disabled="true"/> 
        <br>

       </td>
    </tr>
    <tr  valign="top">
       <td align="right">Password:</td> 
      <td align="left">
      <html:password property="result.password" value="${result.password}" size="30" maxlength="80" disabled="true"/>
      <br>

      </td>
    </tr>
    <tr align="right" valign="top">
      <td align="right">ชื่อ:</td> 
      <td align="left">
      <html:text property="result.firstName"  value="${result.firstName}" size="30" maxlength="80" disabled="true"/>
      </td>
    </tr>
    <tr align="center" valign="top">
      <td align="right">สกุล:</td> 
      <td align="left">
      <html:text property="result.lastName" value="${result.lastName}" size="30" maxlength="80" disabled="true"/>
      </td>
    </tr>
    <tr align="center" valign="top">
      <td align="right">E-mail:</td> 
      <td align="left">
      <html:text property="result.email" value="${result.email}" size="30" maxlength="80" disabled="true"/>
      </td>
    </tr>
  <tr align="center" valign="top">
      <td align="right">Role:</td> 
      <td align="left">
      <html:text property="result.role" value="${result.role}" size="30" maxlength="80" disabled="true"/>
      </td>
    </tr>
   
    <tr  valign="top">
      <td align="left" colspan="2"> 
         <html:submit property="submit" value=" Back "></html:submit>  
      </td>
    </tr>
  </table>
  </logic:iterate>
</html:form>


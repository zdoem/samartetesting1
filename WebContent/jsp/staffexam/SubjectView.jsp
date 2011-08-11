<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Subject View FORM</title>
</head>
<body>

<html:form action="ManageSubjectAction.do" >
<logic:iterate name="subjectMngForm" property="subjectList" id="result">
  <table width="600px">
      <tr  valign="top" bgcolor="#476c0c">
      <td align="left" colspan="2"><font color="#FFFFFF">Subject View FORM ::::::</font></td>
    </tr>
    <tr>
     <td colspan="2">&nbsp;</td>
    </tr>
    <tr  valign="top">
       <td align="right">รหัสวิชา:</td>
       <td align="left">
       <input type="text" value="${result.subjectCode}" size="30" maxlength="80" disabled="disabled">
       <br>
       </td>
    </tr>
    <tr  valign="top">
       <td align="right">ชื่อวิชา:</td> 
      <td align="left">
       <input type="text" value="${result.subjectName}" size="30" maxlength="80" disabled="disabled">
       <br>
      </td>
    </tr>
    <tr align="right" valign="top">
      <td align="right">รายละเอียด:</td> 
      <td align="left">
       <textarea rows="4" cols="20" disabled="disabled">${result.subjectDetails}</textarea>
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

</body>
</html>
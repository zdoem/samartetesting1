<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Subject Edit FORM</title>
</head>
<body>

<html:form action="EditSubjectAction.do" >
<html:errors/>
<html:hidden property="refId" />
<html:hidden property="command" value="EDIT"/>
  <table width="600px" bordercolor="#d6d6d6" backgroundcolor="#d6d6d6">
      <tr  valign="top" bgcolor="#476c0c">
      <td align="left" colspan="2"><font color="#FFFFFF">Subject FORM Edit ::::::</font></td>
    </tr>
    <tr bgcolor="#d6d6d6">
     <td colspan="2">&nbsp;</td>
    </tr>
    <tr  valign="top" bgcolor="#d6d6d6">
       <td align="right">รหัสวิชา:</td>
       <td align="left">
        <html:text property="subjectObj.subjectCode"  size="30" maxlength="80"  /><font color="#FF0000">*</font>  
        <br>

       </td>
    </tr>
    <tr  valign="top" bgcolor="#d6d6d6">
       <td align="right">ชื่อวิชา:</td> 
      <td align="left">
      <html:text property="subjectObj.subjectName"  size="30" maxlength="80"/><font color="#FF0000">*</font> 
      <br>

      </td>
    </tr >
    <tr align="right" valign="top" bgcolor="#d6d6d6">
      <td align="right">รายละเอียด:</td> 
      <td align="left">
      <html:textarea property="subjectObj.subjectDetails" cols="45" rows="4">
      </html:textarea><font color="#FF0000">*</font> 
      </td>
    </tr>
   
    <tr  valign="top" bgcolor="#d6d6d6">
      <td align="left" colspan="2"> 
         <html:submit property="submit" value=" Update "></html:submit> 
         <html:reset property="reset" value=" Reset "></html:reset>   
      </td>
    </tr>
  </table>
</html:form>


</body>
</html>
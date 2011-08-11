<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Set Exam FORM ADD </title>
</head>
<body>


<html:form action="AddSetExamAction.do" method="post" >
<html:errors/>
  <table width="600px" bordercolor="#d6d6d6" backgroundcolor="#d6d6d6">
      <tr  valign="top" bgcolor="#476c0c">
      <td align="left" colspan="2"><font color="#FFFFFF">Set Exam FORM ADD ::::::</font></td>
    </tr>
    <tr bgcolor="#d6d6d6">
     <td colspan="2">&nbsp;</td>
    </tr>
    <tr  valign="top" bgcolor="#d6d6d6">
       <td align="right">รหัสวิชา:</td>
       <td align="left">
       <html:select name="setExamForm"	property="subjectRefId" >
							<html:option value="">-- Please Specify -- </html:option>
							<html:options collection="subjectDLL" property="subjectId" labelProperty="subjectName" />
		</html:select><font color="#FF0000">*</font> 
        <br>

       </td>
    </tr>
    <tr  valign="top" bgcolor="#d6d6d6">
       <td align="right">เลขชุดข้อสอบ:</td> 
      <td align="left">
       <html:text property="subjectName"  size="30" maxlength="80"/>
      <font color="#FF0000">*</font> 
      <br>

      </td>
    </tr >
    <tr align="right" valign="top" bgcolor="#d6d6d6">
      <td align="right">ชื่อชุดข้อสอบ:</td> 
      <td align="left">
        Test
      <font color="#FF0000">*</font> 
      </td>
    </tr>
     <tr  valign="top" bgcolor="#d6d6d6">
       <td align="right">% คะแนนผ่าน:</td> 
      <td align="left">
      <html:textarea property="question" cols="45" rows="4">
      </html:textarea><font color="#FF0000">*</font> 
      <br>
      </td>
    </tr >
    <tr  valign="top" bgcolor="#d6d6d6">
       <td align="right">เป็นชุดข้อสอบหลัก :</td> 
      <td align="left">
  		<html:checkbox property="setExamSelect" ></html:checkbox>
       <font color="#FF0000">*</font> 
      <br>
      </td>
    </tr >
  
    <tr  valign="top" bgcolor="#d6d6d6">
       <td align="right">จำนวนข้อรวม :</td> 
      <td align="left">
Test
       <font color="#FF0000">*</font> 
      <br>
      </td>
    </tr >
  
    <tr  valign="top" bgcolor="#d6d6d6">
      <td align="left" colspan="2"> 
         <html:submit property="submit" value=" ADD "></html:submit> 
         <html:reset property="reset" value=" Reset "></html:reset>   
      </td>
    </tr>
  </table>
</html:form>

</body>
</html>
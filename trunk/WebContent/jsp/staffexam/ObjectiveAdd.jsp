<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Objective FORM ADD </title>
</head>
<body>


<html:form action="AddObjectiveAction.do" method="post" enctype="multipart/form-data">
<html:errors/>
  <table width="600px" bordercolor="#d6d6d6" backgroundcolor="#d6d6d6">
      <tr  valign="top" bgcolor="#476c0c">
      <td align="left" colspan="2"><font color="#FFFFFF">Objective FORM ADD ::::::</font></td>
    </tr>
    <tr bgcolor="#d6d6d6">
     <td colspan="2">&nbsp;</td>
    </tr>
    <tr  valign="top" bgcolor="#d6d6d6">
       <td align="right">รหัสวิชา:</td>
       <td align="left">
       <html:select name="objectiveForm"	property="subjectRefId" >
							<html:option value="">-- Please Specify -- </html:option>
							<html:options collection="subjectDLL" property="subjectId" labelProperty="subjectName" />
		</html:select><font color="#FF0000">*</font> 
        <br>

       </td>
    </tr>
    <tr  valign="top" bgcolor="#d6d6d6">
       <td align="right">ชื่อวิชา:</td> 
      <td align="left">
       <html:text property="subjectName"  size="30" maxlength="80"/>
      <font color="#FF0000">*</font> 
      <br>

      </td>
    </tr >
    <tr align="right" valign="top" bgcolor="#d6d6d6">
      <td align="right">วัตถุประสงค์:</td> 
      <td align="left">
      <select name="objectiveName"  >
					<option selected value="">-- Please Specify -- </option>
		            <option value="00">00</option>
		            <option value="01">01</option>
		            <option value="02">02</option>
		            <option value="03">03</option>
	  </select>
      <font color="#FF0000">*</font> 
      </td>
    </tr>
     <tr  valign="top" bgcolor="#d6d6d6">
       <td align="right">คำถาม:</td> 
      <td align="left">
      <html:textarea property="question" cols="45" rows="4">
      </html:textarea><font color="#FF0000">*</font> 
      <br>
      </td>
      
    </tr >
        <tr  valign="top" bgcolor="#d6d6d6">
       <td align="right">รูปภาพ :</td> 
      <td align="left">
<%--       <html:messages id="err_name" property="common.file.err.size">
		<div style="color:red">
			<bean:write name="err_name" />
		</div>
		  </html:messages> --%>
    
       <html:file property="imgFile" />
       <font color="#FF0000">*</font> 
      <br>
      </td>
    </tr >
    
    <tr  valign="top" bgcolor="#d6d6d6">
       <td align="right">ผู้ออกข้อสอบ:</td> 
      <td align="left">
       Test<font color="#FF0000">*</font> 
      <br>
      </td>
    </tr >
    
    <tr  valign="top" bgcolor="#d6d6d6">
       <td align="right">คะแนน:</td> 
      <td align="left">
       Test<font color="#FF0000">*</font> 
      <br>
      </td>
    </tr >
    
     <tr  valign="top" bgcolor="#d6d6d6">
       <td align="right">ตัวเลือกที่ถูก:</td> 
      <td align="left">
       Test<font color="#FF0000">*</font> 
      <br>
      </td>
    </tr >
    
    <tr  valign="top" bgcolor="#d6d6d6">
       <td align="right">เวลา(วินาที):</td> 
      <td align="left">
       <select name="timeSec"  >
					<option selected value="">-- Please Specify -- </option>
		            <option value="00">00</option>
		            <option value="01">01</option>
		            <option value="02">02</option>
		            <option value="03">03</option>
	  </select><font color="#FF0000">*</font> 
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
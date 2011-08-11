<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %> 

<html>
<%
 String path = request.getContextPath();
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Report Stat Random By Subject</title>

<link rel="stylesheet" href="<%=path %>/ui-lightness/jquery.ui.all.css">
	<script src="<%=path%>/js/jquery-1.5.1.js"></script>
	<script src="<%=path%>/ui/jquery.ui.core.js"></script>
	<script src="<%=path%>/ui/jquery.ui.widget.js"></script>
	<script src="<%=path%>/ui/jquery.ui.datepicker.js"></script>
	<link rel="stylesheet" href="<%=path%>/ui-lightness/jquery-ui-1.8.14.custom.css">

<script>
	$(function() {
		//$( "#datepicker" ).datepicker();	
		$("#fromDate1" ).datepicker({ dateFormat: 'dd-mm-yy' });
	});
	
	$(function() {
		//$( "#datepicker2" ).datepicker();
		$("#toDate1" ).datepicker({ dateFormat:  'dd-mm-yy'  });
	});
	
	function test(){
		
		var date1 = document.getElementById("fromDate1").value;
		var date2 = document.getElementById("toDate1").value;
		
		alert("Date1:"+date1+"\n Date2:"+date2);
	}

  
  function doView(xid){
	    document.forms[1].action="<%=request.getContextPath()%>/ViewManageUserAction.do?refId="+xid;
	    doSubmit();
  }
  function doSubmit(){
    document.forms[1].submit();
  }
</script>
</head>
<body>

<html:form action="ReportStatAction.do" method="post">
<html:hidden property="fromDate"/>
<html:hidden property="toDate"/>

<table width="550" border="1" cellspacing="2" cellpadding="2" bordercolor="#d6d6d6">
  <tr bgcolor="#d6d6d6">
    <th colspan="2" scope="col">&nbsp;</th>
  </tr>
    <tr bgcolor="#d6d6d6">
    <td  colspan="2">
      <label >ชื่อผู้ทดสอบ : <html:text property="testerName" size="30" maxlength="80"/> </label>
    </td>
  </tr>

  <tr bgcolor="#d6d6d6">
    <td  scope="row">
      <label>ตั้งแต่วันที่ทดสอบ :</label> <input type="text"  name="fromDate1"  id="fromDate1" size="15" maxlength="80"/>
    </td>
    <td>
      <label>ถึงวันที่ทดสอบ :</label> <input type="text" name="toDate1" id="toDate1" size="15" maxlength="80"/>
    </td>
  </tr>
  <tr bgcolor="#d6d6d6">
    <th height="47" colspan="2" scope="row">
    <html:button property="button" value=" แสดงรายงาน  " onclick="test()"></html:button> 
     &nbsp;&nbsp;
    <input name="back" type="button" value=" ยกเลิก " >
    </th>
  </tr>
</table>
</html:form>
<br>

</body>
</html>
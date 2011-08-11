<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>  

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Report History Testing Form</title>

<script language="javascript">
  function doEdit(xid){
    document.forms[1].action="<%=request.getContextPath()%>/EditManageUserAction.do?refId="+xid;
    doSubmit();
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

<html:form action="ManageUserAction.do" method="post">
<table width="550" border="1" cellspacing="2" cellpadding="2" bordercolor="#d6d6d6">
  <tr bgcolor="#d6d6d6">
    <th colspan="2" scope="col">&nbsp;</th>
  </tr>
  <tr bgcolor="#d6d6d6">
    <td  colspan="2">
      <label>รหัสวิชา : </label>
    </td>
  </tr>
  <tr bgcolor="#d6d6d6">
    <td  colspan="2">
      <label>ชื่อวิชา : </label>
    </td>
  </tr>

 
  <tr bgcolor="#d6d6d6">
    <th height="47" colspan="2" scope="row">
    <html:submit property="submit" value=" แสดงรายงาน  "></html:submit> 
     &nbsp;&nbsp;
    <input name="back" type="button" value=" ยกเลิก " >
    </th>
  </tr>
</table>
</html:form>
<br>

</body>
</html>
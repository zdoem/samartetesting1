<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>  
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Manage Subject Form</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />	
<script language="javascript">
  function doEdit(xid){
    document.forms[1].action="<%=request.getContextPath()%>/EditSubjectAction.do?refId="+xid;
    doSubmit();
  }
  
  function doView(xid){
	    document.forms[1].action="<%=request.getContextPath()%>/ViewSubjectAction.do?refId="+xid;
	    doSubmit();
  }
  
  function doDelete(xid){
	  if (confirm("Are you sure you want to delete \n ID:"+xid)) {
		    document.forms[1].action="<%=request.getContextPath()%>/DeleteSubjectAction.do?refId="+xid;
		    doSubmit();
		}
  }

  function doSubmit(){
    document.forms[1].submit();
  }
</script>
</head>
<body>

<html:form action="ManageSubjectAction.do" method="post">
<table width="550" border="1" cellspacing="2" cellpadding="2" bordercolor="#d6d6d6">
  <tr bgcolor="#d6d6d6">
    <th colspan="2" scope="col">&nbsp;</th>
  </tr>
  <tr bgcolor="#d6d6d6" align="left"> 
    <th   colspan="2" scope="row">
      <label>รหัสวิชา : <html:text property="subjectCode" size="30" maxlength="80"/></label>
    </th>
  </tr>
  <tr bgcolor="#d6d6d6" align="left">
    <th   colspan="2" scope="row">
       <label> ชื่อวิชา : <html:text property="subjectName" size="35" maxlength="80"/></label>
    </th>
  </tr>
  <tr bgcolor="#d6d6d6">
    <th height="47" colspan="2" scope="row">
    <html:submit property=" submit " value=" ค้นหา  "></html:submit> 
     &nbsp;&nbsp;
    <input name=" back " type="button" value=" กลับ " >
    </th>
  </tr>
</table>
</html:form>
<!-- <p>&nbsp;</p> -->
 <html:form action="ManageSubjectAction.do">
        <display:table export="false"  id="data" name="requestScope.subjectMngForm.subjectList" requestURI="/ManageSubjectAction.do" pagesize="10" class="grid"  decorator="com.samart.etesting.web.util.ActorDecoratorSubject" > 
            <display:column class="tableBody"  property="subjectCode" title="รหัสวิชา" sortable="true"   />
            <display:column class="tableBody"  property="subjectName" title="ชื่อวิชา " sortable="true"  />
            <display:column class="tableBody"  property="subjectDetails" title="รายละเอียด" sortable="true"  />
            <display:column class="tableBody"  property="doViewId" url="/ViewSubjectAction.do" title=" View "  sortable="false" />
            <display:column class="tableBody"  property="doEditId" url="/EditSubjectAction.do"  title=" Edit "   sortable="false" />
            <display:column class="tableBody"  property="doDeleteId"  url="/DeleteSubjectAction.do" title=" Delete "   sortable="false" />
        </display:table>
</html:form>
<a href="AddSubjectAction.do">ADD Subject</a>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>  
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Manage User Form</title>

<script language="javascript">
  function doEdit(xid){
    document.forms[1].action="<%=request.getContextPath()%>/EditMasterUserAction.do?refId="+xid;
    doSubmit();
  }
  
  function doView(xid){
	    document.forms[1].action="<%=request.getContextPath()%>/ViewMasterUserAction.do?refId="+xid;
	    doSubmit();
  }
  
  function doDelete(xid){
	  if (confirm("Are you sure you want to delete \n ID:"+xid)) {
		    document.forms[1].action="<%=request.getContextPath()%>/DeleteMasterUserAction.do?refId="+xid;
		    doSubmit();
		}
  }
  function doSubmit(){
    document.forms[1].submit();
  }
</script>
</head>
<body>

<html:form action="MasterUserAction.do" method="post">
<table width="550" border="1" cellspacing="2" cellpadding="2" bordercolor="#d6d6d6">
  <tr bgcolor="#d6d6d6">
    <th colspan="2" scope="col">&nbsp;</th>
    </tr>
  <tr bgcolor="#d6d6d6">
    <td  align="left">
      <label>User Name : <html:text property="userName" size="25" maxlength="80"/></label>
    </td>
    <td>
      <label> ชื่อ : <html:text property="firstName" size="25" maxlength="80"/></label>
    </td>
  </tr>
  <tr  valign="top" bgcolor="#d6d6d6">
       <td align="left" colspan="2">
                   Role:
       <html:select name="masUserForm"	property="roleIdDDL"   >
							<html:option value="">-- Please Specify -- </html:option>
							<html:options collection="roleDLL" property="roleId" labelProperty="roleName" />
		</html:select>
        <br>

       </td>
    </tr>
  <tr bgcolor="#d6d6d6">
    <th height="47" colspan="2" scope="row">
    <html:submit property="submit" value=" ค้นหา  "></html:submit> 
     &nbsp;&nbsp;
    <input name="back" type="button" value=" กลับ " >
    </th>
  </tr>
</table>
</html:form>
<!-- <p>&nbsp;</p> -->
<html:form action="MasterUserAction.do">
        <display:table export="false"  id="data" name="requestScope.masUserForm.userInfoList" requestURI="/MasterUserAction.do" pagesize="10" class="grid"  decorator="com.samart.etesting.web.util.ActorDecorator" > 
            <display:column class="tableBody"  property="logIn" title="UserName" sortable="true"   />
            <display:column class="tableBody"  property="firstName" title=" ชื่อ " sortable="true"  />
            <display:column class="tableBody"  property="lastName" title=" นามสกุล " sortable="true"  />
             <display:column class="tableBody"  property="role" title=" Role " sortable="true"  />
            <display:column class="tableBody"  property="doViewId" url="/ViewMasterUserAction.do" title=" View "  sortable="false" />
            <display:column class="tableBody"  property="doEditId" url="/EditMasterUserAction.do"  title=" Edit "   sortable="false" />
            <display:column class="tableBody"  property="doDeleteId"  url="/DeleteMasterUserAction.do" title=" Delete "   sortable="false" />
        </display:table>
</html:form>
<a href="#">Register FORM</a>
</body>
</html>
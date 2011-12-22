<%@ include file="/jsp/template_includes.jsp" %>
<%@ include file="/jsp/template_header.jsp" %>
<%@ include file="/jsp/template_includes2.jsp" %>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Watchdog List: bugger,issue,tricker</title>
<script type="text/javascript">
function  doEdit(id){
    //document.forms[0].cmd.value="load";	   
    document.forms[1].action="<%=request.getContextPath()%>/RetrieveDogData.dog?cmd=edit&dogId="+id;
    document.forms[1].submit();
}

function  doView(id){	   
    document.forms[1].action="<%=request.getContextPath()%>/RetrieveDogData.dog?cmd=view&dogId="+id;
    document.forms[1].submit();
}


function doDelete(id){
	if(confirm("คุณต้องการลบรายการนี้  "+id+" ใช่หรือไม่?")){
			document.forms[1].action="<%=request.getContextPath()%>/dogDelete.dog?dogId="+id;
    		document.forms[1].submit();
	}
}

function onADD(){
	document.forms[1].action="<%=request.getContextPath()%>/dogAddForm.dog";
    document.forms[1].submit();
}


function  onSearch(){	   
    document.forms[0].action="<%=request.getContextPath()%>/dogList.dog";
    document.forms[0].submit();
}


</script>
</head>
<body >
<br>
<br>

<center>
<form:form method="post" action="typeAddAction.dog">
  <table width="800px" align="center">
  <tr >
  <th colspan="2" align="left" bgcolor="#497c09" ><h3><font color="#FFFFFF">Criteria For dog..</font></h3></th>
  </tr>
      <tr>
      <th>&nbsp; หัวข้อ/subject:
        <form:input path="dogSubject" size="25"/>
      </th>
       <th> ประเภท Bug :        
   			 <form:select path="dogTypeIdDDL">
                   <form:option value="">---Select---</form:option>
                    <form:options items="${mapTypeDLL}" />
              </form:select>
      </th>
    </tr>
 
      <tr>
      <th>&nbsp; เทคนิก/แนวทางแก้ปัญหา:
        <form:input path="dogSolution"  size="25"/> 
      </th>
    </tr> 
    <tr>
      <td>     
         <p class="submit"><input type="button" value=" Search" onclick="javascript:onSearch();"/>&nbsp;&nbsp;
         <input type="reset" value=" Reset "/></p>
      </td>
    </tr>
    
   </table> 
</form:form>

<%-- // use our pagedListHolder --%>
<jsp:useBean id="pagedListHolder" scope="request" type="org.springframework.beans.support.PagedListHolder"/>
<%-- // create link for pages, "~" will be replaced later on with the proper page number --%>
<c:url value="/dogList.dog" var="pagedLink">
	<c:param name="action" value="dogList.dog"/>
    <c:param name="p" value="~"/>
</c:url>

<%-- // load our paging tag, pass pagedListHolder and the link --%>
<tg:paging pagedListHolder="${pagedListHolder}" pagedLink="${pagedLink}"/>

<%-- // show only current page worth of data --%>
<form:form  commandName="Dogger" method="POST" action="dogList.dog">
<input type="hidden" name="cmd" value="">
<table width="800px" border="1" bordercolor="#FFFFFF">

<tr><td colspan="5" align="left"><h3>รายการข้อมูล Doger ,Tricker,SQL etc..</h3></td>
</tr>
<tr bgcolor="#497c09">
	<th style="color:#FFFFFF;font-weight:bold;text-align:center">DOG_ID</th>
	<th style="color:#FFFFFF;font-weight:bold;text-align:center">DOG_SUBJECT</th>
	<th style="color:#FFFFFF;font-weight:bold;text-align:center">TYPE_NAME</th>
	<th style="color:#FFFFFF;font-weight:bold;text-align:center">DOG_DESC</th>
	<th style="color:#FFFFFF;font-weight:bold;text-align:center">DOG_SOLUTION</th>
	<th style="color:#FFFFFF;font-weight:bold;text-align:center" width="15px">EDIT</th>
	<th style="color:#FFFFFF;font-weight:bold;text-align:center" width="15px">DELETE</th>
</tr>
<c:forEach items="${pagedListHolder.pageList}" var="item">
    <tr  height="20px" >
    	<td align="center" valign="top"><a href="javascript:doView('${item.dogId}')">${item.dogId}</a></td>
    	<td valign="top">${item.dogSubject}</td>
    	<td valign="top">${item.dogTypeName}</td>
    	<td valign="top">${item.dogDesc}</td>
    	<td valign="top">${item.dogSolution}</td>
    	<td valign="top"><a href="javascript:doEdit('${item.dogId}')">Edit</a></td>
    	<td valign="top"><a href="javascript:doDelete('${item.dogId}')">Delete</a></td>
    </tr>
</c:forEach>

<tr><td colspan="5" align="left" >
<p class="submit"><input type="button" value=" ADD " onclick="javascript:onADD();"/></p>
</td>
</tr>
</table>

</form:form>

<%--//load our paging tag, pass pagedListHolder and the link --%>
<tg:paging pagedListHolder="${pagedListHolder}" pagedLink="${pagedLink}"/>

</body>
</html>
<%@ include file="/jsp/template_footer.jsp" %>
</center>
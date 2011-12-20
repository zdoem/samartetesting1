<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/jsp/template_includes.jsp" %>
<%@ include file="/jsp/template_header.jsp" %>
<title>ADD  type of Buger</title>
<script type="text/javascript">

function onSAVE() {
  
	if(document.forms[0].typeName.value==''){
		alert("กรุณากรอกประเภทของ  Bug ด้วย...");
		document.forms[0].typeName.focus();
	}else{
	    document.forms[0].action="<%=request.getContextPath()%>/typeUpdateAction.dog";
	    document.forms[0].submit();
	}
    
  } 
 
 </script>
</head>
<body>
  <div id="main">
<h4>ข้อมูลพื้นฐาน   : EDIT รายการประเภท  BUG</h4>

<form:form method="post" action="typeAddAction.dog">
<form:hidden path="typeId"/>
  <table width="600px">
   
    <tr>
      <th>&nbsp; ประเภทของ Bug:
        <br/>
        <form:input path="typeName" size="45"/><font color="#FF0000">&nbsp;*</font> 
      </th>
    </tr> 
    
    <tr>
      <th>
      &nbsp; รายละเอียด :
        <br/>
        <form:textarea path="typeDesc" cols="35" rows="4"/> 
      </th>
    </tr>
    

    <tr>
      <td>     
         <p class="submit"><input type="button" value=" EDIT " onclick="javascript:onSAVE();"/>&nbsp;&nbsp;<input type="reset" value=" Reset "/></p>
      </td>
    </tr>
  </table>
</form:form>

<%@ include file="/jsp/template_footer.jsp" %>
    
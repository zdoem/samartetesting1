<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/jsp/template_includes.jsp" %>
<%@ include file="/jsp/template_header.jsp" %>
<title>ADD  type of Buger</title>
<script type="text/javascript">

function onSAVE() {
  
	if(document.forms[0].dogSubject.value==''){
		alert("กรุณากรอก  หัวข้อ/ชื่อเรื่อง ด้วย...");
		document.forms[0].dogSubject.focus();
	}else if(document.forms[0].dogTypeIdDDL.value==''){		
		alert("กรุณาเลือก ประเภท Bug ด้วย...");
		document.forms[0].dogTypeIdDDL.focus();		
	}else if(document.forms[0].dogSolution.value==''){
		alert("กรุณากรอกแนวทางแก้ปัญหาหรือ เทคนิค ต่างๆ  ด้วย...");
		document.forms[0].dogSolution.focus();	
	}else{
	    document.forms[0].action="<%=request.getContextPath()%>/saveDoger.dog";
	    document.forms[0].submit();
	}
    
  } 
 
 </script>
</head>
<body>
  <div id="main">
<h4>เพิ่มรายละเอียดเกี่ยวกับ Errors,Logger,SQL หรือ  Tricker</h4>

<form:form method="post" action="typeAddAction.dog">
  <table width="600px">
   
    <tr>
      <th>&nbsp; หัวข้อ/ชื่อเรื่อง :
        <br/>
        <form:textarea path="dogSubject" cols="35" rows="3"/> 
		<font color="#FF0000">&nbsp;*</font>Ex.ปัญหา/เรื่อง/หัวข้อ 
      </th>
    </tr> 
    
        
    <tr>
      <th>
      &nbsp; ประเภท Bug :
        <br/>          
   			 <form:select path="dogTypeIdDDL">
                   <form:option value="">---Select---</form:option>
                    <form:options items="${mapTypeDLL}" />
                </form:select>
        <font color="#FF0000">&nbsp;*</font>  
      </th>
    </tr>

    
    <tr>
      <th>
      &nbsp; รายละเอียด :
        <br/>
        <form:textarea path="dogDesc" cols="45" rows="5"/>
        <font color="#FF0000">&nbsp;</font>  
      </th>
    </tr>
    
        <tr>
      <th>&nbsp; เทคนิก/แนวทางแก้ปัญหา:
        <br/>
        <form:textarea path="dogSolution" cols="45" rows="6"/> 
		<font color="#FF0000">&nbsp;*</font> 
      </th>
    </tr> 
    
        <tr>
      <th>&nbsp; คำแนะนำเพิ่มเติม 1:
        <br/>
         <form:textarea path="dogComment1" cols="35" rows="3"/>
      </th>
    </tr> 
      

    <tr>
      <td>     
         <p class="submit"><input type="button" value=" ADD " onclick="javascript:onSAVE();"/>&nbsp;&nbsp;<input type="reset" value=" Reset "/></p>
      </td>
    </tr>
  </table>
</form:form>

<%@ include file="/jsp/template_footer.jsp" %>
    
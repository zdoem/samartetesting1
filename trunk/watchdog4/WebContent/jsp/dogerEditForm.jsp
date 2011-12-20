<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/jsp/template_includes.jsp" %>
<%@ include file="/jsp/template_header.jsp" %>
<%@ page import="com.dog.model.domain.DogForm" %>
<title>ADD  type of Buger</title>

<%
	DogForm eform = (DogForm)request.getAttribute("command");
	String echo = "false";
	if(eform!=null){
		System.out.println("test :"+eform.getCmd());
		if(eform.getCmd().equals("view")){
			echo = "true";
		}		
	}
	System.out.println(echo);

%>
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
	    document.forms[0].action="<%=request.getContextPath()%>/updateDoger.dog";
	    document.forms[0].submit();
	}    
  } 
  
  
function  doDogList(){
    //document.forms[0].cmd.value="load";	   
    document.forms[0].action="<%=request.getContextPath()%>/dogList.dog";
    document.forms[0].submit();
}
  
 
 </script>
</head>
<body>
  <div id="main">
<h4>รายละเอียดเกี่ยวกับ Errors,Logger,SQL หรือ  Tricker</h4>

<form:form method="post" action="">
	<form:hidden path="dogId"/>
  <table width="600px">
   
    <tr>
      <th>&nbsp; หัวข้อ/ชื่อเรื่อง :
        <br/>
        <form:textarea path="dogSubject" cols="35" rows="3" disabled="<%=echo %>" /> 
		<font color="#FF0000">&nbsp;*</font>Ex.ปัญหา/เรื่อง/หัวข้อ 
      </th>
    </tr> 
    
        
    <tr>
      <th>
      &nbsp; ประเภท Bug :        
   			 <form:select path="dogTypeIdDDL" disabled="<%=echo %>" >
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
        <form:textarea path="dogDesc" cols="45" rows="5" disabled="<%=echo %>"/>
        <font color="#FF0000">&nbsp;</font>  
      </th>
    </tr>
    
    <tr>
      <th>&nbsp; เทคนิก/แนวทางแก้ปัญหา:
        <br/>
        <form:textarea path="dogSolution" cols="45" rows="6" disabled="<%=echo %>"/> 
		<font color="#FF0000">&nbsp;*</font> 
      </th>
    </tr> 
    
      <tr>
      <th>&nbsp; คำแนะนำเพิ่มเติม 1:
        <br/>
         <form:textarea path="dogComment1" cols="35" rows="3" disabled="<%=echo %>"/>
      </th>
    </tr> 
    
    <%
       if(echo.equals("true")) {
    	   //view mode
     %>      
	 <tr>
      <th>&nbsp;Create Date :
        <form:input path="createDate" size="20" disabled="true"/>
      </th>
    </tr>
    
      <tr>
      <th>&nbsp; Update Date :
        <form:input path="updateDate" size="20" disabled="true"/>
      </th>
    </tr>
    
    <tr>
      <td>     
         <p class="submit"><input type="button" value=" BACK DOG " onclick="javascript:doDogList();"/>&nbsp;&nbsp;</p>
      </td>
    </tr>
    <%
       }else{
    %>
     <tr>
      <td>     
         <p class="submit"><input type="button" value=" EDIT " onclick="javascript:onSAVE();"/>&nbsp;&nbsp;<input type="reset" value=" Reset "/></p>
      </td>
    </tr>
    <%
       }    
    %>
  </table>
</form:form>

<%@ include file="/jsp/template_footer.jsp" %>
    
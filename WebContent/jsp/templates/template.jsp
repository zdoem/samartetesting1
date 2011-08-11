<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<html>

<head>
<title><tiles:getAsString name="title" ignore="true"/></title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv=Content-Style-Type content=text/css>
<link rel="stylesheet" href="css/style2.css" type="text/css">
<link href="css/style.css" rel="stylesheet" type="text/css" />	
</head>
<body>

<table width="800px" height="1" border="0" align=center cellpadding="0" cellspacing="0" >
<tr>
<td>
<div>
<tiles:insert attribute="header"/>
</div>
</td>
</tr>


<tr>
<td>
<br/>
<div>
<tiles:insert attribute="body"/>
</div>
</td>
</tr>


<tr>
<td>
<div>
<tiles:insert attribute="bottom"/>
</div>
</td>
</tr>
</table> 

</body>
</html>
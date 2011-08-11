<%@ page import="com.samart.etesting.web.util.*" %>    
<% 

if(!Utitity.isSession(session.getAttribute("usr"),session.getAttribute("status"),"2")){
response.sendRedirect("index.jsp");
} %>
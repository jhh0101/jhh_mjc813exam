<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
%>
<%
request.setCharacterEncoding("UTF-8");
String val = (String)request.getParameter("val");
%>
<!DOCTYPE html>
<html>
    <head>
        <title>MJC813</title>
    </head>

    <body>
        <h1>명지대 813호</h1>
        <hr/>
        <div> 받은 값 : <%=val%> </div>
    </body>
</html>
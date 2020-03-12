<%-- 
    Document   : index
    Created on : Mar 8, 2020, 12:24:18 PM
    Author     : dulshan
--%>


<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a href="<%=request.getContextPath()%>/Admin/login.jsp"> Admin Login</a>
        <h1>Hello World!</h1>
        <p> Hellow User : ${username}</p>
        <% 
            Date date = new Date();
            out.print("<h2>"+date.toString()+"</h2>");
        %>
    </body>
</html>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hello Declare + code + Expression</title>
</head>
<body>
    <% 
    int x = 10; 
    int y = 200; 
    int z = x + y; 
    out.print("Kq la: "); 
    out.print(String.valueOf(z)); 
    %>
    <h2> Hoac ta co the xuat kieu Epression </h2>
    <hr>
    <%= "ket qua la: " %>
    <%= z %>
</body>
</html>
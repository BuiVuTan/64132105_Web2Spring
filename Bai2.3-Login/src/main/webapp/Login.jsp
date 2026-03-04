<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    // Kiểm tra thông tin đăng nhập
    if (username != null && password != null) {
        if ("ABC".equals(username) && "MNK".equals(password)) {
            // Chuyển hướng đến trang UserProfile.htm nếu đúng
            response.sendRedirect("UserProfile.html");
        } else {
            // Chuyển hướng lại trang Login.htm nếu sai
            response.sendRedirect("Login.html");
        }
    }
%>
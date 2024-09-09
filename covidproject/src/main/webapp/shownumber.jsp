<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String state = request.getParameter("t1");
    String contact = "";
    
    if (state != null) {
        switch (state.toLowerCase()) {
            case "mp":
                contact = "312333555";
                break;
            case "up":
                contact = "23234324343";
                break;
            default:
                contact = "Server error or invalid state.";
                break;
        }
    } else {
        contact = "No state parameter provided.";
    }
%>    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Helpline Information</title>
</head>
<body>
    <h3>Helpline number for your state: <%=state %></h3>
    <h3>number for your state: <%= contact %></h3>
</body>
</html>

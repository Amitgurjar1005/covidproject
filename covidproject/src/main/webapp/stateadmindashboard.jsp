<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>State Admin Dashboard</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        h1, h2 { color: #333; }
        .link-container a { display: block; margin: 10px 0; text-decoration: none; color: #007BFF; }
        .link-container a:hover { text-decoration: underline; }
        .form-container { max-width: 600px; margin: 20px auto; padding: 20px; border: 1px solid #ddd; border-radius: 5px; background: #f9f9f9; }
        .form-container label { display: block; margin: 10px 0 5px; }
        .form-container input { width: calc(100% - 16px); padding: 8px; margin-bottom: 10px; border: 1px solid #ccc; border-radius: 4px; }
        .form-container button { padding: 10px 15px; background-color: #28a745; color: white; border: none; border-radius: 4px; cursor: pointer; }
        .form-container button:hover { background-color: #218838; }
        .message { margin-top: 20px; color: #d9534f; }
    </style>
</head>
<body>
    <h1>Welcome State Admin</h1>
    <h2>Manage Your Information</h2>

    <div class="link-container">
        <a href="covidinfo.jsp">Add Info for Today</a>
        <a href="viewownstate">View Info for Own State</a>
        <a href="viewinfostate1">View Info for State</a>
        <a href="home.jsp">Logout</a>
    </div>

    <div class="form-container">
        <form id="form" action="updatestateadmin1" method="post">
            <h3>Update Your Information</h3>

            <label for="userid">User ID:</label>
            <input type="text" id="userid" name="userid" required>

            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>

            <label for="name">Name:</label>
            <input type="text" id="name" name="name" required>

            <label for="address">Address:</label>
            <input type="text" id="address" name="address" required>

            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required>

            <label for="mobile">Mobile No:</label>
            <input type="text" id="mobile" name="mobile" required>

            <label for="state">State:</label>
            <input type="text" id="state" name="state" required>

            <button type="submit">Update</button>
        </form>

        <div class="message">
            <!-- Display success or error messages here if needed -->
            <% 
                String message = (String) request.getAttribute("message");
                if (message != null) {
                    out.println("<p>" + message + "</p>");
                }
            %>
        </div>
    </div>
</body>
</html>

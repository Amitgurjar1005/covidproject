<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Dashboard</title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        background-color: #f5f5f5;
    }
    header {
        background-color: #007BFF;
        color: white;
        padding: 15px;
        text-align: center;
    }
    footer {
        background-color: #007BFF;
        color: white;
        text-align: center;
        padding: 10px;
        position: fixed;
        bottom: 0;
        width: 100%;
    }
    .container {
        width: 80%;
        margin: auto;
        overflow: hidden;
        padding: 20px;
    }
    h2 {
        color: #333;
    }
    form {
        background: white;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        margin-bottom: 20px;
        animation: fadeIn 1s ease-in;
    }
    label {
        display: block;
        margin-top: 10px;
        font-weight: bold;
    }
    input[type="text"], input[type="password"], input[type="email"] {
        width: 100%;
        padding: 10px;
        margin-top: 5px;
        border: 1px solid #ddd;
        border-radius: 4px;
    }
    input[type="submit"] {
        background: #007BFF;
        color: white;
        border: none;
        padding: 10px 15px;
        border-radius: 5px;
        cursor: pointer;
        margin-top: 10px;
        transition: background 0.3s ease;
    }
    input[type="submit"]:hover {
        background: #0056b3;
    }
    .error {
        color: red;
        margin-top: 10px;
    }
    .info {
        background: #e9ecef;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        margin-bottom: 20px;
        animation: slideIn 1s ease-out;
    }
    @keyframes fadeIn {
        from { opacity: 0; }
        to { opacity: 1; }
    }
    @keyframes slideIn {
        from { transform: translateX(-100%); }
        to { transform: translateX(0); }
    }
</style>
<script>
    function validateForm() {
        var email = document.getElementById('a5').value;
        var mobile = document.getElementById('a6').value;

        var emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        var mobilePattern = /^\d{10}$/;

        if (!emailPattern.test(email)) {
            document.getElementById('error-message').innerText = 'Please enter a valid email address.';
            return false;
        }

        if (!mobilePattern.test(mobile)) {
            document.getElementById('error-message').innerText = 'Mobile number must be exactly 10 digits.';
            return false;
        }

        return true;
    }
</script>
</head>
<body>
<header>
    <h1>Welcome to Your Dashboard</h1>
</header>
<div class="container">
    <a href="helpline.jsp" style="text-decoration: none; color: #007BFF;">Helpline Number</a> |
    <a href="viewinfostate1" style="text-decoration: none; color: #007BFF;">View State Information</a>
    
    <div class="info">
        <h2>COVID-19 Information</h2>
        <p><strong>Stay Informed:</strong> COVID-19 continues to impact communities around the world. Stay updated with the latest information and guidelines from health authorities.</p>
        <p><strong>Symptoms:</strong> Common symptoms include fever, cough, and shortness of breath. Seek medical advice if you experience these symptoms.</p>
        <p><strong>Prevention:</strong> Practice good hand hygiene, wear masks, and maintain physical distance to prevent the spread of the virus.</p>
    </div>
    
    <form id="updateForm" action="userupdate" method="post" onsubmit="return validateForm()">
        <h2>Update Your Information</h2>
        <label for="a1">User ID:</label>
        <input type="text" id="a1" name="userid" required>

        <label for="a2">Password:</label>
        <input type="password" id="a2" name="password" required>

        <label for="a3">Name:</label>
        <input type="text" id="a3" name="name" required>

        <label for="a4">Address:</label>
        <input type="text" id="a4" name="address" required>

        <label for="a5">Email:</label>
        <input type="email" id="a5" name="email" required>

        <label for="a6">Mobile No:</label>
        <input type="text" id="a6" name="mobile" pattern="\d{10}" maxlength="10" minlength="10" required title="Mobile number must be exactly 10 digits">

        <div id="error-message" class="error"></div>

        <input type="submit" value="Update Information">
    </form>
    
    <form id="searchForm" action="searchdata" method="post">
        <h2>Search State Information</h2>
        <label for="state">State:</label>
        <input type="text" id="state" name="state">
        <input type="submit" value="Search">
    </form>
</div>
<footer>
    <p>&copy; 2024 Your Website. All rights reserved.</p>
</footer>
</body>
</html>

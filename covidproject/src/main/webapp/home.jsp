<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f8ff;
            margin: 0;
            padding: 0;
            color: #333;
            background-image: url('https://cdn.who.int/media/images/default-source/mca/mca-covid-19/coronavirus-2.tmb-479v.jpg?sfvrsn=4dba955c_19%20479w');
            background-size: cover;
            background-position: center;
        }
        header {
            background-color: #4CAF50;
            color: white;
            padding: 10px 0;
            text-align: center;
        }
        marquee {
            font-size: 1.5em;
            color: #fff;
            background-color: #007BFF;
            padding: 10px;
        }
        .container {
            width: 50%;
            margin: 0 auto;
            padding: 20px;
            background-color: #ffffff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            margin-bottom: 60px; /* Ensure content does not overlap with footer */
        }
        form {
            display: flex;
            flex-direction: column;
        }
        label {
            margin-bottom: 5px;
            font-weight: bold;
        }
        input[type="text"], input[type="password"], select {
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ddd;
            border-radius: 4px;
            width: 100%;
            box-sizing: border-box;
        }
        input[type="submit"] {
            padding: 15px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 1em;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
        footer {
            position: fixed;
            bottom: 0;
            width: 100%;
            background-color: #4CAF50;
            color: white;
            text-align: center;
            padding: 10px 0;
        }
        footer a {
            color: white;
            text-decoration: none;
            font-weight: bold;
        }
        footer a:hover {
            text-decoration: underline;
        }
    </style>
    <script>
        function validateForm() {
            var userid = document.getElementById("a2").value;
            var password = document.getElementById("a3").value;
            var name = document.getElementById("a4").value;
            var users = document.getElementById("a6").value;

            if (userid === "" || password === "" || name === "" || users === "") {
                alert("All fields must be filled out.");
                return false;
            }

            return true;
        }
    </script>
</head>
<body>
    <header>
        <marquee>Welcome to Apna Site</marquee>
    </header>
  <div class="container">
        <form id="form" action="verifyusers1" method="get" onsubmit="return validateForm()">
            <label for="a2">User ID</label>
            <input type="text" id="a2" name="userid">

            <label for="a3">Password</label>
            <input type="password" id="a3" name="password">

            <label for="a4">Name</label>
            <input type="text" id="a4" name="name">

            <label for="a6">User Type</label>
            <select id="a6" name="users">
                <option value="SUPER-ADMIN">SUPER-ADMIN</option>
                <option value="STATE-ADMIN">STATE-ADMIN</option>
                <option value="USERS">USERS</option>
            </select>

            <input type="submit" value="submit">
        
          

          
        </form>
       <center><a href="registration.jsp">Registration Form</a></center>   
        </div>
    <footer>
        <marquee>Stay Home, Save Lives</marquee>
        <a href="https://www.who.int/emergencies/diseases/novel-coronavirus-2019/advice-for-public">stay corna,guidlines</a>
    </footer>
</body>
</html>



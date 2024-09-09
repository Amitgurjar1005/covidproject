<!DOCTYPE html>
<html>
<head>
    <title>Registration Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            color: #333;
            text-align: center;
        }

        marquee {
            font-size: 1.5em;
            color: #fff;
            background-color: #007BFF;
            padding: 10px;
            margin-bottom: 20px;
            display: block;
        }

        .container {
            width: 80%;
            max-width: 600px;
            margin: 20px auto;
            padding: 20px;
            background-color: #ffffff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        form {
            display: flex;
            flex-direction: column;
        }

        label {
            margin-bottom: 5px;
            font-weight: bold;
            text-align: left;
        }

        input[type="text"],
        input[type="password"],
        input[type="email"] {
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
            width: 100%;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }

        footer {
            margin-top: 20px;
            font-size: 0.9em;
            color: #555;
        }

        footer a {
            color: #007BFF;
            text-decoration: none;
            font-weight: bold;
        }

        footer a:hover {
            text-decoration: underline;
        }

        .error {
            color: red;
            font-size: 0.9em;
            margin-bottom: 15px;
        }
    </style>
</head>
<body>
    <marquee>Welcome to Apna Site</marquee>
    <div class="container">
        <form id="form" action="registerservlet" method="post" onsubmit="return validateForm()">
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

            <input type="submit" value="Register">
        </form>
    </div>
    <footer>
        <p>&copy; 2024 Your Company. <a href="#">Privacy Policy</a></p>
    </footer>

    <script>
        function validateForm() {
            var mobile = document.getElementById("a6").value;
            var errorMessage = document.getElementById("error-message");
            
            // Reset error message
            errorMessage.textContent = "";

            // Check if mobile number is exactly 10 digits
            if (!/^\d{10}$/.test(mobile)) {
                errorMessage.textContent = "Mobile number must be exactly 10 digits.";
                return false; // Prevent form submission
            }

            return true; // Allow form submission
        }
    </script>
</body>
</html>

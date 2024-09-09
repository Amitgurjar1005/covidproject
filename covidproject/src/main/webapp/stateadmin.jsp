<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>State Admin Registration Form</title>
    <link rel="stylesheet" type="text/css" href="styles.css" />
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            margin: 0;
            padding: 0;
        }
        .container {
            max-width: 800px;
            margin: 40px auto;
            padding: 20px;
            background-color: #ffffff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            text-align: center;
            color: #333;
        }
        form {
            display: flex;
            flex-direction: column;
        }
        label {
            margin: 10px 0 5px;
            font-weight: bold;
            color: #333;
        }
        input[type="text"],
        input[type="password"],
        input[type="email"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ddd;
            border-radius: 4px;
        }
        input[type="submit"] {
            background-color: #007BFF;
            color: #fff;
            padding: 10px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
        .info {
            background-color: #e7f1ff;
            padding: 15px;
            border-left: 5px solid #007BFF;
            margin-bottom: 20px;
        }
        .info h2 {
            margin-top: 0;
        }
        .info p {
            margin-bottom: 0;
        }
    </style>
</head>
<body>
    <div class="container">
        <marquee behavior="scroll" direction="left" style="color: #007BFF; font-size: 18px; font-weight: bold;">Welcome to our State Admin Portal</marquee>
        <h1>State Admin Registration Form</h1>

        <div class="info">
            <h2>Important Information</h2>
            <p>Please ensure that all the details provided are accurate. This information will be used for managing state-level COVID-19 data. If you face any issues, contact support at <a href="mailto:support@ourwebsite.com">support@ourwebsite.com</a>.</p>
        </div>

        <form id="form" action="stateadminservlet1" method="post">
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

            <input type="submit" value="Register">
        </form>
    </div>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Super Admin Dashboard</title>
<style>
    body {
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        margin: 0;
        padding: 0;
        background: linear-gradient(rgba(0, 0, 0, 0.5), rgba(0, 0, 0, 0.5)), 
                    url('https://cdn.who.int/media/images/default-source/mca/mca-covid-19/coronavirus-2.tmb-479v.jpg?sfvrsn=4dba955c_19%20479w') no-repeat center center fixed;
        background-size: cover;
    }
    h3 {
        color: #ffffff;
        font-family: 'Roboto', sans-serif;
        text-align: center;
    }
    .container {
        max-width: 800px;
        margin: 30px auto;
        padding: 20px;
        border: 1px solid #ddd;
        border-radius: 10px;
        background-color: rgba(255, 255, 255, 0.9); /* Semi-transparent white background */
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    }
    a {
        text-decoration: none;
        color: #1E90FF;
        margin-right: 15px;
        font-weight: bold;
        transition: color 0.3s ease, transform 0.3s ease;
    }
    a:hover {
        text-decoration: underline;
        color: #FF4500; /* Change color on hover */
        transform: scale(1.05); /* Slightly enlarge the link on hover */
    }
    .covid-info {
        margin-top: 20px;
        padding: 15px;
        border: 1px solid #ddd;
        border-radius: 10px;
        background-color: #ffffff;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    }
    ul {
        list-style-type: none;
        padding: 0;
    }
    ul li {
        margin-bottom: 10px;
    }
    ul li a {
        color: #1E90FF;
        font-weight: normal;
        transition: color 0.3s ease;
    }
    ul li a:hover {
        color: #FF4500;
    }
</style>
</head>
<body>
<div class="container">
    <h3>Welcome Super Admin</h3>
    <p>
        <a href="stateadmin.jsp">Create State Account</a>
        <a href="/">View State Accounts</a>
        <a href="/">View User Accounts</a>
       <a href="viewinfostate1">View Info for State</a>
        <a href="home.jsp">Logout</a>
    </p>

    <div class="covid-info">
        <h4>COVID-19 Information</h4>
        <p>Stay informed and follow safety guidelines to help prevent the spread of COVID-19.</p>
        <ul>
            <li><a href="https://www.who.int/health-topics/coronavirus" target="_blank" rel="noopener noreferrer">World Health Organization (WHO) - COVID-19 Information</a></li>
            <li><a href="https://www.cdc.gov/coronavirus/2019-ncov/index.html" target="_blank" rel="noopener noreferrer">Centers for Disease Control and Prevention (CDC) - COVID-19 Guidelines</a></li>
            <li><a href="https://www.jhu.edu/coronavirus" target="_blank" rel="noopener noreferrer">Johns Hopkins University - COVID-19 Dashboard</a></li>
        </ul>
        <p>For the latest updates and guidelines, please refer to these sources regularly.</p>
    </div>
</div>
</body>
</html>

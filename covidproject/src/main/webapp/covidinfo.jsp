<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration Form</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <header>
        <div class="marquee">
            <p>Welcome to Apna site</p>
        </div>
    </header>
    <main>
        <section class="form-container">
            <form id="form" action="covidinfoservlet1" method="post">
                <h1>DATA ENTRY FORM</h1>
                <div class="form-group">
                    <label for="userid">User ID:</label>
                    <input type="text" id="userid" name="userid" required>
                </div>
                <div class="form-group">
                    <label for="state">State:</label>
                    <input type="text" id="state" name="state" required>
                </div>
                <div class="form-group">
                    <label for="total">Total Cases:</label>
                    <input type="number" id="total" name="total" required>
                </div>
                <div class="form-group">
                    <label for="cases">Active Cases:</label>
                    <input type="number" id="cases" name="cases" required>
                </div>
                <div class="form-group">
                    <label for="deathes">Total Deaths:</label>
                    <input type="number" id="deathes" name="deathes" required>
                </div>
                <div class="form-group">
                    <label for="statecode">State Code:</label>
                    <input type="text" id="statecode" name="statecode" required>
                </div>
                <button type="submit" class="submit-button">Submit</button>
            </form>
        </section>
    </main>
</body>
</html>

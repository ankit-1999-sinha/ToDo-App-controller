<html>
	<head>
		<title> Login Page</title>
	</head>
	<body>

	    <div class="container">
            <h1> Login </h1>

                Welcome to the login page ${name}!
                <pre>${errorMessage}</pre>
                <form method="post">
                Name: <input type="text" name="name">
                Password: <input type="password" name="password">
                <input type="submit" value="Submit">
                </form>

		 </div>
	</body>
</html>
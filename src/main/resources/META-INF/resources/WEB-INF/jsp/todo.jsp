<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
	<head>
	<link rel="stylesheet" type="text/css" href="webjars\bootstrap\5.3.0\css\bootstrap.min.css">
		<title> Add TODOs Page </title>
	</head>
	<body>
	<div class="container">
        <h1> Enter Todo Details </h1>
        <form method = "post">
            Description: <input type="text" name="description" required="required"/>
            <input type = "submit" value = "Submit" class = "btn btn-success" />
        </div>
        <script src="webjars\bootstrap\5.3.0\js\bootstrap.min.js"></script>
        <script src="webjars\jquery\3.6.0\jquery.min.js"></script>
	</body>
</html>
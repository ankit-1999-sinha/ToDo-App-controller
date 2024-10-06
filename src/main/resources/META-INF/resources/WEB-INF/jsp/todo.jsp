<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
	<head>
	<link rel="stylesheet" type="text/css" href="webjars\bootstrap\5.3.0\css\bootstrap.min.css">
		<title> Add TODOs Page </title>
	</head>
	<body>
	<div class="container">
        <h1> Enter Todo Details </h1>
        <form:form method = "post" modelAttribute="toDo">
            Description: <form:input type="text"  path="description" required="required"/>
                          <form:errors   path="description" cssClass="text-warning" />
                          <form:input type="hidden"  path="id"/>
                           <form:input type="hidden"  path="isDone"/>

            <input type = "submit" value = "Submit" class = "btn btn-success" />
            </form:form>
        </div>
        <script src="webjars\bootstrap\5.3.0\js\bootstrap.min.js"></script>
        <script src="webjars\jquery\3.6.0\jquery.min.js"></script>
	</body>
</html>
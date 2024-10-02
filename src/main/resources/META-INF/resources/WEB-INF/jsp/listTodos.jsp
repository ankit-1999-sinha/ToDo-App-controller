<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
	<head>
	<link rel="stylesheet" type="text/css" href="webjars\bootstrap\5.3.0\css\bootstrap.min.css">
		<title> List TODOs </title>
	</head>
	<body>
	<div class="container">
        <h1> Your ToDos </h1>
            <table class="table">
                <thead>
                      <tr>
                        <th>id</th>
                        <th>description</th>
                        <th>target date</th>
                        <th>is done?</th>
                        <th></th>
                        <th></th>
                        </tr>
                </thead>
                <tbody>
                    <c:forEach items="${todos}" var="todo">
                    <tr>
                                        <td>${todo.id}</th>
                                        <td>${todo.description}</th>
                                        <td>${todo.targetDate}</th>
                                        <td>${todo.done}</th>
                                        <td> <a href="delete-todo?id=${todo.id}" class="btn btn-warning">DELETE </a></th>
                                        <td> <a href="update-todo?id=${todo.id}" class="btn btn-success">UPDATE </a></th>

                    </tr>
                    </c:forEach>
                </tbody>
            </table>
            <a href="add-todo" class = "btn btn-success">Add ToDos</a>
        </div>
        <script src="webjars\bootstrap\5.3.0\js\bootstrap.min.js"></script>
        <script src="webjars\jquery\3.6.0\jquery.min.js"></script>
	</body>
</html>
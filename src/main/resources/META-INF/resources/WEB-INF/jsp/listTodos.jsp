       <%@ include file = "common/header.jspf" %>
	   <%@ include file = "common/navigation.jspf" %>

	<div class="container">
        <h1> Your ToDos </h1>
            <table class="table">
                <thead>
                      <tr>
                        <th>Description</th>
                        <th>Target Date</th>
                        <th>Is done?</th>
                        <th>DELETE</th>
                        <th>UPDATE</th>
                        </tr>
                </thead>
                <tbody>
                    <c:forEach items="${todos}" var="todo">
                    <tr>
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
     <%@ include file = "common/footer.jspf" %>
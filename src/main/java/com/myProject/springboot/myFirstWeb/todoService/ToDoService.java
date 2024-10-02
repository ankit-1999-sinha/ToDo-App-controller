package com.myProject.springboot.myFirstWeb.todoService;

import com.myProject.springboot.myFirstWeb.todo.ToDo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ToDoService {

    private static List<ToDo> todos = new ArrayList<>();

    private static  int todoCount = 0;
    static {
        todos.add(new ToDo(++todoCount, "ankit", "Learn Spring MVC", LocalDate.now().plusDays(1), false));
        todos.add(new ToDo(++todoCount, "ankit", "Learn Struts", LocalDate.now().plusDays(2), false));
        todos.add(new ToDo(++todoCount, "ankit", "Learn Hibernate", LocalDate.now().plusDays(3), false));
    }

    public List<ToDo> retrieveTodosByName(String userName) {
        List<ToDo> filteredTodos = new ArrayList<ToDo>();
        for (ToDo todo : todos) {
            if (todo.getUserName().equals(userName)) {
                filteredTodos.add(todo);
            }
        }
        return filteredTodos;
    }

    public void addNewTodo(String username, String description, LocalDate targetDate, boolean isDone) {
        todos.add(new ToDo(++todoCount, username, description, targetDate, isDone));
    }
}

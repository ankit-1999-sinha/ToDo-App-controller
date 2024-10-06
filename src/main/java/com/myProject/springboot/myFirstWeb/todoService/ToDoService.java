package com.myProject.springboot.myFirstWeb.todoService;

import com.myProject.springboot.myFirstWeb.todo.ToDo;
import com.myProject.springboot.myFirstWeb.todoController.ToDoController;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.logging.Logger;

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

    public void deleteByID(int id){
        Predicate<? super ToDo> predicate = toDo -> toDo.getId() == id;
        todos.removeIf(predicate);
        Logger logger = Logger.getLogger(ToDoService.class.getName());
        logger.info("Predicate is : "+ predicate);
    }

    public ToDo findById(int id) {
        Predicate<? super ToDo> predicate = toDo -> toDo.getId() == id;
        ToDo todo =  todos.stream().filter(predicate).findFirst().get();
        return  todo;
    }

    public void updateTodo(@Valid ToDo todo) {
        deleteByID(todo.getId());
        todos.add(todo);
    }
}

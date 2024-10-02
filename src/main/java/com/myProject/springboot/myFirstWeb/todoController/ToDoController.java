package com.myProject.springboot.myFirstWeb.todoController;

import com.myProject.springboot.myFirstWeb.todo.ToDo;
import com.myProject.springboot.myFirstWeb.todoService.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;


@Controller
@SessionAttributes("name")
public class ToDoController {


    private ToDoService toDoService ;


    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @RequestMapping("lists-todos")
    public String showAllToDos(ModelMap modelMap) {
       List<ToDo> todos =  toDoService.retrieveTodosByName("ankit");
       modelMap.addAttribute("todos", todos); // (key, value ) pair
        return "listTodos";
    }

    @RequestMapping(value = "add-todo",method = RequestMethod.GET)
    public String showTodoPage(ModelMap modelMap) {
        return "todo";
    }

    @RequestMapping(value = "add-todo",method = RequestMethod.POST)
    public String addNewTodoPage(@RequestParam String description,ModelMap modelMap) {
        String userName = modelMap.get("name").toString();
        Logger logger = Logger.getLogger(ToDoController.class.getName());
        logger.info("userName is : "+userName);
        toDoService.addNewTodo(userName,description, LocalDate.now().plusYears(1),false);
        return "redirect:/lists-todos";

    }
}

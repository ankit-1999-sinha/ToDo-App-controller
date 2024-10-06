package com.myProject.springboot.myFirstWeb.todoController;

import com.myProject.springboot.myFirstWeb.todo.ToDo;
import com.myProject.springboot.myFirstWeb.todoService.ToDoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
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
        modelMap.addAttribute("todos", todos);
        return "listTodos";
    }

    @RequestMapping(value = "add-todo",method = RequestMethod.GET)
    public String showTodoPage(ModelMap modelMap) {
        String userName = modelMap.get("name").toString();
        ToDo toDo = new ToDo(0,userName,"",LocalDate.now().plusYears(1),  false);
        modelMap.put("toDo",toDo); // (key, value) pair
        return "todo";
    }

    @RequestMapping(value = "add-todo",method = RequestMethod.POST)
    public String addNewTodoPage(ModelMap modelMap, @Valid ToDo toDo, BindingResult result) {
        if(result.hasErrors()) {
            return "todo";
        }
        String userName = modelMap.get("name").toString();
        Logger logger = Logger.getLogger(ToDoController.class.getName());
        logger.info("userName is : "+userName);
        toDoService.addNewTodo(userName,toDo.getDescription(), LocalDate.now().plusYears(1),false);
        return "redirect:/lists-todos";

    }

    @RequestMapping("delete-todo")
    public String deleteToDo(@RequestParam int id) {
        toDoService.deleteByID(id);
        return "redirect:/lists-todos";
    }

    @RequestMapping(value = "update-todo", method = RequestMethod.GET)
    public String showUpdateToDoPage(@RequestParam int id,ModelMap model) {
        ToDo todo = toDoService.findById(id);
        model.addAttribute("toDo",todo);
        return "todo";
    }

    @RequestMapping(value = "update-todo",method = RequestMethod.POST)
    public String updateNewTodoPage(ModelMap modelMap, @Valid ToDo todo, BindingResult result) {

        if(result.hasErrors()){
            return "todo";
        }

        String userName = modelMap.get("name").toString();
        Logger logger = Logger.getLogger(ToDoController.class.getName());
        logger.info(" userName is : " + userName);
        todo.setUserName(userName);
        toDoService.updateTodo(todo);
        return "redirect:/lists-todos";
    }
}

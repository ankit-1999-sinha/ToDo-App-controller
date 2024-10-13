package com.myProject.springboot.myFirstWeb.todoController;

import com.myProject.springboot.myFirstWeb.Repository.TodoRepository;
import com.myProject.springboot.myFirstWeb.todo.ToDo;
import com.myProject.springboot.myFirstWeb.todoService.ToDoService;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
public class ToDoControllerJPA {



    private TodoRepository todoRepository;


    public ToDoControllerJPA(TodoRepository todoRepository) {
        super();
        this.todoRepository=todoRepository;
    }

    @RequestMapping("lists-todos")
    public String showAllToDos(ModelMap modelMap) {
        String username = getLoggedInUsername(modelMap);
        List<ToDo> todos = todoRepository.findByuserName(username);
        modelMap.addAttribute("todos", todos);
        return "listTodos";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.GET)
    public String showTodoPage(ModelMap modelMap) {
        String username = getLoggedInUsername(modelMap);
        ToDo toDo = new ToDo(0, username, "", LocalDate.now().plusYears(1), false);
        modelMap.put("toDo", toDo); // (key, value) pair
        return "todo";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.POST)
    public String addNewTodoPage(ModelMap modelMap, @Valid ToDo toDo, BindingResult result) {
        if (result.hasErrors()) {
            return "todo";
        }
        String userName = getLoggedInUsername(modelMap);
        toDo.setUserName(userName);
        Logger logger = Logger.getLogger(ToDoControllerJPA.class.getName());
        logger.info("userName is : " + userName);
        todoRepository.save(toDo);
        return "redirect:/lists-todos";

    }

    @RequestMapping("delete-todo")
    public String deleteToDo(@RequestParam int id) {
        todoRepository.deleteById(id);
        return "redirect:/lists-todos";
    }

    @RequestMapping(value = "update-todo", method = RequestMethod.GET)
    public String showUpdateToDoPage(@RequestParam int id, ModelMap model) {
        ToDo todo = todoRepository.findById(id).get();
        model.addAttribute("toDo", todo);
        return "todo";
    }

    @RequestMapping(value = "update-todo", method = RequestMethod.POST)
    public String updateNewTodoPage(ModelMap modelMap, @Valid ToDo todo, BindingResult result) {

        if (result.hasErrors()) {
            return "todo";
        }

        String userName = getLoggedInUsername(modelMap);
        Logger logger = Logger.getLogger(ToDoControllerJPA.class.getName());
        logger.info(" userName is : " + userName);
        todo.setUserName(userName);
        todoRepository.save(todo);
        return "redirect:/lists-todos";
    }

    private String getLoggedInUsername(ModelMap modelMap){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        return authentication.getName();

    }
}

package com.myProject.springboot.myFirstWeb.login;


import com.myProject.springboot.myFirstWeb.Authentication.AuthenticationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LogInController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private AuthenticationService authenticationService = new AuthenticationService();

    // Query parameters
    // http://localhost:8080/login?name=ankit
    //  to pass name from user to our jsp we use model map
    @RequestMapping("loginWithQueryParam")
    public String goToLoginPage(@RequestParam String name, ModelMap modelMap) {
        modelMap.put("name", name); // (key, value ) pair
        System.out.println("name is: " + name); // not recommended for production code
        logger.debug("Request param at Debug Level is {} " + name);
        logger.info("Request param  at Info Level is {} " + name);
        return "login";
    }

    // only for get request we want to use this method
    @RequestMapping(value= "login",method = RequestMethod.GET)
    public String goToLoginPageWithoutQueryParam() {
        return "login";
    }

    @RequestMapping(value= "login",method = RequestMethod.POST)
    public String goToWelcomepage(@RequestParam String name, @RequestParam String password, ModelMap modelMap) {
        modelMap.put("name", name);

        // Authentication logic
        if(authenticationService.authenticate(name, password)) {
            return "welcome";
        }

        modelMap.put("errorMessage", "Invalid Credentials!!");

        return "login";
    }
}

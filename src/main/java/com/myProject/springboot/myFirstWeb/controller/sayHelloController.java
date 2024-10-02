package com.myProject.springboot.myFirstWeb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class sayHelloController {


    // src/main/resources/META-INF/resources/WEB-INF/jsp
    @RequestMapping("say-hello-jsp")
    public String sayHelloJsp() {
        return "sayHello";
    }

    // we are sending a request to say-hello-jsp
    // this request is being handled by sayHelloController
    // sayHellojsp method is mapped to this URL
    // this method is handling the request and returning back the name of the jsp file
    // spring mvc is making use of view resolver to resolve the view
    // we are configuring the view resolver in the application.properties file
    // we are configuring the prefix and suffix of the view resolver

}

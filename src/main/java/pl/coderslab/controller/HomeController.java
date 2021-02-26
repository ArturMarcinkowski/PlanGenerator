package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.model.Student;
import pl.coderslab.respository.StudentRepository;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String hello(){
        return "hello";
    }

}

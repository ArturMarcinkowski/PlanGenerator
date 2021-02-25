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

    @GetMapping("/admin/hello")
    @ResponseBody
    public String about() { return "Here you can find some details for logged users"; }

    @RequestMapping("/index")
    public String index(){
        return "utilities/index2";
    }



}

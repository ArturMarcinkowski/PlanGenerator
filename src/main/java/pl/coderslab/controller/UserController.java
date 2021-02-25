package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.model.Student;
import pl.coderslab.model.Teacher;
import pl.coderslab.model.User;
import pl.coderslab.respository.StudentRepository;
import pl.coderslab.respository.TeacherRepository;
import pl.coderslab.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller("/user")
public class UserController {

    private final UserService userService;
    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;

    public UserController(UserService userService, StudentRepository studentRepository, TeacherRepository teacherRepository) {
        this.userService = userService;
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
    }

    @GetMapping("/create-user")
    @ResponseBody
    public String createUser() {
        User user = new User();
        user.setUsername("admin3");
        user.setPassword("admin3");
        userService.saveUser(user);
        return "admin";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showForm(Model model) {
//        List<Student> students = studentRepository.findAll();
//        for(Student student:students){
//            if(student.getUser() != null)
//                students.remove(student);
//        }
//        model.addAttribute("students", students);
//        List<Teacher> teachers = teacherRepository.findAll();
//        for(Teacher teacher:teachers){
//            if(teacher.getUser() != null)
//                teachers.remove(teacher);
//        }
        model.addAttribute("user", new User());
        return "user/form";
    }

}

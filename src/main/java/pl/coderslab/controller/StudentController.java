package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Grade;
import pl.coderslab.model.Student;
import pl.coderslab.model.Teacher;
import pl.coderslab.model.User;
import pl.coderslab.respository.GradeRepository;
import pl.coderslab.respository.StudentRepository;
import pl.coderslab.respository.TeacherRepository;
import pl.coderslab.respository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/student")
public class StudentController {
    public final StudentRepository studentRepository;
    public final GradeRepository gradeRepository;
    public final TeacherRepository teacherRepository;
    public final UserRepository userRepository;

    public StudentController(StudentRepository studentRepository, GradeRepository gradeRepository, TeacherRepository teacherRepository, UserRepository userRepository) {
        this.studentRepository = studentRepository;
        this.gradeRepository = gradeRepository;
        this.teacherRepository = teacherRepository;
        this.userRepository = userRepository;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showForm(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("grades", gradeRepository.findAll());
        List<User> users = userRepository.findAllByStudentIsNullAndTeacherIsNull();
        model.addAttribute("users", users);
        return "student/form";
    }


    @PostMapping("/add")
    public String addStudent(@Valid Student student, BindingResult result){
        if (result.hasErrors()) {
            return "student/form";
        }
        saveStudent(student);
        return "redirect:/student/list";

    }

    @GetMapping("/list")
    public String studentList(Model model) {
        model.addAttribute("students", studentRepository.findAll());
        return "student/list";
    }


    @GetMapping("/delete")
    public String deleteStudent(@RequestParam int id){
        studentRepository.deleteById(id);
        return "redirect:/student/list";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String showEditForm(@RequestParam int id, Model model) {
        model.addAttribute("student", studentRepository.findById(id));
        model.addAttribute("grades", gradeRepository.findAll());
        List<User> users = userRepository.findAllByStudentIsNullAndTeacherIsNull();
        Optional<User> currentUser = userRepository.findByStudentId(id);
        if(currentUser.isPresent()){
            users.add(currentUser.get());
        }
        model.addAttribute("users", users);
        return "student/form";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String saveEditForm(@Valid Student student, BindingResult result) {
        if (result.hasErrors()) {
            return "student/form";
        }
        saveStudent(student);
        return "redirect:/student/list";
    }

    public void saveStudent(Student student){
        studentRepository.save(student);
        if(student.getUser() != null){
            List<User> users = userRepository.findAllByStudent(student);
            for(User user:users){
                user.setStudent(null);
                List<Teacher> teachers = teacherRepository.findAllByUserId(user.getId());
                for(Teacher teacher:teachers){
                    teacher.setUser(null);
                    teacherRepository.save(teacher);
                }
                studentRepository.save(student);
            }
            User user = userRepository.findById(student.getUser().getId()).get();
            user.setStudent(student);
            userRepository.save(user);
        }
        else {
            List<User> users = userRepository.findAllByStudentId(student.getId());
            for(User user:users){
                user.setStudent(null);
                userRepository.save(user);
            }
        }
    }



}

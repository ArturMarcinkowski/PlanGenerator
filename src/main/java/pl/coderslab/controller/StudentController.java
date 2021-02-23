package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Grade;
import pl.coderslab.model.Student;
import pl.coderslab.model.Teacher;
import pl.coderslab.respository.GradeRepository;
import pl.coderslab.respository.StudentRepository;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/student")
public class StudentController {
    public final StudentRepository studentRepository;
    public final GradeRepository gradeRepository;

    public StudentController(StudentRepository studentRepository, GradeRepository gradeRepository) {
        this.studentRepository = studentRepository;
        this.gradeRepository = gradeRepository;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showForm(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("grades", gradeRepository.findAll());
        return "student/form";
    }

    @PostMapping("/add")
    public String addStudent(@Valid Student student, BindingResult result){
        if (result.hasErrors()) {
            return "student/form";
        }
        studentRepository.save(student);
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
        return "student/form";
    }


    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String saveEditForm(@Valid Student student, BindingResult result) {
        if (result.hasErrors()) {
            return "student/form";
        }
        studentRepository.save(student);
        return "redirect:/student/list";
    }



}

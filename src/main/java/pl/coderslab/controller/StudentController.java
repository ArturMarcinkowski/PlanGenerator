package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Grade;
import pl.coderslab.model.Student;
import pl.coderslab.respository.GradeRepository;
import pl.coderslab.respository.StudentRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    public final StudentRepository studentRepository;
    public final GradeRepository gradeRepository;

    public StudentController(StudentRepository studentRepository, GradeRepository gradeRepository) {
        this.studentRepository = studentRepository;
        this.gradeRepository = gradeRepository;
    }

    @GetMapping("/add")
    public String studentAdd(HttpServletRequest request) {
        List<Grade> list = gradeRepository.findAll();
        request.setAttribute("grades", list);
        return "student/add";
    }

    @ResponseBody
    @PostMapping("/add")
    public String addStudent(@RequestParam String name, @RequestParam String surname, @RequestParam int gradeId){
        Student student = new Student();
        student.setName(name);
        student.setSurname(surname);
        student.setGrade(gradeRepository.findById(gradeId));
        studentRepository.save(student);
        return "added";

    }

    @GetMapping("/list")
    public String studentList(HttpServletRequest request) {
        List<Student> list = studentRepository.findAll();
        request.setAttribute("students", list);
        return "student/list";
    }


}

package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Grade;
import pl.coderslab.model.Student;
import pl.coderslab.respository.GradeRepository;
import pl.coderslab.respository.StudentRepository;

import javax.servlet.http.HttpServletRequest;
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

    @ResponseBody
    @GetMapping("/delete")
    public String deleteStudent(@RequestParam int id){
        studentRepository.deleteById(id);
        return "deleted";

    }


    @GetMapping("/edit")
    public String editStudent(@RequestParam int id, HttpServletRequest request){

        Optional<Student> student = studentRepository.findById(id);
        List<Grade> list = gradeRepository.findAll();
        request.setAttribute("grades", list);
        if(student.isPresent()) {
            request.setAttribute("student", student.get());
            return "student/edit";
        }
        else
            return "student/list";
    }


    @ResponseBody
    @PostMapping("/edit")
    public String studentEdit(@RequestParam String name, @RequestParam String surname, @RequestParam int gradeId, @RequestParam int studentId){
        Optional <Student> optionalStudent = studentRepository.findById(studentId);
        if(optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            student.setName(name);
            student.setSurname(surname);
            student.setGrade(gradeRepository.findById(gradeId));
            studentRepository.save(student);
            return "updated";
        }
        else
            return "student not found";
    }


}

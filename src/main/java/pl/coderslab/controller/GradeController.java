package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Grade;
import pl.coderslab.model.Student;
import pl.coderslab.model.Subject;
import pl.coderslab.model.Teacher;
import pl.coderslab.respository.GSTRepository;
import pl.coderslab.respository.GradeRepository;
import pl.coderslab.respository.StudentRepository;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
@RequestMapping("/grade")
public class GradeController {
    public final GradeRepository gradeRepository;
    public final StudentRepository studentRepository;
    public final GSTRepository gstRepository;


    public GradeController(GradeRepository gradeRepository, StudentRepository studentRepository, GSTRepository gstRepository) {
        this.gradeRepository = gradeRepository;
        this.studentRepository = studentRepository;
        this.gstRepository = gstRepository;
    }

    @GetMapping("/{id}/list")
    public String gradeDetails(@PathVariable int id, Model model){
        Grade grade = gradeRepository.findById(id);
        model.addAttribute("grade", grade);
        model.addAttribute("gsts", gstRepository.findAllByGrade(grade));
        model.addAttribute("students", studentRepository.findAllByGrade(grade));
        return "grade/list";
    }

    @GetMapping("/{id}/removeStudent")
    public String removeStudent(@PathVariable int id, @RequestParam int studentId, Model model){
        Student student = studentRepository.findById(studentId).get();
        student.setGrade(null);
        studentRepository.save(student);
        return "redirect:/grade/"+id;
    }

    @GetMapping("/{id}/add")
    public String addStudent(@PathVariable int id, Model model){
        model.addAttribute("gradeId", id);
//        model.addAttribute("students", studentRepository.findAllByGradeIdIsNot(id));
//        model.addAttribute("freeStudents", studentRepository.findAllByGradeIsNull());
        model.addAttribute("students", studentRepository.findAllByGradeIdIsNot(id));
        return "grade/addstudents";
    }

    @PostMapping("/{id}/add")
    public String studentAdd(@PathVariable int id, Model model, @RequestParam(name = "studentsId[]") int studentsId[]){
        Grade grade = gradeRepository.findById(id);
        for(int studentId:studentsId){
            Student student = studentRepository.findById(studentId).get();
            student.setGrade(grade);
            studentRepository.save(student);
        }
        model.addAttribute("grade", grade);
        model.addAttribute("students", studentRepository.findAllByGrade(grade));
        return "grade/list";
    }




}

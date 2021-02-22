package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Grade;
import pl.coderslab.model.Student;
import pl.coderslab.model.Subject;
import pl.coderslab.model.Teacher;
import pl.coderslab.respository.GradeRepository;
import pl.coderslab.respository.StudentRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
@RequestMapping("/grade")
public class GradeController {
    public final GradeRepository gradeRepository;
    public final StudentRepository studentRepository;

    public GradeController(GradeRepository gradeRepository, StudentRepository studentRepository) {
        this.gradeRepository = gradeRepository;
        this.studentRepository = studentRepository;
    }

    @GetMapping("/add")
    public String gradeAdd(){
        return "grade/add";
    }

    @PostMapping("/add")
    @ResponseBody
    public String addGrade(@RequestParam String name) {
        Grade grade = new Grade();
        grade.setName(name);
        gradeRepository.save(grade);
        return "added";
    }

    @GetMapping("/list")
    public String gradeList(HttpServletRequest request) {
        List<Grade> list = gradeRepository.findAll();
        request.setAttribute("grades", list);
        return "grade/list";
    }

    @ResponseBody
    @GetMapping("/delete")
    public String deleteGrade(@RequestParam int id){
        gradeRepository.deleteById(id);
        return "deleted";

    }

    @GetMapping("/edit")
    public String editGrade(@RequestParam int id, HttpServletRequest request){

        Grade grade = gradeRepository.findById(id);
        List<Student> list = studentRepository.findAll();
        request.setAttribute("students", list);
        request.setAttribute("grade", grade);
        return "grade/edit";

    }


    @ResponseBody
    @PostMapping("/edit")
    public String gradeEdit(@RequestParam String name, @RequestParam int gradeId, @RequestParam(value="studentsId[]") int[] studentsId){
        Grade grade = gradeRepository.findById(gradeId);
        grade.setName(name);
        gradeRepository.save(grade);
        for(int studentId:studentsId){
            Student student = studentRepository.findById(studentId).get();
            student.setGrade(grade);
            studentRepository.save(student);
        }
        return "updated";
    }

    @GetMapping("/details")
    public String gradeDetails(@RequestParam int id,  HttpServletRequest request){
        Grade grade = gradeRepository.findById(id);
        request.setAttribute("grade", grade);
        List<Student> students = studentRepository.findAllByGrade(grade);
        request.setAttribute("students", students);
        return "grade/details";

    }





}

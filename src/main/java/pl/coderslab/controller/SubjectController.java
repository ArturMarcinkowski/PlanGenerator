package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Grade;
import pl.coderslab.model.Student;
import pl.coderslab.model.Subject;
import pl.coderslab.model.Teacher;
import pl.coderslab.respository.SubjectRepository;
import pl.coderslab.respository.TeacherRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/subject")
public class SubjectController {
    public final SubjectRepository subjectRepository;
    public final TeacherRepository teacherRepository;

    public SubjectController(SubjectRepository subjectRepository, TeacherRepository teacherRepository) {
        this.subjectRepository = subjectRepository;
        this.teacherRepository = teacherRepository;
    }

    @GetMapping("/add")
    public String subjectAdd() {
        return "subject/add";
    }


    @ResponseBody
    @PostMapping("/add")
    public String addSubject(@RequestParam String name){
        Subject subject = new Subject();
        subject.setName(name);



        subjectRepository.save(subject);
        return "added";

    }

    @GetMapping("/list")
    public String subjectList(HttpServletRequest request){
        List<Subject> list = subjectRepository.findAll();
        request.setAttribute("subjects", list);
        return "subject/list";
    }

    @GetMapping("/edit")
    public String editSubject(@RequestParam int id, HttpServletRequest request){

        Optional<Subject> subject = subjectRepository.findById(id);
        if(subject.isPresent()) {
            request.setAttribute("subject", subject.get());
            return "subject/edit";
        }
        else
            return "subject/list";
    }

    @ResponseBody
    @PostMapping("/edit")
    public String subjectEdit(@RequestParam String name, @RequestParam int id){
        Optional<Subject> optionalSubject = subjectRepository.findById(id);
        if(optionalSubject.isPresent()) {
            Subject subject = optionalSubject.get();
            subject.setName(name);
            subjectRepository.save(subject);
            return "updated";
        }
        else
            return "subject not found";
    }

    @ResponseBody
    @GetMapping("/delete")
    public String deleteSubject(@RequestParam int id){
        subjectRepository.deleteById(id);
        return "deleted";

    }

    @GetMapping("/details")
    public String detailsSubject(@RequestParam int id,  HttpServletRequest request){
        Optional<Subject> optionalSubject = subjectRepository.findById(id);
        if(optionalSubject.isPresent()){
            Subject subject = optionalSubject.get();
            List<Teacher> list = teacherRepository.findTeachersBySubject(subject);
            request.setAttribute("subject", subject);
            request.setAttribute("teachers", list);
            return "subject/details";
        }
        return "subject/list";

    }







}

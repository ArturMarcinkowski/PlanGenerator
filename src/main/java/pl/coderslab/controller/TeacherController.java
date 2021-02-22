package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Grade;
import pl.coderslab.model.Student;
import pl.coderslab.model.Subject;
import pl.coderslab.model.Teacher;
import pl.coderslab.respository.SubjectRepository;
import pl.coderslab.respository.TeacherRepository;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.*;

@Controller
@RequestMapping("/teacher")
public class TeacherController {



    public final TeacherRepository teacherRepository;
    public final SubjectRepository subjectRepository;

    public TeacherController(TeacherRepository teacherRepository, SubjectRepository subjectRepository) {
        this.teacherRepository = teacherRepository;
        this.subjectRepository = subjectRepository;
    }

//    @GetMapping("/add")
//    public String teacherAdd(HttpServletRequest request) {
//        return "teacher/add";
//    }
//
//    @ResponseBody
//    @PostMapping("/add")
//    public String addTeacher(@RequestParam String name, @RequestParam String surname){
//        Teacher teacher = new Teacher();
//        teacher.setName(name);
//        teacher.setSurname(surname);
//        teacherRepository.save(teacher);
//        return "added";
//    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showForm(Model model) {
        model.addAttribute("teacher", new Teacher());
        return "teacher/form";
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveProposition(@Valid Teacher teacher, BindingResult result) {
        if (result.hasErrors()) {
            return "teacher/form";
        }
        teacherRepository.save(teacher);
        return "redirect:/teacher/list";
    }





    @GetMapping("/list")
    public String teacherList(HttpServletRequest request) {
        List<Teacher> list = teacherRepository.findAll();
        request.setAttribute("teachers", list);
        return "teacher/list";
    }

    @GetMapping("/edit")
    public String editTeacher(@RequestParam int id, HttpServletRequest request){

        Optional<Teacher> teacher = teacherRepository.findById(id);
        if(teacher.isPresent()) {
            request.setAttribute("teacher", teacher.get());
            List<Subject> list = subjectRepository.findSubjectByTeacher(teacher.get());
            request.setAttribute("subjects", list);
            List<Subject> allSubjects = subjectRepository.findAll();
            request.setAttribute("allSubjects", allSubjects);
            return "teacher/edit";
        }
        else
            return "teacher/list";
    }


    @ResponseBody
    @PostMapping("/edit")
    public String teacherEdit(@RequestParam String name, @RequestParam String surname, @RequestParam int id, @RequestParam(value="subjectsId[]") int[] subjectsId){
        Optional<Teacher> optionalTeacher = teacherRepository.findById(id);
        if(optionalTeacher.isPresent()) {
            Teacher teacher = optionalTeacher.get();
            teacher.setId(id);
            teacher.setName(name);
            teacher.setSurname(surname);
//            List<Subject> subjects = new ArrayList<>();
            Set<Subject> subjects = new HashSet<>();
            for(int subjectId:subjectsId)
                subjects.add(subjectRepository.findById(subjectId).get());
//            Set<Subject> subjectSet = new HashSet<>();
//            CollectionUtils.addAll(subjectSet, subjects);
//            return subjectRepository.findById(1).get().getName();
//            Set<Subject> targetSet = new HashSet<>(subjects);
//            teacher.setSubject(subjects);
            teacherRepository.save(teacher);
            return "done";
        }
        else
            return "teacher not found";
    }

    @ResponseBody
    @GetMapping("/delete")
    public String deleteTeacher(@RequestParam int id){
       teacherRepository.deleteById(id);
        return "deleted";

    }

    @GetMapping("/details")
    public String detailsTeacher(@RequestParam int id,  HttpServletRequest request){
        Optional<Teacher> optionalTeacher = teacherRepository.findById(id);
        if(optionalTeacher.isPresent()){
            Teacher teacher = optionalTeacher.get();
            List<Subject> list = subjectRepository.findSubjectByTeacher(teacher);
            request.setAttribute("subjects", list);
            request.setAttribute("teacher", teacher);
            return "teacher/details";
        }
        return "teacher/list";

    }




}

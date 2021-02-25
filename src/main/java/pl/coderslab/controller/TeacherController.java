package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.*;
import pl.coderslab.respository.GSTRepository;
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
    public final GSTRepository gstRepository;

    public TeacherController(TeacherRepository teacherRepository, SubjectRepository subjectRepository, GSTRepository gstRepository) {
        this.teacherRepository = teacherRepository;
        this.subjectRepository = subjectRepository;
        this.gstRepository = gstRepository;
    }

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

    @RequestMapping("/list")
    public String getAll(Model model) {
        model.addAttribute("teachers", teacherRepository.findAll());
        return "teacher/list";
    }


    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String showEditForm(@RequestParam int id, Model model) {
        Optional<Teacher> optionalTeacher = teacherRepository.findById(id);
        if(optionalTeacher.isPresent()) {
            Teacher teacher = optionalTeacher.get();
            model.addAttribute("teacher", teacher);
            return "teacher/form";
        }
        return "teacher/list";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String saveEditForm(@Valid Teacher teacher, BindingResult result) {
        if (result.hasErrors()) {
            return "teacher/form";
        }
        teacherRepository.save(teacher);
        return "redirect:/teacher/list";
    }

    @GetMapping("/delete")
    public String deleteTeacher(@RequestParam int id){
       teacherRepository.deleteById(id);
        return "redirect:/teacher/list";

    }

    @GetMapping("/details")
    public String details(Model model, @RequestParam int id) {
        model.addAttribute("teacher", teacherRepository.findById(id).get());
        List<GradeSubjectTeacher> gsts =  gstRepository.findAllByTeacherId(id);
        List<Subject> subjects = new ArrayList<>();
        List<Grade> grades = new ArrayList<>();
        for(GradeSubjectTeacher gst:gsts){
            if(!subjects.contains(gst.getSubject())){
                subjects.add(gst.getSubject());
            }
            if(!grades.contains(gst.getGrade())){
                grades.add(gst.getGrade());
            }
        }
        model.addAttribute("grades", grades);
        model.addAttribute("subjects", subjects);
        return "teacher/details";
    }




}

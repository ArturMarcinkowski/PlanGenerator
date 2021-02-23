package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showForm(Model model) {
        model.addAttribute("subject", new Subject());
        return "subject/form";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveProposition(@Valid Subject subject, BindingResult result) {
        if (result.hasErrors()) {
            return "subject/form";
        }
        subjectRepository.save(subject);
        return "redirect:/subject/list";
    }

    @GetMapping("/list")
    public String subjectList(HttpServletRequest request){
        List<Subject> list = subjectRepository.findAll();
        request.setAttribute("subjects", list);
        return "subject/list";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String showEditForm(@RequestParam int id, Model model) {
        Optional<Subject> optionalSubject = subjectRepository.findById(id);
        if(optionalSubject.isPresent()) {
            Subject subject = optionalSubject.get();
            model.addAttribute("subject", subject);
            return "subject/form";
        }
        return "subject/list";
    }


    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String saveEditForm(@Valid Subject subject, BindingResult result) {
        if (result.hasErrors()) {
            return "subject/form";
        }
        subjectRepository.save(subject);
        return "redirect:/subject/list";
    }

    @ResponseBody
    @GetMapping("/delete")
    public String deleteSubject(@RequestParam int id){
        subjectRepository.deleteById(id);
        return "redirect:/subject/list";

    }







}

package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Grade;
import pl.coderslab.model.GradeSubjectTeacher;
import pl.coderslab.model.Subject;
import pl.coderslab.model.Teacher;
import pl.coderslab.respository.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
@RequestMapping("/gst")
public class GSTController {
    public final GradeRepository gradeRepository;
    public final SubjectRepository subjectRepository;
    public final TeacherRepository teacherRepository;
    public final GSTRepository gstRepository;

    public GSTController(GradeRepository gradeRepository, SubjectRepository subjectRepository, TeacherRepository teacherRepository, GSTRepository gstRepository) {
        this.gradeRepository = gradeRepository;
        this.subjectRepository = subjectRepository;
        this.teacherRepository = teacherRepository;
        this.gstRepository = gstRepository;
    }


    @GetMapping("/add")
    public String gstAdd(Model model){
        model.addAttribute("gst", new GradeSubjectTeacher());
        model.addAttribute("grades", gradeRepository.findAll());
        model.addAttribute("subjects", subjectRepository.findAll());
        model.addAttribute("teachers", teacherRepository.findAll());
        return "gst/form";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveProposition(@Valid GradeSubjectTeacher gst, BindingResult result) {
        if (result.hasErrors()) {
            return "gst/form";
        }
        gstRepository.save(gst);
        return "redirect:/gst/list";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String showEditForm(@RequestParam int id, Model model) {
        Optional<GradeSubjectTeacher> optionalGST = gstRepository.findById(id);
        if(optionalGST.isPresent()) {
            GradeSubjectTeacher gst = optionalGST.get();
            model.addAttribute("gst", gst);
            model.addAttribute("grades", gradeRepository.findAll());
            model.addAttribute("subjects", subjectRepository.findAll());
            model.addAttribute("teachers", teacherRepository.findAll());
            return "gst/form";
        }
        return "gst/list";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String saveEditForm(@Valid GradeSubjectTeacher gst, BindingResult result) {
        if (result.hasErrors()) {
            return "gst/form";
        }
        gstRepository.save(gst);
        return "redirect:/gst/list";
    }


    @RequestMapping("/list")
    public String getAll(Model model) {
        model.addAttribute("gsts", gstRepository.findAll());
        return "gst/list";
    }

    @GetMapping("/delete")
    public String deleteGST(@RequestParam int id){
        gstRepository.deleteById(id);
        return "redirect:/gst/list";

    }


}

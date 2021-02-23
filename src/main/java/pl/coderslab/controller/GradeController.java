package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Grade;
import pl.coderslab.model.Student;
import pl.coderslab.model.Subject;
import pl.coderslab.model.Teacher;
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

    public GradeController(GradeRepository gradeRepository, StudentRepository studentRepository) {
        this.gradeRepository = gradeRepository;
        this.studentRepository = studentRepository;
    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showForm(Model model) {
        model.addAttribute("grade", new Grade());
        return "grade/form";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveProposition(@Valid Grade grade, BindingResult result) {
        if (result.hasErrors()) {
            return "grade/form";
        }
        gradeRepository.save(grade);
        return "redirect:/grade/list";
    }

    @RequestMapping("/list")
    public String getAll(Model model) {
        model.addAttribute("grades", gradeRepository.findAll());
        return "grade/list";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam int id) {
        gradeRepository.deleteById(id);
        return "redirect:/grade/list";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String showEditForm(@RequestParam int id, Model model) {
        model.addAttribute("grade", gradeRepository.findById(id));
        return "grade/form";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String saveEditForm(@Valid Grade grade, BindingResult result) {
        if (result.hasErrors()) {
            return "grade/form";
        }
        gradeRepository.save(grade);
        return "redirect:/grade/list";
    }

    @GetMapping("/details")
    public String gradeDetails(@RequestParam int id, Model model){
        Grade grade = gradeRepository.findById(id);
        model.addAttribute("grade", grade);
        model.addAttribute("students", studentRepository.findAllByGrade(grade));
        return "grade/details";

    }





}

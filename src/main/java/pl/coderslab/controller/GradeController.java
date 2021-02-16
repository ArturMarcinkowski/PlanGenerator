package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.model.Grade;
import pl.coderslab.respository.GradeRepository;

@Controller
@RequestMapping("/grade")
public class GradeController {
    public final GradeRepository gradeRepository;

    public GradeController(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    @GetMapping("/add")
    @ResponseBody
    public String addGroup() {
        Grade grade = new Grade();
        grade.setName("sdfs");
        gradeRepository.save(grade);
        return "added";
    }




}

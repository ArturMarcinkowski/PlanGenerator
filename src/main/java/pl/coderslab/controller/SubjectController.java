package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.model.Subject;
import pl.coderslab.model.Teacher;
import pl.coderslab.respository.SubjectRepository;
import pl.coderslab.respository.TeacherRepository;

@Controller
@RequestMapping("/subject")
public class SubjectController {
    public final SubjectRepository subjectRepository;

    public SubjectController(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @GetMapping("/add")
    @ResponseBody
    public String addSubject() {
        Subject subject = new Subject();
        subject.setName("matma");
        subjectRepository.save(subject);
        return "added";
    }




}

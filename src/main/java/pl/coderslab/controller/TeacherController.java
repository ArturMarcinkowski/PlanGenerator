package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.model.Teacher;
import pl.coderslab.respository.TeacherRepository;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
    public final TeacherRepository teacherRepository;

    public TeacherController(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @GetMapping("/add")
    @ResponseBody
    public String addTeacher() {
        Teacher teacher = new Teacher();
        teacher.setName("fas");
        teacher.setSurname("dasda");
        teacherRepository.save(teacher);
        return "added";
    }




}

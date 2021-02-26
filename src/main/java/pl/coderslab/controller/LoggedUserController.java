package pl.coderslab.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.PlanUtils;
import pl.coderslab.model.*;
import pl.coderslab.respository.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.*;

@Controller
@RequestMapping("/logged")
public class LoggedUserController {
    public final GradeRepository gradeRepository;
    public final StudentRepository studentRepository;
    public final GSTRepository gstRepository;
    public final ScheduleRepository scheduleRepository;
    public final TeacherRepository teacherRepository;
    public final UserRepository userRepository;
    public final SubjectRepository subjectRepository;

    public LoggedUserController(GradeRepository gradeRepository, StudentRepository studentRepository, GSTRepository gstRepository, ScheduleRepository scheduleRepository, TeacherRepository teacherRepository, UserRepository userRepository, SubjectRepository subjectRepository) {
        this.gradeRepository = gradeRepository;
        this.studentRepository = studentRepository;
        this.gstRepository = gstRepository;
        this.scheduleRepository = scheduleRepository;
        this.teacherRepository = teacherRepository;
        this.userRepository = userRepository;
        this.subjectRepository = subjectRepository;
    }

    private String getRole(Authentication authentication){
        String name = authentication.getName();
        User user = userRepository.findByUsername(name);
        for(Role role:user.getRoles()){
            if(role.getName().equals("ROLE_STUDENT")) {
                return "STUDENT";
            }
            if(role.getName().equals("ROLE_TEACHER")) {
                return "TEACHER";
            }
            if(role.getName().equals("ROLE_ADMIN")) {
                return "ADMIN";
            }
        }
        return "NONE";
    }


    @GetMapping("/profile")
    public String profile(Authentication authentication){
        switch (getRole(authentication)) {
            case "TEACHER":
                return "redirect:teacher";
            case "STUDENT":
                return "redirect:student";
            case "ADMIN":
                return "redirect:admin";
            case "NONE":
                return "redirect:none";
        }
        return "redirect:/";
    }



    @GetMapping("/student")
    public String student(Authentication authentication, Model model){
        String name = authentication.getName();
        Student student = studentRepository.findByUserUsername(name);
        Grade grade = student.getGrade();
        model.addAttribute("student", student);
        List<GradeSubjectTeacher> gsts =  gstRepository.findAllByGrade(grade);
        model.addAttribute("gsts", gsts);
        model.addAttribute("grade",grade);
        GradeSubjectTeacher[][] allGsts = PlanUtils.getGsts(scheduleRepository.findAllByGstGrade(grade));
        model.addAttribute("allGsts", allGsts);
        model.addAttribute("students", studentRepository.findAllByGrade(grade));
        return "loggedUser/student";
    }

    @GetMapping("/teacher")
    public String teacher(Authentication authentication, Model model){
        String name = authentication.getName();
        Teacher teacher = teacherRepository.findByUserUsername(name);
        model.addAttribute("teacher", teacher);
        List<GradeSubjectTeacher> gsts =  gstRepository.findAllByTeacher(teacher);
        model.addAttribute("gsts", gsts);
        GradeSubjectTeacher[][] allGsts =PlanUtils.getGsts(scheduleRepository.findAllByGstTeacher(teacher));
        model.addAttribute("allGsts", allGsts);
        return "loggedUser/teacher";
    }

    @GetMapping("/admin")
    public String admin(Authentication authentication, Model model){
        String name = authentication.getName();
        User user = userRepository.findByUsername(name);
        model.addAttribute("user", user);
        model.addAttribute("teachersNumber", teacherRepository.count());
        model.addAttribute("studentsNumber", studentRepository.count());
        model.addAttribute("gradesNumber", gradeRepository.count());
        model.addAttribute("subjectsNumber", subjectRepository.count());
        return "loggedUser/admin";
    }

    @GetMapping("/none")
    public String none(Authentication authentication, Model model){
        String name = authentication.getName();
        User user = userRepository.findByUsername(name);
        model.addAttribute("user", user);
        return "loggedUser/none";
    }

    @GetMapping("/settings")
    public String settings(Authentication authentication, Model model){
        switch (getRole(authentication)) {
            case "TEACHER":
                return "redirect:teachersettings";
            case "STUDENT":
                return "redirect:studentsettings";
        }
        return "redirect:/";
    }

    @GetMapping("/teachersettings")
    public String teacherSettings(Authentication authentication, Model model){
        String name = authentication.getName();
        Teacher teacher = teacherRepository.findByUserUsername(name);
        model.addAttribute("teacher", teacher);
        return "loggedUser/teacherSettings";
    }







}

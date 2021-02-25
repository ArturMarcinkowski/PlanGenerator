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

    public LoggedUserController(GradeRepository gradeRepository, StudentRepository studentRepository, GSTRepository gstRepository, ScheduleRepository scheduleRepository, TeacherRepository teacherRepository) {
        this.gradeRepository = gradeRepository;
        this.studentRepository = studentRepository;
        this.gstRepository = gstRepository;
        this.scheduleRepository = scheduleRepository;
        this.teacherRepository = teacherRepository;
    }






    @GetMapping("/student")
    public String student(Authentication authentication, Model model){
//        String name = authentication.getName();
//        Student student = studentRepository.findByUserUsername(name);
        Student student = studentRepository.findById(2).get();
        Grade grade = student.getGrade();
        model.addAttribute("student", student);
        List<GradeSubjectTeacher> gsts =  gstRepository.findAllByGrade(grade);
        model.addAttribute("gsts", gsts);
        model.addAttribute("grade",grade);
        GradeSubjectTeacher[][] allGsts = PlanUtils.getGsts(scheduleRepository.findAllByGstGrade(grade));
        model.addAttribute("allGsts", allGsts);
        model.addAttribute("students", studentRepository.findAllByGrade(grade));


//        List<Subject> subjects = new ArrayList<>();
//        List<Teacher> teachers = new ArrayList<>();
//        for(GradeSubjectTeacher gst:gsts){
//            if(!subjects.contains(gst.getSubject())){
//                subjects.add(gst.getSubject());
//            }
//            if(!teachers.contains(gst.getTeacher())){
//                teachers.add(gst.getTeacher());
//            }
//        }
//        model.addAttribute("teachers", teachers);
//        model.addAttribute("subjects", subjects);


        return "loggedUser/student";
    }

    @GetMapping("/teacher")
    public String teacher(Authentication authentication, Model model){
//        String name = authentication.getName();
//        Teacher teacher = teacherRepository.findByUserUsername(name);
        Teacher teacher = teacherRepository.findById(2).get();
        model.addAttribute("teacher", teacher);
        List<GradeSubjectTeacher> gsts =  gstRepository.findAllByTeacher(teacher);
        model.addAttribute("gsts", gsts);
        GradeSubjectTeacher[][] allGsts =PlanUtils.getGsts(scheduleRepository.findAllByGstTeacher(teacher));
        model.addAttribute("allGsts", allGsts);
        return "loggedUser/teacher";
    }


    @RequestMapping(value = "/username", method = RequestMethod.GET)
    @ResponseBody
    public String currentUserName(Authentication authentication) {
        return authentication.getName();
    }





}

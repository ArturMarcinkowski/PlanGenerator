package pl.coderslab.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
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

    private int hourToNumber(String hour) {
        switch (hour) {
            case "8:00":
                return 0;
            case "8:55":
                return 1;
            case "9:50":
                return 2;
            case "10:45":
                return 3;
            case "11:40":
                return 4;
            case "12:35":
                return 5;
            case "13:30":
                return 6;
            case "14:25":
                return 7;
        }
        return 0;
    }

    private int dayToNumber(String day) {
        switch (day) {
            case "Monday":
                return 0;
            case "Tuesday":
                return 1;
            case "Wednesday":
                return 2;
            case "Thursday":
                return 3;
            case "Friday":
                return 4;
        }
        return 0;
    }


    public GradeSubjectTeacher[][] getGsts(List<Schedule> schedules){
        GradeSubjectTeacher[][] allGsts;
        allGsts = new GradeSubjectTeacher[8][5];
        for(Schedule schedule:schedules){
            if(schedule.getDayOfWeek() != null && schedule.getStartHour() != null){
                allGsts[hourToNumber(schedule.getStartHour())]
                        [dayToNumber(schedule.getDayOfWeek())] = schedule.getGst();
            }
        }
        return allGsts;
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
        GradeSubjectTeacher[][] allGsts = getGsts(scheduleRepository.findAllByGstGrade(grade));
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
        GradeSubjectTeacher[][] allGsts = getGsts(scheduleRepository.findAllByGstTeacher(teacher));
        model.addAttribute("allGsts", allGsts);
        return "loggedUser/teacher";
    }


    @RequestMapping(value = "/username", method = RequestMethod.GET)
    @ResponseBody
    public String currentUserName(Authentication authentication) {
        return authentication.getName();
    }





}

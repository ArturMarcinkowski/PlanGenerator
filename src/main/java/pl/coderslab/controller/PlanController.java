package pl.coderslab.controller;

        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.validation.BindingResult;
        import org.springframework.web.bind.annotation.*;
        import pl.coderslab.PlanUtils;
        import pl.coderslab.model.*;
        import pl.coderslab.respository.GSTRepository;
        import pl.coderslab.respository.GradeRepository;
        import pl.coderslab.respository.ScheduleRepository;
        import pl.coderslab.respository.TeacherRepository;

        import javax.servlet.http.HttpServletRequest;
        import javax.validation.Valid;
        import java.util.ArrayList;
        import java.util.List;

@Controller
@RequestMapping("/plan")
public class PlanController {

    public final ScheduleRepository scheduleRepository;
    public final GSTRepository gstRepository;
    public final GradeRepository gradeRepository;
    public final TeacherRepository teacherRepository;

    public PlanController(ScheduleRepository scheduleRepository, GSTRepository gstRepository, GradeRepository gradeRepository, TeacherRepository teacherRepository) {
        this.scheduleRepository = scheduleRepository;
        this.gstRepository = gstRepository;
        this.gradeRepository = gradeRepository;
        this.teacherRepository = teacherRepository;
    }

    @ModelAttribute(name = "dayOfWeek")
    public List<String> getDays() {
        return List.of("Monday", "Tuesday", "Wednesday", "Thursday", "Friday");
    }
    @ModelAttribute(name = "startHour")
    public List<String> getHours() {
        return List.of("8:00","8:55", "9:50", "10:45", "11:40", "12:35", "13:30", "14:25");
    }


    @GetMapping("/gradeList")
    public String gradeList(Model model){
        model.addAttribute("grades",gradeRepository.findAll());
        return "plan/gradeList";
    }

    @GetMapping("/grade")
    public String grade(Model model, @RequestParam int id){
        Grade grade = gradeRepository.findById(id);
        model.addAttribute("grade",grade);
        GradeSubjectTeacher[][] allGsts = PlanUtils.getGsts(scheduleRepository.findAllByGstGrade(grade));
        model.addAttribute("allGsts", allGsts);
        return "plan/gradePlan";
    }

    @GetMapping("/teacherlist")
    public String TeacherList(Model model){
        model.addAttribute("teachers",teacherRepository.findAll());
        return "plan/teacherList";
    }

    @GetMapping("/teacher")
    public String teacher(Model model, @RequestParam int id){
        Teacher teacher = teacherRepository.findById(id).get();
        model.addAttribute("teacher", teacher);
        GradeSubjectTeacher[][] allGsts = PlanUtils.getGsts(scheduleRepository.findAllByGstTeacher(teacher));
        model.addAttribute("allGsts", allGsts);
        return "plan/teacherPlan";
    }

}


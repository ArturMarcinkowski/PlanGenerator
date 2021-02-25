package pl.coderslab.controller;

        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.validation.BindingResult;
        import org.springframework.web.bind.annotation.*;
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


    @GetMapping("/gradeList")
    public String gradeList(Model model){
        model.addAttribute("grades",gradeRepository.findAll());
        return "plan/gradeList";
    }

//    @GetMapping("/grade")
//    public String grade(Model model, @RequestParam int id){
//        Grade grade = gradeRepository.findById(id);
//        model.addAttribute("grade",grade);
//        GradeSubjectTeacher[] monday;
//        monday = new GradeSubjectTeacher[8];
//        List<Schedule> schedules = scheduleRepository.findAllByGstGrade(grade);
////        for(int i = 0; i < 8; i++){
////            if()
////        }
//
//        for(Schedule schedule:schedules){
//            if(schedule.getDayOfWeek() != null && schedule.getStartHour() != null){
//                monday[hourToNumber(schedule.getStartHour())] = schedule.getGst();
//            }
//        }
//        model.addAttribute("monday", monday);
//
//        return "plan/gradePlan";
//    }


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

    @GetMapping("/grade")
    public String grade(Model model, @RequestParam int id){
        Grade grade = gradeRepository.findById(id);
        model.addAttribute("grade",grade);
        GradeSubjectTeacher[][] allGsts = getGsts(scheduleRepository.findAllByGstGrade(grade));
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
        GradeSubjectTeacher[][] allGsts = getGsts(scheduleRepository.findAllByGstTeacher(teacher));
        model.addAttribute("allGsts", allGsts);
        return "plan/teacherPlan";
    }

}


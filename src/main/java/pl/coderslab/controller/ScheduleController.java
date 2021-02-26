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
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/schedule")
public class ScheduleController {

    public final ScheduleRepository scheduleRepository;
    public final GSTRepository gstRepository;
    public final GradeRepository gradeRepository;
    public final TeacherRepository teacherRepository;

    public ScheduleController(ScheduleRepository scheduleRepository, GSTRepository gstRepository, GradeRepository gradeRepository, TeacherRepository teacherRepository) {
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

    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("schedules", scheduleRepository.findAll());
        return "schedule/list";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String showEditForm(@RequestParam int id, Model model) {
        model.addAttribute("schedule", scheduleRepository.findById(id));
        model.addAttribute("gsts", gstRepository.findAll());
        return "schedule/form";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String saveEditForm(@Valid Schedule schedule, BindingResult result) {
        if (result.hasErrors()) {
            return "schedule/form";
        }
        scheduleRepository.save(schedule);
        return "redirect:/schedule/list";
    }

    @RequestMapping(value = "/addplanforgrade", method = RequestMethod.GET)
    public String showFormSchedule(Model model, @RequestParam int gradeId) {
        model.addAttribute("schedule", new Schedule());
        Grade grade = gradeRepository.findById(gradeId);
//        model.addAttribute("grade", grade);
        model.addAttribute("gsts", gstRepository.findAllByGrade(grade));
        return "schedule/addForGrade";
    }

    @RequestMapping(value = "/addplanforgrade", method = RequestMethod.POST)
    public String saveProposition(@Valid Schedule schedule, BindingResult result) {
        if (result.hasErrors()) {
            return "schedule/form";
        }
        scheduleRepository.save(schedule);
        Grade grade = schedule.getGst().getGrade();
        if(grade != null) {
            return "redirect:/plan/grade?id=" + grade.getId();
        }
        return "redirect:plan/gradeList";
    }

    @RequestMapping(value = "/addplanforteacher", method = RequestMethod.GET)
    public String showFormTeacher(Model model, @RequestParam int teacherId) {
        model.addAttribute("schedule", new Schedule());
        model.addAttribute("gsts", gstRepository.findAllByTeacherId(teacherId));
        return "schedule/addForTeacher";
    }

    @RequestMapping(value = "/addplanforteacher", method = RequestMethod.POST)
    public String savePropositionTeacher(@Valid Schedule schedule, BindingResult result) {
        if (result.hasErrors()) {
            return "schedule/form";
        }
        scheduleRepository.save(schedule);
        Teacher teacher = schedule.getGst().getTeacher();
        if(teacher != null) {
            return "redirect:/plan/teacher?id=" + teacher.getId();
        }
        return "redirect:plan/teacherlist";
    }



}

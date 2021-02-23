package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.*;
import pl.coderslab.respository.GSTRepository;
import pl.coderslab.respository.ScheduleRepository;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/schedule")
public class ScheduleController {

    public final ScheduleRepository scheduleRepository;
    public final GSTRepository gstRepository;

    public ScheduleController(ScheduleRepository scheduleRepository, GSTRepository gstRepository) {
        this.scheduleRepository = scheduleRepository;
        this.gstRepository = gstRepository;
    }

    @ModelAttribute(name = "dayOfWeek")
    public List<String> getDays() {
        return List.of("Monday", "Tuesday", "Wednesday", "Thursday", "Friday");
    }
    @ModelAttribute(name = "startHour")
    public List<String> getHours() {
        return List.of("8:00","8:55", "9:50", "10:45", "11:40", "12:35", "13:30", "14:25");
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showFormSchedule(Model model) {
        model.addAttribute("schedule", new Schedule());
        model.addAttribute("gsts", gstRepository.findAll());
        return "schedule/form";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveProposition(@Valid Schedule schedule, BindingResult result) {
        if (result.hasErrors()) {
            return "schedule/form";
        }
        scheduleRepository.save(schedule);
        return "redirect:/schedule/list";
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

}

package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.*;
import pl.coderslab.respository.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.*;

@Controller
@RequestMapping("/teacher")
public class TeacherController {


    public final TeacherRepository teacherRepository;
    public final SubjectRepository subjectRepository;
    public final GSTRepository gstRepository;
    public final UserRepository userRepository;
    public final StudentRepository studentRepository;

    public TeacherController(TeacherRepository teacherRepository, SubjectRepository subjectRepository, GSTRepository gstRepository, UserRepository userRepository, StudentRepository studentRepository) {
        this.teacherRepository = teacherRepository;
        this.subjectRepository = subjectRepository;
        this.gstRepository = gstRepository;
        this.userRepository = userRepository;
        this.studentRepository = studentRepository;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showForm(Model model) {
        model.addAttribute("teacher", new Teacher());
        List<User> users = userRepository.findAllByStudentIsNullAndTeacherIsNull();
        model.addAttribute("users", users);
        return "teacher/form";
    }

    public void saveTeacher(Teacher teacher){
        teacherRepository.save(teacher);
        if(teacher.getUser() != null){
            List<User> users = userRepository.findAllByTeacher(teacher);
            for(User user:users){
                user.setTeacher(null);
                List<Student> students = studentRepository.findAllByUserId(user.getId());
                for(Student student: students){
                    student.setUser(null);
                    studentRepository.save(student);
                }
                teacherRepository.save(teacher);
            }
            User user = userRepository.findById(teacher.getUser().getId()).get();
            user.setTeacher(teacher);
            userRepository.save(user);
        }
        else {
            List<User> users = userRepository.findAllByTeacherId(teacher.getId());
            for(User user:users){
                user.setTeacher(null);
                userRepository.save(user);
            }
        }
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveProposition(@Valid Teacher teacher, BindingResult result) {
        if (result.hasErrors()) {
            return "teacher/form";
        }
        saveTeacher(teacher);
        return "redirect:/teacher/list";
    }

    @RequestMapping("/list")
    public String getAll(Model model) {
        model.addAttribute("teachers", teacherRepository.findAll());
        return "teacher/list";
    }


    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String showEditForm(@RequestParam int id, Model model) {
        Optional<Teacher> optionalTeacher = teacherRepository.findById(id);
        if(optionalTeacher.isPresent()) {
            Teacher teacher = optionalTeacher.get();
            model.addAttribute("teacher", teacher);
            List<User> users = userRepository.findAllByStudentIsNullAndTeacherIsNull();
//            Optional<User> currentUser = userRepository.findByTeacherId(id);
//            if(currentUser.isPresent()){
//                users.add(currentUser.get());
//            }
            users.addAll(userRepository.findAllByTeacherId(id));
            model.addAttribute("users", users);
            return "teacher/form";
        }
        return "teacher/list";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String saveEditForm(@Valid Teacher teacher, BindingResult result) {
        if (result.hasErrors()) {
            return "teacher/form";
        }
        saveTeacher(teacher);
        return "redirect:/teacher/list";
    }

    @GetMapping("/delete")
    public String deleteTeacher(@RequestParam int id){
       teacherRepository.deleteById(id);
        return "redirect:/teacher/list";

    }

    @GetMapping("/details")
    public String details(Model model, @RequestParam int id) {
        model.addAttribute("teacher", teacherRepository.findById(id).get());
        List<GradeSubjectTeacher> gsts =  gstRepository.findAllByTeacherId(id);
        List<Subject> subjects = new ArrayList<>();
        List<Grade> grades = new ArrayList<>();
        for(GradeSubjectTeacher gst:gsts){
            if(!subjects.contains(gst.getSubject())){
                subjects.add(gst.getSubject());
            }
            if(!grades.contains(gst.getGrade())){
                grades.add(gst.getGrade());
            }
        }
        model.addAttribute("grades", grades);
        model.addAttribute("subjects", subjects);
        return "teacher/details";
    }




}

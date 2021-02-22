package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Grade;
import pl.coderslab.model.GradeSubjectTeacher;
import pl.coderslab.model.Subject;
import pl.coderslab.model.Teacher;
import pl.coderslab.respository.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/gst")
public class GSTController {
    public final GradeRepository gradeRepository;
    public final SubjectRepository subjectRepository;
    public final TeacherRepository teacherRepository;
    public final GSTRepository gstRepository;

    public GSTController(GradeRepository gradeRepository, SubjectRepository subjectRepository, TeacherRepository teacherRepository, GSTRepository gstRepository) {
        this.gradeRepository = gradeRepository;
        this.subjectRepository = subjectRepository;
        this.teacherRepository = teacherRepository;
        this.gstRepository = gstRepository;
    }

    @GetMapping("/add")
    public String gstAdd(HttpServletRequest request){
        List<Teacher> teachers = teacherRepository.findAll();
        List<Grade> grades = gradeRepository.findAll();
        List<Subject> subjects = subjectRepository.findAll();
        request.setAttribute("grades", grades);
        request.setAttribute("subjects", subjects);
        return "gst/add";
    }


    @PostMapping("/add")

    public String addGST(HttpServletRequest request, @RequestParam int gradeId, @RequestParam(value="subjectsId[]") int[] subjectsId) {
        List<Subject> subjects = new ArrayList<>();
        for(int subjectId:subjectsId)
            subjects.add(subjectRepository.findById(subjectId).get());
        request.setAttribute("gradeId", gradeId);
        request.setAttribute("subjects", subjects);

//        List<List<Teacher>> teacherBundle = new ArrayList<>();
//        for(Subject subject:subjects){
//            List<Teacher> teachers = new ArrayList<>(subject.getTeacher());
//            teacherBundle.add(teachers);
//        }
//        request.setAttribute("teachersBundle", teacherBundle);

        return "gst/addTeachers";
    }


    @PostMapping("/addteachers")
    public String addTeachersToGST(@RequestParam int gradeId,@RequestParam List<Subject> subjects, @RequestParam(value="teachersId[]") int[] teachersId) {

        int index = 0;
        for(Subject subject:subjects){
            GradeSubjectTeacher gradeSubjectTeacher = new GradeSubjectTeacher();
            gradeSubjectTeacher.setGrade(gradeRepository.findById(gradeId));
            gradeSubjectTeacher.setSubject(subject);
            gradeSubjectTeacher.setTeacher(teacherRepository.findById(teachersId[index]).get());
            gstRepository.save(gradeSubjectTeacher);
            index++;
        }
        return "added";
    }

}

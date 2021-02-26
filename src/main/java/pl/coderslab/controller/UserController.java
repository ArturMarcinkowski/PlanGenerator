package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.*;
import pl.coderslab.respository.RoleRepository;
import pl.coderslab.respository.StudentRepository;
import pl.coderslab.respository.TeacherRepository;
import pl.coderslab.respository.UserRepository;
import pl.coderslab.service.UserService;

import javax.validation.Valid;
import java.util.*;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;
    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;
    private final RoleRepository roleRepository;

    public UserController(UserService userService, UserRepository userRepository, StudentRepository studentRepository, TeacherRepository teacherRepository, RoleRepository roleRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
        this.roleRepository = roleRepository;
    }

//    @ModelAttribute(name = "roles")
//    public List<String> getRoles() {
//        return List.of("ROLE_ADMIN", "ROLE_TECHER", "ROLE_STUDENT");
//    }
    @ModelAttribute(name = "roles")
    public List<Role> getRoles() {
        return List.of(new Role(1, "ROLE_ADMIN"), new Role(2, "ROLE_TEACHER"), new Role(3, "ROLE_STUDENT"));
    }

    @GetMapping("/create-user")
    @ResponseBody
    public String createUser() {
        User user = new User();
        user.setUsername("admin3");
        user.setPassword("admin3");
        userService.saveUser(user);
        return "admin";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showForm(Model model) {
        model.addAttribute("user", new User());
//        model.addAttribute("grades", gradeRepository.findAll());
//        List<User> users = userRepository.findAllByStudentIsNull();
//        model.addAttribute("teachers", teacherRepository.findAllByUserIsNull());
//        List<Role> roles = roleRepository.findAll();
//        model.addAttribute("roles", roles);
        return "user/form";
    }

    @PostMapping("/add")
    public String addStudent(@Valid User user, BindingResult result){
        if (result.hasErrors()) {
            return "user/form";
        }
        userService.saveUser(user);
        return "redirect:/user/list";
    }

    @RequestMapping("/list")
    public String getAll(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "user/list";
    }
    @RequestMapping("/details")
    public String getAll(Model model, @RequestParam int id) {
        model.addAttribute("user", userRepository.findById(id).get());
        return "user/details";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam int id) {
        userRepository.delete(userRepository.findById(id).get());
        return "redirect:/user/list";
    }


    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String showEditForm(@RequestParam int id, Model model) {
        model.addAttribute("user", userRepository.findById(id));
        return "user/form";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String saveEditForm(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "user/form";
        }
        userRepository.save(user);
        return "redirect:/user/list";
    }


    @RequestMapping(value = "/addrole", method = RequestMethod.GET)
    public String showFormRole(Model model, @RequestParam int id) {
        model.addAttribute("user", userRepository.findById(id).get());
        List<Role> roles = roleRepository.findAll();
        model.addAttribute("roles", roles);
        return "user/addRole";
    }

    @PostMapping("/addrole")
    public String addRole(Model model, @RequestParam(name = "rolesId[]") int rolesId[], @RequestParam int userId){

        Optional<User> optionalUser = userRepository.findById(userId);
        if(optionalUser.isPresent()){
            Set<Role> roles = new HashSet<>();
            for(int roleId:rolesId){
                Optional<Role> optionalRole = roleRepository.findById(roleId);
                if(optionalRole.isPresent()){
                    roles.add(optionalRole.get());
                }
            }
            User user = optionalUser.get();
            user.setRoles(roles);
            userRepository.save(user);
        }
        return "redirect:/user/details?id="+userId;
    }


}

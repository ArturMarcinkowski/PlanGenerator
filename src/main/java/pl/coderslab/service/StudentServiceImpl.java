//package pl.coderslab.service;
//
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//import pl.coderslab.model.Student;
//import pl.coderslab.model.User;
//import pl.coderslab.respository.StudentRepository;
//import pl.coderslab.respository.UserRepository;
//
//import java.util.Arrays;
//import java.util.HashSet;
//
//@Service
//public class StudentServiceImpl implements UserService {
//
//    private final UserRepository userRepository;
//    private final StudentRepository studentRepository;
//    private final BCryptPasswordEncoder passwordEncoder;
//
//    public StudentServiceImpl(UserRepository userRepository, StudentRepository studentRepository,
//                              BCryptPasswordEncoder passwordEncoder) {
//        this.passwordEncoder = passwordEncoder;
//        this.userRepository = userRepository;
//        this.studentRepository = studentRepository;
//    }
//
//    @Override
//    public User findByUserName(String username) {
//        return userRepository.findByUsername(username);
//    }
//    @Override
//    public void saveUser(User user) {
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        user.setEnabled(1);
//        Student userStudent = studentRepository.findByName("ROLE_USER");
//        user.setRoles(new HashSet<>(Arrays.asList(userStudent)));
//        userRepository.save(user);
//    }
//}

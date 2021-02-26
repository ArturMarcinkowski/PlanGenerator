package pl.coderslab.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.model.Student;
import pl.coderslab.model.Teacher;
import pl.coderslab.model.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
    Optional<User> findByStudentId(int id);
    Optional<User> findByTeacherId(int id);
    Optional<User> findByTeacher(Teacher teacher);
    List<User> findAllByStudentIsNullAndTeacherIsNull();
    List<User> findAll();
    List<User> findAllByTeacherId(int id);
    List<User> findAllByTeacher(Teacher teacher);
    List<User> findAllByStudent(Student student);
    List<User> findAllByStudentId(int id);
}

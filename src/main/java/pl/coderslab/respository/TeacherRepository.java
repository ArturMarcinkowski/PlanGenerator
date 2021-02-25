package pl.coderslab.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.model.Student;
import pl.coderslab.model.Subject;
import pl.coderslab.model.Teacher;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
    Teacher findByName(String name);
    List<Teacher> findAllByUserIsNull();
    List<Teacher> findAllByUserId(int id);
    Teacher findByUserUsername(String username);


}
//
package pl.coderslab.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.model.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    List<User> findByStudentId(int id);
    List<User> findAllByStudentIsNullAndTeacherIsNull();
    List<User> findAll();
    List<User> findAllByStudentIsNull();
}

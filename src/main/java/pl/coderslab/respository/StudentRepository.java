package pl.coderslab.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.model.Grade;
import pl.coderslab.model.Student;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    Student findByName(String name);
    List<Student> findAllByGrade(Grade grade);
    List<Student> findAllByGradeId(int id);
    List<Student> findAllByGradeIsNull();
    List<Student> findAllByGradeIdIsNot(int id);
    List<Student> findAllByGradeNotNullAndGradeIdIs(int id);
    List<Student> findAllByUserId(int id);


}
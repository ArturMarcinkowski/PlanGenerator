package pl.coderslab.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.model.Grade;
import pl.coderslab.model.GradeSubjectTeacher;

import java.util.List;

@Repository
public interface GSTRepository extends JpaRepository<GradeSubjectTeacher, Integer> {
    List<GradeSubjectTeacher> findAllByTeacherId(int id);
    List<GradeSubjectTeacher> findAllByGrade(Grade grade);
}
//
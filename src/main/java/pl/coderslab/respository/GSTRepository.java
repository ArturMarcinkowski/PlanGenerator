package pl.coderslab.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.model.GradeSubjectTeacher;

@Repository
public interface GSTRepository extends JpaRepository<GradeSubjectTeacher, Integer> {

}
//
package pl.coderslab.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.model.Grade;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Integer> {
    Grade findByName(String name);
    Grade findById(int id);

}
//
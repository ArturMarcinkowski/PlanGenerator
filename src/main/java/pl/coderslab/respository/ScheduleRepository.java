package pl.coderslab.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.model.Grade;
import pl.coderslab.model.Schedule;
import pl.coderslab.model.Student;
import pl.coderslab.model.Teacher;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {
    List<Schedule> findAllByGstGrade(Grade grade);
    List<Schedule> findAllByGstTeacher(Teacher teacher);



}

package pl.coderslab.model;

import lombok.Data;
import org.hibernate.annotations.Cascade;
import pl.coderslab.model.Teacher;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @ManyToMany
    @JoinTable(name = "teacher_subject")
    private Set<Teacher> teacher;

}

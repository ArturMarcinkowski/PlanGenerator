package pl.coderslab.model;

import lombok.Data;
import pl.coderslab.model.Subject;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String surname;
    @ManyToMany
    @JoinTable(name = "teacher_subject")
    private Set<Subject> subject;


}

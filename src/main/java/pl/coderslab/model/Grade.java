package pl.coderslab.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
//    @OneToMany
//    private Set<Student> students;

}

package pl.coderslab.model;

import lombok.Data;
import pl.coderslab.model.Subject;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String surname;
    @OneToOne
    @JoinColumn(name="user_id")
    private User user;


}

package pl.coderslab.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String surname;
    @ManyToOne
    @JoinColumn(name="grade_id")
    private Grade grade;
    @OneToOne
    @JoinColumn(name="user_id")
    private User user;

}

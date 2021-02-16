package pl.coderslab.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String startTime;
    private int duration;
    private String day;
    @ManyToOne
    @JoinColumn(name="GST_id")
    private GradeSubjectTeacher GST;

}

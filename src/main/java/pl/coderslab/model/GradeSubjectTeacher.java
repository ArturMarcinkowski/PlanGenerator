package pl.coderslab.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class GradeSubjectTeacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int lessonsInWeek;
    @OneToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;
    @OneToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;
    @OneToOne
    @JoinColumn(name = "grade_id")
    private Grade grade;

    public String getSubjectTeacher(){
        return this.subject.getName()+"  ("+ this.teacher.getName()+" "+this.teacher.getSurname()+")";
    }
    public String getClassSubject(){
        return this.subject.getName()+"  ("+ this.grade.getName()+")";
    }

}

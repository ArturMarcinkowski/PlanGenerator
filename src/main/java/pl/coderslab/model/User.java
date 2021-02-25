package pl.coderslab.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, unique = true, length = 60)
    private String username;
    private String password;
    private int enabled;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
    @OneToOne
    @JoinColumn(name="student_id")
    private Student student;
    @OneToOne
    @JoinColumn(name="teacher_id")
    private Teacher teacher;

    public String getStudentTeacher(){
        String result = "";
        if(this.getStudent() != null){
            result+=this.getStudent().getName() +" " +
                    this.getStudent().getSurname() + "(id: " +
                    this.getStudent().getId() + ")   ";
        }
        if(this.getTeacher() != null){
            result+=this.getTeacher().getName() +" " +
                    this.getTeacher().getSurname() + "(id: " +
                    this.getTeacher().getId() + ")";
        }
        return result;
    }

    public String getUsername(){
        return this.username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }


    public User(){}
}

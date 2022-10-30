package pro.sky.hogw.entity;

import javax.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String student;

    private int age;


    public long getId() {
        return id;
    }

    public String getStudent() {
        return student;
    }

    public int getAge() {
        return age;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

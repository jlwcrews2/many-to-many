package no.jlwcrews.manytomany.student;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import no.jlwcrews.manytomany.course.Course;

import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "student_gen")
    @SequenceGenerator(name = "student_gen", sequenceName = "student_seq", allocationSize = 1)
    private Long student_id;
    @Column(name = "student_firstname")
    private String firstName;
    @Column(name = "student_lastname")
    private String lastName;
    @Column(name = "student_age")
    private int age;

    @ManyToMany
    @JoinTable(
            name = "student_course",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    @JsonIgnoreProperties("students")
    private List<Course> courses;

    public Student(String firstName, String lastName, int age, List<Course> courses) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.courses = courses;
    }
}

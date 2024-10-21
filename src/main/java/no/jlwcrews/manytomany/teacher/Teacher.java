package no.jlwcrews.manytomany.teacher;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import no.jlwcrews.manytomany.course.Course;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "teacher_gen")
    @SequenceGenerator(name = "teacher_gen", sequenceName = "teacher_seq", allocationSize = 1)
    @Column(name = "teacher_id")
    private Long teacherId;
    @Column(name = "teacher_firstname")
    private String firstName;
    @Column(name = "teacher_lastname")
    private String lastName;

    @OneToMany(mappedBy = "teacher")
    @JsonIgnoreProperties("teacher")
    private List<Course> courses = new ArrayList<>();

    public Teacher(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}

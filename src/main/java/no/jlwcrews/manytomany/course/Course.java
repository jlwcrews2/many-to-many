package no.jlwcrews.manytomany.course;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import no.jlwcrews.manytomany.student.Student;
import no.jlwcrews.manytomany.teacher.Teacher;

import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "course_gen")
    @SequenceGenerator(name = "course_gen", sequenceName = "course_seq", allocationSize = 1)
    @Column(name = "course_id")
    private Long courseId;
    private String courseName;
    private String courseDescription;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    @JsonIgnoreProperties("courses")
    private Teacher teacher;

    @ManyToMany(mappedBy = "courses")
    private List<Student> students;

    public Course(String courseName, String courseDescription, Teacher teacher) {
        this.courseName = courseName;
        this.courseDescription = courseDescription;
        this.teacher = teacher;
    }
}

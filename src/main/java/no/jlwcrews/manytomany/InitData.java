package no.jlwcrews.manytomany;

import com.github.javafaker.Faker;
import no.jlwcrews.manytomany.course.Course;
import no.jlwcrews.manytomany.course.CourseService;
import no.jlwcrews.manytomany.student.Student;
import no.jlwcrews.manytomany.student.StudentService;
import no.jlwcrews.manytomany.teacher.Teacher;
import no.jlwcrews.manytomany.teacher.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class InitData implements CommandLineRunner {

    private final CourseService courseService;
    private final TeacherService teacherService;
    private final StudentService studentService;
    private final Faker faker = Faker.instance();

    @Autowired
    public InitData(CourseService courseService, TeacherService teacherService, StudentService studentService) {
        this.courseService = courseService;
        this.teacherService = teacherService;
        this.studentService = studentService;
    }

    @Override
    public void run(String... args) throws Exception {
        List<Course> allCourses = new ArrayList<>();
        for (long j = 0; j < 5; j++) {
            Teacher teacher = teacherService.saveTeacher(
                    new Teacher(
                            faker.name().firstName(),
                            faker.name().lastName()
                    )
            );

            for (long i = 0; i < 5; i++) {
                Course course = courseService.saveCourse(
                        new Course(
                                faker.educator().course(),
                                faker.educator().campus(),
                                teacher
                        )
                );
                allCourses.add(course);
                teacher.getCourses().add(course);
                teacherService.saveTeacher(teacher);
            }
        }

        for (long s = 0; s < 5; s++) {
            studentService.saveStudent(
                    new Student(
                            faker.name().firstName(),
                            faker.name().lastName(),
                            new Random().nextInt(17, 22),
                            allCourses
            ));
        }
    }
}

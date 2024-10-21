package no.jlwcrews.manytomany.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private final CourseRepo courseRepo;

    @Autowired
    public CourseService(CourseRepo courseRepo) {
        this.courseRepo = courseRepo;
    }

    public List<Course> getCourses(){
        return courseRepo.findAll();
    }

    public Course getCourseById(long id){
        return courseRepo.findById(id).orElse(null);
    }

    public Course saveCourse(Course course) {
        return courseRepo.save(course);
    }

    public void deleteCourseById(long id) {
        courseRepo.deleteById(id);
    }
}

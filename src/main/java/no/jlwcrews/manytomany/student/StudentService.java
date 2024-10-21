package no.jlwcrews.manytomany.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepo studentRepo;

    @Autowired
    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public List<Student> getStudents(){
        return studentRepo.findAll();
    }

    public Student getStudentById(long id) {
        return studentRepo.findById(id).orElse(null);
    }

    public Student saveStudent(Student student) {
        return studentRepo.save(student);
    }
}

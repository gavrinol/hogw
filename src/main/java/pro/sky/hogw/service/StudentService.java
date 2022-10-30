package pro.sky.hogw.service;

import org.springframework.stereotype.Service;
import pro.sky.hogw.entity.Student;
import pro.sky.hogw.exception.StudentNotFoundException;
import pro.sky.hogw.repository.StudentRepository;


import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student create(Student student) {
        return studentRepository.save(student);
    }

    public Student update(Student student) {
        Student oldStudent = studentRepository.findById(student.getId())
                .orElseThrow(StudentNotFoundException::new);
        oldStudent.setStudent(student.getStudent());
        oldStudent.setAge(student.getAge());
        return studentRepository.save(oldStudent);
    }

    public Student read(long id){
        return studentRepository.findById(id)
                .orElseThrow(StudentNotFoundException::new);
    }

    public Student delete(long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(StudentNotFoundException::new);
        studentRepository.delete(student);
        return student;
    }

    public List<Student> studentsByAge(int age) {
        return studentRepository.findByAge(age);
    }
}

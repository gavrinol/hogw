package pro.sky.hogw.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.hogw.entity.Student;
import pro.sky.hogw.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/student")

public class StudentController {

    public final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Student> create(@RequestBody Student student) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(studentService.create(student));
    }

    @GetMapping("/{id}")
    public Student read (@PathVariable("id") long id){
        return studentService.read(id);
    }

    @PutMapping
    public Student read(@PathVariable("id") Student student) {
        return  studentService.update(student);
    }

    @DeleteMapping("/{id}")
    public Student delete(@PathVariable("id") long id){
        return  studentService.delete(id);
    }

    @GetMapping
    public List<Student> studentsByAge(@RequestParam("age") int age) {
        return  studentService.studentsByAge(age);
    }
}

package pro.sky.hogw.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.hogw.entity.Faculty;
import pro.sky.hogw.service.FacultyService;

import java.util.List;

@RestController
@RequestMapping("/faculty")

public class FacultyController {

    public final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @PostMapping
    public ResponseEntity<Faculty> create(@RequestBody Faculty faculty) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(facultyService.create(faculty));
    }

    @GetMapping("/{id}")
    public Faculty read (@PathVariable("id") long id){
        return facultyService.read(id);
    }

    @PutMapping
    public Faculty update(@RequestBody Faculty faculty) {
        return  facultyService.update(faculty);
    }

    @DeleteMapping("/{id}")
    public Faculty delete(@PathVariable("id") long id){
        return  facultyService.delete(id);
    }

    @GetMapping
    public List<Faculty> studentsByColor(@RequestParam("color") String color) {
        return  facultyService.facultiesByColor(color);
    }
}

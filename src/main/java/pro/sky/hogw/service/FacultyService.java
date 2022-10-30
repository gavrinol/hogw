package pro.sky.hogw.service;

import org.springframework.stereotype.Service;
import pro.sky.hogw.entity.Faculty;
import pro.sky.hogw.exception.FacultyNotFoundException;
import pro.sky.hogw.repository.FacultyRepository;

import java.util.List;

@Service
public class FacultyService {

    public final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty create(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public Faculty update(Faculty faculty) {
        Faculty oldFaculty = facultyRepository.findById(faculty.getId())
                .orElseThrow(FacultyNotFoundException::new);
        oldFaculty.setName(faculty.getName());
        oldFaculty.setColor(faculty.getColor());
        return facultyRepository.save(oldFaculty);
    }

    public Faculty read(long id) {
        return facultyRepository.findById(id)
                .orElseThrow(FacultyNotFoundException::new);
    }

    public Faculty delete(long id) {
        Faculty faculty = facultyRepository.findById(id)
                .orElseThrow(FacultyNotFoundException::new);
        facultyRepository.delete(faculty);
        return faculty;
    }

    public List<Faculty> facultiesByColor(String color) {
        return facultyRepository.findByColor(color);
    }
}


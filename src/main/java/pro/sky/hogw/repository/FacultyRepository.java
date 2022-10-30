package pro.sky.hogw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pro.sky.hogw.entity.Faculty;

import java.util.List;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {

    List<Faculty> findByColor(String color);
}

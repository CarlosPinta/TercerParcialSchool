package ec.edu.espe.pinta.school.dao;

import ec.edu.espe.pinta.school.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, String> {
    List<Student> findByNivelOrderByAsc(String nivel);
    List<Student> findByIdIn(List<String> cedula);
}

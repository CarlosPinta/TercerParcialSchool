package ec.edu.espe.pinta.school.dao;

import ec.edu.espe.pinta.school.model.StudentParaleloAsign;
import ec.edu.espe.pinta.school.model.StudentParaleloAsignPK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentParaleloAsignRepository extends JpaRepository<StudentParaleloAsign, StudentParaleloAsignPK> {
    List<StudentParaleloAsign> findByPkParaleloId(String paralelo);
}

package ec.edu.espe.pinta.school.service;

import ec.edu.espe.pinta.school.dao.ParaleloRepository;
import ec.edu.espe.pinta.school.dao.StudentParaleloAsignRepository;
import ec.edu.espe.pinta.school.dao.StudentRepository;
import ec.edu.espe.pinta.school.model.Paralelo;
import ec.edu.espe.pinta.school.model.Student;
import ec.edu.espe.pinta.school.model.StudentParaleloAsign;
import ec.edu.espe.pinta.school.model.StudentParaleloAsignPK;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    private final ParaleloRepository paraleloRepository;
    private final StudentParaleloAsignRepository asignRepository;



    public List<Student> findStudentsByNivel(String nivel){
        return this.studentRepository.findByNivelOrderByAsc(nivel);
    }

    public Student create(Student student){
            return this.studentRepository.save(student);
    }

    public List<Student> findStudentsByParaleloAndNivel(String paralelo, String nivel){
        Optional<Paralelo> paraleloOpt =this.paraleloRepository.findByIdAndNivel(paralelo,nivel);
        if(paraleloOpt.isEmpty()){
            return null;
        }
        List<StudentParaleloAsign> asigns = this.asignRepository.findByPkParaleloId(paraleloOpt.get().getId());
        List<String> studentIds = asigns.stream().map(n -> n.getPk().getStudentId()).collect(Collectors.toList());
        return  this.studentRepository.findByIdIn(studentIds);

    }


}

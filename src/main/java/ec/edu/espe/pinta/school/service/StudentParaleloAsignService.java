package ec.edu.espe.pinta.school.service;

import ec.edu.espe.pinta.school.dao.ParaleloRepository;
import ec.edu.espe.pinta.school.dao.StudentParaleloAsignRepository;
import ec.edu.espe.pinta.school.dao.StudentRepository;
import ec.edu.espe.pinta.school.model.Paralelo;
import ec.edu.espe.pinta.school.model.Student;
import ec.edu.espe.pinta.school.model.StudentParaleloAsign;
import ec.edu.espe.pinta.school.model.StudentParaleloAsignPK;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentParaleloAsignService {
    private final StudentParaleloAsignRepository asignRepository;
    private final ParaleloRepository paraleloRepository;
    private final StudentRepository studentRepository;

    public String asignStudentParalelo(String nivel, String cedula){
        Optional<Student> student =this.studentRepository.findById(cedula);
        if(student.isEmpty()){
            return "No se encontro el estudiante con la cedula: "+ cedula;
        }
        List<Paralelo> paralelos = this.paraleloRepository.findByNivel(nivel);
        if(paralelos.size() < 0){
            return "No existen paralelos para el nivel: " + nivel;
        }
        int randomParalelo = (int) (Math.random() * paralelos.size() + 1);
        Paralelo paralelRandom = paralelos.get(randomParalelo);
        StudentParaleloAsignPK studentParaleloAsignPk = new StudentParaleloAsignPK(
                cedula,paralelRandom.getId()
        );
        StudentParaleloAsign studentParaleloAsign = new StudentParaleloAsign(studentParaleloAsignPk);
        this.asignRepository.save(studentParaleloAsign);
        return "Estudiante asignado al paralelo : " + paralelRandom.getNombre();
    }

}

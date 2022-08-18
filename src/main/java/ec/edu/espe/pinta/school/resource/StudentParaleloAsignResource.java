package ec.edu.espe.pinta.school.resource;

import ec.edu.espe.pinta.school.model.Student;
import ec.edu.espe.pinta.school.service.StudentParaleloAsignService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/asign")
@RequiredArgsConstructor
public class StudentParaleloAsignResource {

    private final StudentParaleloAsignService  asignService;

    @PostMapping
    public ResponseEntity<String> asignStudentParalelo(@RequestBody Student student){
        try {
            return ResponseEntity.ok(this.asignService.asignStudentParalelo(student.getNivel(),student.getCedula()));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}

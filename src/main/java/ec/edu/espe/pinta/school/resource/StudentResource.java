package ec.edu.espe.pinta.school.resource;

import ec.edu.espe.pinta.school.model.Student;
import ec.edu.espe.pinta.school.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/students")
@RequiredArgsConstructor
public class StudentResource {

    private final StudentService service;

    @GetMapping(path = "/{nivel}")
    public ResponseEntity<List<Student>> findStudentsByNivel(@PathVariable String nivel){
        return ResponseEntity.ok(this.service.findStudentsByNivel(nivel));
    }


    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        try {
            return ResponseEntity.ok(this.service.create(student));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping(path = "asigned/{nivel}/{paralelo}")
    public ResponseEntity<List<Student>> findStudentsByParaleloAndNivel(@PathVariable String nivel,@PathVariable String paralelo){
        try {
            return ResponseEntity.ok(this.service.findStudentsByParaleloAndNivel(paralelo,nivel));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}

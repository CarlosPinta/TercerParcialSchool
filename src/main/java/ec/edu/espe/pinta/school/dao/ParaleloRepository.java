package ec.edu.espe.pinta.school.dao;

import ec.edu.espe.pinta.school.model.Paralelo;

import java.util.List;
import java.util.Optional;

public interface ParaleloRepository {

    List<Paralelo> findByNivel(String nivel);

    Optional<Paralelo> findByIdAndNivel(String id, String Nivel);
}

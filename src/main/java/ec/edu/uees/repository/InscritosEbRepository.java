package ec.edu.uees.repository;

import ec.edu.uees.entities.mapper.InscritosEB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InscritosEbRepository extends JpaRepository<InscritosEB, Integer> {

    @Query(value = "select " +
            "p.id_persona as idPersona, " +
            "p.nombres as nombres, " +
            "p.cedula as cedula, " +
            "p.correo as correo, " +
            "p.telefono as telefono, " +
            "I.fecha as fecha " +
            "from " +
            "inscripcion i " +
            "inner join usuario u  " +
            "on " +
            "u.id_usuario = i.id_usuario " +
            "inner join persona p  " +
            "on " +
            "p.id_persona = u.id_persona " +
            "where " +
            "i.id_evento = :codigoEvento", nativeQuery = true)
    List<InscritosEB> getAllInscritosByEvento(int codigoEvento);
}

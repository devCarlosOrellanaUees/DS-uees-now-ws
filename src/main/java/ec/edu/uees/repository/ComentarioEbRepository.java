package ec.edu.uees.repository;

import ec.edu.uees.entities.mapper.ComentarioEB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComentarioEbRepository extends JpaRepository<ComentarioEB, Integer> {

    @Query(value = "select " +
            "c.id_comentario as idComentario, " +
            "p.nombres as autor, " +
            "c.comentario as texto, " +
            "c.fecha as fecha " +
            "from " +
            "comentario c " +
            "inner join usuario u " +
            "on " +
            "u.id_usuario = c.id_usuario " +
            "inner join persona p " +
            "on " +
            "p.id_persona = u.id_persona " +
            "where c.id_evento = :codigoEvento", nativeQuery = true)
    List<ComentarioEB> getAllComentarios(int codigoEvento);
}

package ec.edu.uees.repository;

import ec.edu.uees.entities.EventoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventoRepository extends JpaRepository<EventoDTO, Integer> {

    @Query("SELECT e FROM EventoDTO e WHERE e.estado=:estado ORDER BY e.idEvento DESC")
    List<EventoDTO> getAllEvento(int estado);

    @Query(value = "SELECT JSON_ARRAY( " +
            "COALESCE(SUM(MONTH(fecha_inicio) = 1), 0), " +
            "COALESCE(SUM(MONTH(fecha_inicio) = 2), 0), " +
            "COALESCE(SUM(MONTH(fecha_inicio) = 3), 0), " +
            "COALESCE(SUM(MONTH(fecha_inicio) = 4), 0), " +
            "COALESCE(SUM(MONTH(fecha_inicio) = 5), 0), " +
            "COALESCE(SUM(MONTH(fecha_inicio) = 6), 0), " +
            "COALESCE(SUM(MONTH(fecha_inicio) = 7), 0), " +
            "COALESCE(SUM(MONTH(fecha_inicio) = 8), 0), " +
            "COALESCE(SUM(MONTH(fecha_inicio) = 9), 0), " +
            "COALESCE(SUM(MONTH(fecha_inicio) = 10), 0), " +
            "COALESCE(SUM(MONTH(fecha_inicio) = 11), 0), " +
            "COALESCE(SUM(MONTH(fecha_inicio) = 12), 0) " +
            ") AS eventos_por_mes " +
            "FROM evento " +
            "WHERE YEAR(fecha_inicio) = :anio", nativeQuery = true)
    String getEventosPorMes(@Param("anio") int anio);

    @Query(value = "select count(e.id_evento) as eventos from evento e", nativeQuery = true)
    Integer countEventos();

    @Query(value = "select count(p.id_persona) as personas from persona p", nativeQuery = true)
    Integer countPersonas();

    @Query(value = "select count(c.id_comentario) as comentarios from comentario c", nativeQuery = true)
    Integer countOpiniones();
}

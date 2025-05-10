package ec.edu.uees.repository;

import ec.edu.uees.entities.mapper.EventosInscritosEB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventosInscritosEbRepository extends JpaRepository<EventosInscritosEB, Integer> {

    @Query(value = "select " +
            "e.id_evento as codigoEvento, " +
            "e.nombre as nombre, " +
            "e.fecha_inicio as fechaInicio, " +
            "e.fecha_fin as fechaFin, " +
            "e.cantidad_aforo as aforo, " +
            "e.inscritos as inscritos, " +
            "e.estado as estado, " +
            "c.nombre as categoria  " +
            "from " +
            "evento e " +
            "inner join inscripcion i " +
            "on " +
            "e.id_evento = i.id_evento " +
            "inner join categoria c  " +
            "on c.id_categoria = e.id_categoria " +
            "group by " +
            "e.id_evento " +
            "order by " +
            "e.id_evento desc", nativeQuery = true)
    List<EventosInscritosEB> eventosInscritos();
}

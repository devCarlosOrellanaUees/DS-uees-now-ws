package ec.edu.uees.repository;

import ec.edu.uees.entities.mapper.EventoEB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventoEbRepository extends JpaRepository<EventoEB, Integer> {

    @Query(value = "select " +
            "e.id_evento as idEvento," +
            "e.nombre as nombre," +
            "e.fecha_inicio as fechaInicio," +
            "e.fecha_fin as fechaFin," +
            "e.cantidad_aforo as cantidadAforo," +
            "e.estado as estado," +
            "e.banner as banner," +
            "e.descripcion as descripcion," +
            "c.nombre as nombreCategoria," +
            "e.inscritos as inscritos " +
            "from " +
            "evento e " +
            "inner join categoria c " +
            "on " +
            "e.id_categoria = c.id_categoria " +
            "where " +
            "e.estado = 1 " +
            "and not exists ( " +
            "select " +
            "1 " +
            "from " +
            "inscripcion i " +
            "where " +
            "i.id_evento = e.id_evento " +
            "and i.id_usuario = :codigoUsuario " +
            "and i.estado = 1" +
            ") " +
            "order by e.id_evento desc", nativeQuery = true)
    List<EventoEB> getEventosDisponibles(int codigoUsuario);

    @Query(value = "select " +
            "e.id_evento as idEvento," +
            "e.nombre as nombre," +
            "e.fecha_inicio as fechaInicio," +
            "e.fecha_fin as fechaFin," +
            "e.cantidad_aforo as cantidadAforo," +
            "e.estado as estado," +
            "e.banner as banner," +
            "e.descripcion as descripcion," +
            "c.nombre as nombreCategoria," +
            "e.inscritos as inscritos " +
            "from " +
            "evento e " +
            "inner join inscripcion i on " +
            "e.id_evento = i.id_evento " +
            "inner join categoria c  " +
            "on " +
            "e.id_categoria = c.id_categoria " +
            "where " +
            "e.estado = 1 " +
            "and i.id_usuario = :codigoUsuario " +
            "and i.estado = 1 " +
            "order by " +
            "i.id_inscripcion desc", nativeQuery = true)
    List<EventoEB> getEventosInscritos(int codigoUsuario);
}

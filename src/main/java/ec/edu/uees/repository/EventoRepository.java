package ec.edu.uees.repository;

import ec.edu.uees.entities.EventoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventoRepository extends JpaRepository<EventoDTO, Integer> {

    @Query("SELECT e FROM EventoDTO e WHERE e.estado=:estado ORDER BY e.idEvento DESC")
    List<EventoDTO> getAllEvento(int estado);
}

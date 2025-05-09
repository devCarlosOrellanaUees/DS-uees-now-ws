package ec.edu.uees.repository;

import ec.edu.uees.entities.ComentarioDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComentarioRepository extends JpaRepository<ComentarioDTO, Integer> {
}

package ec.edu.uees.repository;

import ec.edu.uees.entities.InscripcionDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InscripcionRepository extends JpaRepository<InscripcionDTO, Integer> {
}

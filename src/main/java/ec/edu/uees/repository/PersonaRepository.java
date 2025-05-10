package ec.edu.uees.repository;

import ec.edu.uees.entities.PersonaDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<PersonaDTO, Integer> {
}

package ec.edu.uees.repository;

import ec.edu.uees.entities.RolDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RolRepository extends JpaRepository<RolDTO, Integer> {

    List<RolDTO> findAll();
}

package ec.edu.uees.repository;

import ec.edu.uees.entities.UsuarioDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioDTO, Integer> {

    UsuarioDTO findByUserAndPassword(String user, String password);
}

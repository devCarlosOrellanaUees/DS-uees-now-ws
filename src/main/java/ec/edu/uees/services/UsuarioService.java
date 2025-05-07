package ec.edu.uees.services;

import ec.edu.uees.repository.UsuarioRepository;
import ec.edu.uees.util.ResponseEB;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UsuarioService {

    private static final Logger log = LogManager.getLogger(UsuarioService.class);

    @Autowired
    private UsuarioRepository usuarioRepository;

    public ResponseEB login(String user, String password) {
        try {
            var usuario = usuarioRepository.findByUserAndPassword(user, password);
            if (usuario == null) {
                return ResponseEB.builder().status(-1).message("Credenciales inválidas").build();
            }
            return ResponseEB.builder().status(1).message("Bienvenido").data(usuario).build();
        } catch (Exception e) {
            log.error("[ERROR] ---> "+e);
            return ResponseEB.builder().status(-1).message("ERROR").build();
        }
    }
}





package ec.edu.uees.services;

import ec.edu.uees.repository.PersonaRepository;
import ec.edu.uees.repository.UsuarioRepository;
import ec.edu.uees.util.ResponseEB;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;


@Service
public class UsuarioService {

    private static final Logger log = LogManager.getLogger(UsuarioService.class);

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PersonaRepository personaRepository;

    public ResponseEB login(String user, String password) {
        try {
            var usuario = usuarioRepository.findByUserAndPassword(user, password);
            if (usuario == null) {
                return ResponseEB.builder().status(-1).message("Credenciales inválidas").build();
            }
            var persona = personaRepository.findById(usuario.getIdPersona()).get();
            HashMap<String, Object> data = new HashMap<>();
            data.put("user", usuario);
            data.put("persona", persona);

            return ResponseEB.builder().status(1).message("Bienvenido").data(data).build();
        } catch (Exception e) {
            log.error("[ERROR] ---> " + e);
            return ResponseEB.builder().status(-1).message("ERROR").build();
        }
    }
}





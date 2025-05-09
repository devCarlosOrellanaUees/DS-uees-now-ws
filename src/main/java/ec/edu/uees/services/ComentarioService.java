package ec.edu.uees.services;

import ec.edu.uees.entities.ComentarioDTO;
import ec.edu.uees.entities.mapper.ComentarioEB;
import ec.edu.uees.entities.mapper.EventoEB;
import ec.edu.uees.repository.ComentarioEbRepository;
import ec.edu.uees.repository.ComentarioRepository;
import ec.edu.uees.util.ResponseEB;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComentarioService {

    private static final Logger log = LogManager.getLogger(ComentarioService.class);

    @Autowired
    private ComentarioRepository comentarioRepository;

    @Autowired
    private ComentarioEbRepository comentarioEbRepository;

    public ResponseEB saveComentario(ComentarioDTO comentario) {
        try {
            var response = comentarioRepository.save(comentario);
            return ResponseEB.builder().status(1).message("Comentario guardado").data(response).build();
        } catch (Exception e) {
            log.error("[ERROR] ----> {}", e.getLocalizedMessage());
            return ResponseEB.builder().status(-1).message("Error al guardar comentario").build();
        }
    }

    public ResponseEB getAllComentarios(int codigoEvento) {
        List<ComentarioEB> comentarios = comentarioEbRepository.getAllComentarios(codigoEvento);
        if (comentarios != null && !comentarios.isEmpty()) {
            return ResponseEB.builder().status(1).message("Comentarios").data(comentarios).build();
        } else {
            return ResponseEB.builder().status(-1).message("Error al traer comentarios").build();
        }
    }
}

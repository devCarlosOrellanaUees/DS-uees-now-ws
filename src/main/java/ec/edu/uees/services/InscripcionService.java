package ec.edu.uees.services;

import ec.edu.uees.entities.EventoDTO;
import ec.edu.uees.entities.InscripcionDTO;
import ec.edu.uees.entities.mapper.EventosInscritosEB;
import ec.edu.uees.entities.mapper.InscritosEB;
import ec.edu.uees.repository.EventoRepository;
import ec.edu.uees.repository.InscripcionRepository;
import ec.edu.uees.repository.InscritosEbRepository;
import ec.edu.uees.util.ResponseEB;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InscripcionService {

    private static final Logger log = LogManager.getLogger(InscripcionService.class);

    @Autowired
    private InscripcionRepository inscripcionRepository;

    @Autowired
    private EventoRepository eventoRepository;

    @Autowired
    private InscritosEbRepository inscritosEbRepository;

    @Transactional
    public ResponseEB saveInscripcion(InscripcionDTO inscripcion) {
        try {
            var response = inscripcionRepository.save(inscripcion);
            EventoDTO evento = eventoRepository.findById(inscripcion.getIdEvento()).get();
            evento.setInscritos(evento.getInscritos() + 1);
            eventoRepository.save(evento);


            return ResponseEB.builder().status(1).message("Se ha inscrito en el evento correctamente").data(response).build();
        } catch (Exception e) {
            log.error("[ERROR] ----> {}", e.getLocalizedMessage());
            return ResponseEB.builder().status(-1).message("Se podujo un error al crear inscripcion").build();
        }
    }

    public ResponseEB getAllInscritosByEvento(int codigoEvento) {
        List<InscritosEB> inscritos = inscritosEbRepository.getAllInscritosByEvento(codigoEvento);
        if (inscritos != null && !inscritos.isEmpty()) {
            return ResponseEB.builder().status(1).message("Inscritos recuperados").data(inscritos).build();
        } else {
            return ResponseEB.builder().status(-1).message("Se produjo un error al recuperar inscritos").build();
        }
    }
}

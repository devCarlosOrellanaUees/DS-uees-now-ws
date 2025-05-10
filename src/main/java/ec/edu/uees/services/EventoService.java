package ec.edu.uees.services;

import ec.edu.uees.entities.EventoDTO;
import ec.edu.uees.entities.mapper.EventoEB;
import ec.edu.uees.entities.mapper.EventosInscritosEB;
import ec.edu.uees.repository.EventoEbRepository;
import ec.edu.uees.repository.EventoRepository;
import ec.edu.uees.repository.EventosInscritosEbRepository;
import ec.edu.uees.util.ResponseEB;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoService {

    private static final Logger log = LogManager.getLogger(UsuarioService.class);

    @Autowired
    private EventoRepository eventoRepository;

    @Autowired
    private EventoEbRepository eventoEbRepository;

    @Autowired
    private EventosInscritosEbRepository eventosInscritosEbRepository;

    public ResponseEB saveEvento(EventoDTO evento) {
        try {
            var response = eventoRepository.save(evento);
            return ResponseEB.builder().status(1).message("Evento creado con éxito").data(response).build();
        } catch (Exception e) {
            log.error("[ERROR] ----> {}", e.getLocalizedMessage());
            return ResponseEB.builder().status(-1).message("Se podujo un error al crear evento").build();
        }
    }

    public ResponseEB getAll(int estado) {
        try {
            List<EventoDTO> response = eventoRepository.getAllEvento(estado);
            if (!response.isEmpty()) {
                return ResponseEB.builder().status(1).message("Eventos recuperados correctamente").data(response).build();
            } else {
                return ResponseEB.builder().status(-1).message("No se encontraron eventos").build();
            }
        } catch (Exception e) {
            log.error("[ERROR] ----> {}", e.getLocalizedMessage());
            return ResponseEB.builder().status(-1).message("Se podujo un error listar eventos").build();
        }
    }

    public ResponseEB getAllDisponibles(int codigoUsuario) {
        List<EventoEB> eventos = eventoEbRepository.getEventosDisponibles(codigoUsuario);
        if (eventos != null && !eventos.isEmpty()) {
            return ResponseEB.builder().status(1).message("Eventos disponibles").data(eventos).build();
        } else {
            return ResponseEB.builder().status(-1).message("No tiene eventos disponibles").build();
        }
    }

    public ResponseEB getAllEventosInscritoByUsuario(int codigoUsuario) {
        List<EventoEB> eventos = eventoEbRepository.getEventosInscritos(codigoUsuario);
        if (eventos != null && !eventos.isEmpty()) {
            return ResponseEB.builder().status(1).message("Eventos inscritos").data(eventos).build();
        } else {
            return ResponseEB.builder().status(-1).message("No tiene eventos inscritos").build();
        }
    }

    public ResponseEB getAllEventosInscritos() {
        List<EventosInscritosEB> eventos = eventosInscritosEbRepository.eventosInscritos();
        if (eventos != null && !eventos.isEmpty()) {
            return ResponseEB.builder().status(1).message("Eventos inscritos").data(eventos).build();
        } else {
            return ResponseEB.builder().status(-1).message("No tiene eventos inscritos").build();
        }
    }
}

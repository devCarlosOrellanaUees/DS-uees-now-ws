package ec.edu.uees.controller;

import ec.edu.uees.entities.EventoDTO;
import ec.edu.uees.services.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/evento")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @PostMapping("/save")
    public ResponseEntity<?> saveEvento(@RequestBody EventoDTO evento) {
        return ResponseEntity.ok(eventoService.saveEvento(evento));
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllEventos(@RequestParam Integer estado) {
        return ResponseEntity.ok(eventoService.getAll(estado));
    }

    @GetMapping("/disponibles/usuario")
    public ResponseEntity<?> getAllEventosDisponibles(@RequestParam Integer codigoUsuario) {
        return ResponseEntity.ok(eventoService.getAllDisponibles(codigoUsuario));
    }

    @GetMapping("/inscritos/usuario")
    public ResponseEntity<?> getAllEventosInscritoByUsuario(@RequestParam Integer codigoUsuario) {
        return ResponseEntity.ok(eventoService.getAllEventosInscritoByUsuario(codigoUsuario));
    }

    @GetMapping("/inscritos/all")
    public ResponseEntity<?> getAllEventosInscrito() {
        return ResponseEntity.ok(eventoService.getAllEventosInscritos());
    }
}

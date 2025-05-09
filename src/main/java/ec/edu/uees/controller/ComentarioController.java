package ec.edu.uees.controller;

import ec.edu.uees.entities.ComentarioDTO;
import ec.edu.uees.entities.EventoDTO;
import ec.edu.uees.services.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/comentario")
public class ComentarioController {

    @Autowired
    private ComentarioService comentarioService;

    @PostMapping("/save")
    public ResponseEntity<?> saveEvento(@RequestBody ComentarioDTO comentario) {
        return ResponseEntity.ok(comentarioService.saveComentario(comentario));
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllEventos(@RequestParam Integer codigoEvento) {
        return ResponseEntity.ok(comentarioService.getAllComentarios(codigoEvento));
    }


}

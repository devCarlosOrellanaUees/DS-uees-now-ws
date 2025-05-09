package ec.edu.uees.controller;

import ec.edu.uees.entities.InscripcionDTO;
import ec.edu.uees.services.InscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/inscripcion")
public class InscripcionController {

    @Autowired
    private InscripcionService inscripcionService;

    @PostMapping("/save")
    public ResponseEntity<?> saveEvento(@RequestBody InscripcionDTO inscripcion) {
        return ResponseEntity.ok(inscripcionService.saveInscripcion(inscripcion));
    }
}

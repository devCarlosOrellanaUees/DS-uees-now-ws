package ec.edu.uees.controller;

import ec.edu.uees.pojo.CredencialesEB;
import ec.edu.uees.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping(value = "/login", produces = "application/json")
    public ResponseEntity<?> login(@RequestBody CredencialesEB credencialesEB) {
        return ResponseEntity.ok(usuarioService.login(credencialesEB.getUser(), credencialesEB.getPassword()));
    }
}

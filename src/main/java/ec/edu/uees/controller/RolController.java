package ec.edu.uees.controller;

import ec.edu.uees.services.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/rol")
public class RolController {

    @Autowired
    private RolService rolService;

    @GetMapping("/all")
    public ResponseEntity<?> findAllRoles() {
        return ResponseEntity.ok(rolService.findAllRoles());
    }
}

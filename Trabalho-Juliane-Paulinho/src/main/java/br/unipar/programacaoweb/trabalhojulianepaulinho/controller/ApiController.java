package br.unipar.programacaoweb.trabalhojulianepaulinho.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class ApiController {

    @GetMapping(path = "/api/hello")
    public ResponseEntity<String> getAll() {
        return ResponseEntity.ok("Hello World! I'm here");
    }

}

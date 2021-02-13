package com.adritec96.apiCites.controller;

import com.adritec96.apiCites.dto.DiagnosticoRequest;
import com.adritec96.apiCites.dto.DiagnosticoResponse;
import com.adritec96.apiCites.services.IDiagnosticoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/diagnosticos")
public class DiagnosticoController {
    @Autowired
    private IDiagnosticoService diagnosticoService;

    @PostMapping("/{id}")
    public ResponseEntity<?> create (@RequestBody DiagnosticoRequest diagnostico, @PathVariable(name = "id") int idCita){
        diagnosticoService.save(diagnostico,idCita);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> read ( @PathVariable int id){
        DiagnosticoResponse diagnostico = diagnosticoService.getById(id);
        return diagnostico == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(diagnostico);
    }

}

package com.adritec96.apiCites.controller;

import com.adritec96.apiCites.dto.DiagnosticoRequest;
import com.adritec96.apiCites.dto.DiagnosticoResponse;
import com.adritec96.apiCites.services.DiagnosticoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/diagnosticos")
public class DiagnosticoController {
    @Autowired
    private DiagnosticoService diagnosticoService;

    @PostMapping("/{idCita}")
    public ResponseEntity<?> create (@RequestBody DiagnosticoRequest diagnostico, @PathVariable int idCita){
        if( diagnostico == null || idCita <= 0 ) return ResponseEntity.badRequest().build();
        return ResponseEntity.status(HttpStatus.CREATED).body( diagnosticoService.save(diagnostico,idCita) );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> read ( @PathVariable int id){
        DiagnosticoResponse diagnostico = diagnosticoService.getById(id);
        return diagnostico == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(diagnostico);
    }

}

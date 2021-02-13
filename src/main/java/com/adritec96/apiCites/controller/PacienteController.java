package com.adritec96.apiCites.controller;


import com.adritec96.apiCites.dto.PacienteRequest;
import com.adritec96.apiCites.dto.PacienteResponse;
import com.adritec96.apiCites.services.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    @Autowired
    private IPacienteService pacienteService;

    @GetMapping
    public ResponseEntity<?> getAll (){
        return ResponseEntity.ok(pacienteService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> read (@PathVariable int id){
        PacienteResponse paciente = pacienteService.getById(id);
        return paciente == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(paciente);
    }

    @PostMapping
    public ResponseEntity<?> create (@RequestBody PacienteRequest paciente){
        pacienteService.save(paciente);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}

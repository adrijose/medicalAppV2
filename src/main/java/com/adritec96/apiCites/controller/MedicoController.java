package com.adritec96.apiCites.controller;

import com.adritec96.apiCites.dto.MedicoRequest;
import com.adritec96.apiCites.dto.MedicoResponse;
import com.adritec96.apiCites.services.IMedicoService;
import com.adritec96.apiCites.services.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
    @Autowired
    private IMedicoService medicoService;
    @Autowired
    private IPacienteService pacienteService;

    @PostMapping
    public ResponseEntity<?> create (@RequestBody MedicoRequest medico){
        medicoService.save(medico);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<?> getAll (){
        return ResponseEntity.status(HttpStatus.OK).body(medicoService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> read (@PathVariable int id){
        MedicoResponse medicoResponse = medicoService.getById(id);
        return ResponseEntity.ok(medicoResponse);
    }

    @PutMapping("/{idMedico}/addPaciente")
    public ResponseEntity<?> addPacciente (@PathVariable int idMedico, @RequestParam int id){
        medicoService.asignarPaciente(idMedico,id);
        return ResponseEntity.status(HttpStatus.CREATED).body("OK");
    }



}

package com.adritec96.apiCites.controller;

import com.adritec96.apiCites.Share.ExistRelation;
import com.adritec96.apiCites.Share.NotFound;
import com.adritec96.apiCites.dto.MedicoRequest;
import com.adritec96.apiCites.dto.MedicoResponse;
import com.adritec96.apiCites.services.MedicoService;
import com.adritec96.apiCites.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/medicos")
public class MedicoController {
    @Autowired
    private MedicoService medicoService;
    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public ResponseEntity<?> getAll (){
        return ResponseEntity.status(HttpStatus.OK).body(medicoService.getAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> read (@PathVariable int id){
        MedicoResponse medicoResponse = medicoService.getById(id);
        return ResponseEntity.ok(medicoResponse);
    }

    @PostMapping
    public ResponseEntity<?> create (@RequestBody MedicoRequest medico){
        MedicoResponse result = medicoService.save(medico);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @PutMapping("/{idMedico}/addPaciente")
    public ResponseEntity<?> addPacciente (@PathVariable int idMedico, @RequestParam int idPaciente) throws NotFound, ExistRelation {
        medicoService.asignarPaciente(idMedico,idPaciente);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


}

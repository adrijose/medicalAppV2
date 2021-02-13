package com.adritec96.apiCites.controller;

import com.adritec96.apiCites.dto.CitaRequest;
import com.adritec96.apiCites.dto.CitaResponse;
import com.adritec96.apiCites.services.CitaService;
import com.adritec96.apiCites.services.MedicoService;
import com.adritec96.apiCites.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/citas")
public class CitaController{
    @Autowired
    private CitaService citaService;
    @Autowired
    private MedicoService medicoService;
    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(citaService.getAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getById( @PathVariable(name = "id") int idCita){
        CitaResponse cita = citaService.getById(idCita);
        return cita == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(cita);
    }

    @GetMapping("/paciente/{id}")
    public ResponseEntity<?> getByPaciente ( @PathVariable(name = "id") int idPaciente){
        List<CitaResponse> citas = citaService.getCitesByPaciente(idPaciente);
        return ResponseEntity.ok(citas);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CitaRequest cita, @RequestParam int idMedico, @RequestParam int idPaciente)  {
         citaService.save(cita,idMedico,idPaciente);
         return ResponseEntity.status(HttpStatus.CREATED).build();
    }


}

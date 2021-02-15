package com.adritec96.apiCites.controller;


import com.adritec96.apiCites.Share.ErrorInfo;
import com.adritec96.apiCites.Share.NotFound;
import com.adritec96.apiCites.dto.PacienteRequest;
import com.adritec96.apiCites.dto.PacienteResponse;
import com.adritec96.apiCites.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public ResponseEntity<?> getAll (){
        return ResponseEntity.ok(pacienteService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById (@PathVariable int id) throws NotFound {
        return ResponseEntity.ok( pacienteService.getById(id) );
    }

    @PostMapping
    public ResponseEntity<?> create (@RequestBody PacienteRequest paciente){
        PacienteResponse response = pacienteService.save(paciente);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> edit (@RequestBody PacienteRequest paciente, @PathVariable int id) throws NotFound {
        return ResponseEntity.status(HttpStatus.CREATED).body( pacienteService.edit(paciente,id) );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable int id) throws IllegalArgumentException {
        try{
            pacienteService.delete(id);
            return ResponseEntity.ok().build();
        }catch (IllegalArgumentException ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body( new ErrorInfo(400,"Id no valido", null) );
        }
    }


}

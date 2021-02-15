package com.adritec96.apiCites.services;

import com.adritec96.apiCites.Share.NotFound;
import com.adritec96.apiCites.dto.PacienteRequest;
import com.adritec96.apiCites.dto.PacienteResponse;


import java.util.List;

public interface PacienteService {
    PacienteResponse getById(int id) throws NotFound;
    PacienteResponse getByNns( String nns) throws NotFound;
    PacienteResponse save(PacienteRequest medico);
    void delete(int id);
    List<PacienteResponse> getAll();
    PacienteResponse edit(PacienteRequest paciente, int id) throws NotFound;

}



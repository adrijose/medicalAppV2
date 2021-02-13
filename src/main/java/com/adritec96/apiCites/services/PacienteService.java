package com.adritec96.apiCites.services;

import com.adritec96.apiCites.dto.PacienteRequest;
import com.adritec96.apiCites.dto.PacienteResponse;


import java.util.List;

public interface PacienteService {
    PacienteResponse getById(int id);
    PacienteResponse save(PacienteRequest medico);
    void delete(int id);
    List<PacienteResponse> getAll();

}



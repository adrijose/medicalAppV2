package com.adritec96.apiCites.services;

import com.adritec96.apiCites.dto.PacienteRequest;
import com.adritec96.apiCites.dto.PacienteResponse;


import java.util.List;

public interface IPacienteService  {
    PacienteResponse getById(int id);
    void save(PacienteRequest medico);
    void delete(int id);
    List<PacienteResponse> getAll();

}



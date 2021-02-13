package com.adritec96.apiCites.services;

import com.adritec96.apiCites.dto.DiagnosticoRequest;
import com.adritec96.apiCites.dto.DiagnosticoResponse;

import java.util.List;

public interface DiagnosticoService {
    DiagnosticoResponse getById(int id);
    DiagnosticoResponse save(DiagnosticoRequest diagnostico, int idCita);
    void delete(int id);
    List<DiagnosticoResponse> getAll();
}

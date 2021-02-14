package com.adritec96.apiCites.services;

import com.adritec96.apiCites.Share.NotFound;
import com.adritec96.apiCites.dto.DiagnosticoRequest;
import com.adritec96.apiCites.dto.DiagnosticoResponse;

import java.util.List;

public interface DiagnosticoService {
    DiagnosticoResponse getById(int id) throws NotFound;
    DiagnosticoResponse getByCita(int id) throws NotFound;
    DiagnosticoResponse save(DiagnosticoRequest diagnostico, int idCita);
    void delete(int id);
    List<DiagnosticoResponse> getAll();

}

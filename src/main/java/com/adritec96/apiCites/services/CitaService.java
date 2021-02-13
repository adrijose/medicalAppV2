package com.adritec96.apiCites.services;

import com.adritec96.apiCites.dto.CitaRequest;
import com.adritec96.apiCites.dto.CitaResponse;

import java.util.List;

public interface CitaService {
    CitaResponse getById(int id);
    CitaResponse save(CitaRequest cita, int idMedico, int idPaciente);
    void delete(int id);
    List<CitaResponse> getAll();
    List<CitaResponse> getCitesByPaciente(int idPaciente);
}

package com.adritec96.apiCites.services;

import com.adritec96.apiCites.Share.NotFound;
import com.adritec96.apiCites.dto.CitaRequest;
import com.adritec96.apiCites.dto.CitaResponse;

import java.util.List;

public interface CitaService {
    CitaResponse getById(int id) throws NotFound;
    CitaResponse save(CitaRequest cita, int idMedico, int idPaciente);
    void delete(int id);
    List<CitaResponse> getAll();
    List<CitaResponse> getCitesByPaciente(int idPaciente) throws NotFound;
}

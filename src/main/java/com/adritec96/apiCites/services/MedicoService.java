package com.adritec96.apiCites.services;


import com.adritec96.apiCites.Share.ExistRelation;
import com.adritec96.apiCites.Share.NotFound;
import com.adritec96.apiCites.dto.MedicoRequest;
import com.adritec96.apiCites.dto.MedicoResponse;

import java.util.List;

public interface MedicoService {
    MedicoResponse getById(int id);
    MedicoResponse save(MedicoRequest medico);
    void delete(int id);
    List<MedicoResponse> getAll();
    // Asignar paciente
    void asignarPaciente(int idMedico, int idCliente ) throws NotFound, ExistRelation;

}

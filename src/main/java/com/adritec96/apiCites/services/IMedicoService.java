package com.adritec96.apiCites.services;


import com.adritec96.apiCites.dto.MedicoRequest;
import com.adritec96.apiCites.dto.MedicoResponse;

import java.util.List;

public interface IMedicoService {
    MedicoResponse getById(int id);
    void save(MedicoRequest medico);
    void delete(int id);
    List<MedicoResponse> getAll();
    // Asignar paciente
    void asignarPaciente(int idMedico, int idCliente );

}

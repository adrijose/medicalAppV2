package com.adritec96.apiCites.services;

import com.adritec96.apiCites.dto.PacienteRequest;
import com.adritec96.apiCites.dto.PacienteResponse;
import com.adritec96.apiCites.model.Paciente;
import com.adritec96.apiCites.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PacienteService implements IPacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Override
    @Transactional( readOnly = true )
    public PacienteResponse getById(int id) {
        Optional<Paciente> paciente = pacienteRepository.findById(id);
        return PacienteResponse.toResponse(paciente.get());
    }

    @Override
    @Transactional( readOnly = true )
    public List<PacienteResponse> getAll() {
        List<Paciente> pacientes = pacienteRepository.findAll();
        return pacientes.stream()
                .map(PacienteResponse::toResponse)
                .collect(Collectors.toList() );
    }

    @Override
    @Transactional
    public void save(PacienteRequest paciente) {
        Paciente nuevoPaciente = paciente.toModel();
        pacienteRepository.save(nuevoPaciente);
    }

    @Override
    @Transactional
    public void delete(int id) {
        pacienteRepository.deleteById(id);
    }


}
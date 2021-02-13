package com.adritec96.apiCites.services;

import com.adritec96.apiCites.dto.CitaRequest;
import com.adritec96.apiCites.dto.CitaResponse;
import com.adritec96.apiCites.model.entity.Cita;
import com.adritec96.apiCites.repository.CitaRepository;
import com.adritec96.apiCites.model.entity.Medico;
import com.adritec96.apiCites.repository.MedicoRepository;
import com.adritec96.apiCites.model.entity.Paciente;
import com.adritec96.apiCites.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CitaServiceImpl implements CitaService {

    @Autowired
    private CitaRepository citaRepository;
    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private MedicoRepository medicoRepository;

    @Override
    @Transactional(readOnly = true)
    public CitaResponse getById(int id) {
        Optional<Cita> cita = citaRepository.findById(id);
        if(!cita.isPresent()) return null; //////////////////////////// throw
        return CitaResponse.toResponse(cita.get());
    }

    @Override
    @Transactional(readOnly = true)
    public List<CitaResponse> getAll() {
        List<Cita> citas =  citaRepository.findAll();
        return citas.stream().map(CitaResponse::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<CitaResponse> getCitesByPaciente(int idPaciente) {
        Optional<Paciente> paciente = pacienteRepository.findById(idPaciente);
        if(!paciente.isPresent()) return null; //////////////////////////// throw
        List<Cita> citasPaciente = citaRepository.findByPaciente(paciente.get());
        return citasPaciente.stream().map(CitaResponse::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public CitaResponse save(CitaRequest cita, int idMedico, int idPaciente) {
        Optional<Medico> medico = medicoRepository.findById(idMedico);
        Optional<Paciente> paciente = pacienteRepository.findById(idPaciente);

        Cita nuevaCita = cita.toModel();
        nuevaCita.setMedico(medico.get());
        nuevaCita.setPaciente(paciente.get());

        return CitaResponse.toResponse(citaRepository.save(nuevaCita));
    }

    @Override
    @Transactional
    public void delete(int id) {
        citaRepository.deleteById(id);
    }





}

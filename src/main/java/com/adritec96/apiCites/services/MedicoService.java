package com.adritec96.apiCites.services;

import com.adritec96.apiCites.dto.MedicoRequest;
import com.adritec96.apiCites.dto.MedicoResponse;
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
public class MedicoService implements IMedicoService {

    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    private PacienteRepository pacienteRepository;


    @Override
    @Transactional( readOnly = true )
    public MedicoResponse getById(int id) {
        Optional<Medico> medico = medicoRepository.findById(id);
        return MedicoResponse.toResponse(medico.get());
    }

    @Override
    @Transactional
    public void save(MedicoRequest medico) {
        Medico nuevoMedico = medico.toModel();
        medicoRepository.save(nuevoMedico);
    }

    @Override
    @Transactional
    public void delete(int id) {
        medicoRepository.deleteById(id);
    }

    @Override
    public List<MedicoResponse> getAll() {
        List<Medico> medicos = medicoRepository.findAll();
        return medicos.stream().map(MedicoResponse::toResponse)
                .collect(Collectors.toList());
    }


    @Override
    @Transactional
    public void asignarPaciente(int idMedio,int idCliente){
        // Obtenemos el paciente y el medico
        Optional<Paciente> paciente = pacienteRepository.findById(idCliente);
        Optional<Medico> medico = medicoRepository.findById(idMedio);
        // Añadimos el paciente al medico
        List<Paciente> pacientes = medico.get().getPacientes();
        pacientes.add(paciente.get());
        // Añadimos el medico al paciente
        List<Medico> medicos = paciente.get().getMedicos();
        medicos.add(medico.get());
        // Guardamos en los repositorios
        medicoRepository.save(medico.get());
        pacienteRepository.save(paciente.get());
    }

}

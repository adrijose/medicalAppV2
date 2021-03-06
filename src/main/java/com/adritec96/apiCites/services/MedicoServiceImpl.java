package com.adritec96.apiCites.services;

import com.adritec96.apiCites.Share.ExistRelation;
import com.adritec96.apiCites.Share.NotFound;
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
public class MedicoServiceImpl implements MedicoService {

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
    public MedicoResponse save(MedicoRequest medico) {
        Medico nuevoMedico = medico.toModel();
        return MedicoResponse.toResponse(medicoRepository.save(nuevoMedico));
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
    public void asignarPaciente(int idMedio,int idPaciente) throws NotFound , ExistRelation {
        // Obtenemos el paciente y el medico
        Optional<Paciente> paciente = pacienteRepository.findById(idPaciente);
        if( !paciente.isPresent() ) throw new NotFound("No existe el paciente con id:"+idPaciente);
        Optional<Medico> medico = medicoRepository.findById(idMedio);
        if( !medico.isPresent() ) throw new NotFound("No existe el medico con id:"+idMedio);

        // Comprobamos si existe la relacion
        for ( Paciente p: medico.get().getPacientes() ) {
            if( p == paciente.get() ) throw new ExistRelation("Ya tiene asignado este paciente");
        }

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

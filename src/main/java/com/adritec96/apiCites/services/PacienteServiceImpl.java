package com.adritec96.apiCites.services;

import com.adritec96.apiCites.Share.NotFound;
import com.adritec96.apiCites.dto.PacienteRequest;
import com.adritec96.apiCites.dto.PacienteResponse;
import com.adritec96.apiCites.model.entity.Paciente;
import com.adritec96.apiCites.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PacienteServiceImpl implements PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Override
    @Transactional( readOnly = true )
    public PacienteResponse getById(int id) throws NotFound {
        Optional<Paciente> paciente = pacienteRepository.findById(id);
        if( !paciente.isPresent() ) throw new NotFound("No existe el usuario con id:"+ id);
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
    @Transactional( readOnly = true )
    public PacienteResponse getByNns( String nns) throws NotFound {
        Paciente paciente = pacienteRepository.findNns(nns);
        if( paciente == null ) throw new NotFound("No existe paciente con nns:" + nns);
        return PacienteResponse.toResponse(paciente);
    }


    @Override
    public PacienteResponse edit(PacienteRequest paciente, int id) throws NotFound {
        Optional<Paciente> oPaciente = pacienteRepository.findById(id);
        if(!oPaciente.isPresent()) throw new NotFound("No existe el paciente con id:"+id);
        Paciente pacienteMod = oPaciente.get();
        pacienteMod.setNombre(paciente.getNombre());
        pacienteMod.setApellidos(paciente.getApellidos());
        pacienteMod.setUsuario(paciente.getUsuario());
        pacienteMod.setClave(paciente.getClave());
        pacienteMod.setNns(paciente.getNns());
        pacienteMod.setNumTarjeta(paciente.getNumTarjeta());
        pacienteMod.setTelefono( paciente.getTelefono() );
        pacienteMod.setDireccion(paciente.getDireccion());
        return PacienteResponse.toResponse( pacienteRepository.save(pacienteMod) );
    }


    @Override
    @Transactional
    public PacienteResponse save(PacienteRequest paciente) {
        Paciente nuevoPaciente = paciente.toModel();
        return PacienteResponse.toResponse(pacienteRepository.save(nuevoPaciente));
    }

    @Override
    @Transactional
    public void delete(int id) throws IllegalArgumentException {
        pacienteRepository.deleteById(id);
    }


}

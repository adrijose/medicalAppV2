package com.adritec96.apiCites.services;

import com.adritec96.apiCites.model.entity.Cita;
import com.adritec96.apiCites.repository.CitaRepository;
import com.adritec96.apiCites.dto.DiagnosticoRequest;
import com.adritec96.apiCites.dto.DiagnosticoResponse;
import com.adritec96.apiCites.model.entity.Diagnostico;
import com.adritec96.apiCites.repository.DiagnosticoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class DiagnosticoService implements IDiagnosticoService {

    @Autowired
    private DiagnosticoRepository diagnosticoRepository;
    @Autowired
    private CitaRepository citaRepository;


    @Override
    @Transactional(readOnly = true)
    public DiagnosticoResponse getById(int id) {
        Optional<Diagnostico> diagnostico = diagnosticoRepository.findById(id);
        if(!diagnostico.isPresent()) return null; ///////////////////////////////////// throw
        return DiagnosticoResponse.toRespose(diagnostico.get());
    }

    @Override
    @Transactional(readOnly = true)
    public List<DiagnosticoResponse> getAll() {
        List<Diagnostico> diagnosticos = diagnosticoRepository.findAll();
        return diagnosticos.stream().map(DiagnosticoResponse::toRespose)
                .collect(Collectors.toList());
    }


    @Override
    @Transactional
    public void save(DiagnosticoRequest diagnostico, int idCita) {
        Optional<Cita> cita = citaRepository.findById(idCita);
        Diagnostico nuevoDiagnostico = diagnostico.toModel();

        nuevoDiagnostico.setCita(cita.get());
        cita.get().setDiagnostico(nuevoDiagnostico);

        diagnosticoRepository.save(nuevoDiagnostico);
        citaRepository.save(cita.get());
    }

    @Override
    @Transactional
    public void delete(int id) {
        diagnosticoRepository.deleteById(id);
    }
}

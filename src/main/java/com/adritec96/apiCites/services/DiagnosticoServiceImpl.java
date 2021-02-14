package com.adritec96.apiCites.services;

import com.adritec96.apiCites.Share.NotFound;
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
public class DiagnosticoServiceImpl implements DiagnosticoService {

    @Autowired
    private DiagnosticoRepository diagnosticoRepository;
    @Autowired
    private CitaRepository citaRepository;


    @Override
    @Transactional(readOnly = true)
    public DiagnosticoResponse getById(int id) throws NotFound {
        Optional<Diagnostico> diagnostico = diagnosticoRepository.findById(id);
        if(!diagnostico.isPresent()) throw new NotFound("No existe la diagnostico con id:" + id);
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
    @Transactional(readOnly = true)
    public DiagnosticoResponse getByCita(int idCita) throws NotFound {
        Optional<Cita> cita = citaRepository.findById(idCita);
        if( !cita.isPresent() ) throw new NotFound("No existe la cita con id:"+ idCita);
        if( cita.get().getDiagnostico() == null ) throw new NotFound("No existe la diagnostico para la cita");
        Optional<Diagnostico> diagnostico = diagnosticoRepository.findById(cita.get().getDiagnostico().getId());
        return DiagnosticoResponse.toRespose(diagnostico.get());
    }

    @Override
    @Transactional
    public DiagnosticoResponse save(DiagnosticoRequest diagnostico, int idCita) {
        Optional<Cita> cita = citaRepository.findById(idCita);
        Diagnostico nuevoDiagnostico = diagnostico.toModel();

        nuevoDiagnostico.setCita( cita.get() );
        cita.get().setDiagnostico(nuevoDiagnostico);

        Diagnostico diagSave = diagnosticoRepository.save(nuevoDiagnostico);
        Cita citaSave = citaRepository.save( cita.get() );

        return DiagnosticoResponse.toRespose(diagSave);
    }

    @Override
    @Transactional
    public void delete(int id) {
        diagnosticoRepository.deleteById(id);
    }


}

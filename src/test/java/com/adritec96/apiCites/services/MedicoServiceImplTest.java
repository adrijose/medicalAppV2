package com.adritec96.apiCites.services;

import com.adritec96.apiCites.dto.MedicoRequest;
import com.adritec96.apiCites.dto.MedicoResponse;
import com.adritec96.apiCites.model.entity.Medico;
import com.adritec96.apiCites.model.entity.MedicoPrototype;
import com.adritec96.apiCites.model.entity.Paciente;
import com.adritec96.apiCites.model.entity.PacientePrototype;
import com.adritec96.apiCites.repository.MedicoRepository;
import com.adritec96.apiCites.repository.PacienteRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ExtendWith(MockitoExtension.class)
class MedicoServiceImplTest {

    @InjectMocks
    private MedicoServiceImpl medicoService;
    @Mock
    private MedicoRepository medicoRepository;
    @Mock
    private PacienteRepository pacienteRepository;


    @Test
    void getById() {
        // Mock data
        Medico mockMedico = MedicoPrototype.create( new ArrayList() );
        // Mock Repository
        Mockito.when( medicoRepository.findById( mockMedico.getId()) )
                .thenReturn( Optional.of(mockMedico) );

        MedicoResponse result = medicoService.getById(mockMedico.getId());
        MedicoResponse expected = MedicoResponse.toResponse(mockMedico);

        Assertions.assertEquals(result,expected);
    }

    @Test
    void save() {
        // Mock data
        MedicoRequest request = MedicoPrototype.createRequest();

        Medico mockMedico = request.toModel();

        // Mock Repository
        Mockito.when( medicoRepository.save(mockMedico) ).thenReturn( mockMedico );

        MedicoResponse result = medicoService.save(request);
        MedicoResponse expected = MedicoResponse.toResponse(mockMedico);

        Mockito.verify(medicoRepository).save(mockMedico);
        Assertions.assertEquals(result,expected);
    }

    @Test
    void delete() {
        // Mock data
        Medico mockMedico = MedicoPrototype.create( new ArrayList() );

        medicoService.delete( mockMedico.getId() );
        Mockito.verify(medicoRepository).deleteById(mockMedico.getId());
    }

    @Test
    void getAll() {
        // Mock data
        List<Medico> mockListMedicos = new ArrayList<>();
        for(int i=0; i<6; i++) mockListMedicos.add( MedicoPrototype.create( new ArrayList() ) );
        // Mock Repository
        Mockito.when( medicoRepository.findAll() ).thenReturn(mockListMedicos);

        List<MedicoResponse> result = medicoService.getAll();
        List<MedicoResponse> expected = mockListMedicos.stream().map(MedicoResponse::toResponse).collect(Collectors.toList());

        Assertions.assertEquals(result,expected);
    }

    @Test
    void asignarPaciente() {
        // Mock data
        Paciente mockPaciente = PacientePrototype.create( new ArrayList() );
        Medico mockMedico = MedicoPrototype.create( new ArrayList() );

        // Mock repository
        Mockito.when( pacienteRepository.findById(mockPaciente.getId()) )
                .thenReturn(Optional.of(mockPaciente) );
        Mockito.when( medicoRepository.findById(mockMedico.getId() ) )
                .thenReturn( Optional.of(mockMedico) );
        Mockito.when( pacienteRepository.save(mockPaciente) )
                .thenReturn(mockPaciente);
        Mockito.when( medicoRepository.save(mockMedico) )
                .thenReturn(mockMedico);

        medicoService.asignarPaciente(mockMedico.getId(),mockPaciente.getId());

        Assertions.assertEquals(mockMedico.getPacientes().contains(mockPaciente), true);
        Assertions.assertEquals(mockPaciente.getMedicos().contains(mockMedico), true);

    }
}
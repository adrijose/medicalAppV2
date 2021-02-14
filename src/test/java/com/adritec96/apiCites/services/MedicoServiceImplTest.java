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
        // Test
        MedicoResponse result = medicoService.getById(mockMedico.getId());
        // Mock Response
        MedicoResponse expected = MedicoResponse.toResponse(mockMedico);
        // Verify
        Assertions.assertEquals(result,expected);
    }

    @Test
    void save() {
        // Mock data
        MedicoRequest request = MedicoPrototype.createRequest();
        Medico mockMedico = request.toModel();
        // Mock Repository
        Mockito.when( medicoRepository.save(mockMedico) ).thenReturn( mockMedico );
        // Test
        MedicoResponse result = medicoService.save(request);
        // Mock Response
        MedicoResponse expected = MedicoResponse.toResponse(mockMedico);
        // Verify
        Mockito.verify(medicoRepository).save(mockMedico); // Check save in BD
        Assertions.assertEquals(result,expected); // Check return
    }

    @Test
    void delete() {
        // Mock data
        Medico mockMedico = MedicoPrototype.create( new ArrayList() );
        // Mock Repository
        // Test
        medicoService.delete( mockMedico.getId() );
        // Mock Response
        // Verify
        Mockito.verify(medicoRepository).deleteById(mockMedico.getId());

    }

    @Test
    void getAll() {
        // Mock data
        List<Medico> mockListMedicos = new ArrayList<>();
        for(int i=0; i<6; i++) mockListMedicos.add( MedicoPrototype.create( new ArrayList() ) );
        // Mock Repository
        Mockito.when( medicoRepository.findAll() ).thenReturn(mockListMedicos);
        // Test
        List<MedicoResponse> result = medicoService.getAll();
        // Mock Response
        List<MedicoResponse> expected = mockListMedicos.stream().map(MedicoResponse::toResponse).collect(Collectors.toList());
        // Verify
        Assertions.assertEquals(result,expected); // Check return
    }

    @Test
    void asignarPaciente() {
        // Mock data
        Paciente mockPaciente = PacientePrototype.create( new ArrayList() );
        Medico mockMedico = MedicoPrototype.create( new ArrayList() );
        // Mock Repository
        Mockito.when( medicoRepository.findById(mockMedico.getId() ) )
                .thenReturn( Optional.of(mockMedico) );
        Mockito.when( pacienteRepository.save(mockPaciente) )
                .thenReturn(mockPaciente);
        Mockito.when( pacienteRepository.findById(mockPaciente.getId()) )
                .thenReturn(Optional.of(mockPaciente) );
        Mockito.when( medicoRepository.save(mockMedico) )
                .thenReturn(mockMedico);
        // Mock Response

        // Test
        medicoService.asignarPaciente(mockMedico.getId(),mockPaciente.getId());

        // Verify
        // Comprobar que se han asignado correctamente
        Assertions.assertEquals(mockMedico.getPacientes().contains(mockPaciente), true);
        Assertions.assertEquals(mockPaciente.getMedicos().contains(mockMedico), true);
        // Comprobar que se han guardado en la bd con las asignaciones
        Mockito.verify(medicoRepository).save(mockMedico);
        Mockito.verify(pacienteRepository).save(mockPaciente);
    }
}

        // Mock data
        // Mock Repository
        // Mock Response
        // Test
        // Verify
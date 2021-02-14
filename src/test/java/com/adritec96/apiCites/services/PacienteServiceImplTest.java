package com.adritec96.apiCites.services;

import com.adritec96.apiCites.dto.PacienteRequest;
import com.adritec96.apiCites.dto.PacienteResponse;
import com.adritec96.apiCites.model.entity.Paciente;
import com.adritec96.apiCites.model.entity.PacientePrototype;
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
class PacienteServiceImplTest {

    @InjectMocks
    private PacienteServiceImpl pacienteService;
    @Mock
    private PacienteRepository pacienteRepository;


    @Test
    void getById() {
        // Mock data
        Paciente mockPaciente = PacientePrototype.create( new ArrayList() );
        // Mock Repository
        Mockito.when( pacienteRepository.findById(mockPaciente.getId()) )
                .thenReturn( Optional.of(mockPaciente) );
        // Test
        PacienteResponse result = pacienteService.getById(mockPaciente.getId());
        // Mock Response
        PacienteResponse expected = PacienteResponse.toResponse(mockPaciente);
        // Verify
        Assertions.assertEquals(result,expected);
    }


    @Test
    void getAll() {
        // Mock data
        List<Paciente> mockPacientes = new ArrayList<>();
        for(int i=0; i<5; i++) mockPacientes.add( PacientePrototype.create( new ArrayList() ) );
        // Mock Repository
        Mockito.when( pacienteRepository.findAll() )
                .thenReturn( mockPacientes );
        // Test
        List<PacienteResponse> result = pacienteService.getAll();
        // Mock Response
        List<PacienteResponse> expected = mockPacientes.stream().map(PacienteResponse::toResponse)
                .collect(Collectors.toList());
        // Verify
        Assertions.assertEquals(result,expected);
    }


    @Test
    void when_save_paciente_it_should_return_pacient() {
        // Mock Data
        PacienteRequest request = PacientePrototype.createRequest();
        Paciente model = request.toModel();
        // Mock Repository
        Mockito.when( pacienteRepository.save( model ) ).thenReturn( model );
        // Test
        PacienteResponse result = pacienteService.save( request );
        // Mock Response
        PacienteResponse expected =  PacienteResponse.toResponse( model );
        expected.setId(result.getId());
        // Verify
        Mockito.verify(pacienteRepository).save( model );
        Assertions.assertEquals(result,expected);
    }


    @Test
    void delete() {
        // Mock data
        Paciente mockPaciente = PacientePrototype.create( new ArrayList() );
        // Mock Repository
        // Test
        pacienteService.delete( mockPaciente.getId() );
        // Mock Response
        // Verify
        Mockito.verify(pacienteRepository).deleteById(mockPaciente.getId());

    }
}
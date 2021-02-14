package com.adritec96.apiCites.services;

import com.adritec96.apiCites.dto.PacienteRequest;
import com.adritec96.apiCites.dto.PacienteResponse;
import com.adritec96.apiCites.model.entity.Paciente;
import com.adritec96.apiCites.model.entity.PacienteTest;
import com.adritec96.apiCites.repository.PacienteRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
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

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PacienteServiceImplTest {

    @InjectMocks
    private PacienteServiceImpl pacienteService;
    @Mock
    private PacienteRepository pacienteRepository;


    @Test
    void getById() {
        // Mock Data
        Paciente mockPaciente = PacienteTest.create( new ArrayList() );
        // Mock Repository
        Mockito.when( pacienteRepository.findById(mockPaciente.getId()) )
                .thenReturn( Optional.of(mockPaciente) );

        PacienteResponse result = pacienteService.getById(mockPaciente.getId());
        PacienteResponse expected = PacienteResponse.toResponse(mockPaciente);

        Assertions.assertEquals(result,expected);
    }

    @Test
    void getAll() {
        // Mock Data
        List<Paciente> mockPacientes = new ArrayList<>();
        for(int i=0; i<5; i++) mockPacientes.add( PacienteTest.create( new ArrayList() ) );
        // Mock Repository
        Mockito.when( pacienteRepository.findAll() )
                .thenReturn( mockPacientes );

        List<PacienteResponse> result = pacienteService.getAll();
        List<PacienteResponse> expected = mockPacientes.stream().map(PacienteResponse::toResponse).collect(Collectors.toList());

        Assertions.assertEquals(result,expected);
    }

    @Test
    void when_save_paciente_it_should_return_pacient() {
        // Mock Data
        PacienteRequest request = PacienteTest.createRequest();
        Paciente model = request.toModel();

        // Mock Repository
        Mockito.when( pacienteRepository.save( model ) ).thenReturn( model );

        PacienteResponse result = pacienteService.save( request );
        PacienteResponse expected =  PacienteResponse.toResponse( model );
        expected.setId(result.getId());

        Mockito.verify(pacienteRepository).save( model );
        Assertions.assertEquals(result,expected);
    }

    @Test
    void delete() {
        Paciente mockPaciente = PacienteTest.create( new ArrayList() );
        pacienteService.delete( mockPaciente.getId() );
        Mockito.verify(pacienteRepository).deleteById(mockPaciente.getId());
    }
}
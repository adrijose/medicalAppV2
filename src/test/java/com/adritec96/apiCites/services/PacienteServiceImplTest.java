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
        // Mok Data
        Paciente mokPaciente = PacienteTest.create();
        // Mok Repository
        Mockito.when( pacienteRepository.findById(mokPaciente.getId()) ).thenReturn( Optional.of(mokPaciente) );

        PacienteResponse result = pacienteService.getById(mokPaciente.getId());
        PacienteResponse expected = PacienteResponse.toResponse(mokPaciente);

        Assertions.assertEquals(result,expected);
    }

    @Test
    void getAll() {
        // Mok Data
        List<Paciente> mokPacientes = new ArrayList<>();
        for(int i=0; i<5; i++) mokPacientes.add( PacienteTest.create() );
        // Mok Repository
        Mockito.when( pacienteRepository.findAll() ).thenReturn( mokPacientes );

        List<PacienteResponse> result = pacienteService.getAll();
        List<PacienteResponse> expected = mokPacientes.stream().map(PacienteResponse::toResponse).collect(Collectors.toList());

        Assertions.assertEquals(result,expected);
    }

    @Test
    void when_save_paciente_it_should_return_pacient() {
        // Mok Data
        PacienteRequest request = new PacienteRequest();
        request.setNombre("pepito");
        request.setApellidos("ramirez");
        request.setUsuario("pepe22");
        request.setClave("325322");
        request.setNns("FSAIKGSAI");
        request.setNumTarjeta("523523253");
        request.setTelefono("611611611");
        request.setDireccion("calle de la pasion");

        // Mok Repository
        Mockito.when( pacienteRepository.save( request.toModel() ) ).thenReturn( request.toModel() );

        PacienteResponse result = pacienteService.save( request );
        PacienteResponse expected =  PacienteResponse.toResponse( request.toModel() );
        expected.setId(result.getId());

        Assertions.assertEquals(result,expected);
    }

    @Test
    void delete() {
        pacienteService.delete(0);
    }
}
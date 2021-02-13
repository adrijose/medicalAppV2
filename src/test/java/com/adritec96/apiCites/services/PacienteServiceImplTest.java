package com.adritec96.apiCites.services;

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

import java.util.Optional;

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

        Mockito.when( pacienteRepository.findById(mokPaciente.getId()) ).thenReturn( Optional.of(mokPaciente) );

        PacienteResponse result = pacienteService.getById(mokPaciente.getId());
        PacienteResponse espec = PacienteResponse.toResponse(mokPaciente);

        Assertions.assertEquals(result,espec);
    }

    @Test
    void getAll() {
    }

    @Test
    void save() {
    }

    @Test
    void delete() {
    }
}
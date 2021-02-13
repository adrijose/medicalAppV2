package com.adritec96.apiCites.controller;

import com.adritec96.apiCites.dto.PacienteRequest;
import com.adritec96.apiCites.dto.PacienteResponse;
import com.adritec96.apiCites.model.entity.Paciente;
import com.adritec96.apiCites.model.entity.PacienteTest;
import com.adritec96.apiCites.services.PacienteService;
import com.adritec96.apiCites.services.PacienteServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(PacienteController.class)
class PacienteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PacienteServiceImpl pacienteService;


    @Test
    void getAll() throws Exception {
        List<PacienteResponse> pacientes = new ArrayList<>();
        for(int i=0;i<5;i++) pacientes.add( PacienteResponse.toResponse(PacienteTest.create() ) );

        Mockito.when( pacienteService.getAll() ).thenReturn(pacientes);

        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/pacientes")
                .contentType(MediaType.APPLICATION_JSON)
                //.content()
        ).andExpect(status().isOk());
    }


//    @Test
//    void read() {
//    }
//
//    @Test
//    void it_should_return_created_paciente() {
//        PacienteRequest request = new PacienteRequest();
//        request.setNombre("pepito");
//        request.setApellidos("ramirez");
//        request.setUsuario("pepe22");
//        request.setClave("325322");
//        request.setNns("FSAIKGSAI");
//        request.setNumTarjeta("523523253");
//        request.setTelefono("611611611");
//        request.setDireccion("calle de la pasion");
//
//        Paciente paciente = request.toModel();
//
//        Mockito.when( pacienteService.save(request) ).thenReturn( PacienteResponse.toResponse(paciente) );
//
//        this.mockMvc.perform(post("/pacientes") )
//                .
//                .contentType(MediaType.APPLICATION_JSON)
//                .con
//                .andExpect(status().is2xxSuccessful());
//
//    }


}
package com.adritec96.apiCites.controller;

import com.adritec96.apiCites.dto.PacienteRequest;
import com.adritec96.apiCites.dto.PacienteResponse;
import com.adritec96.apiCites.model.entity.Paciente;
import com.adritec96.apiCites.model.entity.PacienteTest;
import com.adritec96.apiCites.services.PacienteServiceImpl;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


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

    @Test
    void getById() throws Exception {
            PacienteResponse response = PacienteResponse.toResponse( PacienteTest.create() );

            Mockito.when( pacienteService.getById(response.getId()) ).thenReturn(response);

            this.mockMvc.perform(
                    MockMvcRequestBuilders.get("/pacientes/"+response.getId() )
                            .contentType(MediaType.APPLICATION_JSON)
            ).andExpect(status().isOk());

    }

    @Test
    void it_should_return_created_paciente() throws Exception {
        PacienteRequest request = new PacienteRequest();
        request.setNombre("pepito");
        request.setApellidos("ramirez");
        request.setUsuario("pepe22");
        request.setClave("325322");
        request.setNns("FSAIKGSAI");
        request.setNumTarjeta("523523253");
        request.setTelefono("611611611");
        request.setDireccion("calle de la pasion");

        Paciente paciente = request.toModel();

        Mockito.when( pacienteService.save(request) ).thenReturn( PacienteResponse.toResponse(paciente) );

        Gson gson = new Gson();
        String json = gson.toJson(request);

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/pacientes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content( json )
        ).andExpect(status().isCreated());

    }






}
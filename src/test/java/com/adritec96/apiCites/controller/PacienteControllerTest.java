package com.adritec96.apiCites.controller;

import com.adritec96.apiCites.dto.PacienteRequest;
import com.adritec96.apiCites.dto.PacienteResponse;
import com.adritec96.apiCites.model.entity.Paciente;
import com.adritec96.apiCites.model.entity.PacientePrototype;
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

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
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
        // Mock data
        List<PacienteResponse> response = new ArrayList<>();
        for(int i=0;i<5;i++) response.add( PacientePrototype.createResponse() );
        // Mock Response
        Gson gson = new Gson();
        String responseJson = gson.toJson(response);
        // Mock Repository
        Mockito.when( pacienteService.getAll() ).thenReturn(response);
        // Test & Verify
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/pacientes")
        ).andExpect(status().isOk())
                .andExpect(content().json(responseJson));



    }

    @Test
    void getById() throws Exception {
        // Mock data
        PacienteResponse response = PacientePrototype.createResponse();
        // Mock Repository
        Mockito.when( pacienteService.getById(response.getId()) ).thenReturn(response);
        // Test & Verify
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/pacientes/"+response.getId() )
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());



    }

    @Test
    void it_should_return_created_paciente() throws Exception {
        Gson gson = new Gson();
        // Mock data
        PacienteRequest request = PacientePrototype.createRequest();
        Paciente paciente = request.toModel();
        String requestJson = gson.toJson(request);
        // Mock Response
        PacienteResponse response = PacienteResponse.toResponse(paciente);
        String responseJson = gson.toJson(response);
        // Mock Repository
        Mockito.when( pacienteService.save(request) ).thenReturn( response );
        // Test & Verify
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/pacientes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content( requestJson )
        ).andExpect(status().isCreated())
        .andExpect( content().json(responseJson) );
    }


}

        // Mock data
        // Mock Repository
        // Mock Response
        // Test & Verify
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
        List<PacienteResponse> response = new ArrayList<>();
        for(int i=0;i<5;i++) response.add( PacientePrototype.createResponse() );

        Mockito.when( pacienteService.getAll() ).thenReturn(response);

        Gson gson = new Gson();
        String responseJson = gson.toJson(response);

        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/pacientes")
        ).andExpect(status().isOk())
        .andExpect(content().json(responseJson));
    }

    @Test
    void getById() throws Exception {
            PacienteResponse response = PacientePrototype.createResponse();

            Mockito.when( pacienteService.getById(response.getId()) ).thenReturn(response);

            this.mockMvc.perform(
                    MockMvcRequestBuilders.get("/pacientes/"+response.getId() )
                            .contentType(MediaType.APPLICATION_JSON)
            ).andExpect(status().isOk());

    }

    @Test
    void it_should_return_created_paciente() throws Exception {
        PacienteRequest request = PacientePrototype.createRequest();

        Paciente paciente = request.toModel();
        PacienteResponse response = PacienteResponse.toResponse(paciente);

        Mockito.when( pacienteService.save(request) ).thenReturn( response );

        Gson gson = new Gson();
        String requestJson = gson.toJson(request);
        String responseJson = gson.toJson(response);

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/pacientes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content( requestJson )
        ).andExpect(status().isCreated())
        .andExpect( content().json(responseJson) );

    }






}
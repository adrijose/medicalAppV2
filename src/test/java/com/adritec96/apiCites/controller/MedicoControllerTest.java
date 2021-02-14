package com.adritec96.apiCites.controller;

import com.adritec96.apiCites.dto.MedicoRequest;
import com.adritec96.apiCites.dto.MedicoResponse;
import com.adritec96.apiCites.model.entity.Medico;
import com.adritec96.apiCites.model.entity.MedicoPrototype;
import com.adritec96.apiCites.model.entity.Paciente;
import com.adritec96.apiCites.model.entity.PacientePrototype;
import com.adritec96.apiCites.services.MedicoServiceImpl;
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
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(MedicoController.class)
class MedicoControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private MedicoServiceImpl medicoService;
    @MockBean
    private PacienteServiceImpl pacienteService;

    private Gson gson = new Gson();

    @Test
    void getAll() throws Exception {
        // Mock Data
        List<MedicoResponse> response = new ArrayList<>();
        for(int i=0; i<5; i++) response.add( MedicoPrototype.createResponse() );
        // Mock Repository
        Mockito.when( medicoService.getAll() ).thenReturn(response);
        // Mock Response
        String responseJson = gson.toJson(response);
        // Test & Verify
        this.mockMvc.perform( MockMvcRequestBuilders.get("/medicos") )
                .andExpect( status().isOk() )
                .andExpect( content().json(responseJson) );
    }

    @Test
    void getById() throws Exception {
        // Mock data
        MedicoResponse response = MedicoPrototype.createResponse();
        // Mock Repository
        Mockito.when( medicoService.getById( response.getId() ) )
                .thenReturn( response );
        // Mock Response
        String responseJson = gson.toJson(response);
        // Test & Verify
        this.mockMvc.perform( MockMvcRequestBuilders.get("/medicos/"+response.getId()) )
                .andExpect( status().isOk() )
                .andExpect( content().json(responseJson) );

    }

    @Test
    void create() throws Exception {
        // Mock data
        MedicoRequest request = MedicoPrototype.createRequest();
        String requestJson = gson.toJson(request);
        // Mock Response
        MedicoResponse response = request.toResponse();
        String responseJson = gson.toJson(response);
        // Mock Repository
        Mockito.when( medicoService.save(request) ).thenReturn( response );
        // Test & Verify
        this.mockMvc.perform(
                MockMvcRequestBuilders.post("/medicos")
                .contentType(MediaType.APPLICATION_JSON)
                .content( requestJson ) )
                .andExpect( status().isCreated() )
                .andExpect( content().json(responseJson) );

    }

    @Test
    void addPacciente() throws Exception {
        // Mock data
        Medico medico = MedicoPrototype.create( new ArrayList() );
        Paciente paciente = PacientePrototype.create( new ArrayList() );
        // Mock Repository
        // Mock Response
        // Test & Verify
        this.mockMvc.perform(
                MockMvcRequestBuilders.put("/medicos/"+medico.getId()+"/addPaciente")
                .contentType(MediaType.APPLICATION_JSON)
                .param("idPaciente", paciente.getId()+"" ) )
                .andExpect( status().isCreated() );
    }

}




        // Mock data
        // Mock Repository
        // Mock Response
        // Test & Verify
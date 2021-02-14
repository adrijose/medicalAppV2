package com.adritec96.apiCites.controller;

import com.adritec96.apiCites.dto.MedicoResponse;
import com.adritec96.apiCites.model.entity.MedicoPrototype;
import com.adritec96.apiCites.services.MedicoServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
@WebMvcTest(MedicoController.class)
class MedicoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MedicoServiceImpl medicoService;

    @Test
    void getAll() {
        List<MedicoResponse> response = new ArrayList<>();
        for(int i=0; i<5; i++) response.add( MedicoPrototype.createResponse() );
    }

    @Test
    void create() {
    }


    @Test
    void read() {
    }

    @Test
    void addPacciente() {
    }
}
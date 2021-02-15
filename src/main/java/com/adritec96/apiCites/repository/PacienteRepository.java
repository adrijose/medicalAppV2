package com.adritec96.apiCites.repository;

import com.adritec96.apiCites.model.entity.Paciente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PacienteRepository extends UsuarioRepository<Paciente> {
    @Query( value =  "SELECT * FROM pacientes WHERE NNS = ?1", nativeQuery = true)
    Paciente findNns(String nns);
}

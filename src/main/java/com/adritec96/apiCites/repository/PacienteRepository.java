package com.adritec96.apiCites.repository;

import com.adritec96.apiCites.model.entity.Paciente;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends UsuarioRepository<Paciente> {
}

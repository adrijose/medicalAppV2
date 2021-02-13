package com.adritec96.apiCites.repository;

import com.adritec96.apiCites.model.Paciente;
import com.adritec96.apiCites.model.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CitaRepository  extends JpaRepository<Cita,Integer> {
    List<Cita> findByPaciente(Paciente paciente);
}

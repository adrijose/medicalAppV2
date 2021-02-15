package com.adritec96.apiCites.repository;


import com.adritec96.apiCites.model.entity.Diagnostico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiagnosticoRepository extends JpaRepository<Diagnostico,Integer> {
}

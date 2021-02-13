package com.adritec96.apiCites.repository;

import com.adritec96.apiCites.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface UsuarioRepository<T extends Usuario>
        extends JpaRepository<T ,Integer> {

}

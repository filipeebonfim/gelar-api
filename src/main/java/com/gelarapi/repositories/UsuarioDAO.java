package com.gelarapi.repositories;

import com.gelarapi.model.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioDAO extends CrudRepository<Usuario, Long> {
    Usuario findByLogin(String login);

}

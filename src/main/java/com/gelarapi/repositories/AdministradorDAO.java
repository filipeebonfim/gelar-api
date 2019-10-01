package com.gelarapi.repositories;

import com.gelarapi.model.Administrador;
import org.springframework.data.repository.CrudRepository;

public interface AdministradorDAO extends CrudRepository<Administrador, Long> {
}

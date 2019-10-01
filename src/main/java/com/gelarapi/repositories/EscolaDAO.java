package com.gelarapi.repositories;

import com.gelarapi.model.Escola;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EscolaDAO extends CrudRepository<Escola, Long> {
    Escola findByNome(String nome);
}

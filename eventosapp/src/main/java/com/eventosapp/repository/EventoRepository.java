package com.eventosapp.repository;

import com.eventosapp.models.Evento;
import org.springframework.data.repository.CrudRepository;

public interface EventoRepository extends CrudRepository<Evento, String> {
    Evento findByCodigo(long codigo); // Para a geração de links para páginas específicas de cada evento conforme seu código
}

package com.brinquedoteca.brinquedoteca_backend.repository;

import com.brinquedoteca.brinquedoteca_backend.model.Entrada;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface EntradaRepository extends JpaRepository<Entrada, Long> {
    List<Entrada> findByOrigem(Entrada.OrigemEntrada origem);
    List<Entrada> findByData(LocalDate data);
    List<Entrada> findByJogoId(Long jogoId);
    List<Entrada> findByBrinquedoId(Long brinquedoId);
    long countByJogoId(Long jogoId);
    long countByBrinquedoId(Long brinquedoId);
}
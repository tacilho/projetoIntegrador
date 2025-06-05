package com.brinquedoteca.brinquedoteca_backend.repository;

import com.brinquedoteca.brinquedoteca_backend.model.Saida;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface SaidaRepository extends JpaRepository<Saida, Long> {
    List<Saida> findByMotivo(Saida.MotivoSaida motivo);
    List<Saida> findByData(LocalDate data);
    List<Saida> findByJogoId(Long jogoId);
    List<Saida> findByBrinquedoId(Long brinquedoId);
    long countByJogoId(Long jogoId);
    long countByBrinquedoId(Long brinquedoId);
}
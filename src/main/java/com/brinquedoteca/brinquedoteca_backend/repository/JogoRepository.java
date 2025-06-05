package com.brinquedoteca.brinquedoteca_backend.repository;

import com.brinquedoteca.brinquedoteca_backend.model.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JogoRepository extends JpaRepository<Jogo, Long> {
    List<Jogo> findByNomeContaining(String nome);
    List<Jogo> findByTipo(Jogo.TipoJogo tipo);
    List<Jogo> findByFaixaEtaria(String faixaEtaria);
    List<Jogo> findByEstagio(Jogo.EstagioDesenvolvimentoCognitivo estagio);
}
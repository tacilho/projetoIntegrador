package com.brinquedoteca.brinquedoteca_backend.repository;

import com.brinquedoteca.brinquedoteca_backend.model.Brinquedo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BrinquedoRepository extends JpaRepository<Brinquedo, Long> {
    List<Brinquedo> findByNomeContaining(String nome);
    List<Brinquedo> findByTipo(Brinquedo.TipoBrinquedo tipo);
    List<Brinquedo> findByFaixaEtaria(String faixaEtaria);
    List<Brinquedo> findByArea(Brinquedo.AreaBrinquedo area);
}
package com.brinquedoteca.brinquedoteca_backend.service;

import com.brinquedoteca.brinquedoteca_backend.model.Brinquedo;
import com.brinquedoteca.brinquedoteca_backend.repository.BrinquedoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrinquedoService {
    @Autowired
    private BrinquedoRepository brinquedoRepository;

    public Brinquedo salvar(Brinquedo brinquedo) {
        validate(brinquedo);
        return brinquedoRepository.save(brinquedo);
    }

    public List<Brinquedo> listarTodos() {
        return brinquedoRepository.findAll();
    }

    public Brinquedo obterPorId(Long id) {
        return brinquedoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Brinquedo não encontrado"));
    }

    public Brinquedo atualizar(Brinquedo brinquedo) {
        if (!brinquedoRepository.existsById(brinquedo.getId())) {
            throw new RuntimeException("Brinquedo não encontrado");
        }
        validate(brinquedo);
        return brinquedoRepository.save(brinquedo);
    }

    public void deletar(Long id) {
        if (!brinquedoRepository.existsById(id)) {
            throw new RuntimeException("Brinquedo não encontrado");
        }
        brinquedoRepository.deleteById(id);
    }

    public List<Brinquedo> buscar(String nome, Brinquedo.TipoBrinquedo tipo, String faixaEtaria, Brinquedo.AreaBrinquedo area) {
        if (nome != null) return brinquedoRepository.findByNomeContaining(nome);
        if (tipo != null) return brinquedoRepository.findByTipo(tipo);
        if (faixaEtaria != null) return brinquedoRepository.findByFaixaEtaria(faixaEtaria);
        if (area != null) return brinquedoRepository.findByArea(area);
        return listarTodos();
    }

    private void validate(Brinquedo brinquedo) {
        if (brinquedo.getNome() == null || brinquedo.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do brinquedo é obrigatório");
        }
        if (brinquedo.getTipo() == null) {
            throw new IllegalArgumentException("Tipo do brinquedo é obrigatório");
        }
        if (brinquedo.getFaixaEtaria() == null || brinquedo.getFaixaEtaria().trim().isEmpty()) {
            throw new IllegalArgumentException("Faixa etária do brinquedo é obrigatória");
        }
        if (brinquedo.getArea() == null) {
            throw new IllegalArgumentException("Área do brinquedo é obrigatória");
        }
    }
}
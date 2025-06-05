package com.brinquedoteca.brinquedoteca_backend.service;

import com.brinquedoteca.brinquedoteca_backend.model.Entrada;
import com.brinquedoteca.brinquedoteca_backend.repository.EntradaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EntradaService {
    @Autowired
    private EntradaRepository entradaRepository;

    public Entrada salvar(Entrada entrada) {
        validate(entrada);
        return entradaRepository.save(entrada);
    }

    public List<Entrada> listarTodos() {
        return entradaRepository.findAll();
    }

    public Entrada obterPorId(Long id) {
        return entradaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entrada não encontrada"));
    }

    public Entrada atualizar(Entrada entrada) {
        if (!entradaRepository.existsById(entrada.getId())) {
            throw new RuntimeException("Entrada não encontrada");
        }
        validate(entrada);
        return entradaRepository.save(entrada);
    }

    public void deletar(Long id) {
        if (!entradaRepository.existsById(id)) {
            throw new RuntimeException("Entrada não encontrada");
        }
        entradaRepository.deleteById(id);
    }

    public List<Entrada> buscar(Entrada.OrigemEntrada origem, LocalDate data) {
        if (origem != null) return entradaRepository.findByOrigem(origem);
        if (data != null) return entradaRepository.findByData(data);
        return listarTodos();
    }

    public List<Entrada> obterPorJogo(Long jogoId) {
        return entradaRepository.findByJogoId(jogoId);
    }

    public List<Entrada> obterPorBrinquedo(Long brinquedoId) {
        return entradaRepository.findByBrinquedoId(brinquedoId);
    }

    public long contarPorJogo(Long jogoId) {
        return entradaRepository.countByJogoId(jogoId);
    }

    public long contarPorBrinquedo(Long brinquedoId) {
        return entradaRepository.countByBrinquedoId(brinquedoId);
    }

    private void validate(Entrada entrada) {
        if (entrada.getOrigem() == null) {
            throw new IllegalArgumentException("Origem da entrada é obrigatória");
        }
        if (entrada.getJogo() == null && entrada.getBrinquedo() == null) {
            throw new IllegalArgumentException("Entrada deve estar associada a um jogo ou brinquedo");
        }
    }
}
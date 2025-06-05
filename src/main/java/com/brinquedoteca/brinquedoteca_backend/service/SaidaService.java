package com.brinquedoteca.brinquedoteca_backend.service;

import com.brinquedoteca.brinquedoteca_backend.model.Saida;
import com.brinquedoteca.brinquedoteca_backend.repository.SaidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SaidaService {
    @Autowired
    private SaidaRepository saidaRepository;

    public Saida salvar(Saida saida) {
        validate(saida);
        return saidaRepository.save(saida);
    }

    public List<Saida> listarTodos() {
        return saidaRepository.findAll();
    }

    public Saida obterPorId(Long id) {
        return saidaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Saída não encontrada"));
    }

    public Saida atualizar(Saida saida) {
        if (!saidaRepository.existsById(saida.getId())) {
            throw new RuntimeException("Saída não encontrada");
        }
        validate(saida);
        return saidaRepository.save(saida);
    }

    public void deletar(Long id) {
        if (!saidaRepository.existsById(id)) {
            throw new RuntimeException("Saída não encontrada");
        }
        saidaRepository.deleteById(id);
    }

    public List<Saida> buscar(Saida.MotivoSaida motivo, LocalDate data) {
        if (motivo != null) return saidaRepository.findByMotivo(motivo);
        if (data != null) return saidaRepository.findByData(data);
        return listarTodos();
    }

    public List<Saida> obterPorJogo(Long jogoId) {
        return saidaRepository.findByJogoId(jogoId);
    }

    public List<Saida> obterPorBrinquedo(Long brinquedoId) {
        return saidaRepository.findByBrinquedoId(brinquedoId);
    }

    public long contarPorJogo(Long jogoId) {
        return saidaRepository.countByJogoId(jogoId);
    }

    public long contarPorBrinquedo(Long brinquedoId) {
        return saidaRepository.countByBrinquedoId(brinquedoId);
    }

    private void validate(Saida saida) {
        if (saida.getMotivo() == null) {
            throw new IllegalArgumentException("Motivo da saída é obrigatório");
        }
        if (saida.getJogo() == null && saida.getBrinquedo() == null) {
            throw new IllegalArgumentException("Saída deve estar associada a um jogo ou brinquedo");
        }
    }
}
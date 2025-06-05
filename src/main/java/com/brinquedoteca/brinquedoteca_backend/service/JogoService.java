package com.brinquedoteca.brinquedoteca_backend.service;

import com.brinquedoteca.brinquedoteca_backend.model.Jogo;
import com.brinquedoteca.brinquedoteca_backend.repository.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JogoService {
    @Autowired
    private JogoRepository jogoRepository;

    public Jogo salvar(Jogo jogo) {
        validate(jogo);
        return jogoRepository.save(jogo);
    }

    public List<Jogo> listarTodos() {
        return jogoRepository.findAll();
    }

    public Jogo obterPorId(Long id) {
        return jogoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Jogo não encontrado"));
    }

    public Jogo atualizar(Jogo jogo) {
        if (!jogoRepository.existsById(jogo.getId())) {
            throw new RuntimeException("Jogo não encontrado");
        }
        validate(jogo);
        return jogoRepository.save(jogo);
    }

    public void deletar(Long id) {
        if (!jogoRepository.existsById(id)) {
            throw new RuntimeException("Jogo não encontrado");
        }
        jogoRepository.deleteById(id);
    }

    public List<Jogo> buscar(String nome, Jogo.TipoJogo tipo, String faixaEtaria, Jogo.EstagioDesenvolvimentoCognitivo estagio) {
        if (nome != null) return jogoRepository.findByNomeContaining(nome);
        if (tipo != null) return jogoRepository.findByTipo(tipo);
        if (faixaEtaria != null) return jogoRepository.findByFaixaEtaria(faixaEtaria);
        if (estagio != null) return jogoRepository.findByEstagio(estagio);
        return listarTodos();
    }

    private void validate(Jogo jogo) {
        if (jogo.getNome() == null || jogo.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do jogo é obrigatório");
        }
        if (jogo.getTipo() == null) {
            throw new IllegalArgumentException("Tipo do jogo é obrigatório");
        }
        if (jogo.getFaixaEtaria() == null || jogo.getFaixaEtaria().trim().isEmpty()) {
            throw new IllegalArgumentException("Faixa etária do jogo é obrigatória");
        }
        if (jogo.getEstagio() == null) {
            throw new IllegalArgumentException("Estágio do jogo é obrigatório");
        }
    }
}
package com.brinquedoteca.brinquedoteca_backend.controller;

import com.brinquedoteca.brinquedoteca_backend.model.Jogo;
import com.brinquedoteca.brinquedoteca_backend.service.JogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jogos")
public class JogoController {
    @Autowired
    private JogoService jogoService;

    @PostMapping
    public Jogo criar(@RequestBody Jogo jogo) {
        return jogoService.salvar(jogo);
    }

    @GetMapping
    public List<Jogo> listar() {
        return jogoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Jogo obter(@PathVariable Long id) {
        return jogoService.obterPorId(id);
    }

    @PutMapping("/{id}")
    public Jogo atualizar(@PathVariable Long id, @RequestBody Jogo jogo) {
        jogo.setId(id);
        return jogoService.atualizar(jogo);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        jogoService.deletar(id);
    }

    @GetMapping("/search")
    public List<Jogo> buscar(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) Jogo.TipoJogo tipo,
            @RequestParam(required = false) String faixaEtaria,
            @RequestParam(required = false) Jogo.EstagioDesenvolvimentoCognitivo estagio) {
        return jogoService.buscar(nome, tipo, faixaEtaria, estagio);
    }
}
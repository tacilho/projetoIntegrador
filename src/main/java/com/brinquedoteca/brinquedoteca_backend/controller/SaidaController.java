package com.brinquedoteca.brinquedoteca_backend.controller;

import com.brinquedoteca.brinquedoteca_backend.model.Saida;
import com.brinquedoteca.brinquedoteca_backend.service.SaidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/saidas")
public class SaidaController {
    @Autowired
    private SaidaService saidaService;

    @PostMapping
    public Saida criar(@RequestBody Saida saida) {
        return saidaService.salvar(saida);
    }

    @GetMapping
    public List<Saida> listar() {
        return saidaService.listarTodos();
    }

    @GetMapping("/{id}")
    public Saida obter(@PathVariable Long id) {
        return saidaService.obterPorId(id);
    }

    @PutMapping("/{id}")
    public Saida atualizar(@PathVariable Long id, @RequestBody Saida saida) {
        saida.setId(id);
        return saidaService.atualizar(saida);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        saidaService.deletar(id);
    }

    @GetMapping("/search")
    public List<Saida> buscar(
            @RequestParam(required = false) Saida.MotivoSaida motivo,
            @RequestParam(required = false) LocalDate data) {
        return saidaService.buscar(motivo, data);
    }

    @GetMapping("/por-jogo/{jogoId}")
    public List<Saida> obterPorJogo(@PathVariable Long jogoId) {
        return saidaService.obterPorJogo(jogoId);
    }

    @GetMapping("/por-brinquedo/{brinquedoId}")
    public List<Saida> obterPorBrinquedo(@PathVariable Long brinquedoId) {
        return saidaService.obterPorBrinquedo(brinquedoId);
    }
}
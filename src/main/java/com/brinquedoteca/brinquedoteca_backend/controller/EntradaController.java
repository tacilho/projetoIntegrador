package com.brinquedoteca.brinquedoteca_backend.controller;

import com.brinquedoteca.brinquedoteca_backend.model.Entrada;
import com.brinquedoteca.brinquedoteca_backend.service.EntradaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/entradas")
public class EntradaController {
    @Autowired
    private EntradaService entradaService;

    @PostMapping
    public Entrada criar(@RequestBody Entrada entrada) {
        return entradaService.salvar(entrada);
    }

    @GetMapping
    public List<Entrada> listar() {
        return entradaService.listarTodos();
    }

    @GetMapping("/{id}")
    public Entrada obter(@PathVariable Long id) {
        return entradaService.obterPorId(id);
    }

    @PutMapping("/{id}")
    public Entrada atualizar(@PathVariable Long id, @RequestBody Entrada entrada) {
        entrada.setId(id);
        return entradaService.atualizar(entrada);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        entradaService.deletar(id);
    }

    @GetMapping("/search")
    public List<Entrada> buscar(
            @RequestParam(required = false) Entrada.OrigemEntrada origem,
            @RequestParam(required = false) LocalDate data) {
        return entradaService.buscar(origem, data);
    }

    @GetMapping("/por-jogo/{jogoId}")
    public List<Entrada> obterPorJogo(@PathVariable Long jogoId) {
        return entradaService.obterPorJogo(jogoId);
    }

    @GetMapping("/por-brinquedo/{brinquedoId}")
    public List<Entrada> obterPorBrinquedo(@PathVariable Long brinquedoId) {
        return entradaService.obterPorBrinquedo(brinquedoId);
    }
}
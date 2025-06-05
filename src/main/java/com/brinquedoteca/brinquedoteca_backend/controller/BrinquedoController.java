package com.brinquedoteca.brinquedoteca_backend.controller;

import com.brinquedoteca.brinquedoteca_backend.model.Brinquedo;
import com.brinquedoteca.brinquedoteca_backend.service.BrinquedoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/brinquedos")
public class BrinquedoController {
    @Autowired
    private BrinquedoService brinquedoService;

    @PostMapping
    public Brinquedo criar(@RequestBody Brinquedo brinquedo) {
        return brinquedoService.salvar(brinquedo);
    }

    @GetMapping
    public List<Brinquedo> listar() {
        return brinquedoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Brinquedo obter(@PathVariable Long id) {
        return brinquedoService.obterPorId(id);
    }

    @PutMapping("/{id}")
    public Brinquedo atualizar(@PathVariable Long id, @RequestBody Brinquedo brinquedo) {
        brinquedo.setId(id);
        return brinquedoService.atualizar(brinquedo);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        brinquedoService.deletar(id);
    }

    @GetMapping("/search")
    public List<Brinquedo> buscar(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) Brinquedo.TipoBrinquedo tipo,
            @RequestParam(required = false) String faixaEtaria,
            @RequestParam(required = false) Brinquedo.AreaBrinquedo area) {
        return brinquedoService.buscar(nome, tipo, faixaEtaria, area);
    }
}
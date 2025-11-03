package com.brinquedoteca.brinquedoteca_backend.controller;

import com.brinquedoteca.brinquedoteca_backend.model.Brinquedo;
import com.brinquedoteca.brinquedoteca_backend.model.Entrada;
import com.brinquedoteca.brinquedoteca_backend.model.Jogo;
import com.brinquedoteca.brinquedoteca_backend.model.Saida;
import com.brinquedoteca.brinquedoteca_backend.service.BrinquedoService;
import com.brinquedoteca.brinquedoteca_backend.service.EntradaService;
import com.brinquedoteca.brinquedoteca_backend.service.JogoService;
import com.brinquedoteca.brinquedoteca_backend.service.SaidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/pesquisa")
public class PesquisaController {

    @Autowired
    private JogoService jogoService;

    @Autowired
    private BrinquedoService brinquedoService;

    @Autowired
    private EntradaService entradaService;

    @Autowired
    private SaidaService saidaService;

    @GetMapping
    public Map<String, Object> pesquisar(@RequestParam String termo) {
        List<Jogo> jogos = jogoService.buscar(termo, null, null, null);
        List<Brinquedo> brinquedos = brinquedoService.buscar(termo, null, null, null);
        List<Entrada> entradas = entradaService.listarTodos();
        List<Saida> saidas = saidaService.listarTodos();
        return Map.of(
                "jogos", jogos,
                "brinquedos", brinquedos,
                "entradas", entradas,
                "saidas", saidas
        );
    }
}

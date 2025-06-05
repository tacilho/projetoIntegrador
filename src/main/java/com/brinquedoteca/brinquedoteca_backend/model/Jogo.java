package com.brinquedoteca.brinquedoteca_backend.model;

import lombok.Data;
import jakarta.persistence.*;

@Entity
@Table(name = "jogos")
@Data
public class Jogo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", nullable = false)
    private TipoJogo tipo;

    @Column(name = "faixa_etaria", nullable = false)
    private String faixaEtaria;

    @Enumerated(EnumType.STRING)
    @Column(name = "estagio", nullable = false)
    private EstagioDesenvolvimentoCognitivo estagio;

    public enum TipoJogo {
        ENCAIXE, TABULEIRO, QUEBRA_CABECAS, CARTAS, MONTAGEM, OUTRO
    }

    public enum EstagioDesenvolvimentoCognitivo {
        SENSORIO_MOTOR, PRE_OPERATORIO, OPERATORIO_CONCRETO, OPERATORIO_FORMAL
    }
}
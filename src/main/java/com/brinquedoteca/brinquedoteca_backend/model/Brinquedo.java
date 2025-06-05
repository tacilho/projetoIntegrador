package com.brinquedoteca.brinquedoteca_backend.model;

import lombok.Data;
import jakarta.persistence.*;

@Entity
@Table(name = "brinquedos")
@Data
public class Brinquedo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", nullable = false)
    private TipoBrinquedo tipo;

    @Column(name = "faixa_etaria", nullable = false)
    private String faixaEtaria;

    @Enumerated(EnumType.STRING)
    @Column(name = "area", nullable = false)
    private AreaBrinquedo area;

    public enum TipoBrinquedo {
        MONTAGEM, ROLEPLAY, SENSORIAL, OUTRO
    }

    public enum AreaBrinquedo {
        INTERIOR, EXTERIOR, AMBOS
    }
}
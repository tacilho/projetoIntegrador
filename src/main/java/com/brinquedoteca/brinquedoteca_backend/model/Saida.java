package com.brinquedoteca.brinquedoteca_backend.model;

import lombok.Data;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "saidas")
@Data
public class Saida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "motivo", nullable = false)
    private MotivoSaida motivo;

    @ManyToOne
    @JoinColumn(name = "jogo_id")
    private Jogo jogo;

    @ManyToOne
    @JoinColumn(name = "brinquedo_id")
    private Brinquedo brinquedo;

    @Column(name = "data")
    private LocalDate data;

    public enum MotivoSaida {
        DOACAO, DESCARTE, OUTRO
    }
}
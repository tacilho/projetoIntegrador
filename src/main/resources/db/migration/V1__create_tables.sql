CREATE TABLE IF NOT EXISTS jogos (
                                     id SERIAL PRIMARY KEY,
                                     nome VARCHAR(100) NOT NULL,
    tipo VARCHAR(50) NOT NULL CHECK (tipo IN ('ENCAIXE', 'TABULEIRO', 'QUEBRA_CABECAS', 'CARTAS', 'MONTAGEM', 'OUTRO')),
    faixa_etaria VARCHAR(20) NOT NULL,
    estagio VARCHAR(50) NOT NULL CHECK (estagio IN ('SENSORIO_MOTOR', 'PRE_OPERATORIO', 'OPERATORIO_CONCRETO', 'OPERATORIO_FORMAL'))
    );

CREATE TABLE IF NOT EXISTS brinquedos (
                                          id SERIAL PRIMARY KEY,
                                          nome VARCHAR(100) NOT NULL,
    tipo VARCHAR(50) NOT NULL CHECK (tipo IN ('MONTAGEM', 'ROLEPLAY', 'SENSORIAL', 'OUTRO')),
    faixa_etaria VARCHAR(20) NOT NULL,
    area VARCHAR(50) NOT NULL CHECK (area IN ('INTERIOR', 'EXTERIOR', 'AMBOS'))
    );

CREATE TABLE IF NOT EXISTS entradas (
                                        id SERIAL PRIMARY KEY,
                                        origem VARCHAR(50) NOT NULL CHECK (origem IN ('DOACAO', 'COMPRA', 'OUTRO')),
    jogo_id BIGINT,
    brinquedo_id BIGINT,
    data DATE,
    CONSTRAINT fk_jogo FOREIGN KEY (jogo_id) REFERENCES jogos(id),
    CONSTRAINT fk_brinquedo FOREIGN KEY (brinquedo_id) REFERENCES brinquedos(id)
    );

CREATE TABLE IF NOT EXISTS saidas (
                                      id SERIAL PRIMARY KEY,
                                      motivo VARCHAR(50) NOT NULL CHECK (motivo IN ('DOACAO', 'DESCARTE', 'OUTRO')),
    jogo_id BIGINT,
    brinquedo_id BIGINT,
    data DATE,
    CONSTRAINT fk_jogo FOREIGN KEY (jogo_id) REFERENCES jogos(id),
    CONSTRAINT fk_brinquedo FOREIGN KEY (brinquedo_id) REFERENCES brinquedos(id)
    );

CREATE TABLE IF NOT EXISTS usuarios (
                                        id SERIAL PRIMARY KEY,
                                        email VARCHAR(100) UNIQUE NOT NULL,
    senha VARCHAR(100) NOT NULL
    );
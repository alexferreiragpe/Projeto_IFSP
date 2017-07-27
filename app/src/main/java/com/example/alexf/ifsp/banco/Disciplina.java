package com.example.alexf.ifsp.banco;

import java.util.ArrayList;
import java.util.List;

public class Disciplina {
    private final Long id;
    private final String sigla;
    private final String nome;
    private final Long duracao;
    private final List<Disciplina> dependencia = new ArrayList<>();
    private final String getSqlCriacaoTabela = "";

    Disciplina(Long id, String sigla, String nome, Long duracao) {
        this.id = id;
        this.sigla = sigla;
        this.nome = nome;
        this.duracao = duracao;
    }

    public Long getId() {
        return id;
    }


    public String getSigla() {
        return sigla;
    }


    public String getNome() {
        return nome;
    }

    public Long getDuracao() {
        return duracao;
    }

    public List<Disciplina> getDependencia() {
        return dependencia;
    }

    public void adicionarDepencia(Disciplina disciplina) {
        dependencia.add(disciplina);
    }
}

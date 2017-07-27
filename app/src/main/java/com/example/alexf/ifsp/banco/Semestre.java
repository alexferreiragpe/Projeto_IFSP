package com.example.alexf.ifsp.banco;

import java.util.ArrayList;
import java.util.List;

public class Semestre {
    private final int id;
    private final int identificacaoSemestre;
    private final List<Disciplina> disciplinas = new ArrayList<>();
    private final String descricao;
    private final String getSqlCriacaoTabela = "";

    public Semestre(int id, int identificacaoSemestre, String descricao) {
        this.id = id;
        this.identificacaoSemestre = identificacaoSemestre;
        this.descricao = descricao;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public int getId() {
        return id;
    }

    public void adicionarDisciplina(Disciplina disciplina) {
        disciplinas.add(disciplina);
    }

    public Disciplina consultarDisciplina(String sigla) {
        for (Disciplina disciplina : disciplinas) {
            if (disciplina.getSigla().equalsIgnoreCase(sigla)) {
                return disciplina;
            }
        }
        return null;
    }

    public Disciplina consultarDisciplina(Long id) {
        for (Disciplina disciplina : disciplinas) {
            if (disciplina.getId() == id) {
                return disciplina;
            }
        }
        return null;
    }

    public int getIdentificacaoSemestre() {
        return identificacaoSemestre;
    }

    public String getDescricao() {
        return descricao;
    }
}

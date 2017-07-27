package com.example.alexf.ifsp.banco;

import java.util.ArrayList;
import java.util.List;

public class CursoIFSP {
    //private List<Semestre> curso = new ArrayList<>();
    //private final String getSqlCriacaoTabela = "CREATE TABLE IF NOT EXISTS Curso (id integer primary key, name VARCHAR, email VARCHAR);";
    private final Long id;
    private final String nome;
    private final String sigla;
    private final int qtdSemestres;
    private final int quantidadeMaterias;
    private final List<Semestre> curso = new ArrayList<>();


    public CursoIFSP(Long id, String nomeCurso, String sigla, int quantidadeSemestres, int quantidadeMaterias) {
        this.id = id;
        nome = nomeCurso;
        this.sigla = sigla;
        qtdSemestres = quantidadeSemestres;
        this.quantidadeMaterias = quantidadeMaterias;
    }

   /* public String getSqlCriacaoTabela() {
        return getSqlCriacaoTabela;
    }*/

    public void adicionarSemetre(Semestre semestre) {
        curso.add(semestre);
    }

    public int getQuantidadeSemestres() {
        return qtdSemestres;
    }

    public List<Semestre> getCurso() {
        return curso;
    }

    public Long getId() {
        return id;
    }

    public String getSigla() {
        return sigla;
    }

    public int getQuantidadeMaterias() {
        return quantidadeMaterias;
    }

    public String getNome() {
        return nome;
    }
}

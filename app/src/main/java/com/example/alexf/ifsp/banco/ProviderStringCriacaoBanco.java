package com.example.alexf.ifsp.banco;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fábio on 6/26/2016.
 */
public class ProviderStringCriacaoBanco {
    private final List<String> criacaoTabelas = new ArrayList<>();
    private final List<String> dropTabelas = new ArrayList<>();
    private final List<String> inserirDadosCurso = new ArrayList<>();
    private final List<String> inserirDadosSemestre = new ArrayList<>();
    private final List<String> inserirDadosDisciplinas = new ArrayList<>();
    private final List<String> inserirDadosDependencias = new ArrayList<>();

    ProviderStringCriacaoBanco() {

    }

    private void stringTabelas() {
        //CREATE TABLE IF NOT EXISTS
        criacaoTabelas.add("CREATE TABLE IF NOT EXISTS Curso         (id INTEGER PRIMARY KEY AUTOINCREMENT, nome VARCHAR, sigla VARCHAR, quantidadeSemestres integer, quantidadeMaterias integer);");
        criacaoTabelas.add("CREATE TABLE IF NOT EXISTS Semestre      (id INTEGER PRIMARY KEY AUTOINCREMENT, curso_id integer, semestre integer, descricao VARCHAR, FOREIGN KEY(curso_id) REFERENCES Curso(id));");
        criacaoTabelas.add("CREATE TABLE IF NOT EXISTS Disciplinas   (id INTEGER PRIMARY KEY AUTOINCREMENT, sigla VARCHAR(5), nome VARCHAR, duracao NUMERIC, semestre_id INTEGER, FOREIGN KEY(semestre_id) REFERENCES Semestre(id));");
        criacaoTabelas.add("CREATE TABLE IF NOT EXISTS Dependencias  (id INTEGER PRIMARY KEY AUTOINCREMENT, id_disciplina INTEGER, id_dependencia INTEGER, FOREIGN KEY(id_disciplina) REFERENCES Disciplinas(id), FOREIGN KEY(id_dependencia) REFERENCES Disciplinas(id));");
    }

    private void dropTabelas() {
        dropTabelas.add("DROP TABLE Dependencias;");
        dropTabelas.add("DROP TABLE Disciplinas;");
        dropTabelas.add("DROP TABLE Semestre;");
        dropTabelas.add("DROP TABLE Curso;");
    }

    private void dadosCurso() {
        String cabecalho = "INSERT INTO Curso (nome, sigla, quantidadeSemestres, quantidadeMaterias) VALUES ";
        inserirDadosCurso.add(cabecalho + "('Análise e Desenvolvimento de Sistemas','ADS',6,37);");
    }

    private void dadosSemestre() {
        String cabecalho = "INSERT INTO Semestre (curso, semestre, nome) VALUES ";
        inserirDadosSemestre.add(cabecalho + "(1,1, '1º Semestre');");
        inserirDadosSemestre.add(cabecalho + "(1,2, '2º Semestre');");
        inserirDadosSemestre.add(cabecalho + "(1,3, '3º Semestre');");
        inserirDadosSemestre.add(cabecalho + "(1,4, '4º Semestre');");
        inserirDadosSemestre.add(cabecalho + "(1,5, '5º Semestre');");
        inserirDadosSemestre.add(cabecalho + "(1,6, '6º Semestre');");
    }

    private void dadosDisciplinas() {
        String cabecalho = "INSERT INTO Disciplinas (sigla, nome, duracao, semestre_id) VALUES ";
        inserirDadosDisciplinas.add(cabecalho + "('HCTI1','História da Ciência e Tecnologia',6,1);");
        inserirDadosDisciplinas.add(cabecalho + "('INGI1','Inglês Técnico I',6,1);");
        inserirDadosDisciplinas.add(cabecalho + "('CEEI1','Comunicação e Expressão',6,1);");
        inserirDadosDisciplinas.add(cabecalho + "('MATI1','Matemática I',6,1);");
        inserirDadosDisciplinas.add(cabecalho + "('APOI1','Algoritmos e Programação',6,1);");
        inserirDadosDisciplinas.add(cabecalho + "('ARQI1','Arquitetura de Computador',6,1);");
        inserirDadosDisciplinas.add(cabecalho + "('LP1I1','Linguagem de Programação I',6,1);");

        inserirDadosDisciplinas.add(cabecalho + "('ADMI2','Introdução à Administração',6,2);");
        inserirDadosDisciplinas.add(cabecalho + "('BD1I2','Banco de Dados I',6,2);");
        inserirDadosDisciplinas.add(cabecalho + "('ESWI2','Engenharia de Software',6,2);");
        inserirDadosDisciplinas.add(cabecalho + "('SOPI2','Sistemas Operacionais',6,2);");
        inserirDadosDisciplinas.add(cabecalho + "('LP2I2','Linguagem de Programação II',6,2);");
        inserirDadosDisciplinas.add(cabecalho + "('IGTI2','Inglês Técnico II',6,2);");

        inserirDadosDisciplinas.add(cabecalho + "('AOOI3','Análise Orientada a Objeto',6,3);");
        inserirDadosDisciplinas.add(cabecalho + "('BD2I3','Banco de Dados II',6,3);");
        inserirDadosDisciplinas.add(cabecalho + "('IHCI3','Interação Humano-Computador',6,3);");
        inserirDadosDisciplinas.add(cabecalho + "('ED1I3','Estrutura de Dados I',6,3);");
        inserirDadosDisciplinas.add(cabecalho + "('LP3I3','Linguagem de Programação III',6,3);");
        inserirDadosDisciplinas.add(cabecalho + "('MFII3','Matemática Financeira',6,3);");

        inserirDadosDisciplinas.add(cabecalho + "('MPCI4','Metodologia de Pesquisa Científica',6,4);");
        inserirDadosDisciplinas.add(cabecalho + "('ESTI4','Estatística',6,4);");
        inserirDadosDisciplinas.add(cabecalho + "('ED2I4','Estrutura de Dados II',6,4);");
        inserirDadosDisciplinas.add(cabecalho + "('POOI4','Programação Orientada a Objetos',6,4);");
        inserirDadosDisciplinas.add(cabecalho + "('RCOI4','Rede de Computadores',6,4);");
        inserirDadosDisciplinas.add(cabecalho + "('ASWI4','Arquitetura de Software',6,4);");

        inserirDadosDisciplinas.add(cabecalho + "('GPRI5','Gestão de Projetos',6,5);");
        inserirDadosDisciplinas.add(cabecalho + "('DWEI5','Desenvolvimento Web',6,5);");
        inserirDadosDisciplinas.add(cabecalho + "('PS1I5','Projeto de Sistemas I',6,5);");
        inserirDadosDisciplinas.add(cabecalho + "('QSWI5','Qualidade de Software',6,5);");
        inserirDadosDisciplinas.add(cabecalho + "('SSRI5','Serviços de Rede',6,5);");
        inserirDadosDisciplinas.add(cabecalho + "('EL1I5','Eletiva I',6,5);");

        inserirDadosDisciplinas.add(cabecalho + "('EMPI6','Empreendedorismo',6,6);");
        inserirDadosDisciplinas.add(cabecalho + "('TPEI6','Tópicos Específicos',6,6);");
        inserirDadosDisciplinas.add(cabecalho + "('SSII6','Segurança de Software',6,6);");
        inserirDadosDisciplinas.add(cabecalho + "('DSWI6','Desenvolvimento de Sistemas Web',6,6);");
        inserirDadosDisciplinas.add(cabecalho + "('PS2I6','Projeto de Sistemas II',6,6);");
        inserirDadosDisciplinas.add(cabecalho + "('EL2I6','Eletiva II',6,6);");
    }

    private String dadosDependencias() {
        return "";
    }

    public List<String> getInserirDadosDependencias() {
        return inserirDadosDependencias;
    }

    public List<String> getInserirDadosDisciplinas() {
        return inserirDadosDisciplinas;
    }

    public List<String> getInserirDadosSemestre() {
        return inserirDadosSemestre;
    }

    public List<String> getInserirDadosCurso() {
        return inserirDadosCurso;
    }

    public List<String> getCriacaoTabelas() {
        return criacaoTabelas;
    }

    public List<String> getDropTabelas() {
        return dropTabelas;
    }
}

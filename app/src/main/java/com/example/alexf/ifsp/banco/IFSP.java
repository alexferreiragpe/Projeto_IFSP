package com.example.alexf.ifsp.banco;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class IFSP {
    private final String nomeBanco = "IFSP";
    private List<CursoIFSP> cursos = new ArrayList<>();
    private BancoController banco;

    public IFSP(Context context) {
        //curso = new CursoIFSP("Análise e Desenvolvimento de Sistemas","ADS",6, 37);
        this.banco = new BancoController(context, nomeBanco);
        Log.v("CRIAÇÃO BANCO", "PROCURAR CURSOS");
        try {
            this.carregarCursos();
        } catch (Error e) {
            Log.e("ERRO LEITURA BANCO", e.getLocalizedMessage());
            //this.apagarTabelas();
        }

        if (cursos.size() == 0) {
            Log.v("CRIAÇÃO BANCO", "NENHUM CURSO ENCONTRADO");
            this.popularBanco();
            this.carregarCursos();
        }
        Log.v("CRIAÇÃO BANCO", "CURSO ENCONTRADO");
    }

    private void apagarTabelas() {
        ProviderStringCriacaoBanco criacao = new ProviderStringCriacaoBanco();
        for (String tabela : criacao.getDropTabelas()) {
            banco.executarComandoSql(tabela);
        }
    }

    private void popularBanco() {
        ProviderStringCriacaoBanco criacao = new ProviderStringCriacaoBanco();
        try {
            for (String tabela : criacao.getCriacaoTabelas()) {
                banco.executarComandoSql(tabela);
            }

            for (String inserirDadoCurso : criacao.getInserirDadosCurso()) {
                banco.executarComandoSql(inserirDadoCurso);
            }

            for (String inserirDadoSemestre : criacao.getInserirDadosSemestre()) {
                banco.executarComandoSql(inserirDadoSemestre);
            }

            for (String inserirDadoDisciplina : criacao.getInserirDadosDisciplinas()) {
                banco.executarComandoSql(inserirDadoDisciplina);

            }

            for (String inserirDependencias : criacao.getInserirDadosDependencias()) {
                banco.executarComandoSql(inserirDependencias);
            }

            Log.v("CARGA INICIAL BANCO", "BANCO CRIADO");
        } catch (Error e) {
            Log.e("ERRO CARGA BANCO", e.getLocalizedMessage());
            //this.apagarTabelas();
        }
    }

    private void carregarCursos() {
        String sql = "SELECT id, nome, sigla, quantidadeSemestres, quantidadeMaterias FROM Curso";
        Cursor cursor = banco.realizarConsulta(sql, null);
        Log.v("LEITURA BANCO", "CURSOR CRIADO, RESULTADOS: " + cursor.getCount());
        if (cursor.getCount() > 0) {
            //Log.v("BUSCA BANCO",cursor.getString(1));
            do {
                // + " - " + cursor.getString(3));
                cursos.add(new CursoIFSP(cursor.getLong(1), cursor.getString(2), cursor.getString(3), cursor.getInt(4), cursor.getInt(5)));
            } while (cursor.moveToNext());

            comporCurso();
        }
        Log.v("CRIAÇÃO BANCO", "OBJETO CURSO CRIADO");
        cursor.close();
    }

    private void comporCurso() {
        String sql = "SELECT id, curso, semestre, descricao FROM Semestre WHERE curso = ? ;";
        Cursor cursor;
        for (CursoIFSP curso : cursos) {
            cursor = banco.realizarConsulta(sql, new String[]{curso.getId().toString()});
            if (cursor.getCount() > 0) {
                do {
                    Semestre semestre = comporSemestre(cursor.getInt(cursor.getColumnIndex("id")), cursor.getInt(cursor.getColumnIndex("semestre")), cursor.getString(cursor.getColumnIndex("descricao")));
                    curso.adicionarSemetre(semestre);

                    comporDependencias(semestre);
                } while (cursor.moveToNext());
            }
        }
    }

    public Semestre comporSemestre(int id_semestre, int identificacaoSemestre, String descricao) {
        Semestre semestre = new Semestre(id_semestre, identificacaoSemestre, descricao);
        String sql = "SELECT id, sigla, nome, duracao FROM Disciplinas WHERE semestre = ? ;";
        Cursor cursor = banco.realizarConsulta(sql, new String[]{id_semestre + ""});
        if (cursor.getCount() > 0) {
            do {
                semestre.adicionarDisciplina(new Disciplina(cursor.getLong(cursor.getColumnIndex("id")), cursor.getString(cursor.getColumnIndex("sigla")), cursor.getString(cursor.getColumnIndex("nome")), cursor.getLong(cursor.getColumnIndex("duracao"))));
            } while (cursor.moveToNext());
        }
        return semestre;
    }

    private void comporDependencias(Semestre semestre) {
        for (Disciplina disciplina : semestre.getDisciplinas()) {
            consultarDependenciasBanco(disciplina);
        }
    }

    public void consultarDependenciasBanco(Disciplina disciplina) {
        String sql = "SELECT id_disciplina, id_dependencia FROM Dependencia WHERE id_disciplina = ?;";
        Cursor cursor = banco.realizarConsulta(sql, new String[]{disciplina.getId() + ""});

        if (cursor.getCount() > 0) {
            Long id_dependencia = cursor.getLong(cursor.getColumnIndex("id_dependencia"));
            for (CursoIFSP curso : cursos) {
                for (Semestre semestre : curso.getCurso()) {
                    disciplina.adicionarDepencia(semestre.consultarDisciplina(id_dependencia));
                }
            }
        }
    }

    public List<CursoIFSP> getCursos() {
        return cursos;
    }

    public CursoIFSP getCurso(String sigla) {
        for (CursoIFSP curso : cursos) {
            if (curso.getSigla().equalsIgnoreCase(sigla)) {
                return curso;
            }
        }

        return new CursoIFSP((long) 0, "", "", 0, 0);
    }
}

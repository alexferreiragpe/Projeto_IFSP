package com.example.alexf.ifsp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivityDisciplinasRequisitos extends AppCompatActivity {

    private static final String[] DISCIPLINAS = new String[]{" * Selecione a Disciplina * ", "SISTEMAS OPERACIONAIS - SOPI2", "INGLÊS TÉCNICO AVANÇADO - IGTI2", "LINGUAGEM DE PROGRAMAÇÃO II - LP2I2",
            "MATEMÁTICA FINANCEIRA - MFII3", "BANCO DE DADOS II - BD2I3", "LINGUAGEM DE PROGRAMAÇÃO III - LP3I3", "ESTRUTURA DE DADOS I - ED1I3",
            "ANÁLISE ORIENTADA A OBJETOS - AOOI3", "INTERAÇÃO HUMANO-COMPUTADOR - IHCI3", "ESTATÍSTICA - ESTI4", "REDES DE COMPUTADORES - RCOI4",
            "PROGRAMAÇÃO ORIENTADA A OBJETOS - POOI4", "ESTRUTURA DE DADOS II - ED2I4", "ARQUITETURA DE SOFTWARE - ASWI4",
            "SERVICOS DE REDE - SSRI5", "PROJETO DE SISTEMAS I - PS1I5", "QUALIDADE DE SOFTWARE - QSWI5", "GESTÃO DE PROJETOS - GPRI5", "SEGURANÇA DA INFORMAÇÃO - SSII6",
            "PROJETO DE SISTEMAS II - PS2I6", "DESENVOLVIMENTO DE SISTEMAS WEB - DSWI6", "EMPREENDEDORISMO - EMPI6"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity_disciplinas_requisitos);

        final Spinner cboDisciplinas = (Spinner) findViewById(R.id.spinner2);
        final ArrayAdapter<String> adpDisciplinas = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, DISCIPLINAS);
        adpDisciplinas.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cboDisciplinas.setAdapter(adpDisciplinas);
        cboDisciplinas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TextView txtUm = (TextView) findViewById(R.id.textView29);
                TextView txtDois = (TextView) findViewById(R.id.textView30);
                TextView txtTres = (TextView) findViewById(R.id.textView31
                );

                if (cboDisciplinas.getSelectedItem() == "SISTEMAS OPERACIONAIS - SOPI2") {
                    limpar();
                    txtUm.setText(" * ARQUITETURA DE COMPUTADORES");
                } else if (cboDisciplinas.getSelectedItem() == "INGLÊS TÉCNICO AVANÇADO - IGTI2") {
                    limpar();
                    txtUm.setText(" * INGLÊS TÉCNICO");
                } else if (cboDisciplinas.getSelectedItem() == "LINGUAGEM DE PROGRAMAÇÃO II - LP2I2") {
                    limpar();
                    txtUm.setText(" * ALGORITMOS E PROGRAMAÇÃO");
                    txtDois.setText(" * LINGUAGEM DE PROGRAMAÇÃO");
                } else if (cboDisciplinas.getSelectedItem() == "MATEMÁTICA FINANCEIRA - MFII3") {
                    limpar();
                    txtUm.setText(" * MATEMÁTICA");
                } else if (cboDisciplinas.getSelectedItem() == "BANCO DE DADOS II - BD2I3") {
                    limpar();
                    txtUm.setText(" * BANCO DE DADOS I");
                } else if (cboDisciplinas.getSelectedItem() == "LINGUAGEM DE PROGRAMAÇÃO III - LP3I3") {
                    limpar();
                    txtUm.setText(" * BANCO DE DADOS I");
                    txtDois.setText(" * LINGUAGEM DE PROGRAMAÇÃO II");
                } else if (cboDisciplinas.getSelectedItem() == "ESTRUTURA DE DADOS I - ED1I3") {
                    limpar();
                    txtUm.setText(" * LINGUAGEM DE PROGRAMAÇÃO II");
                } else if (cboDisciplinas.getSelectedItem() == "ANÁLISE ORIENTADA A OBJETOS - AOOI3") {
                    limpar();
                    txtUm.setText(" * ENGENHARIA DE SOFTWARE");
                } else if (cboDisciplinas.getSelectedItem() == "INTERAÇÃO HUMANO-COMPUTADOR - IHCI3") {
                    limpar();
                    txtUm.setText(" * ENGENHARIA DE SOFTWARE");
                } else if (cboDisciplinas.getSelectedItem() == "ESTATÍSTICA - ESTI4") {
                    limpar();
                    txtUm.setText(" * MATEMÁTICA");
                } else if (cboDisciplinas.getSelectedItem() == "REDES DE COMPUTADORES - RCOI4") {
                    limpar();
                    txtUm.setText(" * SISTEMAS OPERACIONAIS");
                } else if (cboDisciplinas.getSelectedItem() == "PROGRAMAÇÃO ORIENTADA A OBJETOS - POOI4") {
                    limpar();
                    txtUm.setText(" * LINGUAGEM DE PROGRAMAÇÃO III");
                    txtDois.setText(" * ANÁLISE ORIENTADA A OBJETOS");
                } else if (cboDisciplinas.getSelectedItem() == "ESTRUTURA DE DADOS II - ED2I4") {
                    limpar();
                    txtUm.setText(" * ESTRUTURA DE DADOS I");
                } else if (cboDisciplinas.getSelectedItem() == "ARQUITETURA DE SOFTWARE - ASWI4") {
                    limpar();
                    txtUm.setText(" * ANÁLISE ORIENTADA A OBJETOS");
                } else if (cboDisciplinas.getSelectedItem() == "SERVICOS DE REDE - SSRI5") {
                    limpar();
                    txtUm.setText(" * REDES DE COMPUTADORES");
                } else if (cboDisciplinas.getSelectedItem() == "PROJETO DE SISTEMAS I - PS1I5") {
                    limpar();
                    txtUm.setText(" * METODOLOGIA DE PESQUISA CIENTÍFICA");
                    txtDois.setText(" * PROGRAMAÇÃO ORIENTADA A OBJETOS");
                    txtTres.setText(" * ARQUITETURA DE SOFTWARE");
                } else if (cboDisciplinas.getSelectedItem() == "QUALIDADE DE SOFTWARE - QSWI5") {
                    limpar();
                    txtUm.setText(" * ANÁLISE ORIENTADA A OBJETOS");
                } else if (cboDisciplinas.getSelectedItem() == "GESTÃO DE PROJETOS - GPRI5") {
                    limpar();
                    txtUm.setText(" * ANÁLISE ORIENTADA A OBJETOS");
                    txtDois.setText(" * INTRODUÇÃO À ADMINISTRAÇÃO");
                } else if (cboDisciplinas.getSelectedItem() == "SEGURANÇA DA INFORMAÇÃO - SSII6") {
                    limpar();
                    txtUm.setText(" * SERVIÇOS DE REDE");
                } else if (cboDisciplinas.getSelectedItem() == "PROJETO DE SISTEMAS II - PS2I6") {
                    limpar();
                    txtUm.setText(" * PROJETO DE SISTEMAS I");
                } else if (cboDisciplinas.getSelectedItem() == "DESENVOLVIMENTO DE SISTEMAS WEB - DSWI6") {
                    limpar();
                    txtUm.setText(" * PROGRAMAÇÃO ORIENTADA A OBJETOS");
                    txtDois.setText(" * DESENVOLVIMENTO WEB");
                } else if (cboDisciplinas.getSelectedItem() == "EMPREENDEDORISMO - EMPI6") {
                    limpar();
                    txtUm.setText(" * INTRODUÇÃO À ADMINISTRAÇÃO");
                } else {
                    limpar();
                }
            }


            public void limpar() {
                TextView txtUm = (TextView) findViewById(R.id.textView29);
                TextView txtDois = (TextView) findViewById(R.id.textView30);
                TextView txtTres = (TextView) findViewById(R.id.textView31);
                txtUm.setText("");
                txtDois.setText("");
                txtTres.setText("");

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}

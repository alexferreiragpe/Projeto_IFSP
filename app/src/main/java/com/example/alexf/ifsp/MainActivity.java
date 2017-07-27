package com.example.alexf.ifsp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    private static final String[] SEMESTRES = new String[]{
            " * Selecione o(s) Semestre(s) Cursado(s) * ", "1º SEMESTRE", "2º SEMESTRE", "3º SEMESTRE", "4º SEMESTRE", "5º SEMESTRE", "6º SEMESTRE"
    };


    double Soma = 0;
    double Total = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final CheckBox ch1 = (CheckBox) findViewById(R.id.chbMateria1);
        final CheckBox ch2 = (CheckBox) findViewById(R.id.chbMateria2);
        final CheckBox ch3 = (CheckBox) findViewById(R.id.chbMateria3);
        final CheckBox ch4 = (CheckBox) findViewById(R.id.chbMateria4);
        final CheckBox ch5 = (CheckBox) findViewById(R.id.chbMateria5);
        final CheckBox ch6 = (CheckBox) findViewById(R.id.chbMateria6);
        final CheckBox ch7 = (CheckBox) findViewById(R.id.chbMateria7);


        Button btnCalcular = (Button) findViewById(R.id.btnAdicionar);
        Button btnReinicia = (Button) findViewById(R.id.btnReiniciar);

        final Spinner cboSemestre = (Spinner) findViewById(R.id.cboSemestre);
        final ArrayAdapter<String> adpSemestre = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, SEMESTRES);
        adpSemestre.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cboSemestre.setAdapter(adpSemestre);
        cboSemestre.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (cboSemestre.getSelectedItem() == "1º SEMESTRE") {
                    limpa();
                    abreCheckbox();
                    ch7.setVisibility(View.VISIBLE);
                    ch1.setText("HCTI1");
                    ch2.setText("INGI1");
                    ch3.setText("CEEI1");
                    ch4.setText("MATI1");
                    ch5.setText("APOI1");
                    ch6.setText("ARQI1");
                    ch7.setText("LP1I1");


                } else if (cboSemestre.getSelectedItem() == "2º SEMESTRE") {
                    limpa();
                    abreCheckbox();
                    ch1.setText("ADMI2");
                    ch2.setText("BD1I2");
                    ch3.setText("ESWI2");
                    ch4.setText("SOPI2");
                    ch5.setText("LP2I2");
                    ch6.setText("IGTI2");


                } else if (cboSemestre.getSelectedItem() == "3º SEMESTRE") {
                    limpa();
                    abreCheckbox();
                    ch1.setText("AOOI3");
                    ch2.setText("BD2I3");
                    ch3.setText("IHCI3");
                    ch4.setText("ED1I3");
                    ch5.setText("LP3I3");
                    ch6.setText("MFII3");


                } else if (cboSemestre.getSelectedItem() == "4º SEMESTRE") {
                    limpa();
                    abreCheckbox();
                    ch1.setText("MPCI4");
                    ch2.setText("ESTI4");
                    ch3.setText("ED2I4");
                    ch4.setText("POOI4");
                    ch5.setText("RCOI4");
                    ch6.setText("ASWI4");


                } else if (cboSemestre.getSelectedItem() == "5º SEMESTRE") {
                    limpa();
                    abreCheckbox();
                    ch1.setText("GPRI5");
                    ch2.setText("DWEI5");
                    ch3.setText("PS1I5");
                    ch4.setText("QSWI5");
                    ch5.setText("SSRI5");
                    ch6.setText("EL1I5");

                } else if (cboSemestre.getSelectedItem() == "6º SEMESTRE") {
                    limpa();
                    abreCheckbox();
                    ch1.setText("EMPI6");
                    ch2.setText("TPEI6");
                    ch3.setText("SSII6");
                    ch4.setText("DSWI6");
                    ch5.setText("PS2I6");
                    ch6.setText("EL2I6");

                } else {
                    limpa();
                    fechaCheckbox();
                }
            }

            public void limpa() {
                ch1.setText("");
                ch2.setText("");
                ch3.setText("");
                ch4.setText("");
                ch5.setText("");
                ch6.setText("");
                ch7.setText("");
                ch7.setVisibility(View.INVISIBLE);
            }

            public void abreCheckbox() {
                ch1.setEnabled(true);
                ch2.setEnabled(true);
                ch3.setEnabled(true);
                ch4.setEnabled(true);
                ch5.setEnabled(true);
                ch6.setEnabled(true);
                ch7.setEnabled(true);
            }

            public void fechaCheckbox() {
                ch1.setEnabled(false);
                ch2.setEnabled(false);
                ch3.setEnabled(false);
                ch4.setEnabled(false);
                ch5.setEnabled(false);
                ch6.setEnabled(false);
                ch7.setEnabled(false);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        assert btnCalcular != null;
        btnCalcular.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                SomaSemestre();
            }
        });


        assert btnReinicia != null;
        btnReinicia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Total = 0;
                Soma = 0;
                TextView total1 = (TextView) findViewById(R.id.txtTotal);
                total1.setText("  Porcentagem Concluída do Curso = " + String.format("%.2f", (Soma / 37) * 100) + " %.");
                cboSemestre.setAdapter(adpSemestre);
                NaoChecado_Fechado();
            }
        });

    }

    public void NaoChecado_Fechado() {

        CheckBox ch1 = (CheckBox) findViewById(R.id.chbMateria1);
        CheckBox ch2 = (CheckBox) findViewById(R.id.chbMateria2);
        CheckBox ch3 = (CheckBox) findViewById(R.id.chbMateria3);
        CheckBox ch4 = (CheckBox) findViewById(R.id.chbMateria4);
        CheckBox ch5 = (CheckBox) findViewById(R.id.chbMateria5);
        CheckBox ch6 = (CheckBox) findViewById(R.id.chbMateria6);
        CheckBox ch7 = (CheckBox) findViewById(R.id.chbMateria7);

        ch1.setEnabled(false);
        ch2.setEnabled(false);
        ch3.setEnabled(false);
        ch4.setEnabled(false);
        ch5.setEnabled(false);
        ch6.setEnabled(false);
        ch7.setEnabled(false);

        ch1.setChecked(false);
        ch2.setChecked(false);
        ch3.setChecked(false);
        ch4.setChecked(false);
        ch5.setChecked(false);
        ch6.setChecked(false);
        ch7.setChecked(false);
        ch7.setVisibility(View.INVISIBLE);

        ch1.setText("");
        ch2.setText("");
        ch3.setText("");
        ch4.setText("");
        ch5.setText("");
        ch6.setText("");
        ch7.setText("");

    }

    public void SomaSemestre() {

        CheckBox ch1 = (CheckBox) findViewById(R.id.chbMateria1);
        CheckBox ch2 = (CheckBox) findViewById(R.id.chbMateria2);
        CheckBox ch3 = (CheckBox) findViewById(R.id.chbMateria3);
        CheckBox ch4 = (CheckBox) findViewById(R.id.chbMateria4);
        CheckBox ch5 = (CheckBox) findViewById(R.id.chbMateria5);
        CheckBox ch6 = (CheckBox) findViewById(R.id.chbMateria6);
        CheckBox ch7 = (CheckBox) findViewById(R.id.chbMateria7);

        if (ch1.isChecked()) {
            Soma = Soma + 1;
        }
        if (ch2.isChecked()) {
            Soma = Soma + 1;
        }
        if (ch3.isChecked()) {
            Soma = Soma + 1;
        }
        if (ch4.isChecked()) {
            Soma = Soma + 1;
        }
        if (ch5.isChecked()) {
            Soma = Soma + 1;
        }
        if (ch6.isChecked()) {
            Soma = Soma + 1;
        }
        if (ch7.isChecked()) {
            Soma = Soma + 1;
        }

        final TextView total = (TextView) findViewById(R.id.txtTotal);
        total.setText("  Porcentagem Concluída do Curso = " + String.format("%.2f", (Soma / 37) * 100) + " %.");
        NaoChecado_Fechado();

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            Intent sobre = new Intent(MainActivity.this, Sobre.class);
            startActivity(sobre);
            return true;
        } else if (id == R.id.ifsp) {

            Intent ifsp = new Intent(MainActivity.this, Main2Activity.class);
            startActivity(ifsp);
            return true;
        } else if (id == R.id.dependencias) {

            Intent dependencia = new Intent(MainActivity.this, MainActivityDisciplinasRequisitos.class);
            startActivity(dependencia);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
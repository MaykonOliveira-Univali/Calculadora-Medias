package br.univali.calculadorademeediasunivali;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class configActivity extends AppCompatActivity {
    private EditText edtPP1M1;
    private EditText edtPP2M1;
    private EditText edtPP1M2;
    private EditText edtPP2M2;
    private EditText edtPP1M3;
    private EditText edtPP2M3;

    private SharedPreferences sharedPref;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);

        //RESGATANDO COMPONENTES DA TELA PELO ID
        edtPP1M1 = (EditText) findViewById(R.id.ppr1m1);
        edtPP2M1 = (EditText) findViewById(R.id.ppr2m1);
        edtPP1M2 = (EditText) findViewById(R.id.ppr1m2);
        edtPP2M2 = (EditText) findViewById(R.id.ppr2m2);
        edtPP1M3 = (EditText) findViewById(R.id.ppr1m3);
        edtPP2M3 = (EditText) findViewById(R.id.ppr2m3);

        //PEGANDO O SHAREDPREFERENCES PARA RESGATAR OS VALORES
        sharedPref = getSharedPreferences(getString(R.string.pref_key), Context.MODE_PRIVATE);

        //SETANDO OS VALORES QUE ESTÃO NO SHAREDPREFERENCES NOS ELEMENTOS EDITTEXT DO LAYOUT
        edtPP1M1.setText(String.valueOf(sharedPref.getInt("P-PP1M1", 1)));
        edtPP2M1.setText(String.valueOf(sharedPref.getInt("P-PP2M1", 1)));
        edtPP1M2.setText(String.valueOf(sharedPref.getInt("P-PP1M2", 1)));
        edtPP2M2.setText(String.valueOf(sharedPref.getInt("P-PP2M2", 1)));
        edtPP1M3.setText(String.valueOf(sharedPref.getInt("P-PP1M3", 1)));
        edtPP2M3.setText(String.valueOf(sharedPref.getInt("P-PP2M3", 1)));

        Button btnDefinir = (Button) findViewById(R.id.btnDefinir);

        btnDefinir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            //SETANDO OS NOVOS VALORES NO SHAREPREFERENCES DE ACORDO COM O QUE FOI INSERIDO NOS EDITTEXT DO LAYOUT
            editor = sharedPref.edit();
            editor.putInt("P-PP1M1", Integer.valueOf(edtPP1M1.getText().toString()));
            editor.putInt("P-PP2M1", Integer.valueOf(edtPP2M1.getText().toString()));
            editor.putInt("P-PP1M2", Integer.valueOf(edtPP1M2.getText().toString()));
            editor.putInt("P-PP2M2", Integer.valueOf(edtPP2M2.getText().toString()));
            editor.putInt("P-PP1M3", Integer.valueOf(edtPP1M3.getText().toString()));
            editor.putInt("P-PP2M3", Integer.valueOf(edtPP2M3.getText().toString()));
            editor.apply();

            configActivity.this.finish();

            }
        });

    }

}

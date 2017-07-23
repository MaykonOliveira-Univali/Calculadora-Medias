package br.univali.calculadorademeediasunivali;

import android.content.Intent;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);

        edtPP1M1 = (EditText) findViewById(R.id.ppr1m1);
        edtPP2M1 = (EditText) findViewById(R.id.ppr2m1);
        edtPP1M2 = (EditText) findViewById(R.id.ppr1m2);
        edtPP2M2 = (EditText) findViewById(R.id.ppr2m2);
        edtPP1M3 = (EditText) findViewById(R.id.ppr1m3);
        edtPP2M3 = (EditText) findViewById(R.id.ppr2m3);


        edtPP1M1.setText(String.valueOf(R.string.pp1m1));
        edtPP2M1.setText(String.valueOf(R.string.pp2m1));
        edtPP1M2.setText(String.valueOf(R.string.pp1m2));
        edtPP2M2.setText(String.valueOf(R.string.pp2m2));
        edtPP1M3.setText(String.valueOf(R.string.pp1m3));
        edtPP2M3.setText(String.valueOf(R.string.pp2m3));

        Button btnDefinir = (Button) findViewById(R.id.btnDefinir);

        btnDefinir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                MainActivity.PP1M1 = Integer.valueOf(edtPP1M1.getText().toString());
//                MainActivity.PP2M1 = Integer.valueOf(edtPP2M1.getText().toString());
//                MainActivity.PP1M2 = Integer.valueOf(edtPP1M2.getText().toString());
//                MainActivity.PP2M2 = Integer.valueOf(edtPP2M2.getText().toString());
//                MainActivity.PP1M3 = Integer.valueOf(edtPP1M3.getText().toString());
//                MainActivity.PP2M3 = Integer.valueOf(edtPP2M3.getText().toString());

                

                configActivity.this.finish();

            }
        });

    }

}

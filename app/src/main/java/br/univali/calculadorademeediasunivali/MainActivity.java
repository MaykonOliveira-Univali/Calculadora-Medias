package br.univali.calculadorademeediasunivali;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabCalcular);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText EPr1M1 = (EditText) findViewById(R.id.editTextPr1M1);
                EditText EPr2M1 = (EditText) findViewById(R.id.editTextPr2M1);
                EditText EM1 = (EditText) findViewById(R.id.editTextM1);
                float Pr1M1 = new Float(EPr1M1.getText().toString()).floatValue();
                float Pr2M1 = new Float(EPr2M1.getText().toString()).floatValue();
                float M1 = new Float((Pr1M1+Pr2M1)/2);
                String rM1 = String.valueOf(M1);
                EM1.setText(String.valueOf(M1));
                // -- //
                EditText EPr1M2 = (EditText) findViewById(R.id.editTextPr1M2);
                EditText EPr2M2 = (EditText) findViewById(R.id.editTextPr2M2);
                EditText EM2 = (EditText) findViewById(R.id.editTextM2);
                float Pr1M2 = new Float(EPr1M2.getText().toString()).floatValue();
                float Pr2M2 = new Float(EPr2M2.getText().toString()).floatValue();
                float M2 = new Float((Pr1M2+Pr2M2)/2);
                String rM2 = String.valueOf(M2);
                EM2.setText(String.valueOf(M2));
                // -- //
                EditText EPr1M3 = (EditText) findViewById(R.id.editTextPr1M3);
                EditText EPr2M3 = (EditText) findViewById(R.id.editTextPr2M3);
                EditText EM3 = (EditText) findViewById(R.id.editTextM3);
                float Pr1M3 = new Float(EPr1M3.getText().toString()).floatValue();
                float Pr2M3 = new Float(EPr2M3.getText().toString()).floatValue();
                float M3 = new Float((Pr1M3+Pr2M3)/2);
                String rM3 = String.valueOf(M3);
                EM3.setText(String.valueOf(M3));
                // -- //
                float MF = ((M1 + M2 + M3)/3);
                if (MF > 5.75) {
                    Toast.makeText(MainActivity.this,Float.toString(MF) + ", você foi aprovado",Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this,Float.toString(MF) + ", você foi reprovado",Toast.LENGTH_SHORT).show();
                }

            }
        });
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
            moveTaskToBack(true);
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);
        }

        return super.onOptionsItemSelected(item);
    }
    public void sendMessage(View view) {


    }
}

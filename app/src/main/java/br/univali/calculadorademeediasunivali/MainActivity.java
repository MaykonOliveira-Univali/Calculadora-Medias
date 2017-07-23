package br.univali.calculadorademeediasunivali;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText EPr1M1;
    private EditText EPr2M1;
    private TextView EM1;

    private EditText EPr1M2;
    private EditText EPr2M2;
    private TextView EM2;

    private EditText EPr1M3;
    private EditText EPr2M3;
    private TextView EM3;

    private int PP1M1 = 1;
    private int PP2M1 = 1;
    private int PP1M2 = 1;
    private int PP2M2 = 1;
    private int PP1M3 = 1;
    private int PP2M3 = 1;

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
                EPr1M1 = (EditText) findViewById(R.id.editTextPr1M1);
                EPr2M1 = (EditText) findViewById(R.id.editTextPr2M1);
//                EditText EM1 = (EditText) findViewById(R.id.editTextM1);
                EM1 = (TextView) findViewById(R.id.editTextM1);
                float Pr1M1 = new Float(EPr1M1.getText().toString()).floatValue();
                float Pr2M1 = new Float(EPr2M1.getText().toString()).floatValue();
                float M1 = new Float(((Pr1M1*PP1M1)+(Pr2M1*PP2M1))/(PP1M1+PP2M1));
                EM1.setText(String.valueOf(M1));
                // -- //
                EPr1M2 = (EditText) findViewById(R.id.editTextPr1M2);
                EPr2M2 = (EditText) findViewById(R.id.editTextPr2M2);
//                EditText EM2 = (EditText) findViewById(R.id.editTextM2);
                EM2 = (TextView) findViewById(R.id.editTextM2);
                float Pr1M2 = new Float(EPr1M2.getText().toString()).floatValue();
                float Pr2M2 = new Float(EPr2M2.getText().toString()).floatValue();
                float M2 = new Float(((Pr1M2*PP1M2)+(Pr2M2*PP2M2))/(PP1M2+PP2M2));
                EM2.setText(String.valueOf(M2));
                // -- //
                EPr1M3 = (EditText) findViewById(R.id.editTextPr1M3);
                EPr2M3 = (EditText) findViewById(R.id.editTextPr2M3);
//                EditText EM3 = (EditText) findViewById(R.id.editTextM3);
                EM3 = (TextView) findViewById(R.id.editTextM3);
                float Pr1M3 = new Float(EPr1M3.getText().toString()).floatValue();
                float Pr2M3 = new Float(EPr2M3.getText().toString()).floatValue();
                float M3 = new Float(((Pr1M3*PP1M3)+(Pr2M3*PP2M3))/(PP1M3+PP2M3));
                EM3.setText(String.valueOf(M3));
                // -- //
                float MF = ((M1 + M2 + M3)/3);
                if (MF > 5.75) {
//                    Toast.makeText(MainActivity.this,Float.toString(MF) + ", você foi aprovado",Toast.LENGTH_SHORT).show();
//                    teste("Você foi aprovado");
                    show(MainActivity.this, "Média", "Você foi aprovado", android.R.drawable.ic_dialog_info);
                } else {
//                    Toast.makeText(MainActivity.this,Float.toString(MF) + ", você foi reprovado",Toast.LENGTH_SHORT).show();
//                    show(MainActivity.this, "Média", "Você foi aprovado", android.R.drawable.ic_dialog_info);
                    teste("Você foi reprovado");
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
//            moveTaskToBack(true);
//            android.os.Process.killProcess(android.os.Process.myPid());
//            System.exit(1);
            finish();
        }

        if (id == R.id.action_clear){
            clearLabel();
        }

        if (id == R.id.action_peso){
            Intent it = new Intent(this, configActivity.class);
            startActivity(it);
        }

        return super.onOptionsItemSelected(item);
    }
    public void sendMessage(View view) {


    }

    private void clearLabel(){
        EPr1M1 = (EditText) findViewById(R.id.editTextPr1M1);
        EPr2M1 = (EditText) findViewById(R.id.editTextPr2M1);
        EM1 = (TextView) findViewById(R.id.textViewM1);
        EPr1M1.setText(String.valueOf(""));
        EPr2M1.setText(String.valueOf(""));
        EM1.setText(String.valueOf(""));

        EPr1M2 = (EditText) findViewById(R.id.editTextPr1M2);
        EPr2M2 = (EditText) findViewById(R.id.editTextPr2M2);
        EM2 = (TextView) findViewById(R.id.textViewM2);
        EPr1M2.setText(String.valueOf(""));
        EPr2M2.setText(String.valueOf(""));
        EM2.setText(String.valueOf(""));

        EPr1M3 = (EditText) findViewById(R.id.editTextPr1M3);
        EPr2M3 = (EditText) findViewById(R.id.editTextPr2M3);
        EM3 = (TextView) findViewById(R.id.textViewM3);
        EPr1M3.setText(String.valueOf(""));
        EPr2M3.setText(String.valueOf(""));
        EM3.setText(String.valueOf(""));
    }

    private void teste(String status){
        show(this, "Média", status, android.R.drawable.ic_dialog_info);
    }

    private void show(Context ctx, String title, String msg, int iconId){
        //getResources().getDrawable(R.mipmap.ic_launcher);  RECUPERAR IMAGEM DA PASTA MIPMAP
        AlertDialog.Builder dlg = new AlertDialog.Builder(ctx);
        dlg.setIcon(iconId);
        dlg.setTitle(title);
        dlg.setMessage(msg);
        dlg.setNeutralButton("OK",null);
        dlg.show();
    }
}

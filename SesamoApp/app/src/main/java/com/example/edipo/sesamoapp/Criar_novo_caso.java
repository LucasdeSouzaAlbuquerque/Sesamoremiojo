package com.example.edipo.sesamoapp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
//Pacotes importados por eafs2 por pegar valores necessarios para passagem de parametros em telas.
import android.widget.*;
import android.view.*;
//Pacote importado por eafs2 para ser possivel usar uma classe responsavel por chamar os activities
import android.content.*;


public class Criar_novo_caso extends ActionBarActivity implements View.OnClickListener{

    private EditText edtNomeCaso;
    private EditText edtDescricaoCaso;
    private Button btnAvancar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_novo_caso);

        edtNomeCaso = (EditText)findViewById(R.id.edtNomeCaso);
        edtDescricaoCaso = (EditText)findViewById(R.id.edtDescricaoCaso);
        btnAvancar = (Button)findViewById(R.id.btnAvancar);

        btnAvancar.setOnClickListener(this);
    }

    public void onClick(View w){
        finish();
        /*Intent it = new Intent(this, Adicionar_pessoas_ao_caso.class);
        startActivity(it);*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_criar_novo_caso, menu);
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

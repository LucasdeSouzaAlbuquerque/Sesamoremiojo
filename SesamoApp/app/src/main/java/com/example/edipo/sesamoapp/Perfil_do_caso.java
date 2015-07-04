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


public class Perfil_do_caso extends ActionBarActivity{

    private EditText textQueixas;
    private EditText textDados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_do_caso);

        Bundle bundle = getIntent().getExtras();

        if (bundle.containsKey(""))
        {
            String queixas = bundle.getString("");
            textQueixas.setText(queixas);
            String dados = bundle.getString("");
            textQueixas.setText(dados);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_perfil_do_caso, menu);
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

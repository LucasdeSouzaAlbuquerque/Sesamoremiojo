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
//Tela ainda nao acessivel por nao pertencer ao MVP. Acessivel pela tela de "Criar novo caso".

public class Adicionar_pessoas_ao_caso extends ActionBarActivity implements View.OnClickListener {

    private Button btnCriarGrupo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_pessoas_ao_caso);

        btnCriarGrupo = (Button)findViewById(R.id.btnCriarGrupo);
        btnCriarGrupo.setOnClickListener(this);
    }

    public void onClick(View w){
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_adicionar_pessoas_ao_caso, menu);
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

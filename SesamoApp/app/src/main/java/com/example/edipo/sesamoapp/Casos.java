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

public class Casos extends ActionBarActivity implements View.OnClickListener{

    private Button btnNovoCaso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_casos);

        btnNovoCaso = (Button)findViewById(R.id.btnNovoCaso);

        btnNovoCaso.setOnClickListener(this);

        /*Pegando pacote de dados(no momento, o login) da activity anterior
        Bundle bundle = getIntent().getExtras();

        if (bundle.containsKey("Login"))
        {
            String login = bundle.getString("Login");
            edtNome.setText(login);
        }*/

    }

    public void onClick(View w){
        Intent it = new Intent(this, Criar_novo_caso.class);
        startActivity(it);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_casos, menu);
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

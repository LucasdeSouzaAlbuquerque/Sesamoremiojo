package com.example.edipo.sesamoapp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
//Pacotes importados por eafs2 por pegar valores necessários para passagem de parâmetros em telas.
import android.widget.*;
import android.view.*;
//Pacote importado por eafs2 para ser possível usar uma classe responsável por chamar os activities
import android.content.*;

public class ActMain extends ActionBarActivity implements View.OnClickListener {

    private EditText edtNome;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);

        edtNome = (EditText)findViewById(R.id.edtNome);
        btnLogin = (Button)findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(this);
    }

    public void onClick(View w){
        Intent it = new Intent(this, Casos.class);
        it.putExtra("Login", edtNome.getText().toString());
        startActivity(it);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_act_main, menu);
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

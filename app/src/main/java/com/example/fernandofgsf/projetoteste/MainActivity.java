package com.example.fernandofgsf.projetoteste;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fernandofgsf.projetoteste.util.TipoMsg;
import com.example.fernandofgsf.projetoteste.util.Util;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Bem vindo, Galdino!");

//        Button btnEnviar = (Button) findViewById(R.id.btnEnviar);
//        btnEnviar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Util.showMsgAlertOK(MainActivity.this, "Titulo", "Essa é a msg...", TipoMsg.SUCESSO);
//            }
//        });
    }

    public void clickBtnEnviar(View view){
        Util.showMsgAlertOK(MainActivity.this, "Titulo", "Essa é a msg...", TipoMsg.SUCESSO);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_login, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_sair:
                SharedPreferences.Editor editor = getSharedPreferences("pref", Context.MODE_PRIVATE).edit();
                editor.remove("login");
                editor.remove("senha");
                editor.commit();

                finish();
                Intent i = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(i);

                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

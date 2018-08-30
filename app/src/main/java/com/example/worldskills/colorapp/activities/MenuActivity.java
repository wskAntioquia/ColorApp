package com.example.worldskills.colorapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.worldskills.colorapp.R;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    //para ir a al juego por defecto
    public void irAJuego(View view) {
        startActivity(new Intent(MenuActivity.this,JuegoActivity.class));
    }

    //para ir y ver los 4 puntajes mas altos de los juego por defecto
    public void irAPuntajes(View view) {
        startActivity(new Intent(MenuActivity.this,PuntajesActivity.class));
    }

    //para ir a la pantalla de configuracion del juego
    public void irAConfiguracion(View view) {
        startActivity(new Intent(MenuActivity.this,ConfiguracionActivity.class));
    }


}

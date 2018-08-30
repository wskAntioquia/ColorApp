package com.example.worldskills.colorapp.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import com.example.worldskills.colorapp.R;

public class ConfiguracionActivity extends AppCompatActivity {

    private TextInputEditText tiempo,tiempoPalabra,intentos;
    private TextInputLayout tiempoInput,tiempoPalabraInput,intentosInput;
    private Button jugar;
    private RadioButton porTiempo,porIntetos;
    private SharedPreferences preferences;
    private int tipoJuego;

    public final int INTENTOS=0;
    public final int TIEMPO=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);
            inicializar();
            preferences=getSharedPreferences("configuracion",MODE_PRIVATE);
            cargarDatos();
            jugar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //validara campos
                    tipoJuego=(porTiempo.isChecked())?TIEMPO:INTENTOS;
                    Intent intent=new Intent(getApplicationContext(),JuegoActivity.class);
                    if (porTiempo.isChecked()){
                        guardarDatosJuegoTiempo();
                        intent.putExtra("tipoJuego",tipoJuego);
                        intent.putExtra("tiempo",tiempo.getText().toString());
                        intent.putExtra("tiempoPalabra",tiempoPalabra.getText().toString());
                    }else if (porIntetos.isChecked()){
                        guardarDatosJuegoIntento();
                        intent.putExtra("tipoJuego",tipoJuego);
                        intent.putExtra("intentos",intentos.getText().toString());
                        intent.putExtra("tiempoPalabra",tiempoPalabra.getText().toString());

                    }
                    startActivity(intent);
                }
            });

    }

    private void cargarDatos() {
        int tipoJuego =preferences.getInt("tipoJuego",3);
        if (tipoJuego!=3){
            if (tipoJuego==TIEMPO){
                String tiempo=preferences.getString("tiempo",null);
                String tiempoPalabra=preferences.getString("tiempoPalabra",null);
                this.tiempo.setText(tiempo);
                this.tiempoPalabra.setText(tiempoPalabra);
            }else if (tipoJuego==INTENTOS){
                int intentos=preferences.getInt("intentos",0);
                String tiempoPalabra=preferences.getString("tiempoPalabra",null);
                this.intentos.setText(intentos);
                this.tiempoPalabra.setText(tiempoPalabra);
            }
        }
    }

    private void guardarDatosJuegoIntento() {
        SharedPreferences.Editor editor=preferences.edit();
        editor.putInt("tipoJuego",tipoJuego);
        editor.putString("tiempo",tiempo.getText().toString());

        editor.putString("tiempoPalabra",tiempoPalabra.getText().toString());
        editor.apply();
    }

    private void guardarDatosJuegoTiempo() {
        SharedPreferences.Editor editor=preferences.edit();
        editor.putInt("tipoJuego",tipoJuego);
        editor.putInt("intentos",Integer.parseInt(intentos.getText().toString()));
        editor.putString("tiempoPalabra",tiempoPalabra.getText().toString());
        editor.apply();

    }

    private void inicializar() {
        tiempo=findViewById(R.id.txt_tiempo);
        tiempoPalabra=findViewById(R.id.txt_tiempo_palabra);
        intentos=findViewById(R.id.txt_intentos);
        jugar=findViewById(R.id.btn_jugar_config);
        porTiempo=findViewById(R.id.radioButton_tiempo);
        porIntetos=findViewById(R.id.radioButton_intentos);
        tiempoInput=findViewById(R.id.tiempoInput);
        tiempoPalabraInput=findViewById(R.id.tiemPalabraInput);
        intentosInput=findViewById(R.id.intentosInput);

    }

    public void validacionRadios(View view) {
        switch (view.getId()){
            case R.id.radioButton_tiempo:
                intentosInput.setVisibility(View.GONE);
                tiempoInput.setVisibility(View.VISIBLE);
                break;
            case R.id.radioButton_intentos:
                intentosInput.setVisibility(View.VISIBLE);
                tiempoInput.setVisibility(View.GONE);
                break;
        }
    }
}

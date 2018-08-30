package com.example.worldskills.colorapp.activities;

import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.worldskills.colorapp.R;

import java.util.Random;

public class JuegoActivity extends AppCompatActivity {
    Button pause;
    TextView palabras, correctas, total_p, intentos;
    FloatingActionButton f1, f2, f3, f4;
    
    String colores[]={"AMARILLO","AZUL","ROJO","VERDE"};
    long tiempo_palabra=3000;
    int correcta=0, incorrecta=0, total_palabras=0, posicion_palabra, mil=1000,  intento=3;
    boolean seleccio=false, estado=true;
    Random random= new Random();
    CountDownTimer contador_palabra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);
        inicializar();
        play();
        
        
    }

    //cuando la el juego se esta ejecutando y el boton esta en estado de play
    private void play() {
        iniciarJuego();
        cambiarPalabra();
        cambiarColorPalabra();
        cambiarColorBotones();
    }

    //cambiar el color de los botones
    private void cambiarColorBotones() {
    }

    //cambiar el color de la tinta de los botones
    private void cambiarColorPalabra() {
    }

    //cambiar la palabra presentada
    private void cambiarPalabra() {
        habilitarBotones();
        total_palabras++;
        total_p.setText(total_palabras+"");
        
        posicion_palabra=random.nextInt(4);
        palabras.setText(colores[posicion_palabra]);
        
        contador_palabra= new CountDownTimer(tiempo_palabra,mil) {
            @Override
            public void onTick(long millisUntilFinished) {
                
            }

            @Override
            public void onFinish() {
                if (!intentos.getText().toString().equalsIgnoreCase("0")){
                    if (seleccio==false){
                        intento--;
                        incorrecta++;
                    }
                    cambiarPalabra();
                    cambiarColorBotones();
                    cambiarColorPalabra();
                }

            }
        }.start();
        
    }

    private void habilitarBotones() {
    }

    private void iniciarJuego() {
    }

    //inicializar los elementos de la interfaz grafica
    private void inicializar() {
        palabras= findViewById(R.id.textView_palabra);
        correctas= findViewById(R.id.textView_correctas);
        intentos= findViewById(R.id.textView_intentos);
        total_p= findViewById(R.id.textView_totalp);

        f1= findViewById(R.id.floatingActionButton);
        f2= findViewById(R.id.floatingActionButton2);
        f3= findViewById(R.id.floatingActionButton3);
        f4= findViewById(R.id.floatingActionButton4);

        pause= findViewById(R.id.button_pause);
        
        
    }
}

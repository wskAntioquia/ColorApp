package com.example.worldskills.colorapp.activities;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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
    int correcta=0, incorrecta=0, total_palabras=0, posicion_palabra, mil=1000,  intento=3, count=0;
    boolean seleccio=false, estado=true;
    int bcolor1=0,bcolor2=0,bcolor3=0,bcolor4=0, color;
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
        estado=false;
        pause.setText("PAUSE");
    }

    //cambiar el color de los botones
    private void cambiarColorBotones() {
        boolean btn1=false,btn2=false,btn3=false,btn4=false;
        int color1=0,color2=0,color3=0,color4=0;
        while (btn1==false || btn2==false || btn3==false ||btn4==false){
            int azar=random.nextInt(4);
            switch (azar){
                case 0:
                    if (btn1==false){
                        if (color1==0){
                            f1.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#1EA1BE")));
                            color1=1;
                            btn1=true;
                            bcolor1=0;
                            break;
                        }
                        if (color2==0){
                            f1.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#169133")));
                            color2=1;
                            btn1=true;
                            bcolor1=1;
                            break;
                        }
                        if (color3==0){
                            f1.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#891210")));
                            color3=1;
                            btn1=true;
                            bcolor1=2;
                            break;
                        }
                        if (color4==0){
                            f1.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#DBDB1A")));
                            color4=1;
                            btn1=true;
                            bcolor1=3;
                            break;
                        }

                    }

                case 1:
                    if (btn2==false){
                        if (color1==0){
                            f2.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#1EA1BE")));
                            color1=1;
                            btn2=true;
                            bcolor2=0;
                            break;
                        }
                        if (color2==0){
                            f2.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#169133")));
                            color2=1;
                            btn2=true;
                            bcolor2=1;
                            break;
                        }
                        if (color3==0){
                            f2.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#891210")));
                            color3=1;
                            btn2=true;
                            bcolor2=2;
                            break;
                        }
                        if (color4==0){
                            f2.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#DBDB1A")));
                            color4=1;
                            btn2=true;
                            bcolor2=3;
                            break;
                        }

                    }

                case 2:
                    if (btn3==false){
                        if (color1==0){
                            f3.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#1EA1BE")));
                            color1=1;
                            btn3=true;
                            bcolor3=0;
                            break;
                        }
                        if (color2==0){
                            f3.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#169133")));
                            color2=1;
                            btn3=true;
                            bcolor3=1;
                            break;
                        }
                        if (color3==0){
                            f3.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#891210")));
                            color3=1;
                            btn3=true;
                            bcolor3=2;
                            break;
                        }
                        if (color4==0){
                            f3.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#DBDB1A")));
                            color4=1;
                            btn1=true;
                            bcolor3=3;
                            break;
                        }

                    }

                case 3:
                    if (btn4==false){
                        if (color1==0){
                            f4.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#1EA1BE")));
                            color1=1;
                            btn4=true;
                            bcolor4=0;
                            break;
                        }
                        if (color2==0){
                            f4.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#169133")));
                            color2=1;
                            btn4=true;
                            bcolor4=1;
                            break;
                        }
                        if (color3==0){
                            f4.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#891210")));
                            color3=1;
                            btn4=true;
                            bcolor4=2;
                            break;
                        }
                        if (color4==0){
                            f4.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#DBDB1A")));
                            color4=1;
                            btn4=true;
                            bcolor4=3;
                            break;
                        }

                    }

                }
        }



    }

    //cambiar el color de la tinta de los botones
    private void cambiarColorPalabra() {
         color=random.nextInt(4);
        switch (color){
            case 0:
                palabras.setTextColor(Color.parseColor("#1EA1BE"));
                break;
            case 1:
                palabras.setTextColor(Color.parseColor("#169133"));
                break;
            case 2:
                palabras.setTextColor(Color.parseColor("#891210"));
                break;
            case 3:
                palabras.setTextColor(Color.parseColor("#DBDB1A"));
                break;
        }
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
                        intentos.setText(intento+"");
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
        f1.setEnabled(true);
        f2.setEnabled(true);
        f3.setEnabled(true);
        f4.setEnabled(true);
    }
    private void desabiliotarBotones() {
        f1.setEnabled(false);
        f2.setEnabled(false);
        f3.setEnabled(false);
        f4.setEnabled(false);
    }

    private void iniciarJuego() {
        if (incorrecta==5){
            contador_palabra.cancel();
        }
        if (count==4){
            pause.setEnabled(false);
        }
        if (intento==0){
            contador_palabra.cancel();
        }
    }

    //inicializar los elementos de la interfaz grafica
    private void inicializar() {
        palabras= findViewById(R.id.textView_palabra);
        correctas= findViewById(R.id.textView_correctas);
        intentos= findViewById(R.id.textView_intentos);
        intentos.setText("3");
        total_p= findViewById(R.id.textView_totalp);

        f1= findViewById(R.id.floatingActionButton);
        f2= findViewById(R.id.floatingActionButton2);
        f3= findViewById(R.id.floatingActionButton3);
        f4= findViewById(R.id.floatingActionButton4);

        pause= findViewById(R.id.button_pause);
        
        
    }

    public void pausarJuego(View view) {
        count++;
        if (estado){
            total_palabras--;
            play();
        }else {
            pause();

        }
    }

    private void pause() {
        estado=true;
        pause.setText("PLAY");
        contador_palabra.cancel();
        desabiliotarBotones();
    }

    public void verificarResouesta(View view) {
        desabiliotarBotones();
        if (f1.getId()==view.getId()){
            if (color==bcolor1){
                correcta++;
                correctas.setText(correcta+"");
            }
        }

        if (f2.getId()==view.getId()){
            if (color==bcolor2){
                correcta++;
                correctas.setText(correcta+"");
            }
        }

        if (f3.getId()==view.getId()){
            if (color==bcolor3){
                correcta++;
                correctas.setText(correcta+"");
            }
        }

        if (f4.getId()==view.getId()){
            if (color==bcolor4){
                correcta++;
                correctas.setText(correcta+"");
            }
        }

    }
}

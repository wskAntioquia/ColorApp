package com.example.worldskills.colorapp.activities;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.example.worldskills.colorapp.R;
import com.example.worldskills.colorapp.data.Constantes;
import com.example.worldskills.colorapp.data.DataBase;

import java.util.SimpleTimeZone;

public class PuntajesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puntajes);
        ListView lista = findViewById(R.id.lista);
        int campos[]={R.id.textView_puntajep};
        String columnas[]={Constantes.CORRECTAS};
        DataBase dataBase= new DataBase(getApplicationContext());
        Cursor c= dataBase.listarPuntajes();
        SimpleCursorAdapter adapter=new SimpleCursorAdapter(getApplicationContext(),R.layout.plantilla,c,columnas,campos);
        lista.setAdapter(adapter);

    }
}

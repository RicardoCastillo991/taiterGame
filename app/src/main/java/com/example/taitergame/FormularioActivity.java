package com.example.taitergame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FormularioActivity extends AppCompatActivity {
    private Button btnDosJugadores,btnTresJugadores, btnCuatroJugadores;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        btnDosJugadores = (Button) findViewById(R.id.btnDosJugadores);
        btnTresJugadores = (Button)findViewById(R.id.btnTresJugadores);
        btnCuatroJugadores = (Button) findViewById(R.id.btnCuatroJugadores);

        btnDosJugadores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FormularioActivity.this, DosJugadoresActivity.class);
                startActivity(intent);
            }
        });

        btnTresJugadores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FormularioActivity.this, CuatroJugadoresActivity.class);
                intent.putExtra("Jugadores", "3");
                startActivity(intent);
            }
        });

        btnCuatroJugadores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FormularioActivity.this, CuatroJugadoresActivity.class);
                intent.putExtra("Jugadores", "4");
                startActivity(intent);
            }
        });



    }
}
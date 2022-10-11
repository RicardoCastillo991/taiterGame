package com.example.taitergame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FormularioActivity extends AppCompatActivity {
    private Button btnDosJugadores, btnCuatroJugadores;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        btnDosJugadores = (Button) findViewById(R.id.btnDosJugadores);
        btnCuatroJugadores = (Button) findViewById(R.id.btnCuatroJugadores);

        btnDosJugadores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FormularioActivity.this, DosJugadoresActivity.class);
                startActivity(intent);
            }
        });

        btnCuatroJugadores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FormularioActivity.this, CuatroJugadoresActivity.class);
                startActivity(intent);
            }
        });

    }
}
package com.example.taitergame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class JuegoActivity extends AppCompatActivity {
    private TextView tvNumeroJugadores, tvTiempo, tvJugadorUno, tvJugadorDos, tvJugadorTres, tvJugadorCuatro;
    private Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);
        tvNumeroJugadores = (TextView) findViewById(R.id.tvNumeroJugadores);
        tvTiempo = (TextView) findViewById(R.id.tvTiempo);
        tvJugadorUno = (TextView) findViewById(R.id.tvJugador1);
        tvJugadorDos = (TextView) findViewById(R.id.tvJugador2);
        tvJugadorTres = (TextView) findViewById(R.id.tvJugadorTres);
        tvJugadorCuatro = (TextView) findViewById(R.id.tvJugadorCuatro);

        bundle = getIntent().getExtras();
        String jugadores = bundle.getString("Jugadores");
        String tiempo = bundle.getString("tiempo");
        String jugadorUno = bundle.getString("jugadorUno");
        String jugadorDos = bundle.getString("jugadorDos");
        String jugadorTres = bundle.getString("jugadorTres");
        String jugadorCuatro = bundle.getString("jugadorCuatro");


        tvTiempo.setText(tiempo);
        tvJugadorUno.setText(jugadorUno);
        tvJugadorDos.setText(jugadorDos);
        tvJugadorTres.setText(jugadorTres);
        tvJugadorCuatro.setText(jugadorCuatro);
        tvNumeroJugadores.setText(jugadores);
    }
}
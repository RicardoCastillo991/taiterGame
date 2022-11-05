package com.example.taitergame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class JuegoActivity extends AppCompatActivity {
    private TextView tvJugadorUno, tvJugadorDos, tvJugadorTres, tvJugadorCuatro, tvOxigenos, tvBasuras;
    private ImageButton btnJugadorUno, btnJugadorDos, btnJugadorTres, btnJugadorCuatro, btnSumarOxigeno, btnRestarOxigeno, btnSumarBasura;
    private Button btnTerminarGame;
    private Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);
        tvJugadorUno = findViewById(R.id.tvJugadorUno);
        tvJugadorDos = findViewById(R.id.tvJugadorDos);
        tvJugadorTres = findViewById(R.id.tvJugadorTres);
        tvJugadorCuatro = findViewById(R.id.tvJugadorCuatro);
        tvOxigenos = findViewById(R.id.tvOxigenos);
        tvBasuras =findViewById(R.id.tvBasuras);
        btnJugadorUno = findViewById(R.id.btnJugadorUno);
        btnJugadorDos = findViewById(R.id.btnJugadorDos);
        btnJugadorTres = findViewById(R.id.btnJugadorTres);
        btnJugadorCuatro = findViewById(R.id.btnJugadorCuatro);
        btnTerminarGame = findViewById(R.id.btnTerminarGame);
        btnSumarOxigeno = findViewById(R.id.imgSumarOxigeno);
        btnRestarOxigeno = findViewById(R.id.imgRestarOxigeno);
        btnSumarBasura = findViewById(R.id.imgSumarBasura);

        //se toman los datos de la activity pasada.
        bundle = getIntent().getExtras();
        String jugadores = bundle.getString("Jugadores");
        String jugadorUno = bundle.getString("jugadorUno");
        String jugadorDos = bundle.getString("jugadorDos");
        String jugadorTres = bundle.getString("jugadorTres");
        String jugadorCuatro = bundle.getString("jugadorCuatro");

        //creacion del objeto jugador
        Juego juego = new Juego();
        Jugador ObJugadorUno = new Jugador();
        ObJugadorUno.setNombre(jugadorUno);
        Jugador ObJugadorDos = new Jugador();
        ObJugadorDos.setNombre(jugadorDos);
        ObJugadorDos.setOxigeno(11);
        ObJugadorDos.setBasura(2);
        Jugador ObJugadorTres = new Jugador();
        ObJugadorTres.setNombre(jugadorTres);
        Jugador ObJugadorCuatro = new Jugador();
        ObJugadorCuatro.setNombre(jugadorCuatro);

        //ocultar los jugadores que no van a jugar y crear las clases
        int numeroJugadores = Integer.parseInt(jugadores);

        if(numeroJugadores == 4){

        }
        if(numeroJugadores == 3){
            tvJugadorCuatro.setVisibility(View.INVISIBLE);
            btnJugadorCuatro.setVisibility(View.INVISIBLE);
        }
        if(numeroJugadores == 2){
            tvJugadorCuatro.setVisibility(View.INVISIBLE);
            btnJugadorCuatro.setVisibility(View.INVISIBLE);
            tvJugadorTres.setVisibility(View.INVISIBLE);
            btnJugadorTres.setVisibility(View.INVISIBLE);
        }

        //poniendo los nombre de los jugadores en los textView
        tvOxigenos.setText("Oxigenos ");
        tvBasuras.setText("Basuras ");
        tvJugadorUno.setText(jugadorUno);
        tvJugadorDos.setText(jugadorDos);
        tvJugadorTres.setText(jugadorTres);
        tvJugadorCuatro.setText(jugadorCuatro);

        final int[] turno = {0,1,2,3,4};
        btnJugadorUno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvOxigenos.setText("Oxigeno "+ObJugadorUno.getOxigeno());
                tvBasuras.setText("Basuras "+ObJugadorUno.getBasura());
                juego.setTurno(1);
            }
        });

        btnJugadorDos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvOxigenos.setText("Oxigeno "+ObJugadorDos.getOxigeno());
                tvBasuras.setText("Basuras "+ObJugadorDos.getBasura());
                juego.setTurno(2);
            }
        });

        btnJugadorTres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvOxigenos.setText("Oxigeno "+ObJugadorTres.getOxigeno());
                tvBasuras.setText("Basuras "+ObJugadorTres.getBasura());
                juego.setTurno(3);
            }
        });

        btnJugadorCuatro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvOxigenos.setText("Oxigeno "+ObJugadorCuatro.getOxigeno());
                tvBasuras.setText("Basuras "+ObJugadorCuatro.getBasura());
                juego.setTurno(4);
            }
        });

        btnSumarOxigeno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(juego.getTurno() == 1) {
                    ObJugadorUno.setOxigeno(ObJugadorUno.getOxigeno()+1);
                    tvOxigenos.setText("Oxigeno "+ObJugadorUno.getOxigeno());
                }
                if(juego.getTurno() == 2) {
                    ObJugadorDos.setOxigeno(ObJugadorDos.getOxigeno()+1);
                    tvOxigenos.setText("Oxigeno "+ObJugadorDos.getOxigeno());
                }
                if(juego.getTurno() == 3) {
                    ObJugadorTres.setOxigeno(ObJugadorTres.getOxigeno()+1);
                    tvOxigenos.setText("Oxigeno "+ObJugadorTres.getOxigeno());
                }
                if(juego.getTurno() == 4) {
                    ObJugadorCuatro.setOxigeno(ObJugadorCuatro.getOxigeno()+1);
                    tvOxigenos.setText("Oxigeno "+ObJugadorCuatro.getOxigeno());
                }
            }
        });
        btnRestarOxigeno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(juego.getTurno() == 1) {
                    ObJugadorUno.setOxigeno(ObJugadorUno.getOxigeno()-1);
                    tvOxigenos.setText("Oxigeno "+ObJugadorUno.getOxigeno());
                }
                if(juego.getTurno() == 2) {
                    ObJugadorDos.setOxigeno(ObJugadorDos.getOxigeno()-1);
                    tvOxigenos.setText("Oxigeno "+ObJugadorDos.getOxigeno());
                }
                if(juego.getTurno() == 3) {
                    ObJugadorTres.setOxigeno(ObJugadorTres.getOxigeno()-1);
                    tvOxigenos.setText("Oxigeno "+ObJugadorTres.getOxigeno());
                }
                if(juego.getTurno() == 4) {
                    ObJugadorCuatro.setOxigeno(ObJugadorCuatro.getOxigeno()-1);
                    tvOxigenos.setText("Oxigeno "+ObJugadorCuatro.getOxigeno());
                }
            }
        });
        btnSumarBasura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(juego.getTurno() == 1) {
                    if(ObJugadorUno.getBasura() < 3){
                        ObJugadorUno.setBasura(ObJugadorUno.getBasura()+1);
                    }
                    else{
                        ObJugadorUno.setBasura(0);
                    }
                    tvBasuras.setText("Basuras "+ObJugadorUno.getBasura());
                }
                if(juego.getTurno() == 1) {
                    if(ObJugadorDos.getBasura() < 3){
                        ObJugadorDos.setBasura(ObJugadorDos.getBasura()+1);
                    }
                    else{
                        ObJugadorDos.setBasura(0);
                    }
                    tvBasuras.setText("Basuras "+ObJugadorDos.getBasura());
                }
                if(juego.getTurno() == 1) {
                    if(ObJugadorTres.getBasura() < 3){
                        ObJugadorTres.setBasura(ObJugadorTres.getBasura()+1);
                    }
                    else{
                        ObJugadorTres.setBasura(0);
                    }
                    tvBasuras.setText("Basuras "+ObJugadorTres.getBasura());
                }
                if(juego.getTurno() == 1) {
                    if(ObJugadorCuatro.getBasura() < 3){
                        ObJugadorCuatro.setBasura(ObJugadorCuatro.getBasura()+1);
                    }
                    else{
                        ObJugadorCuatro.setBasura(0);
                    }
                    tvBasuras.setText("Basuras "+ObJugadorCuatro.getBasura());
                }
            }
        });

        btnTerminarGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(JuegoActivity.this, InicioActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
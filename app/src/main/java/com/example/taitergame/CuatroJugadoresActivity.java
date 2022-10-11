package com.example.taitergame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class CuatroJugadoresActivity extends AppCompatActivity {
    private Button btnComenzar;
    private Bundle bundle;
    private EditText txtJugadorUno,txtJugadorDos, txtJugadorCuatro, txtJugadorTres;
    private ConstraintLayout colorJugadorCuatro, colorJugadorTres;
    private TextView txtTiempo;
    private SeekBar seekBarTiempo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuatro_jugadores);
        txtJugadorUno = (EditText)findViewById(R.id.txtJugadorUno);
        txtJugadorDos = (EditText)findViewById(R.id.txtJugadorDos);

        btnComenzar = (Button) findViewById(R.id.btnComenzarPartida);

        //Estos objetos son para el uso de solo un activity para dos condiciones.
        txtJugadorCuatro = (EditText)findViewById(R.id.txtJugadorCuatro);
        colorJugadorCuatro = (ConstraintLayout)findViewById(R.id.colorJugador4);

        txtJugadorTres = (EditText)findViewById(R.id.txtJugadorTres);
        colorJugadorTres = (ConstraintLayout)findViewById(R.id.colorJugador3);
        //El seekbar y tv son para la medicion y utilizacion del tiempo para cada jugador.
        txtTiempo = (TextView)findViewById(R.id.txtTiempo);
        seekBarTiempo = (SeekBar)findViewById(R.id.seekBarTiempo2);
        //el bundle toma los datos de los botones de formulario para saber cuantos jugadores son.
        bundle = getIntent().getExtras();
        String jugadores = bundle.getString("Jugadores");
        //transformar de string a int
        int numeroJugadores = Integer.parseInt(jugadores);

        if(numeroJugadores == 3){
            txtJugadorCuatro.setVisibility(View.INVISIBLE);
            colorJugadorCuatro.setBackgroundColor(Color.parseColor("#ffffff"));
        }
        if(numeroJugadores == 2){
            txtJugadorCuatro.setVisibility(View.INVISIBLE);
            colorJugadorCuatro.setBackgroundColor(Color.parseColor("#ffffff"));
            txtJugadorTres.setVisibility(View.INVISIBLE);
            colorJugadorTres.setBackgroundColor(Color.parseColor("#ffffff"));
        }

        //Adaptacion del limites del tiempo para la seekbar(el juego no puede durar menos de 30 segundos).
        seekBarTiempo.setMax(330);
        seekBarTiempo.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int valor = i + 30;
                txtTiempo.setText((String.valueOf(valor)));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        btnComenzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numeroJugadoresString = jugadores;
                String tiempo = txtTiempo.getText().toString();
                String jugadorUno = txtJugadorUno.getText().toString();
                String jugadorDos = txtJugadorDos.getText().toString();
                String jugadorTres = txtJugadorTres.getText().toString();
                String jugadorCuatro = txtJugadorCuatro.getText().toString();

                Intent intent = new Intent(CuatroJugadoresActivity.this, JuegoActivity.class);
                intent.putExtra("tiempo", tiempo);
                intent.putExtra("Jugadores", numeroJugadoresString);
                if(numeroJugadores == 2){
                    intent.putExtra("jugadorUno", jugadorUno);
                    intent.putExtra("jugadorDos", jugadorDos);
                }
                if(numeroJugadores == 3){
                    intent.putExtra("jugadorUno", jugadorUno);
                    intent.putExtra("jugadorDos", jugadorDos);
                    intent.putExtra("jugadorTres", jugadorTres);
                }
                if(numeroJugadores == 4){
                    intent.putExtra("jugadorUno", jugadorUno);
                    intent.putExtra("jugadorDos", jugadorDos);
                    intent.putExtra("jugadorTres", jugadorTres);
                    intent.putExtra("jugadorCuatro", jugadorCuatro);
                }
                startActivity(intent);
            }
        });
    }
}
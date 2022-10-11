package com.example.taitergame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcel;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class CuatroJugadoresActivity extends AppCompatActivity {
    private Button btnComenzar;
    private Bundle bundle;
    private EditText txtJugadorCuatro;
    private ConstraintLayout colorJugadorCuatro;
    private TextView txtTiempo;
    private SeekBar seekBarTiempo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuatro_jugadores);
        btnComenzar = (Button) findViewById(R.id.btnComenzarPartida);

        //Estos objetos son para el uso de solo un activity para dos condiciones.
        txtJugadorCuatro = (EditText)findViewById(R.id.txtJugadorCuatro);
        colorJugadorCuatro = (ConstraintLayout)findViewById(R.id.colorJugador4);
        //El seekbar y tv son para la medicion y utilizacion del tiempo para cada jugador.
        txtTiempo = (TextView)findViewById(R.id.txtTiempo);
        seekBarTiempo = (SeekBar)findViewById(R.id.seekBarTiempo2);
        //el bundle toma los datos de los botones de formulario para saber cuantos jugadores son.
        bundle = getIntent().getExtras();
        String jugadores = bundle.getString("Jugadores");

        int numeroJugadores = Integer.parseInt(jugadores);

        if(numeroJugadores == 3){
            txtJugadorCuatro.setVisibility(View.INVISIBLE);
            colorJugadorCuatro.setBackgroundColor(Color.parseColor("#ffffff"));
        }

        //Adaptacion del limites del tiempo para la seekbar(el juego no puede durar menos de 30 segundos).
        seekBarTiempo.setMax(330);

        seekBarTiempo.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int valor = i + 30;
                txtTiempo.setText("Segundos: "+(String.valueOf(valor)));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });






    }
}
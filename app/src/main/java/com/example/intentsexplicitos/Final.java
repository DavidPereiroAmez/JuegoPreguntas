package com.example.intentsexplicitos;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Final extends AppCompatActivity {
    Button buttonReturn;
    RadioGroup respuestas;
    int sumaCorrectas;
    ImageView fotoFinish;
    Drawable imagenFinal;
    TextView nombreFinal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        Bundle extras = getIntent().getExtras();
        int respuestasCorrectas = extras.getInt("sumaCorrectas");
        sumaCorrectas += respuestasCorrectas;
        System.out.println(sumaCorrectas);
        TextView repuestasCorrectas = (TextView) findViewById(R.id.repuestasCorrectas);
        repuestasCorrectas.setText("" + sumaCorrectas);
        buttonReturn = findViewById(R.id.buttonReturn);
        fotoFinish = findViewById(R.id.fotoFinish);
        nombreFinal = findViewById(R.id.nombreFinal);
        //int id = getResources().getIdentifier("@drawable/gandalf", null, null);
        switch(sumaCorrectas){
            case 0: imagenFinal = getResources().getDrawable(R.drawable.smeagol);
                    fotoFinish.setImageDrawable(imagenFinal);
                    nombreFinal.setText(getString(R.string.gollum));
            break;
            case 1: imagenFinal = getResources().getDrawable(R.drawable.samsagaz);
                    fotoFinish.setImageDrawable(imagenFinal);
                nombreFinal.setText(getString(R.string.samsagaz));
                break;
            case 2: imagenFinal = getResources().getDrawable(R.drawable.elrond);
                    fotoFinish.setImageDrawable(imagenFinal);
                nombreFinal.setText(getString(R.string.elrond));
                break;
            case 3: imagenFinal = getResources().getDrawable(R.drawable.gandalf);
                    fotoFinish.setImageDrawable(imagenFinal);
                nombreFinal.setText(getString(R.string.gandalf));
                break;
            case 4: imagenFinal = getResources().getDrawable(R.drawable.feanor);
                fotoFinish.setImageDrawable(imagenFinal);
                nombreFinal.setText(getString(R.string.feanor));
                break;
        }
        buttonReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }

        });
    }
}
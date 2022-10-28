package com.example.intentsexplicitos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class Pregunta1 extends AppCompatActivity {

    Button botonSeguir;
    RadioGroup respuestas;
    int sumaCorrectas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta1);
        Intent intent = new Intent(Pregunta1.this, Pregunta2.class);
        botonSeguir = findViewById(R.id.buttonNext);
        respuestas = findViewById(R.id.radioGroup1);
        respuestas.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i){
                if(i == R.id.respuesta1b){
                    sumaCorrectas = 1;
                }else{
                    sumaCorrectas = 0;
                }
            }
        });
        botonSeguir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("sumaCorrectas", sumaCorrectas);
                Pregunta1.this.startActivity(intent);
                finish();
            }

        });
    }

}
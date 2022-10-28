package com.example.intentsexplicitos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class Pregunta4 extends AppCompatActivity {

    Button botonSeguir;
    RadioGroup respuestas;
    int sumaCorrectas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta4);
        Bundle extras = getIntent().getExtras();
        int respuestasCorrectas = extras.getInt("sumaCorrectas");
        sumaCorrectas += respuestasCorrectas;
        //System.out.println(respuestasCorrectas);
        Intent intent = new Intent(Pregunta4.this, Final.class);
        botonSeguir = findViewById(R.id.buttonNext4);
        respuestas = findViewById(R.id.radioGroup4);
        respuestas.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i){
                if(i == R.id.respuesta4c){
                    sumaCorrectas += 1;
                }else{
                    sumaCorrectas += 0;
                }
            }
        });
        botonSeguir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("sumaCorrectas", sumaCorrectas);
                Pregunta4.this.startActivity(intent);
                finish();
            }

        });
    }
}
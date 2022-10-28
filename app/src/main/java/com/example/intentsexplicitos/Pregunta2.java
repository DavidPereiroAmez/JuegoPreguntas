package com.example.intentsexplicitos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class Pregunta2 extends AppCompatActivity {

    Button botonSeguir;
    RadioGroup respuestas;
    int sumaCorrectas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta2);
        Bundle extras = getIntent().getExtras();
        int respuestasCorrectas = extras.getInt("sumaCorrectas");
        sumaCorrectas += respuestasCorrectas;
        //System.out.println(respuestasCorrectas);
        Intent intent = new Intent(Pregunta2.this, Pregunta3.class);
        botonSeguir = findViewById(R.id.buttonNext2);
        respuestas = findViewById(R.id.radioGroup2);
        respuestas.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i){
                if(i == R.id.respuesta2b){
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
                Pregunta2.this.startActivity(intent);
                finish();
            }

        });
    }

}
package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class VentanaPotencia extends AppCompatActivity {

    EditText editNumBase;
    EditText editNumPotencia;
    int numBase;
    int numPotencia;
    int resultadoOperacion;
    String textResultado;
    Button buttonPotencia;
    TextView resulPotencia;
    Calculadora calculadora;
    Button buttonRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        editNumBase = findViewById(R.id.numBase);
        editNumPotencia = findViewById(R.id.numPotencia);
        buttonPotencia = findViewById(R.id.buttonPotencia);
        resulPotencia = findViewById(R.id.resultPotencia);
        buttonRegresar = findViewById(R.id.buttonRegresarPot);

        buttonPotencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iniciarDatos(editNumPotencia, editNumBase);
                resultadoOperacion = calculadora.potencia(numPotencia, numBase);
                textResultado = getStringNum(resultadoOperacion);
                resulPotencia.setText(textResultado);
            }
        });

        buttonRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cambiarMenu();
            }
        });
    }

    protected void iniciarDatos(EditText editNum1, EditText editNum2){
        this.calculadora = new Calculadora();
        this.numBase = getIntNum(editNum1);
        this.numPotencia = getIntNum(editNum2);
    }

    public int getIntNum(EditText editNum1){
        String textNum1 = editNum1.getText().toString();
        int num = Integer.parseInt(textNum1);
        return num;
    }

    public String getStringNum(int resultOperacion){
        String textOperacion = String.valueOf(resultOperacion);
        return  textOperacion;
    }

    public void cambiarMenu(){
        Intent menu = new Intent(this,MainActivity.class);
        startActivity(menu);
    }
}
package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class VentanaFibonacci extends AppCompatActivity {

    EditText editNumFibo;
    int numFibo;
    String textNumFibo;
    Button buttonFibo;
    TextView resultFibo;
    Calculadora calculadora;
    int resultadoOpFibo;
    String textResult;
    Button buttonRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        editNumFibo = findViewById(R.id.numFibonacci);
        buttonFibo = findViewById(R.id.buttonFibonacci);
        resultFibo = findViewById(R.id.resultadoFibo);
        buttonRegresar = findViewById(R.id.buttonRegresarFibo);

        buttonFibo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iniciarDatos(editNumFibo);
                resultadoOpFibo = calculadora.fibonacci(numFibo);
                textResult = getStringNum(resultadoOpFibo);
                resultFibo.setText(textResult);
            }
        });

        buttonRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cambiarMenu();
            }
        });
    }

    protected void iniciarDatos(EditText editNum1){
        this.calculadora = new Calculadora();
        this.numFibo = getIntNum(editNum1);
    }

    public int getIntNum(EditText editNum1){
        textNumFibo = editNum1.getText().toString();
        int num = Integer.parseInt(textNumFibo);
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
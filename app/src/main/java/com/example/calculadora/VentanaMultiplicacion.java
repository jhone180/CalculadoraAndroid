package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class VentanaMultiplicacion extends AppCompatActivity {

    EditText editNum1;
    EditText editNum2;
    String textNum1;
    String textNum2;
    int num1;
    int num2;
    Button buttonResult;
    TextView result;
    Calculadora calculadora;
    int resultadoMul;
    String textResult;
    Button buttonRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        editNum1 = findViewById(R.id.num1);
        editNum2 = findViewById(R.id.num2);
        buttonResult = findViewById(R.id.buttonResult);
        result = findViewById(R.id.result);
        buttonRegresar = findViewById(R.id.buttonRegresarMult);

        buttonResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iniciarDatos(editNum1, editNum2);
                resultadoMul = calculadora.multiplicacion(num1, num2);
                textResult = getStringNum(resultadoMul);
                result.setText(textResult);
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
        this.num1 = getIntNum(editNum1);
        this.num2 = getIntNum(editNum2);
    }

    public int getIntNum(EditText editNum1){
        textNum1 = editNum1.getText().toString();
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
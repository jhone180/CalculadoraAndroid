package com.example.calculadora;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button buttonOperacion;
    EditText editNumOperacion;
    int numOperacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonOperacion = findViewById(R.id.buttonOperacion);
        editNumOperacion = findViewById(R.id.numOperacion);
        buttonOperacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numOperacion = getIntNum(editNumOperacion);
                validacionVentana(numOperacion, view);
            }
        });
    }

    public void validacionVentana(int operacion, View view){
        switch (operacion) {
            case 1:
                cambiarMultiplicacion();
                break;
            case 2:
                cambiarFibonacci();
                break;
            case 3:
                cambiarPotencia();
                break;
            default:
                mostrarAlerta(view);
        }
    }

    public int getIntNum(EditText editNum1){
        String textNum1 = editNum1.getText().toString();
        int num = Integer.parseInt(textNum1);
        return num;
    }

    public void cambiarMultiplicacion(){
        Intent multiplicacion = new Intent(this, VentanaMultiplicacion.class);
        startActivity(multiplicacion);
    }

    public void cambiarFibonacci(){
        Intent fibonacci = new Intent(this, VentanaFibonacci.class);
        startActivity(fibonacci);
    }

    public void cambiarPotencia(){
        Intent potencia = new Intent(this, VentanaPotencia.class);
        startActivity(potencia);
    }


    public void mostrarAlerta(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("¡Alerta!")
                .setMessage("Numero no corresponde a ninguna operación.")
                .setNegativeButton("Aceptar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alerta = builder.create();
        alerta.show();
    }

}
package com.example.calculadora;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity {

    private GoogleMap mMap;
    private Button btnMap;

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

        btnMap = findViewById(R.id.btn_map);

        // Agregar un Listener al botón
        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear un Intent para abrir la actividad del mapa
                Intent mapIntent = new Intent(MainActivity.this, MapsActivity.class);

                // Agregar la ubicación específica en un objeto Bundle
                Bundle args = new Bundle();
                LatLng location = new LatLng(4.653384977826347, -74.14522083254803); // San Francisco
                args.putParcelable("location", location);
                mapIntent.putExtra("bundle", args);

                // Iniciar la actividad del mapa
                startActivity(mapIntent);
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
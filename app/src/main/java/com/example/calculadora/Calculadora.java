package com.example.calculadora;

public class Calculadora {

    int resultado;

    public int potencia(int num1, int num2){
        if(num2 == 1){
            return num1;
        } else {
            return num1 * potencia(num1, num2 - 1);
        }
    }

    public int fibonacci(int num1){
        if(num1 <= 1){
            return num1;
        } else {
            return fibonacci(num1 - 1) + fibonacci(num1 - 2);
        }
    }

    public int multiplicacion(int num1, int num2){
        resultado = num1 * num2;
        return resultado;
    }
}

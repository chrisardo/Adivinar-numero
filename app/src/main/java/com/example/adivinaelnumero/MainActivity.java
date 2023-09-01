package com.example.adivinaelnumero;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText num;
    TextView resultado;
    TextView n_intentos;
    //creo las variable para contar el numero de intentos y una para el numero aleatorio
    int intento= 0;
    int rndvar;
    //Invocamos el objeto Random
    final Random miRandom = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num = (EditText)findViewById(R.id.numero);
        resultado = (TextView)findViewById(R.id.resultado);
        n_intentos = (TextView)findViewById(R.id.intento);

        //Guardando en una variable un numero aleatorio del 1 al 100
        rndvar = miRandom.nextInt(100);
    }

    public void Adivinar(View view){

        String numeString = num.getText().toString();
        int numeInt = Integer.parseInt(numeString);

        if (numeInt == rndvar){
            resultado.setText("Genial !! Adivinaste el numero");
        }else{
            if (numeInt > rndvar){
                Toast.makeText(this, "Es menor que: " + numeInt, Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this, "Es mayor que: " + numeInt, Toast.LENGTH_LONG).show();
            }
        }

        num.requestFocus();
        intento++;
        n_intentos.setText("Intentos: " + intento);
    }

    public void borrar(View view){
        num.setText("");
       resultado.setText("");
       n_intentos.setText("");
       intento = 0;
       rndvar = ' ';
    }
}

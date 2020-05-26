package com.fernandomoya.fernadomoya_examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Registro extends AppCompatActivity {

    Bundle nombreUsuario;
    TextView mensajeBienvenida,aPagar,nombreCompleto, montoInicial;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        mensajeBienvenida = findViewById(R.id.lblBienvenido);
        nombreUsuario = getIntent().getExtras();

        nombreCompleto = findViewById(R.id.txtNombreCompleto);
        montoInicial = findViewById(R.id.txtMontoInicial);
        aPagar= findViewById(R.id.lblApagarMensual);

        String datoRecibido = "Bienvenido " + nombreUsuario.getString("usuario");
        mensajeBienvenida.setText(datoRecibido);
    }

    public void calcularMonto(View V){
        double monto=0;
        double aPagarMensual=0;

            monto = Integer.parseInt(montoInicial.getText().toString());
            aPagarMensual = ((1800 - monto) / 3) * 1.05;
            aPagar.setText(String.valueOf(aPagarMensual));
    }

    public void enviarRegistro(View v) {
        Intent respuestas = new Intent(this, Encuesta.class);
        double pagar=0;
        double pagarMensual=0;
        double totalPagar=0;

            pagar = Integer.parseInt(montoInicial.getText().toString());
            pagarMensual = ((1800 - pagar) / 3) * 1.05;
            totalPagar = pagarMensual * 3;
            respuestas.putExtra("nombreCompleto", nombreCompleto.getText().toString());
            respuestas.putExtra("totalPagar", String.valueOf(totalPagar));
            respuestas.putExtra("usuario", mensajeBienvenida.getText().toString());
            startActivity(respuestas);
            Toast.makeText(getApplicationContext(), "Elemento guardado con\n" +
                "exito",Toast.LENGTH_LONG).show();
    }





}

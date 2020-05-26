package com.fernandomoya.fernadomoya_examen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Resumen extends AppCompatActivity {
    Bundle respuestaFormulario;
    TextView respuesta1,respuesta21,respuesta22,respuesta23,respuesta3,nombre,total, user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumen);

        respuesta1=findViewById(R.id.lblResultadoP1);
        respuesta21=findViewById(R.id.lblResultadoP21);
        respuesta22=findViewById(R.id.lblResultadoP22);
        respuesta23=findViewById(R.id.lblResultadoP23);
        respuesta3=findViewById(R.id.lblResultadoP3);

        nombre=findViewById(R.id.lblUsuarioConectado);
        total=findViewById(R.id.lblTotalPago);
        user=findViewById(R.id.lblUsuarioResumen);

        respuestaFormulario=getIntent().getExtras();

        String datoRespuesta1=respuestaFormulario.getString("respuestaRazon");
        respuesta1.setText(datoRespuesta1);

        String datoRespuesta21=respuestaFormulario.getString("respuestaFutbol");
        respuesta21.setText(datoRespuesta21);
        String datoRespuesta22=respuestaFormulario.getString("respuestaTennis");
        respuesta22.setText(datoRespuesta22);
        String datoRespuesta23=respuestaFormulario.getString("respuestaBasket");
        respuesta23.setText(datoRespuesta23);

        String datoRespuesta3=respuestaFormulario.getString("respuestaSi");
        respuesta3.setText(datoRespuesta3);

        String datoRespuesta4="Nombre: "+respuestaFormulario.getString("nombreCompleto");
        nombre.setText(datoRespuesta4);

        String datoRespuesta5= "Total a pagar: $ "+  respuestaFormulario.getString("totalPagar");
        total.setText(datoRespuesta5);

        String datoRespuesta6=respuestaFormulario.getString("usuario");
        user.setText(datoRespuesta6);

    }
}

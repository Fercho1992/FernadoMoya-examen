package com.fernandomoya.fernadomoya_examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Encuesta extends AppCompatActivity {
    Bundle respuestaFormulario;
    TextView nombre, total, razon, user;
    CheckBox cbfutbol, cbtennis, cbbasket;
    RadioButton rdSi, rdNo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encuesta);

        nombre=findViewById(R.id.lblN);
        total=findViewById(R.id.lblT);
        user=findViewById(R.id.lblNombreUsuario);
        respuestaFormulario=getIntent().getExtras();
        String datoRespuesta1=respuestaFormulario.getString("nombreCompleto");
        nombre.setText(datoRespuesta1);
        String datoRespuesta2=respuestaFormulario.getString("totalPagar");
        total.setText(datoRespuesta2);
        String datoRespuesta3=respuestaFormulario.getString("usuario");
        user.setText(datoRespuesta3);
        razon = findViewById(R.id.txtPregunta1);
        rdSi=findViewById(R.id.rbSi);
        rdNo=findViewById(R.id.rbNo);
        cbfutbol=findViewById(R.id.cbFutbol);
        cbtennis=findViewById(R.id.cbTennis);
        cbbasket=findViewById(R.id.cbBasketball);

    }

    public void enviarFormularioRespuestas(View v) {
        Intent respuestas = new Intent(this, Resumen.class);

        if (rdSi.isChecked()==true) {
            respuestas.putExtra("respuestaSi", rdSi.getText().toString());
        }
        if(rdNo.isChecked()==true){
            respuestas.putExtra("respuestaSi", rdNo.getText().toString());
        }
        if (cbfutbol.isChecked()==true) {
            respuestas.putExtra("respuestaFutbol", cbfutbol.getText().toString());
        }
        if (cbtennis.isChecked()==true) {
            respuestas.putExtra("respuestaTennis", cbtennis.getText().toString());
        }
        if (cbbasket.isChecked()==true) {
            respuestas.putExtra("respuestaBasket", cbbasket.getText().toString());
        }
        respuestas.putExtra("respuestaRazon", razon.getText().toString());
        respuestas.putExtra("nombreCompleto", nombre.getText().toString());
        respuestas.putExtra("usuario", user.getText().toString());
        respuestas.putExtra("totalPagar",  total.getText().toString());
        startActivity(respuestas);
        Toast.makeText(getApplicationContext(), "Encuesta guardada con\n" +
                "exito",Toast.LENGTH_LONG).show();
    }
}

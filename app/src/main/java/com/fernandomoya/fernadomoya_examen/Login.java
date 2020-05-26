package com.fernandomoya.fernadomoya_examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login();
    }

    public void login() {
        Button Login = (Button) findViewById(R.id.btnLogin);
        Login.setOnClickListener (new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                EditText user=(EditText) findViewById(R.id.txtUsuario);
                String usuario = user.getText().toString();
                EditText pass=(EditText) findViewById(R.id.txtContrasena);
                String password = pass.getText().toString();
                String userStored="estudiante2020";
                String passStored="uisrael2020";
                if (usuario.equals(userStored) & password.equals(passStored)){
                    Intent intentEnvio= new Intent(Login.this, Registro.class);
                    intentEnvio.putExtra("usuario",user.getText().toString());
                    startActivity(intentEnvio);
                }
                else {
                    Toast.makeText(getApplicationContext(), "Usuario y/o contraseña  son incorrectas",Toast.LENGTH_LONG).show();
                }
            }
        });
    }


}

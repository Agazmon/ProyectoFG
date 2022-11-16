package com.example.proyectobookit.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyectobookit.R;
import com.example.proyectobookit.data.model.RequestAPI;

//Vista de login
public class LoginActivity extends AppCompatActivity {
    EditText etUsuario, etPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Obtención de los elementos implicados
        this.etUsuario = (EditText) findViewById(R.id.editUsuario);
        this.etPass = (EditText) findViewById(R.id.editPass);
    }
    // Compbrobaciones básicas antes de conectar al usuario
    public void conecta(View view) {
        try {
            RequestAPI requestAPI = new RequestAPI(this);
            String user = etUsuario.getText().toString();
            String pass = etPass.getText().toString();
            if (user.trim().equals("")) {
                etUsuario.setError("Usuario vacío");
            } else if (user.length() > 30) {
                etUsuario.setError("Usuario demasiado largo");
            } else if(pass.length()<5){
                etUsuario.setError("Usuario demasiado corto. Mínimo de 5 caracteres");
            }
            if (pass.trim().equals("")) {
                etPass.setError("Contraseña vacía");
            } else if (pass.length() > 30) {
                etPass.setError("Contraseña demasiado larga");
            } else if (pass.length() < 7) {
                etPass.setError("Contraseña demasiado corta. Mínimo de 7 caracteres.");
            }
            if (etUsuario.getError() == null && etPass.getError() == null) {
                requestAPI.loginRequest(user, pass);
            }
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
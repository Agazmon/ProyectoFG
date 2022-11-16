package com.example.proyectobookit.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyectobookit.R;
import com.example.proyectobookit.data.model.RequestAPI;
import com.example.proyectobookit.ui.search.SearchActivity;

import org.json.JSONArray;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    //Usuario conectado
    private String usuario;
    // Objeto para lanzar request, tiene que ser estático para poder acceder al el, pese a que se inicialice
    private RequestAPI requestAPI;
    // RecyclerView para las reservas
    private RecyclerView rvRestaurante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Inicializar el objeto de request
        requestAPI = new RequestAPI(this);
        // Obtener extras
        Bundle extras = getIntent().getExtras();
        if(extras!=null){
            //Obtener vistas
            TextView tvBienvenida = (TextView) findViewById(R.id.tvBienvenida);
            rvRestaurante = findViewById(R.id.rvReservas);
            //LISTENERS
            findViewById(R.id.ibBuscarRestaurante).setOnClickListener(v -> abrirBusqueda(v));
            this.usuario = extras.getString("user");
            if(usuario.equals("")) {
                Toast.makeText(getApplicationContext(), "Error: Usuario no usado correctamente 1", Toast.LENGTH_SHORT).show();
                finish();
            }
            //Capitalizar primera letra
            String mensaje = tvBienvenida.getText().toString();
            usuario = usuario.substring(0,1).toUpperCase() + usuario.substring(1);
            String nuevo = String.format(mensaje,usuario);
            tvBienvenida.setText(nuevo);
            //Layout horizontal para ver reservas
            LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL,false);
            rvRestaurante.setLayoutManager(layoutManager);
            rvRestaurante.setItemAnimator(new DefaultItemAnimator());
            requestAPI.obtenerReservasUsuario(usuario);
        } else{
            //Volver al login
            Toast.makeText(getApplicationContext(), "Error: Usuario no usado correctamente 2", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
    //Codigo para que consulte las reservas después de volver de otras pantallas
    @Override
    protected void onResume() {
        requestAPI = new RequestAPI(this);
        requestAPI.obtenerReservasUsuario(usuario);
        super.onResume();
    }
    // Función para establecer los elementos del HorizontalAdapter
    public void setReservasUsuario(JSONArray reservasUsuario){
        HorizontalAdapter hAdapter = new HorizontalAdapter(this, reservasUsuario);
        rvRestaurante.setAdapter(hAdapter);
    }
    // Intent para abrir la busqueda
    public void abrirBusqueda(View v){
        Intent intent = new Intent(this, SearchActivity.class);
        intent.putExtra("user", usuario);
        this.startActivity(intent);
    }

}
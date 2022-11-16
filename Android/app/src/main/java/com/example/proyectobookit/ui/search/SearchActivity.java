package com.example.proyectobookit.ui.search;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ListView;

import com.example.proyectobookit.R;
import com.example.proyectobookit.data.model.RequestAPI;
import com.example.proyectobookit.ui.main.MainActivity;
import com.example.proyectobookit.ui.restaurant.RestaurantActivity;

import org.json.JSONArray;

import okhttp3.OkHttpClient;

public class SearchActivity extends AppCompatActivity {
    // Lista en la que apareceran los restaurantes encontrados
    private ListView lvRestaurantes;
    // Objeto array de los restaurantes
    private JSONArray restaurantes;
    // Bundle pasado de la actividad principal
    private Bundle bundle;
    //Inicializar la actividad
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        // Obtener los elementos de la vista
        SearchView svRestaurante = (SearchView) findViewById(R.id.svRestaurante);
        lvRestaurantes = (ListView) findViewById(R.id.lvRestaurantes);
        // Configuracion de la vista
        svRestaurante.setIconifiedByDefault(false);
        // Listener para buscar
        svRestaurante.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                buscar(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return true;
            }
        });
    }
    // Metodo que realiza la busqueda
    public void buscar(String nombreRestaurante) {
        if (nombreRestaurante == null || nombreRestaurante.trim().equals("")) {
            Toast.makeText(this, "Error: Nombre de restaurante no válido.", Toast.LENGTH_SHORT).show();
        }
        else if(nombreRestaurante.length()<4){
            Toast.makeText(this, "Error: Nombre de restaurante demasiado corto.",Toast.LENGTH_SHORT).show();
        }else{
            RequestAPI requestAPI = new RequestAPI(this);
            requestAPI.buscarRestaurante(nombreRestaurante, this);
        }

    }
    // Metodo que pone la lista en la pantalla
    public void setLista(JSONArray restaurantes){
        this.restaurantes = restaurantes;
        if(restaurantes != null) {
            if (bundle == null) {
                bundle = this.getIntent().getExtras();
            }
            if (bundle == null) {
                Toast.makeText(this, "Error: Se ha perdido el nombre usuario.", Toast.LENGTH_SHORT).show();
                finish();
            } else {
                String usuario = bundle.getString("user");
                if (usuario.equals("")) {
                    Toast.makeText(this, "Error: Se ha perdido el nombre usuario.", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    lvRestaurantes.setAdapter(new CustomListViewAdapter(this, restaurantes, usuario));
                }

            }
        }
    }
}
package com.example.proyectobookit.ui.search;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.proyectobookit.R;
import com.example.proyectobookit.ui.restaurant.RestaurantActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CustomListViewAdapter extends BaseAdapter {

    // Contexto
    Context ctx;
    // Datos para pintar la lista
    JSONArray restaurantes;
    // Inflater de la vista
    LayoutInflater inflater;
    // Usuario conectado
    String usuarioLogeado;
    // Constructor del adaptador personalizado
    public CustomListViewAdapter(Context ctx, JSONArray restaurantes, String usuario){
        this.ctx = ctx;
        this.restaurantes = restaurantes;
        inflater = LayoutInflater.from(ctx);
        usuarioLogeado = usuario;
    }
    // Devuelve le numero de elementos
    @Override
    public int getCount() {
        return restaurantes.length();
    }
    // No necesito este metodo
    @Override
    public Object getItem(int position) {
        return null;
    }
    // No neceisto este metodo
    @Override
    public long getItemId(int position) {
        return 0;
    }
    // Obtener la vista que tiene que pintar
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        try {
            // Inflater para la vista
            convertView = inflater.inflate(R.layout.activity_list_view_restaurante, null);
            // Pintar los datos del restaurante
            JSONObject restaurante = restaurantes.getJSONObject(position);
            TextView tvRestaurante = (TextView) convertView.findViewById(R.id.tvRestName);
            tvRestaurante.setText(restaurante.getString("nombre"));
            TextView tvLocation = (TextView) convertView.findViewById(R.id.tvRestLocation);
            tvLocation.setText(restaurante.getString("direccion"));
            ImageView logoImg = (ImageView) convertView.findViewById(R.id.ivLogoRest);
            String telefono = restaurante.getString("telefono");
            // Poner el logo del restaurante
            logoImg.setImageResource(R.drawable.ic_fork_and_knife_cutlery_circle_interface_symbol_for_restaurant_svgrepo_com);
            // Listener al hacerle click
            convertView.setOnClickListener(e-> {
                Intent intent = new Intent(e.getContext(), RestaurantActivity.class);
                intent.putExtra("restaurante", ((TextView)(e.findViewById(R.id.tvRestName))).getText());
                intent.putExtra("telefono",(telefono));
                intent.putExtra("user", usuarioLogeado);
                e.getContext().startActivity(intent);
            });
            //Listener para llamar al restaurante
            ImageButton ibLlamada = (ImageButton) convertView.findViewById(R.id.ibPhone);
            ibLlamada.setOnClickListener(e->{
                Intent intent = new Intent(Intent.ACTION_DIAL);
                String telefonoUri="tel:+"+telefono;
                intent.setData(Uri.parse(telefonoUri));
                e.getContext().startActivity(intent);
            });

       } catch (JSONException e) {
            e.printStackTrace();
        }
        return convertView;
    }
}

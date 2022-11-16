package com.example.proyectobookit.ui.main;

import android.content.Context;
import android.content.res.Resources;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectobookit.R;

import org.json.JSONArray;
import org.json.JSONException;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

//Visualizador horizontal para las reservas
public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.ViewHolder> {
    // Contexto
    private Context contexto;
    // Las reservas a pintar
    private JSONArray reservas;
    public HorizontalAdapter(Context contexto, JSONArray reservas){
        this.contexto = contexto;
        this.reservas = reservas;

    }
    //Funcion que rellena el recycler view
    @NonNull
    @Override
    public HorizontalAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Crear la vista
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_restaurante,parent,false);
        return new ViewHolder(view);
    }
    // Asignación de los datos datos a los que hay que mostrar
    @Override
    public void onBindViewHolder(@NonNull HorizontalAdapter.ViewHolder holder, int position) {
        try {
            holder.tvNumeroReserva.setText("Reserva Nº"+reservas.getJSONObject(position).getString("idReserva"));
            holder.ivLogo.setImageResource(R.drawable.ic_fork_and_knife_cutlery_circle_interface_symbol_for_restaurant_svgrepo_com);
            holder.tvNombreRest.setText(reservas.getJSONObject(position).getString("nombreRestaurante").toString());
            //DIA
            String diaReserva = reservas.getJSONObject(position).getString("diaReserva").toString();
            diaReserva = diaReserva.replace("-","");
            String horaReserva = reservas.getJSONObject(position).getString("horaReserva");
            Date fecha = new Date(Integer.parseInt(diaReserva.substring(0,4)), Integer.parseInt(diaReserva.substring(5,6))-1, Integer.parseInt(diaReserva.substring(6)), Integer.parseInt(horaReserva.substring(0,2)),Integer.parseInt(horaReserva.substring(4,5)));
            SimpleDateFormat forma = new SimpleDateFormat("dd/MM");
            diaReserva = forma.format(fecha);
            holder.tvDiaReserva.setText("Dia:" + diaReserva);
            //HORA
            SimpleDateFormat patron = new SimpleDateFormat("HH:mm");
            horaReserva = patron.format(fecha);
            holder.tvHoraReservaItem.setText("Hora:"+horaReserva);
            // Codigo para mostrar algo mas personalizado a la hora de mostrar el estado de la reserva
            switch(reservas.getJSONObject(position).getString("estado")){
                case "1":
                    holder.rbEstado.setButtonTintList(holder.resources.getColorStateList(R.color.reservaPendiente));
                    holder.rbEstado.setText("Estado: Pendiente");
                    break;
                case "2":
                    holder.rbEstado.setButtonTintList(holder.resources.getColorStateList(R.color.reservaConfirmada));
                    holder.rbEstado.setText("Estado: Confirmada");
                    break;
                case "0":
                    holder.rbEstado.setButtonTintList(holder.resources.getColorStateList(R.color.reservaCancelada));
                    holder.rbEstado.setText("Estado: Cancelada");
                    break;
                default:
                    holder.rbEstado.setButtonTintList(holder.resources.getColorStateList(R.color.reservaCancelada));
                    holder.rbEstado.setText("Estado: Desconocido");
                    break;
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return reservas.length();
    }
    // Elementos que usa la vista
    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView ivLogo;
        TextView tvNombreRest,tvDiaReserva,tvHoraReservaItem, tvNumeroReserva;
        RadioButton rbEstado;
        Resources resources;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivLogo = itemView.findViewById(R.id.ivLogoRestItem);
            tvNombreRest = itemView.findViewById(R.id.tvNombreRestItem);
            tvDiaReserva = itemView.findViewById(R.id.tvDiaReservaItem);
            tvHoraReservaItem = itemView.findViewById(R.id.tvHoraReservaItem);
            rbEstado = itemView.findViewById(R.id.estadoReserva);
            tvNumeroReserva = itemView.findViewById(R.id.tvNumReserva);
            resources = itemView.getResources();
        }
    }
}

package com.example.proyectobookit.ui.restaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.proyectobookit.R;
import com.example.proyectobookit.data.model.RequestAPI;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalField;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class RestaurantActivity extends AppCompatActivity {

    // Elementos de la vista
    private RequestAPI requestAPI;
    private EditText etFechaHora, etNumComensal;
    private Spinner spinnerHora;
    private Button btBookit;
    //Datos reserva
    private String usuarioLogeado;
    private String dayBookit;
    private String nombreRest;
    private String telefonoRest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);
        // Obtener datos del intent
        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
            usuarioLogeado = bundle.getString("user");
        } else{
            finish();
        }
        nombreRest = bundle.getString("restaurante");
        telefonoRest = bundle.getString("telefono");
        // inicializar api
        requestAPI = new RequestAPI(this);
        //Elementos de la vista
        ((TextView) this.findViewById(R.id.tvNombreRest)).setText(nombreRest);
        etFechaHora = findViewById(R.id.etFechaHora);
        etNumComensal = findViewById(R.id.etNumComensal);
        spinnerHora = findViewById(R.id.spinnerHoras);
        btBookit = (Button) findViewById(R.id.btBookit);
        etFechaHora.setOnClickListener(e-> seleccionarFecha(etFechaHora));
        btBookit.setOnClickListener(e-> reserva());


    }
    //Comprobaciones básicas para reservar
    private void reserva(){
        if(etFechaHora.getText().toString().equals("")){
            Toast.makeText(this, "Error: Debe seleccionar una fecha para reservar",Toast.LENGTH_SHORT).show();
        }else if(spinnerHora.getSelectedItem()==null){
            Toast.makeText(this, "Error: Debe seleccionar una fecha válida para reservar",Toast.LENGTH_SHORT).show();
        } else if(spinnerHora.getSelectedItem().toString().equals("")){
            Toast.makeText(this, "Error: Debe seleccionar una hora para reservar",Toast.LENGTH_SHORT).show();
        } else if(etNumComensal.getText().toString().equals("")){
            Toast.makeText(this, "Error: Debe de tener al menos un comensal para poder reservar",Toast.LENGTH_SHORT).show();
        } else if(Integer.parseInt(etNumComensal.getText().toString())>10){
            Toast.makeText(this, "Error: Para reservas de mas de 10 comensales, contacte con el restaurante",Toast.LENGTH_SHORT).show();
        } else{
            String horaReserva = spinnerHora.getSelectedItem().toString().substring(0,2);
            String formatohora = "%s:00:00";
            horaReserva = String.format(formatohora, horaReserva);
            int numComensales = Integer.parseInt(etNumComensal.getText().toString());
            requestAPI.reserva(usuarioLogeado,nombreRest,telefonoRest,dayBookit, horaReserva,numComensales);
        }
    }
    // Seleccionador de la fecha
    private void seleccionarFecha(EditText etFechaHora) {
        DatePickerDialog dpd;
        Calendar calendario = Calendar.getInstance();
        int day = calendario.get(Calendar.DAY_OF_MONTH);
        int month = calendario.get(Calendar.MONTH);
        int year = calendario.get(Calendar.YEAR);
        dpd = new DatePickerDialog(RestaurantActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int mYear, int mMonth, int mDay) {

                SimpleDateFormat simpledateformat = new SimpleDateFormat("EEEE");
                Date date = new Date(mYear, mMonth+1, mDay);
                String dayOfWeek = simpledateformat.format(date);
                Calendar calendar = Calendar.getInstance();
                calendar.set(mYear, mMonth, mDay);
                // Ajustar el dia de la semana
                int diaSemanaNumero=0;
                switch(calendar.get(Calendar.DAY_OF_WEEK)){
                    case Calendar.SUNDAY:
                        diaSemanaNumero = 7;
                        break;
                    case Calendar.MONDAY:
                        diaSemanaNumero = 1;
                        break;
                    case Calendar.TUESDAY:
                        diaSemanaNumero = 2;
                        break;
                    case Calendar.WEDNESDAY:
                        diaSemanaNumero = 3;
                        break;
                    case Calendar.THURSDAY:
                        diaSemanaNumero = 4;
                        break;
                    case Calendar.FRIDAY:
                        diaSemanaNumero = 5;
                        break;
                    case Calendar.SATURDAY:
                        diaSemanaNumero = 6;
                        break;
                }
                // FIN ajustar el dia de la semana
                String formato = "%d-%d";
                String mensaje = String.format(formato, mDay, mMonth+1);
                etFechaHora.setText(mensaje);
                // FIN Formateo para campo
                // Comparar dias
                int diaActual = calendario.getInstance().get(Calendar.DAY_OF_YEAR);
                calendario.set(mYear, mMonth, mDay);
                int diaSeleccionado = calendario.get(Calendar.DAY_OF_YEAR);
                // FIN Comparar dias
                requestAPI.obtenerHorarioRestaurante(nombreRest, telefonoRest,diaSemanaNumero, diaSeleccionado==diaActual);
                // Formato para BBDD
                String formatoBookit = "%d-%d-%d";
                dayBookit = String.format(formatoBookit,mYear, mMonth+1, mDay);
                // FIN Formato para BBDD
            }
        }, day, month, year);
        dpd.getDatePicker().setMinDate(System.currentTimeMillis());
        long tiempo2Semanas = 14*24*60*60*1000;
        dpd.getDatePicker().setMaxDate(System.currentTimeMillis()+tiempo2Semanas);
        dpd.show();
    }
    // Establece las horas que está abierto el restaurante
    public void setArrayHoras(String[] horas){
        if(horas!=null) {
            ArrayAdapter<String> adaptarItems = new ArrayAdapter<String>(this, R.layout.list_item, horas);
            Spinner spinnerHoras = ((RestaurantActivity) this).findViewById(R.id.spinnerHoras);
            spinnerHoras.setAdapter(adaptarItems);
        } else{
            spinnerHora.setAdapter(null);
        }
    }
}
package com.example.proyectobookit.data.model;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;


import com.example.proyectobookit.ui.main.MainActivity;
import com.example.proyectobookit.ui.restaurant.RestaurantActivity;
import com.example.proyectobookit.ui.search.SearchActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

import com.example.proyectobookit.R;


public class RequestAPI {
    // Contexto sobre el que se realizan las operaciones
    protected static Context app;
    // IP del servidor
    private final String ip = "https://40289522.servicio-online.net/api/android";
    // Cliente para lanzar las peticiones
    private final OkHttpClient client = new OkHttpClient();
    //Constructor parametrizado
    public RequestAPI(Context app) {
        RequestAPI.app = app;
    }
    // Lanza la petición de login
    public void loginRequest(String usuario, String pass) throws IOException {
        String subapi = "/getLoginUsuario.php";
        String params = "?user=" + usuario + "&pass=" + getSHA256(pass);
        Request request = new Request.Builder()
                .url(ip + subapi + params)
                .build();
        client.newCall(request).enqueue(new Callback() {
            String respuestaServer;

            @Override
            public void onFailure(Call call, IOException e) {
                tostadaMainThread("Error al conectar con el servidor");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    if (!response.isSuccessful())
                        throw new IOException("Unexpected code " + response);
                    respuestaServer = responseBody.string();
                    if (respuestaServer.equals("")) {
                        tostadaMainThread("No hay respuesta del servidor");
                    } else {
                        JSONObject respuestaJSON = obtenerJSON(respuestaServer);
                        if (respuestaJSON.getString("tipoMensaje").equals("ERROR")) {
                            tostadaMainThread(respuestaJSON.getString("mensaje"));
                        } else {
                            tostadaMainThread("Sesión iniciada");
                            sesionIniciada(usuario);
                        }
                    }
                } catch (Exception e) {
                    throw new IOException("Error en la traducción de la respuesta" + e.getMessage() + respuestaServer);
                }
            }
        });

    }
    // peticion que obtiene los restaurantes por nombre, para mostrarlos en la pantalla de busqueda
    public void buscarRestaurante(String nombreRestaurante, SearchActivity searchActivity) {
        String subapi = "/searchRestaurante.php";
        String params = "?nombre=" + nombreRestaurante;
        Request request = new Request.Builder()
                .url(ip + subapi + params)
                .build();
        client.newCall(request).enqueue(new Callback() {
            String respuestaServer;

            @Override
            public void onFailure(Call call, IOException e) {
                tostadaMainThread("Error al conectar con el servidor");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    if (!response.isSuccessful())
                        throw new IOException("Unexpected code " + response);
                    respuestaServer = responseBody.string();
                    if (respuestaServer.equals("")) {
                        tostadaMainThread("No hay respuesta del servidor");
                    } else {
                        JSONObject respuestaJSON = obtenerJSON(respuestaServer);
                        if (respuestaJSON.getString("tipoMensaje").equals("ERROR")) {
                            tostadaMainThread(respuestaJSON.getString("mensaje"));
                        } else {
                            JSONArray restaurantes = respuestaJSON.getJSONArray("mensaje");
                            if (restaurantes.length() == 0) {
                                tostadaMainThread("No hay restaurantes");
                                //TODO Poner en la lista un elemento vacío que indique que no hay restaurantes
                            } else {
                                pintar(restaurantes);
                            }
                        }
                    }
                } catch (Exception e) {
                    throw new IOException("Error en la traducción de la respuesta" + e.getMessage());
                }
            }
        });
    }

    //Pintar los elementos en la lista en la pantalla de busqueda
    protected static void pintar(JSONArray restaurantes) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                SearchActivity busqueda = (SearchActivity) app;
                busqueda.setLista(restaurantes);
            }
        });

    }
    // Obtención dinamica del horario del restaurante dependiendo del día de la semana dado
    public void obtenerHorarioRestaurante(String nombreRestaurante, String telefono, int diaSemana, boolean hoy) {
        String subapi = "/getHorarioRestaurante.php";
        String params = "?nombre=" + nombreRestaurante + "&telefono=" + telefono + "&diaSemana=" + diaSemana;
        Request request = new Request.Builder()
                .url(ip + subapi + params)
                .build();
        client.newCall(request).enqueue(new Callback() {
            String respuestaServer;

            @Override
            public void onFailure(Call call, IOException e) {
                tostadaMainThread("Error al conectar con el servidor");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    if (!response.isSuccessful())
                        throw new IOException("Unexpected code " + response);
                    respuestaServer = responseBody.string();
                    if (respuestaServer.equals("")) {
                        tostadaMainThread("No hay respuesta del servidor");
                    } else {
                        JSONObject respuestaJSON = obtenerJSON(respuestaServer);
                        if (respuestaJSON.getString("tipoMensaje").equals("ERROR")) {
                            tostadaMainThread(respuestaJSON.getString("mensaje"));
                            new Handler(Looper.getMainLooper()).post(new Runnable() {
                                @Override
                                public void run() {
                                    ((RestaurantActivity) app).setArrayHoras(null);
                                }
                            });
                        } else {
                            JSONObject horarios = obtenerJSON(respuestaJSON.getString("mensaje"));
                            int apertura = Integer.parseInt(horarios.getString("apertura"));
                            int cierre = Integer.parseInt(horarios.getString("cierre"));
                            int diferencia = cierre - apertura;
                            //Obtención del array de las horas
                            String[] array = new String[diferencia];
                            List<String> rangosHorarios = new ArrayList<>();
                            int posArray = 0;
                            //Creación del array de forma dinámica
                            for (int i = apertura; i < cierre; i++) {
                                if (i < 9) {
                                    array[posArray++] = ("0" + i + ":00-" + "0" + (i + 1) + ":00");
                                } else if (i == 9) {
                                    array[posArray++] = ("0" + i + ":00-" + (i + 1) + ":00");
                                } else {
                                    array[posArray++] = (i + ":00-" + (i + 1) + ":00");
                                }
                            }
                            new Handler(Looper.getMainLooper()).post(new Runnable() {
                                @Override
                                public void run() {
                                    ((RestaurantActivity) app).setArrayHoras(array);
                                }
                            });

                        }
                    }
                } catch (Exception e) {
                    throw new IOException("Error en la traducción de la respuesta" + e.getMessage());
                }
            }
        });
    }
    //Función para realizar la reserva
    public void reserva(String usuarioReserva, String nombreRestReserva, String telefonoRestReserva, String diaReserva, String horaReserva, int numComensales) {
        String subapi = "/reserva.php";
        String params = "?usuario=" + usuarioReserva
                + "&restaurante=" + nombreRestReserva
                + "&telefono=" + telefonoRestReserva
                + "&dia=" + diaReserva
                + "&hora=" + horaReserva
                + "&numComensales=" + numComensales;
        Request request = new Request.Builder()
                .url(ip + subapi + params)
                .build();
        client.newCall(request).enqueue(new Callback() {
            String respuestaServer;

            @Override
            public void onFailure(Call call, IOException e) {
                tostadaMainThread("Error al conectar con el servidor");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    if (!response.isSuccessful())
                        throw new IOException("Unexpected code " + response);
                    respuestaServer = responseBody.string();
                    if (respuestaServer.equals("")) {
                        tostadaMainThread("No hay respuesta del servidor");
                    } else {
                        JSONObject respuestaJSON = obtenerJSON(respuestaServer);
                        tostadaMainThread(respuestaJSON.getString("mensaje"));
                    }
                } catch (Exception e) {
                    throw new IOException("Error en la traducción de la respuesta" + e.getMessage());
                }
            }
        });
    }
    //Función para obtener todas las reservas del usuario y poder mostrarlas en la pantalla principal
    public void obtenerReservasUsuario(String usuario) {
        String subapi = "/getReservaUsuario.php";
        String params = "?usuario=" + usuario;
        Request request = new Request.Builder()
                .url(ip + subapi + params)
                .build();
        client.newCall(request).enqueue(new Callback() {
            String respuestaServer;

            @Override
            public void onFailure(Call call, IOException e) {
                tostadaMainThread("Error al conectar con el servidor");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    if (!response.isSuccessful())
                        throw new IOException("Unexpected code " + response);
                    respuestaServer = responseBody.string();
                    if (respuestaServer.equals("")) {
                        tostadaMainThread("No hay respuesta del servidor");
                    } else {
                        JSONObject respuestaJSON = obtenerJSON(respuestaServer);
                        if (respuestaJSON.getString("tipoMensaje").equals("ERROR")) {
                            tostadaMainThread(respuestaJSON.getString("mensaje"));
                        } else {
                            JSONArray reservasUsuario = respuestaJSON.getJSONArray("mensaje");
                            if (reservasUsuario.length() == 0) {
                                tostadaMainThread("El usuario no tiene reservas que mostrar");
                            } else {
                                asignarReservasVista(reservasUsuario);
                            }
                        }
                    }
                } catch (Exception e) {
                    throw new IOException("Error en la traducción de la respuesta" + e.getMessage());
                }
            }
        });
    }
    //Pintar los elementos en la lista en la pantalla principal
    protected static void asignarReservasVista(JSONArray reservasUsuario){
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                MainActivity actividad = (MainActivity) app;
                actividad.setReservasUsuario(reservasUsuario);
            }
        });

    }

    //UTILIDADES PARA TODAS LAS OPERACIONES
    public static JSONObject obtenerJSON(String respuestaServer) throws JSONException {
        return new JSONObject(respuestaServer);
    }
    //Para cambiar de actividad  una vez iniciada la sesión
    protected static void sesionIniciada(String usuario) {
        Intent intent = new Intent(app, MainActivity.class);
        intent.putExtra("user", usuario);
        app.startActivity(intent);
    }
    // Lanzar una tostada en el hilo de la UI
    protected static void tostadaMainThread(final String mensaje) {
        if (mensaje != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(app, mensaje, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
    // Función para obtener el sha256 de un string
    protected static String getSHA256(String pass) {
        String result = null;
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            digest.reset();
            digest.update(pass.getBytes("utf8"));
            result = String.format("%064x", new BigInteger(1, digest.digest()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


}

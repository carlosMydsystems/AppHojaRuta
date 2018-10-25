package com.example.sistemas.apphojaruta;

import android.arch.core.executor.DefaultTaskExecutor;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.sistemas.apphojaruta.Entidades.DetalleHojaRuta;
import com.example.sistemas.apphojaruta.Request.ActualizarRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class DetalleBusquedaClienteHojaRuta extends AppCompatActivity {

    DetalleHojaRuta detalleHojaRuta;
    Button btnregistraentrega;
    String ItemSeleccionado;
    TextView tvcliente,tvdireccion,tvbulto,tvtelefono;
    Spinner spestadoentrega;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_busqueda_cliente_hoja_ruta);

        String[] estadoentrega = {"Entrega total","Parcialmente rechazado","Totalmente rechazado"};
        detalleHojaRuta = new DetalleHojaRuta();
        detalleHojaRuta = (DetalleHojaRuta) getIntent().getExtras().getSerializable("detalle");
        tvcliente = findViewById(R.id.tvCliente);
        tvcliente.setText(detalleHojaRuta.getCLiente());
        tvdireccion = findViewById(R.id.tvdireccion);
        tvdireccion.setText(detalleHojaRuta.getDireccion());
        tvbulto = findViewById(R.id.tvbultos);
        tvbulto.setText(detalleHojaRuta.getBultos());
        tvtelefono = findViewById(R.id.tvtelefono);
        tvtelefono.setText(detalleHojaRuta.getTelefono());
        btnregistraentrega = findViewById(R.id.btnRegistroEntrega);
        spestadoentrega = findViewById(R.id.spEstado);
        spestadoentrega.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,estadoentrega));
        spestadoentrega.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                ItemSeleccionado = (String)parent.getItemAtPosition(position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnregistraentrega.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ActualizarEstadoHojaRuta();

            }
        });
    }

    private void ActualizarEstadoHojaRuta() {

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {

                    JSONObject jsonresponse = new JSONObject(response);
                    boolean success = jsonresponse.getBoolean("success");

                    if (success){

                        Toast.makeText(DetalleBusquedaClienteHojaRuta.this, "Se actualizo exitosamente", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(DetalleBusquedaClienteHojaRuta.this,MainActivity.class);
                        startActivity(intent);
                        finish();

                    }else{
                        AlertDialog.Builder  builder = new AlertDialog.Builder(
                                DetalleBusquedaClienteHojaRuta.this);
                        builder.setMessage("No se encontraron registros")
                                .setNegativeButton("Regresar",null)
                                .create()
                                .show();
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };

        ActualizarRequest actualizarRequest = new ActualizarRequest(detalleHojaRuta.getNumeroHojaRuta(),
                "Busqueda","Estado",responseListener);
        RequestQueue queue = Volley.newRequestQueue(DetalleBusquedaClienteHojaRuta.this);
        queue.add(actualizarRequest);
    }
}
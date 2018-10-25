package com.example.sistemas.apphojaruta;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.sistemas.apphojaruta.Entidades.DetalleHojaRuta;
import com.example.sistemas.apphojaruta.Entidades.HojaRuta;
import com.example.sistemas.apphojaruta.Request.ActualizarRequest;
import com.example.sistemas.apphojaruta.Request.BuscarRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ListarClientes extends AppCompatActivity {

    DetalleHojaRuta detalleHojaRuta;
    ArrayList<DetalleHojaRuta> detallehojarutaarray;
    ArrayList<String> listaInformacion;
    ListView lvClientes;
    String prueba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_clientes);

        prueba = getIntent().getExtras().getString("numerohojaruta");
        Toast.makeText(this, prueba, Toast.LENGTH_SHORT).show();

        buscar();


    }

    // Se crea un metodo para hacer la busqueda

    private void buscar() {

        detallehojarutaarray = new ArrayList<DetalleHojaRuta>();

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {

                    JSONObject jsonresponse = new JSONObject(response);
                    boolean success = jsonresponse.getBoolean("success");

                    if (success){

                        JSONArray jsonArray=jsonresponse.getJSONArray("hojaruta");
                        for(int i=0;i<jsonArray.length();i++) {
                            detalleHojaRuta = new DetalleHojaRuta();
                            JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                            detalleHojaRuta.setCLiente(jsonObject1.getString("Cliente"));
                            detalleHojaRuta.setBultos(jsonObject1.getString("Bultos"));
                            detalleHojaRuta.setDireccion(jsonObject1.getString("Direccion"));
                            detalleHojaRuta.setEstado(jsonObject1.getString("Estado"));
                            detallehojarutaarray.add(detalleHojaRuta);
                        }

                        Toast.makeText(ListarClientes.this, "Se hizo el ingreso", Toast.LENGTH_SHORT).show();

                        ObtenerLista();

                    }else{
                        AlertDialog.Builder  builder = new AlertDialog.Builder(
                                ListarClientes.this);
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

        ActualizarRequest actualizarRequest = new ActualizarRequest("1111",
                "Busqueda","Estado",responseListener);
        RequestQueue queue = Volley.newRequestQueue(ListarClientes.this);
        queue.add(actualizarRequest);
    }

    private void ObtenerLista() {
        listaInformacion = new ArrayList<String>();
        for (int i=0; i< detallehojarutaarray.size();i++){

            listaInformacion.add(detallehojarutaarray.get(i).getCLiente() + " \n" +
                    detallehojarutaarray.get(i).getDireccion()+ " \n" + detallehojarutaarray.get(i).getTelefono() );

        }
        ArrayAdapter adaptador = new ArrayAdapter(this,android.R.layout.simple_list_item_1,listaInformacion);
         lvClientes.setAdapter(adaptador);

         lvClientes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DetalleHojaRuta detalle = detallehojarutaarray.get(position);
                Bundle bundle = new Bundle();
                bundle.putSerializable("detalle",detalle);
                Intent intent = new Intent(ListarClientes.this,DetalleBusquedaClienteHojaRuta.class);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
            }
        });
    }
}

package com.example.sistemas.apphojaruta.Request;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class ActualizarRequest extends StringRequest {

    private static final String ACTUALIZAR_REQUEST_URL = "http://mydsystems.com/pruebaDaniel/Consultaprueba2.php";

    private Map<String, String> params;

    public ActualizarRequest(String Numerohojaruta, String TipoServicio, String Estado, Response.Listener <String> listener)

    {
        super(Request.Method.POST, ACTUALIZAR_REQUEST_URL, listener, null);
        params = new HashMap<>();

        params.put("Numerohojaruta", 	Numerohojaruta);
        params.put("TipoServicio", 	TipoServicio);
        params.put("Estado", 	Estado);
    }


    public Map <String, String> getParams() {
        return params;
    }
}
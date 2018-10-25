package com.example.sistemas.apphojaruta.Request;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class BuscarRequest extends StringRequest {

    private static final String LOGIN_REQUEST_URL = "http://mydsystems.com/pruebaDaniel/Consultaprueba2.php";

    private Map<String, String> params;

    public BuscarRequest(String numerohojaruta, String tipobusqueda, Response.Listener <String> listener)

    {
        super(Request.Method.POST, LOGIN_REQUEST_URL, listener, null);
        params = new HashMap<>();

        params.put("Numerohojaruta", 	numerohojaruta);
        params.put("tipobusqueda", 	tipobusqueda);
    }


    public Map <String, String> getParams() {
        return params;
    }
}
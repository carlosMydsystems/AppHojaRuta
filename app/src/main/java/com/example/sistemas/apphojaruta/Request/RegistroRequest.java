package com.example.sistemas.apphojaruta.Request;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegistroRequest  extends StringRequest {

    private static final String LOGIN_REQUEST_URL = "http://mydsystems.com/pruebaDaniel/Consultaprueba1.php";

    private Map<String, String> params;

    public RegistroRequest(String numerohojaruta, String tipobusqueda, Response.Listener <String> listener)

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
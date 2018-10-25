package com.example.sistemas.apphojaruta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etnumerohojaruta;
    Button btnbuscarhojaruta;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etnumerohojaruta = findViewById(R.id.etnumerohojaruta);
        btnbuscarhojaruta = findViewById(R.id.btnBuscarHojaRuta);

        btnbuscarhojaruta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ListarClientes.class);
                intent.putExtra("numerohojaruta",etnumerohojaruta.getText().toString());
                startActivity(intent);
                finish();
            }
        });



    }
}

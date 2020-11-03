package com.estebangarriga.entrega_n2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button btnEditar = findViewById(R.id.ButtonR);

        final EditText Nom = findViewById(R.id.NombreR);
        final DatePicker Fech = findViewById(R.id.FechaR);
        final EditText Tel = findViewById(R.id.TelefonoR);
        final EditText Eml = findViewById(R.id.EmailR);
        final EditText Desc = findViewById(R.id.DescripcionR);

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("Fecha",String.valueOf(Fech.getDayOfMonth()));

                // Creo el intent para ir a la otra activity
                Intent intent = new Intent(MainActivity.this, Activity2.class);

                //Agrego los datos al intent
                intent.putExtra("Nombre", Nom.getText().toString());

                intent.putExtra("diaNacimiento",String.valueOf(Fech.getDayOfMonth()));
                intent.putExtra("mesNacimiento",String.valueOf(Fech.getMonth()));
                intent.putExtra("añoNacimiento",String.valueOf(Fech.getYear()));

                //intent.putExtra("Fecha", String.valueOf(Fech.getText().toString()));
                intent.putExtra("Telefono", Tel.getText().toString());
                intent.putExtra("Email", Eml.getText().toString());
                intent.putExtra("Descripcion", Desc.getText().toString());

                //Inicio la activity
                startActivity(intent);
            }
        });
    }
}

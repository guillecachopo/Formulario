package com.example.guill.formulario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SegundaActivity extends AppCompatActivity {

    TextView etiNombre,etiTelefono, etiEmail, etiDescripcion, etiFecha;
    Button btnVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        etiNombre = (TextView) findViewById( R.id.tvNombreEscrito );
        etiTelefono = (TextView) findViewById( R.id.tvTelefonoEscrito);
        etiEmail = (TextView) findViewById( R.id.tvEmailEscrito);
        etiDescripcion = (TextView) findViewById( R.id.tvDescrEscrito);
        etiFecha = (TextView) findViewById(R.id.tvFechaEscrito);

        Intent intent=getIntent();
        Bundle extras =intent.getExtras();
        if (extras != null) {
            String datoNombre=(String)extras.get("@string/nombre_obtenido");
            String datoFecha= (String) extras.get("@string/fecha_obtenida");
            String datoTelefono= (String) extras.get("@string/telefono_obtenido");
            String datoEmail= (String) extras.get("@string/email_obtenido");
            String datoDescripcion= (String) extras.get("@string/descripcion_obtenida");

            etiNombre.setText(datoNombre);
            etiFecha.setText(datoFecha);
            etiTelefono.setText(datoTelefono);
            etiEmail.setText(datoEmail);
            etiDescripcion.setText(datoDescripcion);
        }

    }

    public void irMainActivity(View v){
        Intent intent = new Intent(this, MainActivity.class);

        //Datos precargados:

        String auxetNombre=etiNombre.getText().toString();
        String auxetTelefono=etiTelefono.getText().toString();
        String auxetEmail=etiEmail.getText().toString();
        String auxetDescripcion=etiDescripcion.getText().toString();
        String auxFecha = etiFecha.getText().toString();

        intent.putExtra("@string/nombre_obtenido",auxetNombre);
        intent.putExtra("@string/telefono_obtenido",auxetTelefono);
        intent.putExtra("@string/email_obtenido",auxetEmail);
        intent.putExtra("@string/descripcion_obtenida",auxetDescripcion);
        intent.putExtra("@string/fecha_obtenida", auxFecha);

        startActivity(intent);
    }
}

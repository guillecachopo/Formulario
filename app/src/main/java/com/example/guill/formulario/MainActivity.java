package com.example.guill.formulario;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private DatePicker datePicker;
    private java.util.Calendar calendar;
    private TextView dateView;
    private int anio, mes, dia;
    private TextInputEditText etNombre, etTelefono, etEmail, etDescripcion;
    private Button btnEnviar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dateView = (TextView) findViewById(R.id.tvFechaElegida);
        calendar = java.util.Calendar.getInstance();
        anio = calendar.get(java.util.Calendar.YEAR);

        mes = calendar.get(java.util.Calendar.MONTH);
        dia = calendar.get(java.util.Calendar.DAY_OF_MONTH);

        etNombre = (TextInputEditText) findViewById(R.id.etNombre);
        etTelefono = (TextInputEditText) findViewById(R.id.etTelefono);
        etEmail = (TextInputEditText) findViewById(R.id.etEmail);
        etDescripcion = (TextInputEditText) findViewById(R.id.etDescripcion);
        btnEnviar=(Button) findViewById(R.id.button);

        btnEnviar.setOnClickListener(this);

        //Para retornar los datos si se hace click en el boton en la segunda actividad
        Intent i=getIntent();
        Bundle extras =i.getExtras();

        if (extras != null) {
            String datoNombre = (String) extras.get("@string/nombre_obtenido");
            String datoFecha = (String) extras.get("@string/fecha_obtenida");
            String datoTelefono = (String) extras.get("@string/telefono_obtenido");
            String datoEmail = (String) extras.get("@string/email_obtenido");
            String datoDescripcion = (String) extras.get("@string/descripcion_obtenida");

            etNombre.setText(datoNombre);
            dateView.setText(datoFecha);
            etTelefono.setText(datoTelefono);
            etEmail.setText(datoEmail);
            etDescripcion.setText(datoDescripcion);
        }
    }

    @Override
    public void onClick(View v) {

        Intent intent;

        intent = new Intent(this,SegundaActivity.class);

        String auxetNombre=etNombre.getText().toString();
        String auxetTelefono=etTelefono.getText().toString();
        String auxetEmail=etEmail.getText().toString();
        String auxetDescripcion=etDescripcion.getText().toString();
        String auxFecha = dateView.getText().toString();

        intent.putExtra("@string/nombre_obtenido",auxetNombre);
        intent.putExtra("@string/telefono_obtenido",auxetTelefono);
        intent.putExtra("@string/email_obtenido",auxetEmail);
        intent.putExtra("@string/descripcion_obtenida",auxetDescripcion);
        intent.putExtra("@string/fecha_obtenida", auxFecha);


        startActivity(intent);
    }

    public void irSegundaActividad(View v){
        Intent intent = new Intent(this, SegundaActivity.class);
        startActivity(intent);
    }


    @SuppressWarnings("deprecation")
    public void setDate(View view) {
        showDialog(999);
        Toast.makeText(getApplicationContext(), "Seleccione la fecha", Toast.LENGTH_SHORT)
                .show();
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(this, myDateListener, anio, mes, dia);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int anio, int mes, int dia) {
            // TODO Auto-generated method stub

            mostrarFecha(anio, mes+1, dia);
        }
    };

    private void mostrarFecha(int anio, int mes, int dia) {
        dateView.setText(new StringBuilder().append(dia).append("/")
                .append(mes).append("/").append(anio));
    }

}

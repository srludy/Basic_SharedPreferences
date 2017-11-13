package com.example.jose.acceso_datos_3a;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    final static int subActivity = 2;
    //Objetos del XML.
    Button save;
    Button showData;
    EditText txtNom;
    EditText fNa;
    EditText dni;
    RadioButton rMas;
    RadioButton rFem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Inicializaciones.
        save = (Button) findViewById(R.id.save);
        showData = (Button) findViewById(R.id.button2);
        txtNom = (EditText) findViewById(R.id.txtNom);
        fNa = (EditText) findViewById(R.id.txtFna);
        dni = (EditText) findViewById(R.id.txtDni);
        rMas = (RadioButton) findViewById(R.id.radioButton1);
        rFem = (RadioButton) findViewById(R.id.radioButton2);

        //Listener del Button Guardar.
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Hacemos una comprobacion de campos vacios.
                if(txtNom.getText().toString().isEmpty() || fNa.getText().toString().isEmpty() || dni.getText().toString().isEmpty() ||(!rMas.isChecked() && !rFem.isChecked())){
                   Toast.makeText(getApplicationContext(),"Rellena Todos los Campos", Toast.LENGTH_SHORT).show();
                }else {
                    //Creamos SharedPreferences y almacenamos todos los campos de los EditText.
                    SharedPreferences sp = getSharedPreferences("personalInformation", Activity.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();

                    editor.putString("nom", txtNom.getText().toString());
                    editor.putString("fNa", fNa.getText().toString());
                    editor.putString("dni", dni.getText().toString());

                    if (rMas.isChecked()) {
                        editor.putString("sexo", "Masculino");
                    } else {
                        editor.putString("sexo", "Femenino");
                    }
                    //Hacemos commit para completar el almacenaje de la informarcion correctamente.
                    editor.commit();
                    Toast.makeText(getApplicationContext(),"Informacion preferente guardada!.", Toast.LENGTH_SHORT).show();
                }
        }
        });
        //Listener del Button Mostrar datos.
        showData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ActivityShowData.class);
                startActivityForResult(i,subActivity);
            }
        });

    }
}

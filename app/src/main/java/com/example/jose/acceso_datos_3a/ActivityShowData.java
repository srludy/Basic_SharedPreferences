package com.example.jose.acceso_datos_3a;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class ActivityShowData extends AppCompatActivity {

    //Objectos de XMl.
    Button volver;
    TextView nom;
    TextView fNa;
    TextView dni;
    TextView sexo ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);

        //Iniciamos Objetos del XML.
        volver = (Button) findViewById(R.id.back);
        nom = (TextView) findViewById(R.id.mostrarNom);
        fNa = (TextView) findViewById(R.id.mostrarFna);
        dni = (TextView) findViewById(R.id.mostrarDni);
        sexo = (TextView) findViewById(R.id.mostrarSexo);

        //Establecemos el Listener para volver.
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //Lanzamos metodo recuperar datos de las preferencias.
        recuperaDatos();
    }

    public void recuperaDatos(){

        //Creamos un Objeto con las preferencias establecidas.
        SharedPreferences sp = getSharedPreferences("personalInformation", MODE_PRIVATE);

        //Añadimos a los TextView el valor de las preferencias recogidas.
        nom.setText(sp.getString("nom",""));
        fNa.setText(sp.getString("fNa",""));
        dni.setText(sp.getString("dni",""));
        sexo.setText(sp.getString("sexo",""));
    }

}

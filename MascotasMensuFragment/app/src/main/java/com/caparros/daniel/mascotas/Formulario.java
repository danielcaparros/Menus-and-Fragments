package com.caparros.daniel.mascotas;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.caparros.daniel.mascotas.JavaMail.EnviarEmail;

public class Formulario extends AppCompatActivity implements View.OnClickListener {


    private TextInputEditText tietNombre, tietCorreo, tietMensaje;
    private Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        tietNombre=(TextInputEditText) findViewById(R.id.tietNombre);
        tietCorreo=(TextInputEditText) findViewById(R.id.tietCorreo);
        tietMensaje=(TextInputEditText) findViewById(R.id.tietMensaje);
        btnEnviar=(Button) findViewById(R.id.btnEnviar);

        //Click listener
        btnEnviar.setOnClickListener(this);

    }

    private void EnviarEmail(){

        //Getting content for email
        String email = tietCorreo.getText().toString().trim();
        String nombre=tietNombre.getText().toString().trim();
        String mensaje=tietMensaje.getText().toString().trim();

        //Creating SendMail object
        EnviarEmail sm =new EnviarEmail(this,email,nombre,mensaje);

        //Executing sendmail to send email
        sm.execute();
    }

    @Override
    public void onClick(View view) {
        EnviarEmail();
    }
}

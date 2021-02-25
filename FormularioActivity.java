package com.proventaja.tiendit.petagram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class FormularioActivity extends AppCompatActivity {
    private EditText ed_nombre,ed_email,ed_mensaje;
    private Button btn_mensaje;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        ed_nombre  = findViewById(R.id.et_login_nombre);
        ed_email  = findViewById(R.id.et_login_Email);
        ed_mensaje  = findViewById(R.id.et_login_mensaje);
        btn_mensaje = findViewById(R.id.btn_login_enviar);
    }
}
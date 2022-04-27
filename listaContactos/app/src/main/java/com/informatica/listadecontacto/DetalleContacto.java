package com.informatica.listadecontacto;

import android.content.Intent;
import android.net.Uri;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.informatica.listadecontacto.model.Contacto;

public class DetalleContacto extends AppCompatActivity {

    private TextView txtNameValue;
    private TextView txtEmailValue;
    private TextView txtPhoneValue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto);
        Intent intent= getIntent();
        Contacto contacto = (Contacto) intent.getExtras().get("KEY_EXTRA_CONTACT");

        txtNameValue = findViewById(R.id.txtNameValue);
        txtEmailValue = findViewById(R.id.txtEmailValue);
        txtPhoneValue = findViewById(R.id.txtPhoneValue);

        txtNameValue.setText(contacto.getName());
        txtEmailValue.setText(contacto.getEmail());
        txtPhoneValue.setText(contacto.getPhone());

        LinearLayout llPhone = findViewById(R.id.detalleContacto);
        llPhone.setOnClickListener( view -> {
            Intent intentCall = new Intent(Intent.ACTION_DIAL);
            intentCall.setData(Uri.parse(String.format("tel:%s",txtPhoneValue.getText().toString())));
            startActivity(intentCall);
        });
    }
}
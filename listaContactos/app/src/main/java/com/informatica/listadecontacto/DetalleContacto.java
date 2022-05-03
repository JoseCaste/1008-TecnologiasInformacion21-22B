package com.informatica.listadecontacto;

import android.content.Intent;
import android.net.Uri;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.informatica.listadecontacto.model.Contacto;
import com.informatica.listadecontacto.model.RetroPhoto;
import com.informatica.listadecontacto.retrofit.RetrofitInstance;
import com.informatica.listadecontacto.retrofit.services.PhotoService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

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

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        txtNameValue = findViewById(R.id.txtNameValue);
        txtEmailValue = findViewById(R.id.txtEmailValue);
        txtPhoneValue = findViewById(R.id.txtPhoneValue);

        txtNameValue.setText(contacto.getId());
        txtEmailValue.setText(contacto.getTitulo());
        txtPhoneValue.setText(contacto.getUrl());

        LinearLayout llPhone = findViewById(R.id.detalleContacto);
        llPhone.setOnClickListener( view -> {
            Intent intentCall = new Intent(Intent.ACTION_DIAL);
            intentCall.setData(Uri.parse(String.format("tel:%s",txtPhoneValue.getText().toString())));
            startActivity(intentCall);
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Activity contacto destruido", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "Activity contacto pausado", Toast.LENGTH_SHORT).show();
    }
}
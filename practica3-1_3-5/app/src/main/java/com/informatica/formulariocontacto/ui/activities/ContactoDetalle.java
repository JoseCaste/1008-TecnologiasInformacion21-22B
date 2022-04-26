package com.informatica.formulariocontacto.ui.activities;

import android.app.Activity;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.informatica.formulariocontacto.EXTRAS;
import com.informatica.formulariocontacto.R;
import com.informatica.formulariocontacto.model.Contacto;

public class ContactoDetalle extends AppCompatActivity {

    private TextView lblFullName;
    private TextView lblBirthday;
    private TextView lblPhone;
    private TextView lblEmail;
    private TextView lblContactDescription;
    private Button btnBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto_detalle);

        lblFullName = findViewById(R.id.lblFullName);
        lblBirthday = findViewById(R.id.lblBirthday);
        lblPhone = findViewById(R.id.lblPhone);
        lblEmail = findViewById(R.id.lblEmail);
        lblContactDescription = findViewById(R.id.lblDescriptionContact);
        btnBack = findViewById(R.id.btnBack);

        Contacto contactoDetalle =  (Contacto) getIntent().getExtras().get(EXTRAS.CONTACTO.getCode());

        lblFullName.setText(contactoDetalle.getName());
        lblBirthday.setText(contactoDetalle.getBirthday());
        lblPhone.setText(contactoDetalle.getPhone());
        lblEmail.setText(contactoDetalle.getEmail());
        lblContactDescription.setText(contactoDetalle.getContactDescription());

        btnBack.setOnClickListener(view ->{
            ((Activity) view.getContext()).finish();
        });
    }
}
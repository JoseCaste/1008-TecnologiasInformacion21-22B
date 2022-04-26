package com.informatica.formulariocontacto;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.informatica.formulariocontacto.model.Contacto;
import com.informatica.formulariocontacto.ui.activities.ContactoDetalle;
import com.informatica.formulariocontacto.ui.dialog.DatePickerFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText txtFullName;
    private EditText etPlannedDate;
    private EditText txtPhone;
    private EditText txtEmail;
    private EditText txtContactDescription;
    private Button btnNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtFullName = findViewById(R.id.txtFullName);
        etPlannedDate = findViewById(R.id.etPlannedDate);
        txtPhone = findViewById(R.id.txtPhone);
        txtEmail = findViewById(R.id.txtEmail);
        txtContactDescription = findViewById(R.id.textAreaContacto);
        btnNext = findViewById(R.id.btnNext);
        loadListeners();
    }

    private void loadListeners() {
        etPlannedDate.setOnClickListener(this);
        btnNext.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.etPlannedDate){
            showDatePickerDialog();
        }
        if(view.getId() == R.id.btnNext){
            try {
                validateInputs();
                Contacto contacto = new Contacto(txtFullName.getText().toString(),etPlannedDate.getText().toString(),txtPhone.getText().toString(),txtEmail.getText().toString(), txtContactDescription.getText().toString());
                Intent contactoDetalleIntent = new Intent(this, ContactoDetalle.class);
                contactoDetalleIntent.putExtra(EXTRAS.CONTACTO.getCode(),contacto);
                startActivity(contactoDetalleIntent);
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }

    private void validateInputs() throws Exception{
        if(txtFullName.getText().toString().equals("")){
            txtFullName.setError("Ingrese un nombre");
            throw new Exception("ERROR_FULLNAME_NULL");
        }
        if(txtEmail.getText().toString().equals("")){
            txtEmail.setError("Ingrese un email válido");
            throw new Exception("ERROR_EMAIL_NULL");
        }
        if(txtPhone.getText().toString().equals("")){
            txtPhone.setError("Ingrese un número de contacto válido");
            throw new Exception("ERROR_PHONE_NULL");
        }
        if(txtContactDescription.getText().toString().equals("")){
            txtContactDescription.setError("Ingrese una descripción");
            throw new Exception("ERROR_DESCRIPTION-CONTACTO_NULL");
        }
    }

    private void showDatePickerDialog() {
        DatePickerFragment newFragment = DatePickerFragment.newInstance((datePicker, year, month, day) -> {
            // +1 because January is zero
            final String selectedDate = day + " / " + (month+1) + " / " + year;
            etPlannedDate.setText(selectedDate);
        });
        newFragment.show(getSupportFragmentManager(),"DatePicker");
    }
}
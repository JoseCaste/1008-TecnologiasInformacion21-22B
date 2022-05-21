package com.informatica.unistmo.almacenamiento;

import android.content.Context;
import android.os.Build;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final short INDEX_NAME = 0;
    private final short INDEX_PHONE = 1;
    private final short INDEX_EMAIL = 2;
    private EditText txtContactName;
    private EditText txtContactEmail;
    private EditText txtContactPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadListenersAndResources();
    }

    private void loadListenersAndResources() {
        findViewById(R.id.btnGuardar).setOnClickListener(this::onClick);
        findViewById(R.id.btnRecover).setOnClickListener(this::onClick);
        findViewById(R.id.btnPreferences).setOnClickListener(this::onClick);

        txtContactName = findViewById(R.id.txtContactName);
        txtContactEmail = findViewById(R.id.txtContactEmail);
        txtContactPhone = findViewById(R.id.txtContactPhone);
    }

    @Override
    public void onClick(View v) {

        try {
            switch (v.getId()){
                case R.id.btnGuardar:
                    saveContact();
                    break;
                case  R.id.btnRecover:
                    recoverContact();
                    break;
                case  R.id.btnPreferences:
                    startPreferences();
                    break;
            }
        }catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }

    }

    private void startPreferences() throws Exception{
    }

    private void recoverContact() throws Exception{
        try {
            FileInputStream fin = openFileInput("contact.txt");
            int a;
            StringBuilder temp = new StringBuilder();
            while ((a = fin.read()) != -1)
            {
                temp.append((char)a);
            }


            final String[] contactData = temp.toString().split("-");
            loadDataToEditText(contactData);
        }catch (FileNotFoundException e){
            e.printStackTrace();
            throw new Exception("el archivo de contacto no ha sido guardado");
        }

    }

    private void loadDataToEditText(final String[] contactData) {
        txtContactName.setText(contactData[INDEX_NAME]);
        txtContactPhone.setText(contactData[INDEX_PHONE]);
        txtContactEmail.setText(contactData[INDEX_EMAIL]);
    }

    private void saveContact() throws Exception {
        validateInputs();

        saveFileIO();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Arrays.asList(txtContactPhone,txtContactEmail, txtContactName).stream().forEach(editText -> editText.setText(""));
        }
    }

    private void saveFileIO() throws FileNotFoundException {
        FileOutputStream outputStream = openFileOutput("contact.txt", Context.MODE_PRIVATE);
        try {
            outputStream.write(txtContactName.getText().toString().getBytes(StandardCharsets.ISO_8859_1));
            outputStream.write("-".getBytes(StandardCharsets.ISO_8859_1));
            outputStream.write(txtContactPhone.getText().toString().getBytes(StandardCharsets.ISO_8859_1));
            outputStream.write("-".getBytes(StandardCharsets.ISO_8859_1));
            outputStream.write(txtContactEmail.getText().toString().getBytes(StandardCharsets.ISO_8859_1));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        Toast.makeText(this, "Contacto guardado", Toast.LENGTH_SHORT).show();
    }

    private void validateInputs() throws Exception {
        if(Objects.equals(txtContactName.getText().toString(),""))
            throw new Exception("El nombre de contacto es necesario");

        if(Objects.equals(txtContactPhone.getText().toString(),""))
            throw new Exception("El número de contacto es necesario");

        if (!Objects.equals(txtContactPhone.getText().toString(),"")){
            if(!Patterns.EMAIL_ADDRESS.matcher(txtContactEmail.getText().toString()).matches()) {
                txtContactEmail.setError("Introduzca un email válido");
                throw new Exception("Introduzca un email válido");
            }
        }else throw new Exception("El correo de contacto es necesario");
    }
}
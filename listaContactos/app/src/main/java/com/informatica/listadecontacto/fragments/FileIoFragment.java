package com.informatica.listadecontacto.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.informatica.listadecontacto.R;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class FileIoFragment extends Fragment {

    private Button btnSave;

    private EditText txtDatum;

    private TextView labelDato;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_file_io, container, false);
        loadListerners();
        return view;
    }

    private void loadListerners() {
        btnSave = view.findViewById(R.id.btnSave);
        txtDatum = view.findViewById(R.id.txtDatum);
        EditText txtEmail = view.findViewById(R.id.txtEmailSharedPreference);
        labelDato = view.findViewById(R.id.labelDato);
        btnSave.setOnClickListener(view ->{
            try {
                FileOutputStream outputStream = view.getContext().openFileOutput("contact.txt", Context.MODE_APPEND);
                outputStream.write(txtDatum.getText().toString().getBytes(StandardCharsets.UTF_8));
                outputStream.close();
                Toast.makeText(view.getContext(), "Dato guradado", Toast.LENGTH_SHORT).show();
            } catch (FileNotFoundException e) {
                Toast.makeText(view.getContext(), "Archivo contact.txt no fue encontrado", Toast.LENGTH_SHORT).show();
                throw new RuntimeException(e);
            } catch (IOException e) {
                Toast.makeText(view.getContext(), "Hubo un error al guardar los datos", Toast.LENGTH_SHORT).show();
                throw new RuntimeException(e);
            }
            saveWithSharedPreference(txtDatum.getText().toString(),txtEmail.getText().toString());
            /*try {
                FileInputStream inputStream = view.getContext().openFileInput("contact.txt");

            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }*/
        });
    }

    private void saveWithSharedPreference(String datum, String email) {
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("contacts",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("DATUM",datum);
        editor.putString("EMAIL",email);
        editor.apply();

        loadResourcesSharedPreferences();
    }

    private void loadResourcesSharedPreferences() {
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("contacts",Context.MODE_PRIVATE);
        Toast.makeText(getContext(), sharedPreferences.getString("DATUM","NULL").concat("-").concat(sharedPreferences.getString("EMAIL","NULL")), Toast.LENGTH_SHORT).show();
    }
}
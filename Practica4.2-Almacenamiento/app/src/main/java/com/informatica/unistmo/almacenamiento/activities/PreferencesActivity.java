package com.informatica.unistmo.almacenamiento.activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.informatica.unistmo.almacenamiento.R;

import java.util.Objects;

public class PreferencesActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String BK_COLOR = "BK_COLOR";
    private static final String FT_COLOR = "FT_COLOR";
    private EditText txtBackgroundColor;
    private EditText txtFontColor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        findViewById(R.id.btnSavePreference).setOnClickListener(this::onClick);

        txtBackgroundColor = findViewById(R.id.txtBackgroundColor);
        txtFontColor = findViewById(R.id.txtFontColor);
        loadPreferences();
    }

    @Override
    public void onClick(View v) {

        try {
            if(v.getId() == R.id.btnSavePreference){
                final String backgroundColor = txtBackgroundColor.getText().toString();
                final String fontColor = txtFontColor.getText().toString();
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    if(Objects.isNull(backgroundColor) || Objects.equals(backgroundColor,"")){
                        txtBackgroundColor.setError("El color de fondo es necesario");
                        throw new Exception("El color de fondo es necesario");
                    }

                    if(Objects.isNull(fontColor) || Objects.equals(fontColor,"")){
                        txtFontColor.setError("El color de letra es necesario");
                        throw new Exception("El color de letra es necesario");
                    }
                    savePreferences(backgroundColor, fontColor);
                    Toast.makeText(this, "Preferences guardados", Toast.LENGTH_SHORT).show();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void loadPreferences(){
        final SharedPreferences preferences = getSharedPreferences("settings.xml",Context.MODE_PRIVATE);
        txtBackgroundColor.setText(preferences.getString(BK_COLOR,""));
        txtFontColor.setText(preferences.getString(FT_COLOR,""));
    }
    private void savePreferences(final String backgroundColor, final String fontColor) {
        final SharedPreferences preferences = getSharedPreferences("settings.xml", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = preferences.edit();

        editor.putString(BK_COLOR,backgroundColor);
        editor.putString(FT_COLOR,fontColor);

        editor.apply();
    }
}
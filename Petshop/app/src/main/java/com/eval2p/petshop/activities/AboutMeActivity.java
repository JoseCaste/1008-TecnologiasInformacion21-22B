package com.eval2p.petshop.activities;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.eval2p.petshop.R;

public class AboutMeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
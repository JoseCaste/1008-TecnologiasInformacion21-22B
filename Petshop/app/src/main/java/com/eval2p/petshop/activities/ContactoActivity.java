package com.eval2p.petshop.activities;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.eval2p.petshop.R;
import com.eval2p.petshop.fragments.ContactFragment;

public class ContactoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportFragmentManager().beginTransaction().replace(R.id.contact_fragment, new ContactFragment()).commit();
    }
}
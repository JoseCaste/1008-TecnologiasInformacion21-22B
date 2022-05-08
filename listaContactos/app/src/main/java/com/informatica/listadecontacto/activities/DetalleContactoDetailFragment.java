package com.informatica.listadecontacto.activities;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import com.informatica.listadecontacto.R;
import com.informatica.listadecontacto.fragments.ContactListFragment;
import com.informatica.listadecontacto.model.Contacto;

public class DetalleContactoDetailFragment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto_detail_fragment);
        Contacto contacto = (Contacto) getIntent().getExtras().get("KEY_EXTRA_CONTACT");
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fragment_detail, new ContactListFragment(contacto)).commit();


    }
}
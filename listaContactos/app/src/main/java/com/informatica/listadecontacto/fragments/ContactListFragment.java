package com.informatica.listadecontacto.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.informatica.listadecontacto.R;
import com.informatica.listadecontacto.model.Contacto;

public class ContactListFragment extends Fragment {


    private Contacto contacto;

    public ContactListFragment(Contacto  contacto) {
        this.contacto = contacto;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frament_contact_detail,container,false);

        TextView textViewName= view.findViewById(R.id.fragment_detail_name);
        textViewName.setText(contacto.getTitulo());

        TextView textPhone = view.findViewById(R.id.fragment_detail_phone);
        textPhone.setText(contacto.getId());

        TextView textEmail = view.findViewById(R.id.fragment_detail_email);
        textEmail.setText(contacto.getUrl());
        return view;

    }
}

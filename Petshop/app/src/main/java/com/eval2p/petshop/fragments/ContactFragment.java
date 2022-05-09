package com.eval2p.petshop.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.eval2p.petshop.R;

public class ContactFragment extends Fragment {

    private TextView txtName;
    private TextView txtEmail;
    private TextView txtComments;

    private Button btnSend;
    public ContactFragment(){

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.contact_fragment,container,false);
        txtName = view.findViewById(R.id.txtName);
        txtEmail = view.findViewById(R.id.txtEmail);
        txtComments = view.findViewById(R.id.txtComments);
        btnSend = view.findViewById(R.id.btnSend);

        btnSend.setOnClickListener(context->{
            final String name = txtName.getText().toString();
            final String email = txtEmail.getText().toString();
            final String comments = txtComments.getText().toString();
            Intent emailIntent = new Intent(Intent.ACTION_SEND);
            emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{email});
            emailIntent.putExtra(Intent.EXTRA_SUBJECT,"Contacto Petshop | ".concat(name));
            emailIntent.putExtra(Intent.EXTRA_TEXT, comments);
            emailIntent.setType("message/rfc822");
            context.getContext().startActivity(emailIntent);
        });
        return view;
    }
}

package com.informatica.listadecontacto.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.informatica.listadecontacto.DetalleContacto;
import com.informatica.listadecontacto.R;
import com.informatica.listadecontacto.model.Contacto;

import java.util.List;

public class DetalleContactoAdapter extends RecyclerView.Adapter<DetalleContactoAdapter.DetalleContactoViewHolder>{
    private List<Contacto> contactoList;
    private Context context;

    public DetalleContactoAdapter (Context context, List<Contacto> contactoList){
        this.context = context;
        this.contactoList = contactoList;
    }

    @Override
    public DetalleContactoViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        Context context
                = parent.getContext();
        LayoutInflater inflater
                = LayoutInflater.from(context);

        View contactCard
                = inflater
                .inflate(R.layout.contact_card,
                        parent, false);

        DetalleContactoViewHolder viewHolder
                = new DetalleContactoViewHolder(contactCard);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DetalleContactoViewHolder holder, int position) {
        holder.lblContactName.setText(contactoList.get(position).getName());
        holder.lblPhone.setText(contactoList.get(position).getPhone());
        holder.lblEmail.setText(contactoList.get(position).getEmail());
        holder.itemView.setOnClickListener(view -> {

            Intent intent = new Intent(view.getContext(), DetalleContacto.class);
            intent.putExtra("KEY_EXTRA_CONTACT",contactoList.get(position));
            view.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return contactoList.size();
    }

    public class DetalleContactoViewHolder extends RecyclerView.ViewHolder{
        public TextView lblContactName;
        public TextView lblPhone;
        public TextView lblEmail;

        public DetalleContactoViewHolder(View itemView){
            super(itemView);
            this.lblContactName = itemView.findViewById(R.id.lblContactName);
            this.lblPhone = itemView.findViewById(R.id.lblPhone);
            this.lblEmail = itemView.findViewById(R.id.lblEmail);
        }

    }
}

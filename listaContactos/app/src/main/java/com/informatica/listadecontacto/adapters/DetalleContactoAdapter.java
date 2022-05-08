package com.informatica.listadecontacto.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.informatica.listadecontacto.activities.DetalleContacto;
import com.informatica.listadecontacto.R;
import com.informatica.listadecontacto.activities.DetalleContactoDetailFragment;
import com.informatica.listadecontacto.model.Contacto;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

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
        holder.lblContactName.setText(contactoList.get(position).getId());
        holder.lblPhone.setText(contactoList.get(position).getTitulo());
        holder.lblEmail.setText(contactoList.get(position).getUrl());

        createPiccasoDisplay(holder, position);
        holder.itemView.setOnClickListener(view -> {
            PopupMenu popup = new PopupMenu(view.getContext(), view);
            popup.setOnMenuItemClickListener(viewPopUp->{
                switch (viewPopUp.getItemId()){
                    case R.id.item_detail_intent:
                        Toast.makeText(view.getContext(), "Intent detail", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(view.getContext(), DetalleContacto.class);
                        intent.putExtra("KEY_EXTRA_CONTACT",contactoList.get(position));
                        view.getContext().startActivity(intent);
                        break;
                    case R.id.item_detail_fragment:
                        Toast.makeText(view.getContext(), "Fragment detail", Toast.LENGTH_SHORT).show();
                        Intent intent_detail_fragment = new Intent(view.getContext(), DetalleContactoDetailFragment.class);
                        intent_detail_fragment.putExtra("KEY_EXTRA_CONTACT", contactoList.get(position));
                        view.getContext().startActivity(intent_detail_fragment);
                        break;
                }
                return false;
            });
            MenuInflater inflater = popup.getMenuInflater();
            inflater.inflate(R.menu.detail_menu, popup.getMenu());
            popup.show();
        });
    }

    private void createPiccasoDisplay(final DetalleContactoViewHolder holder, int position) {
        Picasso.Builder picasso = new Picasso.Builder(context);
        picasso.downloader(new OkHttp3Downloader(context));
        picasso.build().load(contactoList.get(position).getUrl()).resize(100,100).placeholder(R.drawable.ic_launcher_background).error(R.drawable.ic_launcher_background).into(holder.imgContact);
    }

    @Override
    public int getItemCount() {
        return contactoList.size();
    }

    public class DetalleContactoViewHolder extends RecyclerView.ViewHolder{
        public TextView lblContactName;
        public TextView lblPhone;
        public TextView lblEmail;
        public ImageView imgContact;

        public DetalleContactoViewHolder(View itemView){
            super(itemView);
            this.lblContactName = itemView.findViewById(R.id.lblContactName);
            this.lblPhone = itemView.findViewById(R.id.lblPhone);
            this.lblEmail = itemView.findViewById(R.id.lblEmail);
            this.imgContact = itemView.findViewById(R.id.imgContact);
        }

    }
}

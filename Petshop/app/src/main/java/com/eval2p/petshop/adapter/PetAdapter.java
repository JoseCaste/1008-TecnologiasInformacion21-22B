package com.eval2p.petshop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.eval2p.petshop.R;
import com.eval2p.petshop.model.Pet;

import java.util.List;

public class PetAdapter extends RecyclerView.Adapter<PetAdapter.PetDatailViewHolder> {

    private final List<Pet> petList;
    private Context context;
    public PetAdapter(final List<Pet> petList, Context context){
        this.petList = petList;
        this.context = context;
    }

    @NonNull
    @Override
    public PetDatailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context
                = parent.getContext();
        LayoutInflater inflater
                = LayoutInflater.from(context);

        View contactCard
                = inflater
                .inflate(R.layout.pet_card,
                        parent, false);
        PetDatailViewHolder petDatailViewHolder = new PetDatailViewHolder(contactCard);
        return petDatailViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PetDatailViewHolder holder, int position) {
        holder.tvPetName.setText(petList.get(position).getName());
        holder.petImage.setImageResource(petList.get(position).getIdDrawable());
    }

    @Override
    public int getItemCount() {
        return petList.size();
    }

    class PetDatailViewHolder extends RecyclerView.ViewHolder{

        public ImageView petImage;
        public TextView tvPetName;

        public PetDatailViewHolder(@NonNull View itemView) {
            super(itemView);
            petImage = itemView.findViewById(R.id.pet_image);
            tvPetName = itemView.findViewById(R.id.tvPetName);
        }
    }
}

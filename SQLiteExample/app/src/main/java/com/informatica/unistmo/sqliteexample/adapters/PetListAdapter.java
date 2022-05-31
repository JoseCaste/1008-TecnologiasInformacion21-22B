package com.informatica.unistmo.sqliteexample.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.informatica.unistmo.sqliteexample.R;
import com.informatica.unistmo.sqliteexample.models.Pet;
import org.w3c.dom.Text;

import java.util.List;

public class PetListAdapter extends RecyclerView.Adapter<PetListAdapter.PetViewHolder> {

    private Context context;
    private List<Pet> petList;

    public PetListAdapter(Context context, List<Pet> petList){
        this.context = context;
        this.petList = petList;
    }
    @NonNull
    @Override
    public PetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final Context context
                = parent.getContext();
        final LayoutInflater inflater
                = LayoutInflater.from(context);

        View itemView = inflater.inflate(R.layout.pet_card, parent, false);

        return new PetViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PetListAdapter.PetViewHolder holder, int position) {
        final Pet pet = petList.get(position);
        holder.lblPetName.setText(pet.getName().concat(" | ").concat(pet.getBreed()));
        holder.lblRank.setText(String.valueOf(pet.getBones()));
        holder.petAvatar.setImageResource(pet.getAvatar());
    }

    @Override
    public int getItemCount() {
        return petList.size();
    }

    class PetViewHolder extends RecyclerView.ViewHolder{

        private ImageButton btnLess;
        private ImageButton btnPluss;
        private TextView lblPetName;
        private TextView lblRank;
        private ImageView petAvatar;

        public PetViewHolder(@NonNull View itemView) {
            super(itemView);

            this.btnLess = itemView.findViewById(R.id.btnLess);
            this.btnPluss = itemView.findViewById(R.id.btnPluss);
            this.lblPetName = itemView.findViewById(R.id.lblPetName);
            this.lblRank = itemView.findViewById(R.id.lblRank);
            this.petAvatar = itemView.findViewById(R.id.petAvatar);

        }
    }
}

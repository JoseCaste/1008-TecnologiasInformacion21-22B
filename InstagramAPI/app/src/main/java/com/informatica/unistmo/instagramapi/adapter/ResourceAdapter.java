package com.informatica.unistmo.instagramapi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.informatica.unistmo.instagramapi.R;
import com.informatica.unistmo.instagramapi.retrofitconfig.InstagramResource;
import org.w3c.dom.Text;

import java.util.List;

public class ResourceAdapter extends RecyclerView.Adapter<ResourceAdapter.ResourceDetailViewHolder> {

    private List<InstagramResource> instagramResourceList;
    private Context context;

    public ResourceAdapter(List<InstagramResource> instagramResourceList, Context context){
        this.instagramResourceList = instagramResourceList;
        this.context = context;
    }
    @NonNull
    @Override
    public ResourceDetailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context
                = parent.getContext();
        LayoutInflater inflater
                = LayoutInflater.from(context);

        // Inflate the layout

        View instagramView
                = inflater
                .inflate(R.layout.instagra_post_card,
                        parent, false);

        ResourceDetailViewHolder viewHolder
                = new ResourceDetailViewHolder(instagramView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ResourceDetailViewHolder holder, int position) {

        final InstagramResource instagramResource= instagramResourceList.get(position);
        holder.txtInstragramId.setText(String.valueOf(instagramResource.getId()));
        holder.tvTimestamp.setText(instagramResource.getTimestamp());
        holder.tvInstagramName.setText(instagramResource.getUsername());
    }

    @Override
    public int getItemCount() {
        return instagramResourceList.size();
    }
    class ResourceDetailViewHolder extends RecyclerView.ViewHolder{

        private TextView tvInstagramName;
        private TextView tvTimestamp;
        private TextView txtInstragramId;

        public ResourceDetailViewHolder(@NonNull View itemView) {
            super(itemView);
            tvInstagramName = itemView.findViewById(R.id.instagramName);
            tvTimestamp = itemView.findViewById(R.id.instagramDate);
            txtInstragramId = itemView.findViewById(R.id.userName);
        }
    }
}

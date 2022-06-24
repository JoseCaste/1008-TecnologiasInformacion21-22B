package com.informatica.unistmo.micitymaps.mvp;

import android.content.Context;
import android.content.Intent;
import android.widget.Button;
import android.widget.ImageView;
import com.informatica.unistmo.micitymaps.R;
import com.informatica.unistmo.micitymaps.maps.BodegaActivity;
import com.informatica.unistmo.micitymaps.maps.CoppelMapsActivity;
import com.informatica.unistmo.micitymaps.maps.MercadoMapsActivity;
import com.informatica.unistmo.micitymaps.maps.ParqueMapsActivity;

public class Presenter implements  MyMVP.Presenter{

    @Override
    public void onButtonClick(final Context context, final int sourceButton) {
        if (sourceButton == R.id.imageViewCoppel){
            context.startActivity(new Intent(context, CoppelMapsActivity.class));
        }

        if(sourceButton == R.id.imageViewBodega){
            context.startActivity(new Intent(context, BodegaActivity.class));
        }

        if(sourceButton == R.id.imageViewParque){
            context.startActivity(new Intent(context, ParqueMapsActivity.class));
        }

        if(sourceButton == R.id.imageViewMercado){
            context.startActivity(new Intent(context, MercadoMapsActivity.class));
        }
    }
}

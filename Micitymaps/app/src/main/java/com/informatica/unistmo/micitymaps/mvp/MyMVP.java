package com.informatica.unistmo.micitymaps.mvp;

import android.content.Context;
import android.widget.Button;
import android.widget.ImageView;

public interface MyMVP {

    interface View{
        void seeMercadoMaps();

        void seeParqueMaps();

        void seeCoppenMaps();

        void seeBodegaMaps();

    }

    interface  Model{

    }

    interface Presenter{
        void onButtonClick(final Context context, final int sourceButton);
    }
}

package com.informatica.unistmo.micitymaps;

import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.gms.maps.MapView;
import com.informatica.unistmo.micitymaps.mvp.MyMVP;
import com.informatica.unistmo.micitymaps.mvp.Presenter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private MapView mapView;
    private ImageView coppel;
    private ImageView mercado;
    private ImageView bodega;
    private ImageView parque;

    private MyMVP.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new Presenter();
        loadImageView();

    }

    private void loadImageView() {
        coppel = findViewById(R.id.imageViewCoppel);
        mercado = findViewById(R.id.imageViewMercado);
        bodega = findViewById(R.id.imageViewBodega);
        parque = findViewById(R.id.imageViewParque);

        coppel.setOnClickListener(this);
        mercado.setOnClickListener(this);
        parque.setOnClickListener(this);
        bodega.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
            presenter.onButtonClick(this,v.getId());
    }
}
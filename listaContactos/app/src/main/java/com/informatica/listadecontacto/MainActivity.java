package com.informatica.listadecontacto;

import android.content.Intent;
import android.os.Build;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.informatica.listadecontacto.adapters.DetalleContactoAdapter;
import com.informatica.listadecontacto.model.Contacto;
import com.informatica.listadecontacto.model.RetroPhoto;
import com.informatica.listadecontacto.retrofit.RetrofitInstance;
import com.informatica.listadecontacto.retrofit.services.PhotoService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {

    private List<Contacto> contactoList;
    private List<String> names;
    private ListView lstContacto;
    private RecyclerView recyclerView;
    private DetalleContactoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadResources();
    }

    private void loadResources() {
        PhotoService service = RetrofitInstance.getRetrofitInstance().create(PhotoService.class);
        Call<List<RetroPhoto>> call = service.getAllPhotos(100);
        call.enqueue(new Callback<List<RetroPhoto>>() {
            @Override
            public void onResponse(Call<List<RetroPhoto>> call, Response<List<RetroPhoto>> response) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    contactoList = response.body().stream().
                            map(photo -> new Contacto(String.valueOf(photo.getId()),photo.getTitle(),photo.getUrl())).collect(Collectors.toList());
                    loadAdapters();
                }

            }

            @Override
            public void onFailure(Call<List<RetroPhoto>> call, Throwable t) {
                //progressDoalog.dismiss();
                Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
        //contactoList = Arrays.asList(new Contacto("Jose","jose@gmail.com","9711533508"),new Contacto("Juan","juan@gmail.com","9711533508"),new Contacto("Juan","juan@gmail.com","9711533508"),new Contacto("Juan","juan@gmail.com","9711533508"),new Contacto("Juan","juan@gmail.com","9711533508"),new Contacto("Juan","juan@gmail.com","9711533508"),new Contacto("Juan","juan@gmail.com","9711533508"));
        /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            names = contactoList.stream().map(item -> item.getName()).collect(Collectors.toList());
        }else Toast.makeText(getApplicationContext(),"Tu versión de dispositivo es demasiado antiguo para ejecutar la aplicación",Toast.LENGTH_LONG).show();*/
    }

    private void loadAdapters() {
        recyclerView = findViewById(R.id.recyclerView);
        adapter = new DetalleContactoAdapter(this,contactoList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}
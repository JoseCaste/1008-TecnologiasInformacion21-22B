package com.informatica.listadecontacto.activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.informatica.listadecontacto.R;
import com.informatica.listadecontacto.adapters.DetalleContactoAdapter;
import com.informatica.listadecontacto.model.Contacto;
import com.informatica.listadecontacto.model.RetroPhoto;
import com.informatica.listadecontacto.retrofit.RetrofitInstance;
import com.informatica.listadecontacto.retrofit.services.PhotoService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import java.util.List;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {

    private static final int BLUETOOTH_REQUEST = 1;
    private List<Contacto> contactoList;
    private RecyclerView recyclerView;
    private DetalleContactoAdapter adapter;
    private Button btnPopUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnPopUp =  findViewById(R.id.btnPopUp);
        btnPopUp.setOnClickListener(context ->{
            PopupMenu popup = new PopupMenu(this, context);
            popup.setOnMenuItemClickListener(view->{
                switch (view.getItemId()){
                    case R.id.menu_inicio:
                        Toast.makeText(this, "Inicio", Toast.LENGTH_SHORT).show();
                    break;
                    case R.id.submenu_2:
                        Toast.makeText(this, "ViewPager", Toast.LENGTH_SHORT).show();
                        Intent intentViewPager = new Intent(this, ViewPagerActivity.class);
                        startActivity(intentViewPager);
                        break;
                    case R.id.submenu_3:
                        Toast.makeText(this, "Submenu 3", Toast.LENGTH_SHORT).show();
                        try {
                            requestBluetoothPermission();
                        }catch (Exception exception){
                            Toast.makeText(this, exception.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                        break;
                }
                return false;
            });
            MenuInflater inflater = popup.getMenuInflater();
            inflater.inflate(R.menu.item_menu, popup.getMenu());
            popup.show();
        });

        loadResources();
    }

    private void requestBluetoothPermission() throws Exception{
        if(checkSelfPermission(Manifest.permission.BLUETOOTH )== PackageManager.PERMISSION_GRANTED){
            Toast.makeText(this, "Permisios de BLUETOOTH concedidos", Toast.LENGTH_SHORT).show();
        }else{
            if(!ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.BLUETOOTH)){
                throw new Exception("Se necesitan permisos de BLUETOOTH para usar esta característica");

            }else
                Toast.makeText(this, "Permisos dados-", Toast.LENGTH_SHORT).show();

            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.BLUETOOTH}, BLUETOOTH_REQUEST);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == BLUETOOTH_REQUEST){

            if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this, "Permisos dados", Toast.LENGTH_SHORT).show();
            } else Toast.makeText(this, "Permisos no concedidos", Toast.LENGTH_SHORT).show();
        }else Toast.makeText(this, "Permisos denegados", Toast.LENGTH_SHORT).show();

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
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
                Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.item_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_inicio:
                Toast.makeText(this, "Menu de inicio", Toast.LENGTH_SHORT).show();
                break;
            case R.id.submenu_2:
                Toast.makeText(this, "Submenu 2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.submenu_3:
                Toast.makeText(this, "Submenu 3", Toast.LENGTH_SHORT).show();
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    private void loadAdapters() {
        recyclerView = findViewById(R.id.recyclerView);
        adapter = new DetalleContactoAdapter(this,contactoList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}
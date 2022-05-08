package com.informatica.listadecontacto.activities;

import android.os.Build;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.informatica.listadecontacto.R;
import com.informatica.listadecontacto.adapters.DetalleContactoAdapter;
import com.informatica.listadecontacto.fragments.ContactListFragment;
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

    private List<Contacto> contactoList;
    private List<String> names;
    private ListView lstContacto;
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
                        Toast.makeText(this, "Submenu 2", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.submenu_3:
                        Toast.makeText(this, "Submenu 3", Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            });
            MenuInflater inflater = popup.getMenuInflater();
            inflater.inflate(R.menu.item_menu, popup.getMenu());
            popup.show();
        });
        /*FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fragment_detail, new ContactListFragment()).commit();*/

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
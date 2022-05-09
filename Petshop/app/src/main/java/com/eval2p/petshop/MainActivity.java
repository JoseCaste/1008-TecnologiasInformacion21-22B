package com.eval2p.petshop;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.eval2p.petshop.activities.AboutMeActivity;
import com.eval2p.petshop.activities.ContactoActivity;
import com.eval2p.petshop.adapter.PetAdapter;
import com.eval2p.petshop.enums.ImagesID;
import com.eval2p.petshop.model.Pet;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView petRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        petRecyclerView = findViewById(R.id.petRecyclerView);

        loadRosources();
    }

    private void loadRosources() {
        List<Pet> petList = Arrays.asList(new Pet("Pet1", ImagesID.PET.getIdDrawable()),new Pet("Pet2", ImagesID.BEAGLE.getIdDrawable()),new Pet("Pet3", ImagesID.BONE.getIdDrawable()),new Pet("Pet4", ImagesID.BRACO.getIdDrawable()),new Pet("Pet3", ImagesID.BULL_DOG.getIdDrawable()),new Pet("Pet3", ImagesID.CAT.getIdDrawable()));
        PetAdapter petAdapter = new PetAdapter(petList, getApplicationContext());
        petRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        petRecyclerView.setAdapter(petAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.options_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_contacto:
                startActivity(new Intent(this, ContactoActivity.class));
                break;
            case R.id.item_about:
                startActivity(new Intent(this, AboutMeActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }
}
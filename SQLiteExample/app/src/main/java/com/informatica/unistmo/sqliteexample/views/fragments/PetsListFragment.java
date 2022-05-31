package com.informatica.unistmo.sqliteexample.views.fragments;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.informatica.unistmo.sqliteexample.R;
import com.informatica.unistmo.sqliteexample.adapters.PetListAdapter;
import com.informatica.unistmo.sqliteexample.models.Pet;

import java.util.ArrayList;
import java.util.List;

public class PetsListFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_pets_list, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        List<Pet> pets = new ArrayList<>();
        pets.add(new Pet(R.drawable.pet, 0,"Akita Inu","Happy"));
        pets.add(new Pet(R.drawable.beagle, 0,"Beagle","Lucky"));
        pets.add(new Pet(R.drawable.bulldog, 0,"Bulldog","Jumper"));
        pets.add(new Pet(R.drawable.dog, 0,"Galgo","Eyes"));
        pets.add(new Pet(R.drawable.braco, 0,"Labrador","Shorty"));
        pets.add(new Pet(R.drawable.hamster, 0,"Mastin","Charm"));
        pets.add(new Pet(R.drawable.cat, 0,"Pug","Foot"));

        RecyclerView recyclerView = view.findViewById(R.id.petList_recyclerview);


        recyclerView.setAdapter(new PetListAdapter(view.getContext(), pets));
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
    }
}
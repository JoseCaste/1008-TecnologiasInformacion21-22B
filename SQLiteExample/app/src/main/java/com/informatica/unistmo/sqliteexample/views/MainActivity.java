package com.informatica.unistmo.sqliteexample.views;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.informatica.unistmo.sqliteexample.R;
import com.informatica.unistmo.sqliteexample.views.fragments.PetsListFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().add(R.id.main_fragment, PetsListFragment.class,null).commit();
    }
}
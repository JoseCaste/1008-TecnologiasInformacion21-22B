package com.informatica.listadecontacto.activities;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.informatica.listadecontacto.R;
import com.informatica.listadecontacto.adapters.ViewPagerAdapter;
import com.informatica.listadecontacto.fragments.ContactListFragment;
import com.informatica.listadecontacto.fragments.FileIoFragment;
import com.informatica.listadecontacto.model.Contacto;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class ViewPagerActivity extends AppCompatActivity {

    private TabLayout tabLayout;

    private ViewPager2 viewPager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tabLayout = findViewById(R.id.tab_layout);

        viewPager2 = findViewById(R.id.view_pager);
        final List<Fragment> fragmentList = Arrays.asList(new FileIoFragment(),new ContactListFragment(new Contacto("Jose","Some title","https://google.com")), new Fragment());

        viewPager2.setAdapter(new ViewPagerAdapter(this,fragmentList));

        new TabLayoutMediator(tabLayout, viewPager2,(tab, position)->{
           tab.setText("TAB-".concat(String.valueOf(position+1)));
        }).attach();
    }
}
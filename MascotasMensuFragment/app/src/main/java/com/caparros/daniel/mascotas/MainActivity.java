package com.caparros.daniel.mascotas;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.caparros.daniel.mascotas.Adaptador.PageAdapter;
import com.caparros.daniel.mascotas.Fragments.ReciclerViewFragment;
import com.caparros.daniel.mascotas.Fragments.ViewPagerFragment;
import com.caparros.daniel.mascotas.Pojo.Mascota;
import com.caparros.daniel.mascotas.Adaptador.MascotaAdaptador;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar=(Toolbar) findViewById(R.id.toolbar);
        tabLayout=(TabLayout) findViewById(R.id.tabLayout);
        viewPager=(ViewPager) findViewById(R.id.viewPager);
        setUpViewPager();


        if (toolbar != null){
            setSupportActionBar(toolbar);


        }

    }

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments= new ArrayList<>();

        fragments.add(new ViewPagerFragment());
        fragments.add(new ReciclerViewFragment());

        return fragments;
    }

    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_casa);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_dog);
    }

    public boolean onCreateOptionsMenu(Menu menu){

        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){

        switch (item.getItemId()) {

            case R.id.mContacto:
                Intent intent = new Intent(this,Formulario.class);
                startActivity(intent);
                break;
            case R.id.mAcerca:
                Intent intent2 = new Intent(this,BioDesarrollador.class);
                startActivity(intent2);
                break;
            case R.id.mFavoritos:
                 Intent intent3 = new Intent(this, Favoritos.class);
                 startActivity(intent3);
                break;



        }
         return true;

    }





}


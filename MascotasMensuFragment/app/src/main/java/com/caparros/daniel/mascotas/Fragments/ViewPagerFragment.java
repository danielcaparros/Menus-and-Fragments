package com.caparros.daniel.mascotas.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.caparros.daniel.mascotas.Adaptador.MascotaAdaptador;
import com.caparros.daniel.mascotas.Pojo.Mascota;
import com.caparros.daniel.mascotas.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ViewPagerFragment extends Fragment {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_view_pager, container, false);


        listaMascotas=(RecyclerView) v.findViewById(R.id.rvMascotas);

        LinearLayoutManager llm=new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();


        return v;
    }

    public void inicializarListaMascotas(){

        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota("Daniel",1,R.drawable.perro1));
        mascotas.add(new Mascota("Ramon",2,R.drawable.perro2));
        mascotas.add(new Mascota("Raul",3,R.drawable.perro3));
        mascotas.add(new Mascota("JC",4,R.drawable.perro4));
        mascotas.add(new Mascota("Pablo",5,R.drawable.perro5));
        mascotas.add(new Mascota("Jesus",6,R.drawable.perro2));
        mascotas.add(new Mascota("David",7,R.drawable.perro4));

    }

    public void inicializarAdaptador(){

        MascotaAdaptador adaptador=new MascotaAdaptador(mascotas, getActivity());
        listaMascotas.setAdapter(adaptador);

    }

}

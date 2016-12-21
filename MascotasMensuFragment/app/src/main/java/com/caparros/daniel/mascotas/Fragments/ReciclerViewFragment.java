package com.caparros.daniel.mascotas.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.caparros.daniel.mascotas.Adaptador.PerfilAdaptador;
import com.caparros.daniel.mascotas.Pojo.Perfil;
import com.caparros.daniel.mascotas.R;

import java.util.ArrayList;


/**
 * Created by daniel on 20/12/2016.
 */

public class ReciclerViewFragment extends Fragment {

    ArrayList<Perfil> perfiles;
    private RecyclerView listaPerfiles;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);


        View v=inflater.inflate(R.layout.fragment_reciclerview,container,false);

        listaPerfiles=(RecyclerView) v.findViewById(R.id.rvPerfi);

        GridLayoutManager glm= new GridLayoutManager(getActivity(),2);

        //LinearLayoutManager llm=new LinearLayoutManager(getActivity());
        //llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaPerfiles.setLayoutManager(glm);
        inicializarListaPerfil();
        inicializarAdaptador();


        return v;
    }

    public void inicializarListaPerfil(){

        perfiles = new ArrayList<Perfil>();

        perfiles.add(new Perfil(1,R.drawable.perro1));
        perfiles.add(new Perfil(2,R.drawable.perro1));
        perfiles.add(new Perfil(3,R.drawable.perro1));
        perfiles.add(new Perfil(4,R.drawable.perro1));
        perfiles.add(new Perfil(5,R.drawable.perro1));
        perfiles.add(new Perfil(6,R.drawable.perro1));
        perfiles.add(new Perfil(7,R.drawable.perro1));

    }

    public void inicializarAdaptador(){

        PerfilAdaptador adaptador=new PerfilAdaptador(perfiles, getActivity());
        listaPerfiles.setAdapter(adaptador);

    }

}

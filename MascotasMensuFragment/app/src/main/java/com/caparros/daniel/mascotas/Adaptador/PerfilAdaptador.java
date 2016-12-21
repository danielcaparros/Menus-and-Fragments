package com.caparros.daniel.mascotas.Adaptador;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.caparros.daniel.mascotas.Pojo.Mascota;
import com.caparros.daniel.mascotas.Pojo.Perfil;
import com.caparros.daniel.mascotas.R;

import java.util.ArrayList;

/**
 * Created by daniel on 20/12/2016.
 */

public class PerfilAdaptador extends RecyclerView.Adapter<PerfilAdaptador.PerfilViewHolder>{


    ArrayList<Perfil> perfiles;
    Activity activity;

    public PerfilAdaptador(ArrayList<Perfil> perfiles, Activity activity){
        this.perfiles=perfiles;
        this.activity=activity;
    }

    @Override
    public PerfilViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_perfil,parent,false);
        return new PerfilViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final PerfilViewHolder perfilViewHolder, int position) {
        final Perfil perfil=perfiles.get(position);
        perfilViewHolder.imgFotoPerfil.setImageResource(perfil.getFoto());
        perfilViewHolder.tvPuntuacionPerfil.setText(String.valueOf(perfil.getPuntuacion()));

    }

    @Override
    public int getItemCount() {
        return perfiles.size();
    }

    public static class PerfilViewHolder extends RecyclerView.ViewHolder {
        private TextView tvPuntuacionPerfil;
        private ImageView imgFotoPerfil;


            public PerfilViewHolder(View itemView) {
                super(itemView);
                imgFotoPerfil=(ImageView) itemView.findViewById(R.id.imgFotoPerfil);
                tvPuntuacionPerfil=(TextView) itemView.findViewById(R.id.tvPuntuacionPerfil);



            }
    }
}






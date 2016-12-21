package com.caparros.daniel.mascotas.Pojo;

/**
 * Created by daniel on 20/12/2016.
 */

public class Perfil {

    private int puntuacion;
    private int foto;

    public Perfil(int puntuacion, int foto ){

        this.puntuacion=puntuacion;
        this.foto=foto;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}

package com.proventaja.tiendit.petagram;

import java.io.Serializable;

public class Mascota implements Serializable {
    private int id;
    private String nombre;
    private int imagen;
    private int calificacion;

    public Mascota(int id,int imagen, String nombre, int calificacion) {
        this.id = id;
        this.imagen = imagen;
        this.nombre = nombre;
        this.calificacion = calificacion;
    }
    public Mascota() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }
}

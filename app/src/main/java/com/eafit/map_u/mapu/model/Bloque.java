package com.eafit.map_u.mapu.model;

import java.util.ArrayList;

public class Bloque {

    private int numSalones;
    private String nombre, descripcion, imagen;
    private double latitud, longitud;

    public Bloque() {
    }

    public Bloque(String nombre, double latitud, double longitud, String descripcion, int numSalones,String url) {
        this.imagen = url;
        this.numSalones = numSalones;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public String getURL(){
        return imagen;
    }

    public void setURL(String url) {
        this.imagen = url;
    }

    public int getNumSalones(){return numSalones;}

    public void setNumSalones(int numSalones) {
        this.numSalones = numSalones;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getLatitud(){
        return latitud;
    }

    public void setLatitud(double latitud){
        this.latitud = latitud;
    }

    public double getLongitud(){
        return longitud;
    }

    public void setLongitud(double longitud){
        this.longitud = longitud;
    }

}
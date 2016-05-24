package com.eafit.map_u.mapu.model;

import java.util.ArrayList;

public class Bloque {

    private int id, numSalones;
    private String nombre, descripcion;
    private double latitud, longitud;

    public Bloque() {
    }

    public Bloque(int id, int numSalones, String nombre, String descripcion, double latitud, double longitud) {
        this.id = id;
        this.numSalones = numSalones;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.latitud = latitud;
        this.longitud = longitud;
    }

        public int getId(){
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getNumSalones(){
            return id;
        }

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

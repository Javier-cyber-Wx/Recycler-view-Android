package com.example.recyclerview;

public class Restaurante {
    private String nombre;
    private String urlPhoto;
    private float valoracion;
    private String dirección;

    public Restaurante(String nombre, String urlPhoto, float valoracion, String dirección) {
        this.nombre = nombre;
        this.urlPhoto = urlPhoto;
        this.valoracion = valoracion;
        this.dirección = dirección;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrlPhoto() {
        return urlPhoto;
    }

    public void setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
    }

    public float getValoracion() {
        return valoracion;
    }

    public void setValoracion(float valoracion) {
        this.valoracion = valoracion;
    }

    public String getDirección() {
        return dirección;
    }

    public void setDirección(String dirección) {
        this.dirección = dirección;
    }
}

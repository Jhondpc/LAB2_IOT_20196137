package com.example.lab2_20196137.dto;
import com.google.gson.annotations.SerializedName;

public class Nombre {
    @SerializedName("title")
    private String titulo;

    @SerializedName("first")
    private String nombre;

    @SerializedName("last")
    private String apellido;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}

package com.example.lab2_20196137.dto;
import com.google.gson.annotations.SerializedName;
public class Calle {
    @SerializedName("number")
    private int numero;

    @SerializedName("name")
    private String nombre;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

package com.example.lab2_20196137.dto;
import com.google.gson.annotations.SerializedName;

public class Id {
    @SerializedName("name")
    private String nombre;

    @SerializedName("value")
    private String valor;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}

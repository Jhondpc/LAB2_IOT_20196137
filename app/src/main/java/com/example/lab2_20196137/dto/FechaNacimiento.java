package com.example.lab2_20196137.dto;
import com.google.gson.annotations.SerializedName;

public class FechaNacimiento {
    @SerializedName("date")
    private String fecha;

    @SerializedName("age")
    private int edad;

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}

package com.example.lab2_20196137.dto;
import com.google.gson.annotations.SerializedName;

public class Coordenadas {
    @SerializedName("latitude")
    private String latitud;

    @SerializedName("longitude")
    private String longitud;

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }
}

package com.example.lab2_20196137.dto;
import com.google.gson.annotations.SerializedName;

public class ZonaHoraria {
    @SerializedName("offset")
    private String offset;

    @SerializedName("description")
    private String descripcion;

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}

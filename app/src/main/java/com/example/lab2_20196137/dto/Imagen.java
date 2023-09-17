package com.example.lab2_20196137.dto;
import com.google.gson.annotations.SerializedName;

public class Imagen {
    @SerializedName("large")
    private String grande;

    @SerializedName("medium")
    private String mediana;

    @SerializedName("thumbnail")
    private String miniatura;

    public String getGrande() {
        return grande;
    }

    public void setGrande(String grande) {
        this.grande = grande;
    }

    public String getMediana() {
        return mediana;
    }

    public void setMediana(String mediana) {
        this.mediana = mediana;
    }

    public String getMiniatura() {
        return miniatura;
    }

    public void setMiniatura(String miniatura) {
        this.miniatura = miniatura;
    }
}

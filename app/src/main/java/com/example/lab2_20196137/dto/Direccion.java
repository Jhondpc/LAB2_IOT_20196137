package com.example.lab2_20196137.dto;
import com.google.gson.annotations.SerializedName;

public class Direccion {
    @SerializedName("street")
    private Calle calle;

    @SerializedName("city")
    private String ciudad;

    @SerializedName("state")
    private String estado;

    @SerializedName("country")
    private String pais;

    @SerializedName("postcode")
    private String codigoPostal;

    @SerializedName("coordinates")
    private Coordenadas coordenadas;

    @SerializedName("timezone")
    private ZonaHoraria zonaHoraria;

    public Calle getCalle() {
        return calle;
    }

    public void setCalle(Calle calle) {
        this.calle = calle;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public Coordenadas getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(Coordenadas coordenadas) {
        this.coordenadas = coordenadas;
    }

    public ZonaHoraria getZonaHoraria() {
        return zonaHoraria;
    }

    public void setZonaHoraria(ZonaHoraria zonaHoraria) {
        this.zonaHoraria = zonaHoraria;
    }
}

package com.example.lab2_20196137.dto;
import com.google.gson.annotations.SerializedName;

public class Info {
    @SerializedName("seed")
    private String semilla;

    @SerializedName("results")
    private int resultados;

    @SerializedName("page")
    private int pagina;

    @SerializedName("version")
    private String version;

    public String getSemilla() {
        return semilla;
    }

    public void setSemilla(String semilla) {
        this.semilla = semilla;
    }

    public int getResultados() {
        return resultados;
    }

    public void setResultados(int resultados) {
        this.resultados = resultados;
    }

    public int getPagina() {
        return pagina;
    }

    public void setPagina(int pagina) {
        this.pagina = pagina;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}

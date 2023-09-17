package com.example.lab2_20196137.dto;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UsuarioResponse {
    @SerializedName("results")
    private List<Usuario> usuarios;

    @SerializedName("info")
    private Info info;

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }
}

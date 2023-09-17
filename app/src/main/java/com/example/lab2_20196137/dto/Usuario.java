package com.example.lab2_20196137.dto;
import com.google.gson.annotations.SerializedName;

public class Usuario {
    @SerializedName("gender")
    private String genero;

    @SerializedName("name")
    private Nombre nombre;

    @SerializedName("location")
    private Direccion direccion;

    @SerializedName("email")
    private String email;

    @SerializedName("login")
    private Login login;

    @SerializedName("dob")
    private FechaNacimiento fechaNacimiento;

    @SerializedName("registered")
    private FechaRegistro fechaRegistro;

    @SerializedName("phone")
    private String telefono;

    @SerializedName("cell")
    private String celular;

    @SerializedName("id")
    private Id identificacion;

    @SerializedName("picture")
    private Imagen imagen;

    @SerializedName("nat")
    private String nacionalidad;

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public void setNombre(Nombre nombre) {
        this.nombre = nombre;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public FechaNacimiento getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(FechaNacimiento fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public FechaRegistro getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(FechaRegistro fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Id getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(Id identificacion) {
        this.identificacion = identificacion;
    }

    public Imagen getImagen() {
        return imagen;
    }

    public void setImagen(Imagen imagen) {
        this.imagen = imagen;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
}

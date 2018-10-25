package com.example.sistemas.apphojaruta.Entidades;

import java.io.Serializable;

public class DetalleHojaRuta implements Serializable {

    private String NumeroHojaRuta;
    private String CLiente;
    private String Direccion;
    private String Bultos;
    private String Telefono;
    private String Estado;

    public DetalleHojaRuta() {
    }

    public DetalleHojaRuta(String numeroHojaRuta, String CLiente, String direccion, String bultos,
                           String telefono, String estado) {

        NumeroHojaRuta = numeroHojaRuta;
        this.CLiente = CLiente;
        Direccion = direccion;
        Bultos = bultos;
        Telefono = telefono;
        Estado = estado;

    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getCLiente() {
        return CLiente;
    }

    public void setCLiente(String CLiente) {
        this.CLiente = CLiente;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getBultos() {
        return Bultos;
    }

    public void setBultos(String bultos) {
        Bultos = bultos;
    }

    public String getNumeroHojaRuta() {
        return NumeroHojaRuta;
    }

    public void setNumeroHojaRuta(String numeroHojaRuta) {
        NumeroHojaRuta = numeroHojaRuta;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }
}

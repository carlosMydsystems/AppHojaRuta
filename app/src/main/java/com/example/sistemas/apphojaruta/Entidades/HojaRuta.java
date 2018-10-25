package com.example.sistemas.apphojaruta.Entidades;

import java.io.Serializable;

public class HojaRuta implements Serializable {

    private String NumeroHojaRuta;
    private String Usuario;
    private String Fechareparto;
    private String Vehiculo;
    private String Chofer;
    private String TotalDocumentos;
    private String TotalPedidos;
    private String Bultos;
    private String Asistente;
    private String Estado;

    public HojaRuta(String numeroHojaRuta, String usuario, String fechareparto, String vehiculo,
                    String chofer, String totalDocumentos, String totalPedidos, String bultos,
                    String asistente, String estado) {
        NumeroHojaRuta = numeroHojaRuta;
        Usuario = usuario;
        Fechareparto = fechareparto;
        Vehiculo = vehiculo;
        Chofer = chofer;
        TotalDocumentos = totalDocumentos;
        TotalPedidos = totalPedidos;
        Bultos = bultos;
        Asistente = asistente;
        Estado = estado;
    }

    public HojaRuta() {
    }

    public String getNumeroHojaRuta() {
        return NumeroHojaRuta;
    }

    public void setNumeroHojaRuta(String numeroHojaRuta) {
        NumeroHojaRuta = numeroHojaRuta;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String usuario) {
        Usuario = usuario;
    }

    public String getFechareparto() {
        return Fechareparto;
    }

    public void setFechareparto(String fechareparto) {
        Fechareparto = fechareparto;
    }

    public String getVehiculo() {
        return Vehiculo;
    }

    public void setVehiculo(String vehiculo) {
        Vehiculo = vehiculo;
    }

    public String getChofer() {
        return Chofer;
    }

    public void setChofer(String chofer) {
        Chofer = chofer;
    }

    public String getTotalDocumentos() {
        return TotalDocumentos;
    }

    public void setTotalDocumentos(String totalDocumentos) {
        TotalDocumentos = totalDocumentos;
    }

    public String getTotalPedidos() {
        return TotalPedidos;
    }

    public void setTotalPedidos(String totalPedidos) {
        TotalPedidos = totalPedidos;
    }

    public String getBultos() {
        return Bultos;
    }

    public void setBultos(String bultos) {
        Bultos = bultos;
    }

    public String getAsistente() {
        return Asistente;
    }

    public void setAsistente(String asistente) {
        Asistente = asistente;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }
}

package com.example.apicoches.utils;

public class Coche {
    private String marca, modelo, imagen;
    private int caballos;
    private double precio;

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public int getCaballos() {
        return caballos;
    }

    public void setCaballos(int caballos) {
        this.caballos = caballos;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return  modelo;
    }

    public Coche(String marca, String modelo, String imagen, int caballos, double precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.imagen = imagen;
        this.caballos = caballos;
        this.precio = precio;
    }
}

package com.example.josemariavera.utils;

public class Pedido {
    private String nombre;
    private String apellido;
    private String direccion;
    private int telefono;
    private int nIngredientes;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getnIngredientes() {
        return nIngredientes;
    }

    public void setnIngredientes(int nIngredientes) {
        this.nIngredientes = nIngredientes;
    }

    public Pedido(String nombre, String apellido, String direccion, int telefono, int nIngredientes) {
        setNombre(nombre);
        setApellido(apellido);
        setDireccion(direccion);
        setTelefono(telefono);
        setnIngredientes(nIngredientes);
    }
}

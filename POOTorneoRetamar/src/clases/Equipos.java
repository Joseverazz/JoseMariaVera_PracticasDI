package clases;

import java.io.Serializable;

public class Equipos implements Serializable {
    private String nombre;
    private int partidosJugados = 0;
    private int partidosGanados = 0;
    private int partidosPerdidos = 0;
    private int partidosEmpatados = 0;
    private int golesContra = 0;
    private int golesFavor = 0;
    private int puntos = 0;
    private int partidosHierba = 0;
    private int partidosCemento = 0;


    public String getNombre() {
        return nombre;
    }

    public int getPartidosJugados() {
        return partidosJugados;
    }

    public int getPartidosGanados() {
        return partidosGanados;
    }

    public int getPartidosPerdidos() {
        return partidosPerdidos;
    }

    public int getPartidosEmpatados() {
        return partidosEmpatados;
    }

    public int getGolesContra() {
        return golesContra;
    }

    public int getGolesFavor() {
        return golesFavor;
    }

    public int getPuntos() {
        return puntos;
    }

    public int getPartidosHierba() {
        return partidosHierba;
    }

    public int getPartidosCemento() {
        return partidosCemento;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPartidosJugados(int partidosJugados) {
        this.partidosJugados = partidosJugados;
    }

    public void setPartidosGanados(int partidosGanados) {
        this.partidosGanados = partidosGanados;
    }

    public void setPartidosPerdidos(int partidosPerdidos) {
        this.partidosPerdidos = partidosPerdidos;
    }

    public void setPartidosEmpatados(int partidosEmpatados) {
        this.partidosEmpatados = partidosEmpatados;
    }

    public void setGolesContra(int golesContra) {
        this.golesContra = golesContra;
    }

    public void setGolesFavor(int golesFavor) {
        this.golesFavor = golesFavor;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public void setPartidosHierba(int partidosHierba) {
        this.partidosHierba = partidosHierba;
    }

    public void setPartidosCemento(int partidosCemento) {
        this.partidosCemento = partidosCemento;
    }

    public Equipos(String nombre) {
        setNombre(nombre);
    }

    @Override
    public String toString() {
        return String.format("| %-15s | %3d | %3d | %3d | %3d | %3d | %3d | %6d | %6d | %6d |",
                nombre,partidosJugados,partidosGanados,
                partidosPerdidos,partidosEmpatados,
                golesFavor,golesContra,getPuntos(),getPartidosHierba(),getPartidosCemento());
    }

    public Equipos(Equipos e) {
        setNombre(e.getNombre());
        setPartidosJugados(e.getPartidosJugados());
        setPartidosGanados(e.getPartidosGanados());
        setPartidosPerdidos(e.getPartidosPerdidos());
        setPartidosEmpatados(e.getPartidosEmpatados());
        setGolesContra(e.getGolesContra());
        setGolesFavor(e.getGolesFavor());
        setPuntos(e.getPuntos());
    }


}

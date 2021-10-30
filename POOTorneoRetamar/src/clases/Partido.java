package clases;
import java.io.Serializable;

public class Partido implements Serializable {
    //dos variables equipo, hierba, cemento, resultado, dia(jornada).
    Equipos a= null;
    Equipos b= null;

    boolean hierba = false;

    int golesA =0;
    int golesB=0;
    int jornada;

    public Equipos getA() {
        return a;
    }

    public Equipos getB() {
        return b;
    }

    public void setA(Equipos a) {
        this.a = a;
    }

    public void setB(Equipos b) {
        this.b = b;
    }

    public boolean getHierba(){
        return hierba;
    }

    public void setHierba(boolean hierba) {
        this.hierba = hierba;
    }

    public void setHierba2(boolean hierba2){
        if (hierba2){
            a.setPartidosHierba(a.getPartidosHierba()+1);
            b.setPartidosHierba(b.getPartidosHierba()+1);
        }else
        {
            a.setPartidosCemento(a.getPartidosCemento()+1);
            b.setPartidosCemento(b.getPartidosCemento()+1);
        }

        setHierba(hierba2);
    }



    public int getGolesA() {
        return golesA;
    }

    public void setGolesA(int golesA) {

        this.golesA = golesA;
    }

    public int getGolesB() {
        return golesB;
    }

    public void setGolesB(int golesB) {
        this.golesB = golesB;
    }

    public int getJornada() {
        return jornada;
    }

    public void setJornada(int jornada) {
        this.jornada = jornada;
    }

    public Partido(int jornada, Equipos equipoA, Equipos equipoB) {
        setJornada(jornada);
        setA(equipoA);
        setB(equipoB);
    }

    public void celebrarPartido(int golesA, int golesB)
    {
        setGolesA(golesA);
        setGolesB(golesB);
    }

    @Override
    public String toString() {
        return String.format("| %8d | %8b | %15s | %8d |\n",getJornada(),getHierba(),a.getNombre(),getGolesA())+
                String.format("| %8d | %8b | %15s | %8d |",getJornada(),getHierba(),b.getNombre(),getGolesB());
    }

}

package clases;

public class Source {

    public final static String JAR = Source.class.getProtectionDomain().getCodeSource().getLocation().getFile();
    public final static String PATH = JAR.substring(0,JAR.lastIndexOf('/'));
    public final static String FICHERO = PATH+"/FEquipos.obj";
    public final static String FICHEAux = PATH+"/FEquiposAux.obj";
}


import fsg.in;
import clases.*;

import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main  {
    private static List<Equipos> lEquipos;
    private static final int NUMERO_EQUIPOS = 12;

    // new Calendario(12);
        public static void main(String[] args) throws IOException, ClassNotFoundException {
            FEquipos fe = new FEquipos(URLDecoder.decode(Source.FICHERO, StandardCharsets.UTF_8));
            if (fe.leer() == null) anadirEquipos(fe);
            int op;
            while (true) {
                in.cls();
                menu();
                op = in.leerInt("", v -> v > 0 && v < 8, "Elige una opción: (1-7): ");
                in.cls();
                if (op == 7) break;
                switch (op) {
                    case 1: anadirEquipos(fe);break;
                    case 2: listarEquipos(fe);break;
                    case 3: generarPartidos();break;
                    case 4: generarCalendario();break;
                    case 5: break;
                    case 6: break;
                    default:
                }
                in.detener();
            }
        }

    private static void generarCalendario() {
        new Calendario(12);
    }

    private static void generarPartidos()
    {
        lEquipos = new ArrayList<>(List.of(
                new Equipos("e1"),
                new Equipos("e2"),
                new Equipos("e3"),
                new Equipos("e4"),
                new Equipos("e5"),
                new Equipos("e6"),
                new Equipos("e7"),
                new Equipos("e8"),
                new Equipos("e9"),
                new Equipos("e10"),
                new Equipos("e11"),
                new Equipos("e12")));
        List<Equipos> lEquipos2 = lEquipos;
        List<Partido> lCalendario = new ArrayList<Partido>();
        int[] equipos;
        String[][] matriz1, matriz2, jornadas, jornadas2;
        equipos = new int[lEquipos2.size()];
        //Asigno posiciones del array a los equipos
        for (int i = 0; i < lEquipos2.size(); i++) {
            equipos[i] = i + 1;
        }

        matriz1 = new String[lEquipos2.size() - 1][lEquipos2.size() / 2];
        matriz2 = new String[lEquipos2.size() - 1][lEquipos2.size() / 2];
        jornadas = new String[lEquipos2.size() - 1][lEquipos2.size() / 2]; //primera vuelta
        jornadas2 = new String[lEquipos2.size() - 1][lEquipos2.size() / 2]; //segunda vuelta

        int cont = 0;
        int cont2 = lEquipos2.size() - 2;

        for (int i = 0; i < lEquipos2.size() - 1; i++) {
            for (int j = 0; j < lEquipos2.size() / 2; j++) {
                //matriz1
                matriz1[i][j] = String.valueOf(equipos[cont]);
                cont++;
                if (cont == (lEquipos2.size() - 1)) cont = 0;

                //matriz2
                if (j == 0) matriz2[i][j] = String.valueOf(lEquipos2.size());
                else {
                    matriz2[i][j] = String.valueOf(lEquipos2.get(cont2));
                    cont2--;
                    if (cont2 == -1) cont2 = lEquipos2.size() - 2;
                }

                //matriz2
                if (j == 0) matriz2[i][j] = String.valueOf(lEquipos2.size());
                else {
                    matriz2[i][j] = String.valueOf(equipos[cont2]);
                    cont2--;
                    if (cont2 == -1) cont2 = lEquipos2.size() - 2;
                }

                //Elaboro la matriz final de enfrentamientos por jornada (primera vuelta)
                if (j == 0) {
                    if (i % 2 == 0) jornadas[i][j] = matriz2[i][j] + "-" + matriz1[i][j];
                    else jornadas[i][j] = matriz1[i][j] + "-" + matriz2[i][j];
                } else jornadas[i][j] = matriz1[i][j] + "-" + matriz2[i][j];


                //segunda vuelta - al reves que la primera
                if (j == 0) {
                    if (i % 2 == 0) jornadas2[i][j] = matriz1[i][j] + "-" + matriz2[i][j];
                    else jornadas2[i][j] = matriz2[i][j] + "-" + matriz1[i][j];
                } else jornadas2[i][j] = matriz2[i][j] + "-" + matriz1[i][j];
            }
        }

        int jorn = 1;
        for (int i = 0; i < lEquipos2.size() - 1; i++) {
            for (int j = 0; j < lEquipos2.size() / 2; j++) {
                lCalendario.add(new Partido( jorn,
                        lEquipos2.get(Integer.parseInt(jornadas[i][j].split("-")[0])-1),
                        lEquipos2.get(Integer.parseInt(jornadas[i][j].split("-")[1])-1)));
            }
            jorn++;
        }

        System.out.println();
        jorn = lEquipos2.size();
        for (int i = 0; i < lEquipos2.size() - 1; i++) {
            for (int j = 0; j < lEquipos2.size() / 2; j++) {
                lCalendario.add(new Partido(jorn,
                        lEquipos2.get(Integer.parseInt(jornadas2[i][j].split("-")[0])-1),
                        lEquipos2.get(Integer.parseInt(jornadas2[i][j].split("-")[1])-1)));
            }
            jorn++;
        }



        for (int i = 0; i < lCalendario.size(); i++) {
            System.out.println("+----------+----------+-----------------+----------+");
            System.out.println("| Jornada  | Hierba   | Nombre          | Goles    |");
            System.out.println("+----------+----------+-----------------+----------+");
            if (i%6<3) lCalendario.get(i).setHierba2(true);
            System.out.print(lCalendario.get(i)+"\n");
            System.out.println("+----------+----------+-----------------+----------+");
        }
        System.out.println("+----------+----------+-----------------+----------+");


    }

    private static void listarEquipos(FEquipos fe) throws IOException, ClassNotFoundException{
            fe.abrir();
            Equipos ar;
            List<Equipos> lAux = new ArrayList<>();

            while((ar = fe.leer())!=null)
            {
                lAux.add(ar);
            }
            System.out.println("+----------+-----------------+-----+-----+-----+-----+-----+-----+--------+--------+--------+");
            System.out.println("| Posicion | Nombre          | PJ  | PG  | PP  | PE  | GC  | GF  | Puntos | JHier  | Jnohie |");
            System.out.println("+----------+-----------------+-----+-----+-----+-----+-----+-----+--------+--------+--------+");
            for (int i = 0; i < lAux.size(); i++) {
                System.out.printf("| %8d ",i+1);
                System.out.print(lAux.get(i)+"\n");
            }
            System.out.println("+----------+-----------------+-----+-----+-----+-----+-----+-----+--------+--------+--------+");
        }

        private static void anadirEquipos(FEquipos fe) throws IOException, ClassNotFoundException {
        for (int i = 0; i < NUMERO_EQUIPOS; i++) {
            String nombre = in.leerString("Nombre del equipo "+i+": ");

                if(buscarEquipos(fe,nombre) != null) {
                    System.out.println("Ya existe el equipo.");
                    return;
                }

                Equipos eq = new Equipos(nombre);

                fe.escribir(eq);
            }
            System.out.println("Equipos almacenado.");
        }






        /*
        /* **********************************
        private static void entradaMercancia(FEquipos fa) throws IOException, ClassNotFoundException {
            int codigo = in.leerInt("Codigo: ", v->v> 0);
            Equipos en = buscarEquipos(fa,codigo);
            if(en == null) {
                System.out.println("No existe el Equipos a modificar.");
                return;
            }

            System.out.println("***************");
            System.out.println("Artículo a modificar: ");
            System.out.printf("%-40s %6.2f %6.2f %6d\n",
                    en.getDescripcion(),en.getPrecioCompra(),
                    en.getPrecioVenta(),en.getStock());
            System.out.println("***************");

            int stock = in.leerInt("Cuantas unidades quieres añadir: ", v-> v > 0);
            en.setStock(en.getStock() + stock);

            System.out.println("***************");
            System.out.println("El artículo modificado ahora es: ");
            System.out.printf("%06d %-40s %6.2f %6.2f %6d\n",
                    en.getCodigo(),en.getDescripcion(),
                    en.getPrecioCompra(),en.getPrecioVenta(),
                    en.getStock());
            System.out.println("***************");
        }
        /* **********************************
        private static void salidaMercancia(FEquipos fa) throws IOException, ClassNotFoundException {
            int codigo = in.leerInt("Código: ", v->v> 0);
            Equipos en = buscarEquipos(fa,codigo);
            if(en == null) {
                System.out.println("No existe el Equipos a modificar.");
                return;
            }

            System.out.println("***************");
            System.out.println("Artículo a modificar: ");
            System.out.printf("%-40s %6.2f %6.2f %6d\n",
                    en.getDescripcion(),en.getPrecioCompra(),
                    en.getPrecioVenta(),en.getStock());
            System.out.println("***************");

            int stock = in.leerInt("Cuantas unidades quieres quitar: ");

            if((en.getStock() - stock) >= 0)
                en.setStock(stock);
            else
                System.out.println("El stock no puede ser negativo.");

            System.out.println("***************");
            System.out.println("El artículo modificado ahora es: ");
            System.out.printf("%06d %-40s %6.2f %6.2f %6d\n",
                    en.getCodigo(),en.getDescripcion(),
                    en.getPrecioCompra(),en.getPrecioVenta(),
                    en.getStock());
            System.out.println("***************");
        }
        /* **********************************
        private static void modificar(FEquipos fa) throws IOException, ClassNotFoundException {
            int codigo = in.leerInt("Codigo: ", v->v> 0);
            Equipos en = buscarEquipos(fa,codigo);
            if(en == null) {
                System.out.println("No existe el Equipos a modificar.");
                return;
            }

            System.out.println("***************");
            System.out.println("Artículo a modificar: ");
            System.out.printf("%-40s %6.2f %6.2f %6d\n",
                    en.getDescripcion(),en.getPrecioCompra(),
                    en.getPrecioVenta(),en.getStock());
            System.out.println("***************");

            String descripcion = in.leerString("Descripción: ",v-> v.equals("")
                    || v.matches("[A-ZÃÃÃÃÃÃÃ]+(\\s[A-ZÃÃÃÃÃÃÃ]+)*"));
            double pc = in.leerDouble("Precio de compra: ", v->
                    v>=0 && new BigDecimal(""+v).scale()<=2);
            double pv = in.leerDouble("Precio de venta: ", v->
                    v>=0 && new BigDecimal(""+v).scale()<=2);
            Equipos nuevoEquipos = new Equipos(codigo,
                    (descripcion.equals(""))? en.getDescripcion(): descripcion
                    ,(pc == 0)? en.getPrecioCompra(): pc
                    ,(pv == 0)? en.getPrecioVenta(): pv
                    ,en.getStock());
            //
            FEquipos faAux = new FEquipos(URLDecoder.decode(Source.FICHEAux,
                    "UTF-8"));
            faAux.vaciar();

            Equipos ar = null;
            fa.abrir();
            while((ar = fa.leer())!=null)
                if(codigo != ar.getCodigo())
                    faAux.escribir(ar);
                else
                    faAux.escribir(nuevoEquipos);
            fa.cerrar();

            fa.vaciar();
            faAux.abrir();
            while((ar = faAux.leer())!=null)
                faAux.escribir(ar);
            fa.cerrar();

            System.out.println("***************");
            System.out.println("El artÃ­culo modificado ahora es: ");
            System.out.printf("%06d %-40s %6.2f %6.2f %6d\n",
                    nuevoEquipos.getCodigo(),nuevoEquipos.getDescripcion(),
                    nuevoEquipos.getPrecioCompra(),nuevoEquipos.getPrecioVenta(),
                    nuevoEquipos.getStock());
            System.out.println("***************");

        }
        /* **********************************
        private static void baja(FEquipos fa) throws IOException, ClassNotFoundException {
            int codigo = in.leerInt("Codigo: ", v->v> 0);
            //Comprobar si existe:
            Equipos en = buscarEquipos(fa,codigo);
            if(en == null) {
                System.out.println("No existe el Equipos a eliminar.");
                return;
            }

            FEquipos faAux = new FEquipos(URLDecoder.decode(Source.FICHEAux,
                    "UTF-8"));
            faAux.vaciar();

            Equipos ar = null;
            fa.abrir();
            while((ar = fa.leer())!=null)
                if(codigo != ar.getCodigo())
                    faAux.escribir(ar);
            fa.cerrar();

            fa.vaciar();
            faAux.abrir();
            while((ar = faAux.leer())!=null)
                faAux.escribir(ar);
            fa.cerrar();

            System.out.println("Se ha eliminado: ");
            System.out.printf("%06d %-40s %6.2f %6.2f %6d\n",
                    en.getCodigo(),en.getDescripcion(),en.getPrecioCompra(),
                    en.getPrecioVenta(),en.getStock());


        }
        /* **********************************
        private static void Listar(FEquipos fa) throws IOException, ClassNotFoundException {
            fa.abrir();
            Equipos ar = null;

            while(true)
            {
                ar = fa.leer();
                if(ar == null) break;

                System.out.printf("%06d %-40s %6.2f %6.2f %6d\n",
                        ar.getCodigo(),ar.getDescripcion(),ar.getPrecioCompra(),
                        ar.getPrecioVenta(),ar.getStock());
            }


        }
        /* **********************************
        private static void alta(FEquipos fa) throws IOException, ClassNotFoundException {
            int codigo = in.leerInt("Codigo: ", v->v> 0);
            //Comprobar si no estÃ¡ repetido:
            if(buscarEquipos(fa,codigo) != null) {
                System.out.println("Ya existe el artÃ­culo.");
                return;
            }


            String descripcion = in.leerString("DescripciÃ³n: ",v-> v.matches(
                    "[A-ZÃÃÃÃÃÃÃ]+(\\s[A-ZÃÃÃÃÃÃÃ]+)*"));

            double pc = in.leerDouble("Precio de compra: ", v->
                    v>0 && new BigDecimal(""+v).scale()<=2);
            double pv = in.leerDouble("Precio de venta: ", v->
                    v>0 && new BigDecimal(""+v).scale()<=2);

            //int st = in.leerInt("Stock: ",v-> v>0);
            Equipos ar = new Equipos(codigo,descripcion,pc,pv,0);
            fa.escribir(ar);

            System.out.println("Equipos almacenado.");

        }
        /* **********************************/
        static void menu(){
            System.out.println("TORNEO DE FUTBOL RETAMAR ");
            System.out.println("===========================================");
            System.out.println("1. Añadir equipo");
            System.out.println("2. Listar equipos");
            System.out.println("3. no sirve");
            System.out.println("4. no sirve");
            System.out.println("5. no sirve");
            System.out.println("6. no sirve");
            System.out.println("7. Salir");
            System.out.print("Elegir opcion (1-7): ");
        }
        /* **********************************/
        static Equipos buscarEquipos(FEquipos fe, String nombre) throws IOException, ClassNotFoundException {
            fe.abrir();
            Equipos equipo;
            while(true)
            {
                equipo = fe.leer();
                if(equipo == null) break;

                if (equipo.getNombre().equals(nombre)) {
                    fe.cerrar();
                    return equipo;
                }
            }
            fe.cerrar();
            return null;
        }
    }


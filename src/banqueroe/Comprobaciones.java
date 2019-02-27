
package banqueroe;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alexis Holguin
 */
public class Comprobaciones {

    static List<Proceso> asignados;
    static List<Proceso> necesarios;
    static Disponibles recursos;

    Comprobaciones(List<Proceso> asignados, List<Proceso> necesarios, Disponibles recursos) {
        this.asignados = asignados;
        this.necesarios = necesarios;
        this.recursos = recursos;
    }

    public static List<Proceso> devuelveLista() {
        List<Proceso> terminados = new ArrayList<Proceso>();
        Disponibles recursosUsados = new Disponibles();
        for (int i = 0; i < necesarios.size(); i++) {
            if (!(terminados.contains(asignados.get(i))) && ejecuta(asignados.get(i), necesarios.get(i), recursos)) {
                System.out.println("Proceso " + (i + 1) + " terminado");
                for (int j = 0; j < recursos.getDisponibles().size(); j++) {
                    recursosUsados.getDisponibles().add((recursos.getDisponibles().get(j) + asignados.get(i).getRecursosNecesarios().get(j)) - necesarios.get(i).getRecursosNecesarios().get(j));
                }
                imprimirMatriz(asignados, terminados, necesarios, i, recursos, recursosUsados);
                for (int j = 0; j < recursos.getDisponibles().size(); j++) {
                    recursos.setDisponible(recursos.getDisponibles().get(j) + asignados.get(i).getRecursosNecesarios().get(j), j);
                }
                terminados.add(asignados.get(i));
                System.out.println("Recursos Liberados: " + recursos.getDisponibles());
                System.out.println();
                i = -1;
            }
            recursosUsados.getDisponibles().clear();
        }
        //imprimirMatrizSimple(asignados);
        if (terminados.size() == asignados.size()) {
            System.out.println("Todos los procesos han sido ejecutados sin problemas.");
        } else {
            System.out.println("Hay un interbloqueo, no se pueden seguir ejecutando procesos...");
        }
        return terminados;
    }

    public static Boolean ejecuta(Proceso asignados, Proceso necesarios, Disponibles disponibles) {
        // Devuelve True si tiene recursos suficientes...
        Boolean ej = true;
        for (int i = 0; i < necesarios.getRecursosNecesarios().size(); i++) {
            if ((asignados.getRecursosNecesarios().get(i) + disponibles.getDisponibles().get(i)) < necesarios.getRecursosNecesarios().get(i)) {
                ej = false;
                break;
            }
        }
        return ej;
    }

    public static void imprimirMatriz(List<Proceso> matriz, List<Proceso> terminados, List<Proceso> necesarios, int indice, Disponibles disponible, Disponibles restados) {
        String cadenaAsignados = "";
        String cadenaMaximos = "";
        String cadena = "";
        for (int i = 0; i < matriz.size(); i++) {
            cadenaAsignados = "|";
            cadenaMaximos = "|";
            if (terminados.contains(matriz.get(i))) {
                for (int j = 0; j < matriz.get(i).getRecursosNecesarios().size(); j++) {
                    cadenaAsignados += "\033[34m0|";
                    cadenaMaximos += "\033[34m" + necesarios.get(i).getRecursosNecesarios().get(j) + "|";
                }
            } else {
                for (int j = 0; j < matriz.get(i).getRecursosNecesarios().size(); j++) {
                    cadenaAsignados += "\033[30m" + matriz.get(i).getRecursosNecesarios().get(j) + "|";
                    cadenaMaximos += "\033[30m" + necesarios.get(i).getRecursosNecesarios().get(j) + "|";
                }
            }
            if (indice == i) {
                cadena += cadenaAsignados + "\t\t" + cadenaMaximos + "\t\t" + disponible.getDisponibles() + "\t" + restados.getDisponibles() + "\n";
            } else {
                cadena += cadenaAsignados + "\t\t" + cadenaMaximos + "\n";
            }
        }
        System.out.println("Asignados \tNecesarios \tDisponibles \tTomados");
        System.out.print(cadena);
    }

}

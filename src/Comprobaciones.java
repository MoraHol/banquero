

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juan_
 */
public class Comprobaciones {

    static List<Proceso> asignados;
    static List<Proceso> necesarios;
    static Disponibles recursos;
    
    Comprobaciones(List<Proceso> asignados, List<Proceso> necesarios, Disponibles recursos) {
        Comprobaciones.asignados = asignados;
        Comprobaciones.necesarios = necesarios;
        Comprobaciones.recursos = recursos;
    }

    public static List<Proceso> devuelveLista() {
    	// aqui se guardaran los procesos que se han termindo
        List<Proceso> terminados = new ArrayList<Proceso>();
        // aqui se guardaran los recursos disponibles por iteracion de cada proceso
        Disponibles recursosUsados = new Disponibles();
        // se ejecuta por cada proceso
        for (int i = 0; i < necesarios.size(); i++) {
        	// se define si el procesos puede terminar sin problema
            if (!(terminados.contains(asignados.get(i))) && ejecuta(asignados.get(i), necesarios.get(i), recursos)) {
                System.out.println("Proceso " + (i + 1) + " terminado");
                // definira los recursos utilizados por ese proceso
                for (int j = 0; j < recursos.getDisponibles().size(); j++) {
                    recursosUsados.getDisponibles().add((recursos.getDisponibles().get(j) + asignados.get(i).getRecursosNecesarios().get(j)) - necesarios.get(i).getRecursosNecesarios().get(j));
                }
                imprimirMatriz(asignados, terminados, necesarios, i, recursos, recursosUsados);
                // define los recursos disponibles para siguiente iteracion 
                for (int j = 0; j < recursos.getDisponibles().size(); j++) {
                    recursos.setDisponible(recursos.getDisponibles().get(j) + asignados.get(i).getRecursosNecesarios().get(j), j);
                }
                // añade el proceso que se pudo terminar sin problema
                terminados.add(asignados.get(i));
                System.out.println("Recursos Liberados: " + recursos.getDisponibles());
                System.out.println();
                i = -1;
            }
            recursosUsados.getDisponibles().clear();
        }
        // si el nuemro de procesos es igual al numero de procesos temrinados entonces no hubo interbloqueo
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
                    cadenaAsignados += "0|";
                    cadenaMaximos += necesarios.get(i).getRecursosNecesarios().get(j) + "|";
                }
            } else {
                for (int j = 0; j < matriz.get(i).getRecursosNecesarios().size(); j++) {
                    cadenaAsignados += matriz.get(i).getRecursosNecesarios().get(j) + "|";
                    cadenaMaximos += necesarios.get(i).getRecursosNecesarios().get(j) + "|";
                }
            }
            if (indice == i) {
                cadena += cadenaAsignados + "\t\t" + cadenaMaximos + "\t\t" + disponible.getDisponibles() + "\t" + restados.getDisponibles() + "\n";
            } else {
                cadena += cadenaAsignados + "\t\t" + cadenaMaximos + "\n";
            }
        }
        System.out.println("Asignados \t\tNecesarios \t\tDisponibles\t\tTomados");
        System.out.print(cadena);
    }

}

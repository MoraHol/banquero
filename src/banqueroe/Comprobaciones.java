/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banqueroe;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juan_
 */
public class Comprobaciones {

    public static List<Proceso> devuelveLista(List<Proceso> asignados, List<Proceso> necesarios, Disponibles recursos) {
        List<Proceso> terminados = new ArrayList<Proceso>();
        Disponibles recursosUsados = new Disponibles();
        for (int i = 0; i < necesarios.size(); i++) {
            if (!(terminados.contains(asignados.get(i))) && ejecuta(asignados.get(i), necesarios.get(i), recursos)) {
                terminados.add(asignados.get(i));
                System.out.println("Proceso " + (i + 1) + " terminado");
                for (int j = 0; j < recursos.getDisponibles().size(); j++) {
                    recursosUsados.getDisponibles().add((recursos.getDisponibles().get(j) + asignados.get(i).getRecursosNecesarios().get(j)) - necesarios.get(i).getRecursosNecesarios().get(j));
                    recursos.setDisponible(recursos.getDisponibles().get(j) + asignados.get(i).getRecursosNecesarios().get(j), j);
                }
                imprimirMatriz(asignados, terminados);
                System.out.println("Recursos antes de liberar: " + recursosUsados.getDisponibles());
                System.out.println("Recursos disponibles: " + recursos.getDisponibles());
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

    public static void imprimirMatriz(List<Proceso> matriz, List<Proceso> terminados) {
        String cadenaAsignados = "";
        for (int i = 0; i < matriz.size(); i++) {
            cadenaAsignados += "|";
            if (terminados.contains(matriz.get(i))) {
                for (int j = 0; j < matriz.get(i).getRecursosNecesarios().size(); j++) {
                    cadenaAsignados+="\033[34m0|";
                }
            } else {
                for (int j = 0; j < matriz.get(i).getRecursosNecesarios().size(); j++) {
                    cadenaAsignados += matriz.get(i).getRecursosNecesarios().get(j) + "|";
                }
            }
            cadenaAsignados += "\n";
        }

        System.out.println(
                "Matriz de Recursos Asignados: ");
        System.out.println(cadenaAsignados);
    }

}

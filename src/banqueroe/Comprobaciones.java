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
        for (int i = 0; i < necesarios.size(); i++) {
            if (!(terminados.contains(asignados.get(i))) && ejecuta(asignados.get(i), necesarios.get(i), recursos)) {
                terminados.add(asignados.get(i));
                System.out.println("Proceso " + i + " terminado");
                for (int j = 0; j < recursos.getDisponibles().size(); j++) {
                    recursos.setDisponible(recursos.getDisponibles().get(j) + asignados.get(i).getRecursosNecesarios().get(j), j);
                }
                System.out.println("Recursos disponibles: " + recursos.getDisponibles());
                i = -1;
            }

        }
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
}
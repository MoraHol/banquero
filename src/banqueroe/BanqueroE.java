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
public class BanqueroE {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        List<Proceso> asignados = creaAsignados();
        List<Proceso> necesarios = creaNecesarios();
        Disponibles disponibles = creaDisponibles();
        Comprobaciones.devuelveLista(asignados, necesarios, disponibles);
    }

    public static List<Proceso> creaAsignados() {
        List<Proceso> recursosAsignados = new ArrayList<Proceso>();
        recursosAsignados.add(new Proceso());
        recursosAsignados.add(new Proceso());
        recursosAsignados.add(new Proceso());
        recursosAsignados.add(new Proceso());
        recursosAsignados.get(0).getRecursosNecesarios().add(1);
        recursosAsignados.get(0).getRecursosNecesarios().add(0);
        recursosAsignados.get(0).getRecursosNecesarios().add(0);
        recursosAsignados.get(1).getRecursosNecesarios().add(6);
        recursosAsignados.get(1).getRecursosNecesarios().add(1);
        recursosAsignados.get(1).getRecursosNecesarios().add(2);
        recursosAsignados.get(2).getRecursosNecesarios().add(2);
        recursosAsignados.get(2).getRecursosNecesarios().add(1);
        recursosAsignados.get(2).getRecursosNecesarios().add(1);
        recursosAsignados.get(3).getRecursosNecesarios().add(0);
        recursosAsignados.get(3).getRecursosNecesarios().add(0);
        recursosAsignados.get(3).getRecursosNecesarios().add(2);
        return recursosAsignados;
    }

    public static List<Proceso> creaNecesarios() {
        List<Proceso> recursosMaximos = new ArrayList<Proceso>();
        recursosMaximos.add(new Proceso());
        recursosMaximos.add(new Proceso());
        recursosMaximos.add(new Proceso());
        recursosMaximos.add(new Proceso());
        recursosMaximos.get(0).getRecursosNecesarios().add(3);
        recursosMaximos.get(0).getRecursosNecesarios().add(2);
        recursosMaximos.get(0).getRecursosNecesarios().add(2);
        recursosMaximos.get(1).getRecursosNecesarios().add(6);
        recursosMaximos.get(1).getRecursosNecesarios().add(1);
        recursosMaximos.get(1).getRecursosNecesarios().add(3);
        recursosMaximos.get(2).getRecursosNecesarios().add(3);
        recursosMaximos.get(2).getRecursosNecesarios().add(1);
        recursosMaximos.get(2).getRecursosNecesarios().add(4);
        recursosMaximos.get(3).getRecursosNecesarios().add(4);
        recursosMaximos.get(3).getRecursosNecesarios().add(2);
        recursosMaximos.get(3).getRecursosNecesarios().add(2);
        return recursosMaximos;
    }

    public static Disponibles creaDisponibles() {
        Disponibles lista = new Disponibles();
        lista.getDisponibles().add(0);
        lista.getDisponibles().add(1);
        lista.getDisponibles().add(1);
        return lista;
    }

}

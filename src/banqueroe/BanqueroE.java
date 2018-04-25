/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banqueroe;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author juan_
 */
public class BanqueroE {

    static Random random = new Random();
    static List<Proceso> asignados = new ArrayList<Proceso>();
    static List<Proceso> necesarios = new ArrayList<Proceso>();
    static Disponibles disponibles = new Disponibles();

    public static void main(String[] args) {
        // TODO code application logic here
        String cadenaAsignados = "";
        String cadenaMaximos = "";
        String cadena = "";
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduzca el numero de recursos: ");
        int numeroRecursos = teclado.nextInt();
        for (int i = 0; i < numeroRecursos; i++) {
            disponibles.getDisponibles().add(0);
        }
        System.out.println("Introduzca el numero de Clientes: ");
        int numeroProcesos = teclado.nextInt();
        for (int i = 0; i < numeroProcesos; i++) {
            necesarios.add(new Proceso());
            asignados.add(new Proceso());
        }
        creaAsignados();
        creaNecesarios();
        creaDisponibles();
        //disponibles = actualizarDisponibles(disponibles);
        for (int i = 0; i < asignados.size(); i++) {
            cadenaAsignados = "|";
            cadenaMaximos = "|";
            for (int j = 0; j < asignados.get(i).getRecursosNecesarios().size(); j++) {
                cadenaAsignados += asignados.get(i).getRecursosNecesarios().get(j) + "|";
                cadenaMaximos += necesarios.get(i).getRecursosNecesarios().get(j) + "|";
            }
            cadena += cadenaAsignados + "\t\t" + cadenaMaximos + "\n";
        }
        System.out.println("Asignados \t Maximos ");
        System.out.print(cadena);
        System.out.println("Recursos Disponibles: ");
        System.out.println(disponibles.getDisponibles() + "\n");
        Comprobaciones algoritmo = new Comprobaciones(asignados, necesarios, disponibles);
        Comprobaciones.devuelveLista();
    }

    public static void creaAsignados() {
        int numero = 0;
        for (int i = 0; i < asignados.size(); i++) {
            for (int j = 0; j < disponibles.getDisponibles().size(); j++) {
                numero = random.nextInt(3);
                asignados.get(i).getRecursosNecesarios().add(numero);
            }
        }
    }

    public static void creaNecesarios() {
        int numero = 0;
        for (int i = 0; i < necesarios.size(); i++) {
            for (int j = 0; j < disponibles.getDisponibles().size(); j++) {
                numero = random.nextInt(5);
                necesarios.get(i).getRecursosNecesarios().add(numero);
            }
        }
    }

    public static void creaDisponibles() {
        for (int i = 0; i < disponibles.getDisponibles().size(); i++) {
            int valor = random.nextInt(5);
            disponibles.setDisponible(valor, i);
        }
    }
}

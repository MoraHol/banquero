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
        //recursosAsignados.add(new Proceso());
        //recursosAsignados.add(new Proceso());
        //recursosAsignados.add(new Proceso());
        //recursosAsignados.add(new Proceso());
        //recursosAsignados.get(0).getRecursosNecesarios().add(1);
        //recursosAsignados.get(0).getRecursosNecesarios().add(0);
        //recursosAsignados.get(0).getRecursosNecesarios().add(0);
        //recursosAsignados.get(1).getRecursosNecesarios().add(6);
        //recursosAsignados.get(1).getRecursosNecesarios().add(1);
        //recursosAsignados.get(1).getRecursosNecesarios().add(2);
        //recursosAsignados.get(2).getRecursosNecesarios().add(2);
        //recursosAsignados.get(2).getRecursosNecesarios().add(1);
        //recursosAsignados.get(2).getRecursosNecesarios().add(1);
        //recursosAsignados.get(3).getRecursosNecesarios().add(0);
        //recursosAsignados.get(3).getRecursosNecesarios().add(0);
        //recursosAsignados.get(3).getRecursosNecesarios().add(2);
        Scanner teclado = new Scanner(System.in);
        int numero = 0;
        System.out.println("Introduzca los valores para la matriz de Asignados: ");
        for (int i = 0; i < asignados.size(); i++) {
            for (int j = 0; j < disponibles.getDisponibles().size(); j++) {
                System.out.print("Posicion[" + i + "][" + j + "]: ");
                numero = teclado.nextInt();
                asignados.get(i).getRecursosNecesarios().add(numero);
            }
        }
    }

    public static void creaNecesarios() {
        Scanner teclado = new Scanner(System.in);
        int numero = 0;
        System.out.println("Introduzca los valores para la matriz de Necesarios: ");
        for (int i = 0; i < necesarios.size(); i++) {
            for (int j = 0; j < disponibles.getDisponibles().size(); j++) {
                System.out.print("Posicion[" + i + "][" + j + "]: ");
                numero = teclado.nextInt();
                necesarios.get(i).getRecursosNecesarios().add(numero);
            }
        }
        //recursosMaximos.add(new Proceso());
        //recursosMaximos.add(new Proceso());
        //recursosMaximos.add(new Proceso());
        //recursosMaximos.add(new Proceso());
        /*recursosMaximos.get(0).getRecursosNecesarios().add(3);
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
        recursosMaximos.get(3).getRecursosNecesarios().add(2);*/
 /*for (int i = 0; i < recursosMaximos.size(); i++) {
            for (int j = 0; j < disponible.getDisponibles().size(); j++) {
                recursosMaximos.get(i).getRecursosNecesarios().add(random.nextInt(disponible.getDisponibles().get(j)));
            }
        }*/
    }

    public static void creaDisponibles() {
        Scanner teclado = new Scanner(System.in);
        //lista.getDisponibles().add(9);
        //lista.getDisponibles().add(3);
        //lista.getDisponibles().add(6);
        //lista.getDisponibles().add(random.nextInt(7) + 3);
        //lista.getDisponibles().add(random.nextInt(7) + 3);
        //lista.getDisponibles().add(random.nextInt(7) + 3);
        for (int i = 0; i < disponibles.getDisponibles().size(); i++) {
            System.out.print("Introduzca el valor del Recurso " + i+": ");
            int valor = teclado.nextInt();
            disponibles.setDisponible(valor, i);
        }
    }

    public static Disponibles actualizarDisponibles(Disponibles lista) {
        lista.getDisponibles().set(0, 0);
        lista.getDisponibles().set(1, 1);
        lista.getDisponibles().set(2, 1);
        return lista;
    }
}

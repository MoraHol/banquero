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
public class Disponibles {

    List<Integer> recursos;

    public Disponibles() {
        recursos = new ArrayList<Integer>();
    }

    public List<Integer> getDisponibles() {
        return recursos;
    }

    public void setDisponible(int valor, int indice) {
        recursos.set(indice, valor);
    }

}

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
public class Proceso {
    
    List<Integer> recursos;
    public Proceso(){
        recursos = new ArrayList<Integer>();
    }
    
    public List<Integer> getRecursosNecesarios(){
     return recursos;   
    }
    
    public String getNombre(int indice){
        return "P"+indice;
    }
    
}

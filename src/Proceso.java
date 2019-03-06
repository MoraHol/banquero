import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alexis Holguin	
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
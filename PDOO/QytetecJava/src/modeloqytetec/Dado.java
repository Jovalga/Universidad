
package modeloqytetec;

import java.util.Random;

/**
 * @author Jorge Valenzuela García
 */
public class Dado {
    
    private static final Dado instance = new Dado();
    
    // El constructor privado asegura que no se puede instanciar
    // desde otras clases
    private Dado(){}
    
    public static Dado getInstance(){
        return instance;
    }
    
    protected int tirar(){
        Random randomGenerator = new Random();
        int valor = (randomGenerator.nextInt() % 6);
        if (valor < 0){
            valor = -valor;
            valor = valor+1;
        }
        else
            valor++;
        
        return valor;
    }
    
    @Override
    public String toString(){
        return "Soy un dado\n";
    }
    
}

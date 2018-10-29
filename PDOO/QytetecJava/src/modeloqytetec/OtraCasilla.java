
package modeloqytetec;

/**
 * @author Jorge Valenzuela garcia
 */
public class OtraCasilla extends Casilla{
    
    public OtraCasilla(int numeroCasilla, TipoCasilla tipo){
        super(numeroCasilla, 0, tipo);
    }
    
        @Override
    protected boolean soyEdificable(){
        return false;
    }  

    @Override
    public String toString(){
        String salida;
        salida = "Numero Casilla: " + Integer.toString(this.getNumeroCasilla()) +
        "\nTipo: " + this.getTipo().toString();
        return salida;
    }
    
}

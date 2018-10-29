
package modeloqytetec;

/**
 * @author Jorge Valenzuela Garcia
 */
public abstract class Casilla {
    
    // ATRIBUTOS

    private int coste;
    private int numeroCasilla;
    
    // ATRIBUTOS REFERENCIADOS
    private TipoCasilla tipo;    
    
    
    // CONSTRUCTOR
    public Casilla(int numeroCasilla, int coste, TipoCasilla tipo){
        this.numeroCasilla = numeroCasilla;
        this.tipo = tipo;
        if (tipo == TipoCasilla.IMPUESTO)
            this.coste = 100;
        else
            this.coste = coste;

    }
    
    // MÉTODOS
    
    public TipoCasilla getTipo(){
        return this.tipo;
    }
    
    protected int getCoste(){
        return this.coste;
    }
    
    protected int getNumeroCasilla(){
        return this.numeroCasilla;
    }
    
    protected abstract boolean soyEdificable();

    public String toStringNumeroCasilla(){
        return Integer.toString(this.numeroCasilla);
    }
    
    public abstract String toString();
    
    /*protected int getCosteHipoteca(){//**//**//**
        return 0;
    }*/
    
    /*protected int precioTotalComprar(){
        return 0;
    }*/
    

    
    /*private void asignarTituloPropiedad(){
    }
    */
    

}

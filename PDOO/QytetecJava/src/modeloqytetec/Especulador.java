
package modeloqytetec;

/**
 * @author Jorge Valenzuela garcia
 */
public class Especulador extends Jugador{
    
    // ATRIBUTOS
    private static int factorEspeculador = 2;
    private int fianza;
    
    // CONSTRUCTOR
    public Especulador(Jugador jugador, int fianza){
        super(jugador);
        this.fianza = fianza;
    }
    
    
    // METODOS
    protected Especulador convertirme(int fianza){
        return this;
    }
    
    @Override
    protected int getFactor(){
        return Especulador.factorEspeculador;
    }
    
    protected void irACarcel(Casilla casilla){
        boolean condicion = this.pagarFianza(this.fianza);
        if (!condicion){
            this.setCasillaActual(casilla);
            this.setEncarcelado(true);
        }
    }
   
    private boolean pagarFianza(int cantidad){
        boolean decision = this.tengoSaldo(cantidad);
        if (decision)
            this.modificarSaldo(-cantidad);
        return decision;
    }
    
    @Override
    protected void pagarImpuestos(int cantidad){
        int cantidadEsp = cantidad /2; // Los especuladores pagan la mitad
        this.modificarSaldo(cantidadEsp);
    }
    
    @Override
    public String toString(){
        String salida;
        salida = super.toString();
        salida += "\nFianza: " + this.fianza;
            return salida;
        }
        
}
    

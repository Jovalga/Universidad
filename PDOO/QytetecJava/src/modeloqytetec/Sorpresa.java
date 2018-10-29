package modeloqytetec;

/**
 * @author Jorge Valenzuela García
 */
public class Sorpresa {
    
    private String texto;
    private TipoSorpresa tipo;
    private int valor;
    
    
    // CONSTRUCTOR
    public Sorpresa(String texto, int valor, TipoSorpresa tipo){
        this.texto = texto;
        this.valor = valor;
        this.tipo = tipo;
    }
    
    
    // CONSULTORES
    public String getTexto(){
        return this.texto;
    }
    
    public TipoSorpresa getTipo(){
        return this.tipo;
    }
    
    public int getValor(){
        return this.valor;
    }
    
    
    
    
    // MÉTODO TO STRING
    @Override
    public String toString(){
        return "Sorpresa: \n" + texto + "\nValor: " + Integer.toString(this.valor) + "\nTipo = " + tipo;
    }
    
}


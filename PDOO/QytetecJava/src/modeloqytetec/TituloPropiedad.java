
package modeloqytetec;

/**
 * @author Jorge Valenzuela Garcia
 */
public class TituloPropiedad {
    
    // ATRIBUTOS
    private String nombre;
    private boolean hipotecada;
    private int alquilerBase;
    private float factorRevalorizacion;
    private int hipotecaBase;
    private int precioEdificar;

    // ATRIBUTOS REFERENCIADOS
    private Jugador propietario;
    private Casilla casilla;
    
    // CONSTRUCTOR
    public TituloPropiedad(String nombre, int alquilerBase, float factorRevalorizacion, int hipotecaBase, int precioEdificar){
        this.nombre = nombre;
        this.hipotecada = false;
        this.alquilerBase = alquilerBase;
        this.factorRevalorizacion = factorRevalorizacion;
        this.hipotecaBase = hipotecaBase;
        this.precioEdificar = precioEdificar;
    }

    // MÉTODOS
    
    protected void cobrarAlquiler(int coste){
        this.propietario.modificarSaldo(coste);
    }
    
    protected int getAlquilerBase(){
        return this.alquilerBase;
    }
    
    protected Casilla getCasilla(){
        return this.casilla;
    }
    
    protected float getFactorRevalorizacion(){
        return this.factorRevalorizacion;
    } 
    
    protected int getHipotecaBase(){
        return this.hipotecaBase;
    }
    
    protected boolean getHipotecada(){
        return this.hipotecada;
    }
   
    protected String getNombre(){
        return this.nombre;
    }
    
    protected int getPrecioEdificar(){
        return this.precioEdificar;
    }
    
    protected boolean propietarioEncarcelado(){
        return this.propietario.getEncarcelado();
    }
    
    protected void setCasilla(Casilla casilla){
        if (casilla.getTipo() == TipoCasilla.CALLE)
            this.casilla = casilla;
    }
    
    protected void setHipotecada(boolean hipotecada){
        this.hipotecada = hipotecada;
    }
    
    protected void setPropietario(Jugador propietario){
        this.propietario = propietario;
    }
    
    protected boolean tengoPropietario(){
        if(this.propietario == null)
            return false;
        else
            return true;
    }
    
    @Override
    public String toString(){
        String salida;
        
        salida= "Nombre: " + this.nombre + "\n" +
                "Hipotecada: " + Boolean.toString(this.hipotecada) + "\n" +
                "Alquiler Base: " + Integer.toString(this.alquilerBase) + "\n" +
                "Factor Revalorizacion: " + Float.toString(this.factorRevalorizacion) + "\n" +
                "Hipoteca Base: " + Integer.toString(this.hipotecaBase)  + "\n" +
                "Precio Edificar: " + Integer.toString(this.precioEdificar) + "\n";
        
                if(this.casilla == null)
                    salida += "Casilla: Sin asignar\n";
                else
                    salida += "Casilla: " + this.casilla.toStringNumeroCasilla() + "\n";
                if(this.propietario == null)
                    salida += "Propietario: Sin asignar\n";
                else
                    salida +="Propietario: " + this.propietario.toStringNombre() + "\n";
        return salida;
    }
    
    public String toStringNombre(){
        return this.nombre;
    }
    
}



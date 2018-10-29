
package modeloqytetec;

/**
 * @author Jorge Valenzuela Garcia
 */
public class Calle extends Casilla{
    
    // ATRIBUTOS
    private int numHoteles;
    private int numCasas;
    private TituloPropiedad titulo;
    
    // CONSTRUCTOR
    public Calle(int numeroCasilla, int coste, TituloPropiedad titulo){
      super(numeroCasilla, coste, TipoCasilla.CALLE);
      this.numHoteles = 0;
      this.numCasas = 0;
      this.titulo = titulo;
    }
    
    // METODOS
     public TituloPropiedad getTitulo(){
        return this.titulo;
    }
    
    protected TituloPropiedad asignarPropietario(Jugador jugador){
        this.titulo.setPropietario(jugador);
        return this.titulo;
    }
    
    protected int calcularValorHipoteca(){
        int hipobase = this.titulo.getHipotecaBase();
        int cantidadRecibida = hipobase + (int)((this.numCasas * 0.5 * hipobase) + (this.numHoteles * 2 * hipobase));
        return cantidadRecibida;
    }
            
    protected int cancelarHipoteca(){
        this.titulo.setHipotecada(false);
        int cantidadRecibida = this.calcularValorHipoteca();
        return cantidadRecibida;
    }
    
    
    protected int cobrarAlquiler(){
        int costeAlquilerBase = this.titulo.getAlquilerBase();
        int costeAlquiler = (int) (costeAlquilerBase + ((this.numCasas * 0.5) + (this.numHoteles * 2)));
        this.titulo.cobrarAlquiler(costeAlquiler);
        return costeAlquiler;
    }
            
    protected int edificarCasa(){
        this.setNumCasas(this.numCasas +1);
        return this.titulo.getPrecioEdificar();
    }
    
    protected int edificarHotel(){
        this.setNumHoteles(this.numHoteles +1);
        return this.titulo.getPrecioEdificar();
    }
    
    protected boolean estaHipotecada(){
        if(this.titulo.getHipotecada())
            return true;
        else
            return false;
    }
    
    protected int getNumCasas(){
        return this.numCasas;
    }
    
    protected int getNumHoteles(){
        return this.numHoteles;
    }
    
    protected int getPrecioEdificar(){
        return this.titulo.getPrecioEdificar();
    }
    
    protected int hipotecar(){
        this.titulo.setHipotecada(true);
        int cantidadRecibida = this.calcularValorHipoteca();
        return cantidadRecibida;
    }
    
    protected boolean propietarioEncarcelado(){
        return this.titulo.propietarioEncarcelado();
    }
    
    protected boolean tengoPropietario(){
        return this.titulo.tengoPropietario();
    }
    
    protected boolean sePuedeEdificarCasa(int factorEspeculador){
        return this.numCasas < 4*factorEspeculador;
    }
    
    protected boolean sePuedeEdificarHotel(int factorEspeculador){
        return this.numHoteles < 4*factorEspeculador && this.numCasas == 4*factorEspeculador;
    }
    
    protected void setNumCasas(int nuevoNumero){
        this.numCasas = nuevoNumero;
    }
    
    protected void setNumHoteles(int nuevoNumero){
        this.numHoteles = nuevoNumero;
    }
 
    private void setTitulo(TituloPropiedad titulo) throws Exception{
        this.titulo = titulo;
    }
    
    @Override
    protected boolean soyEdificable(){
        return true;
    }
    
    protected int venderTitulo(){
        this.titulo.setPropietario(null);
        this.setNumCasas(0);
        this.setNumHoteles(0);
        int precioVenta, precioCompra;
        precioCompra = super.getCoste() + ((this.numCasas + this.numHoteles) * this.titulo.getPrecioEdificar());
        precioVenta = (int) (precioCompra + (this.titulo.getFactorRevalorizacion() * precioCompra));
        return precioVenta;
    }
    
    
    
    @Override
    public String toString(){
        String salida;
        salida = "Numero Casilla: " + Integer.toString(this.getNumeroCasilla()) + "\n" +
        "Coste: " + Integer.toString(super.getCoste()) + "\n" +
        "Numero Hoteles: " + Integer.toString(this.numHoteles) + "\n" +
        "Numero Casas: " + Integer.toString(this.numCasas) + "\n" +
        "Tipo: CALLE\n";
        salida += "Titulo: " + this.titulo.toString();
        return salida;
    }
    
}

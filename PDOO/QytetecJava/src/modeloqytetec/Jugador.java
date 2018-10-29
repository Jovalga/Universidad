
package modeloqytetec;

import java.util.ArrayList;

/**
 * @author Jorge Valenzuela Garcia
 */
public class Jugador {
    
    // Atributos
    private boolean encarcelado;
    String nombre;
    private int saldo;
    
    // Atributos referenciados
    private Casilla casillaActual;
    private Sorpresa cartaLibertad;
    private ArrayList<TituloPropiedad> propiedades;
    
    //Atributos especulador
    protected static int factorEspeculador = 1;
    
    // Constructor
    public Jugador(String nombre){
        this.encarcelado = false; // Cuando se empieza, nunca se está encarcelado
        this.nombre = nombre;
        this.saldo = 7500;

        this.casillaActual = new OtraCasilla(0, TipoCasilla.SALIDA);
        this.propiedades = new ArrayList();
    }
    
    // Constructor de copia
    protected Jugador(Jugador jugador){
        this.encarcelado = jugador.encarcelado;
        this.nombre = jugador.nombre;
        this.saldo = jugador.saldo;
        this.casillaActual = jugador.casillaActual;
        this.cartaLibertad = jugador.cartaLibertad;
        this.propiedades = jugador.propiedades;
    }
    
    public Casilla getCasillaActual(){
        return this.casillaActual;
    }
    
    public boolean getEncarcelado(){
        return this.encarcelado;
    }
    
    public boolean tengoPropiedades(){
        if(this.propiedades.isEmpty())
            return false;
        else
            return true;
    }
    
    protected boolean actualizarPosicion(Casilla casilla){

        if(casilla.getNumeroCasilla() < this.casillaActual.getNumeroCasilla())
            this.modificarSaldo(Qytetet.SALDO_SALIDA);
        
        boolean tienePropietario = false;
        this.setCasillaActual(casilla);
        
        if(casilla.getTipo().equals(TipoCasilla.CALLE)){
            Calle calle = (Calle) casilla;
            if(calle.soyEdificable()){
                if(calle.tengoPropietario()){
                    tienePropietario = true;
                    if(!calle.propietarioEncarcelado()){
                        this.modificarSaldo(-calle.cobrarAlquiler());
                    }
                }
            }
        }
        if(casilla.getTipo().equals(TipoCasilla.IMPUESTO)){
            this.pagarImpuestos(-casilla.getCoste());
        }
        return tienePropietario;
    }
    
    protected boolean comprarTitulo(){
        boolean puedoComprar = false;
        Calle calle = (Calle) this.casillaActual;
        if(calle.soyEdificable()){
            if(!calle.tengoPropietario()){
                if(calle.getCoste() <= this.saldo){
                    TituloPropiedad titulo = calle.asignarPropietario(this);
                    this.propiedades.add(titulo);
                    this.modificarSaldo(-calle.getCoste());
                    puedoComprar = true;
                }
            }
        }
        return puedoComprar;
    }
    
    
    protected Especulador convertirme(int fianza){
        return new Especulador(this, fianza);
    }
    
    
    protected Sorpresa devolverCartaLibertad(){ // Posible error
        Sorpresa devolver = this.cartaLibertad;
        this.cartaLibertad = null;
        return devolver;
    }
    
    protected int getFactor(){
        return Jugador.factorEspeculador;
    }
    
    public int getSaldo(){
        return this.saldo;
    }
    
    protected void irACarcel(Casilla casilla){
        this.setCasillaActual(casilla);
        this.setEncarcelado(true);
    }
    
    protected void modificarSaldo(int cantidad){
        this.saldo += cantidad;
    }
    
    protected int obtenerCapital(){
        int capital = this.saldo;
        int coste,precio,casas,hoteles;
        Calle calle;
        for(TituloPropiedad titulo : this.propiedades){
            calle = (Calle) titulo.getCasilla();
            coste = calle.getCoste();
            casas = calle.getNumCasas();
            hoteles = calle.getNumHoteles();
            precio = calle.getPrecioEdificar();
            capital += coste + ((casas+hoteles) * precio);
            if(titulo.getHipotecada())
                capital -= titulo.getHipotecaBase();
        }
        return capital;
    }
    
    protected ArrayList<TituloPropiedad> obtenerPropiedadesHipotecadas(boolean hipotecada){
        ArrayList<TituloPropiedad> devolverSi = new ArrayList();
        ArrayList<TituloPropiedad> devolverNo = new ArrayList();
        for(TituloPropiedad titulo : this.propiedades)    
            if(titulo.getHipotecada())
                devolverSi.add(titulo);
            else
                devolverNo.add(titulo);
        
        if(hipotecada)
            return devolverSi;
        else
            return devolverNo;
    }
    
    protected void pagarCobrarPorCasaYHotel(int cantidad){
        int numeroTotal = this.cuantasCasasHotelesTengo();
        this.modificarSaldo(cantidad * numeroTotal);
    }
    
    protected void pagarImpuestos(int cantidad){
        this.modificarSaldo(cantidad);
    }
    
    protected boolean pagarLibertad(int cantidad){
        boolean tengoSaldo = this.tengoSaldo(cantidad);
        if(tengoSaldo)
            this.modificarSaldo(-cantidad);
        return tengoSaldo;
    }
    
    protected boolean puedoEdificarCasa(Casilla casilla){
        // true si es de mi propiedad y tengo saldo
        if(this.esDeMiPropiedad(casilla)){
            Calle calle = (Calle) casilla;
            return this.tengoSaldo(calle.getPrecioEdificar());
        }
        return false;
    }
    
    protected boolean puedoEdificarHotel(Casilla casilla){
        // true si es de mi propiedad y tengo saldo
        if(this.esDeMiPropiedad(casilla)){
            Calle calle = (Calle) casilla;
            return this.tengoSaldo(calle.getPrecioEdificar());
        }
        else
            return false;
    }
    
    protected boolean puedoHipotecar(Casilla casilla){
        if(this.esDeMiPropiedad(casilla))
            return true;
        else
            return false;
    }
    
    protected boolean puedoPagarHipoteca(Casilla casilla){
        Calle calle = (Calle) casilla;
        if(this.esDeMiPropiedad(casilla) && this.saldo >= calle.calcularValorHipoteca())
            return true;
        else
            return false;
    }
    
    protected boolean puedoVenderPropiedad(Casilla casilla){
        boolean devolver = false;
        if(this.esDeMiPropiedad(casilla)){
            Calle calle = (Calle) casilla;
            if(!calle.estaHipotecada())
                devolver = true;
        }
        return devolver;
    }
    
    protected void setCartaLibertad(Sorpresa carta){
        if(carta.getTipo() == TipoSorpresa.SALIRCARCEL)
            this.cartaLibertad = carta;
    }
    
    protected void setCasillaActual(Casilla casilla){
        this.casillaActual = casilla;
    }
    
    protected void setEncarcelado(boolean encarcelado){
        this.encarcelado = encarcelado;
    }
    
    protected boolean tengoCartaLibertad(){
        if(this.cartaLibertad == null)
            return false;
        else
            return true;
    }
    
    protected void venderPropiedad(Casilla casilla){
        Calle calle = (Calle) casilla;
        int precioVenta = calle.venderTitulo();
        this.modificarSaldo(precioVenta);
        this.eliminarDeMisPropiedades(casilla);
    }
    
    private int cuantasCasasHotelesTengo(){
        int total = 0;
        Calle calle;
        for(TituloPropiedad titulo: this.propiedades){
            calle = (Calle) titulo.getCasilla();
            total += calle.getNumCasas();
            total += calle.getNumHoteles();
        }
        return total;
    }
    
    private void eliminarDeMisPropiedades(Casilla casilla){
        Calle calle = (Calle) casilla;
        TituloPropiedad titulo = calle.getTitulo();
        int indice;
        // Comprobamos que tenemos el titulo entre nuestras propiedades
        if(this.propiedades.contains(titulo)){
            // Obtenemos el indice de dicho titulo y borramos
            indice = this.propiedades.indexOf(titulo);
            this.propiedades.remove(indice);                    
        }
    }
    
    private boolean esDeMiPropiedad(Casilla casilla){
        boolean mio = false;
        Calle calle = (Calle) casilla;
        for(TituloPropiedad titulo : this.propiedades)
            if(calle.getTitulo().getNombre().equals(titulo.getNombre()))
                mio = true;
        return mio;
    }
            
    protected boolean tengoSaldo(int cantidad){
        return this.saldo >= cantidad;
    }
    
    
    @Override
    public String toString(){
        String salida;
        
        // Si no tengo propiedades
        if(this.propiedades.isEmpty()){
            salida =    "Nombre: " + this.nombre + "\n" +
                        "Encarcelado: " + Boolean.toString(this.encarcelado) + "\n" +
                        "Saldo: " + Integer.toString(this.saldo) + "\n" +
                        "Casilla Actual: " + this.casillaActual.toStringNumeroCasilla() + "\n";
            
            if(this.tengoCartaLibertad())
                salida += "Carta Libertad = Si\n" + "SIN PROPIEDADES";
            else
                salida += "Carta Libertad = No\n" + "SIN PROPIEDADES";
            
            return salida;
        } 
        
        // Si tengo propiedades
        else{
            salida =    "Nombre: " + this.nombre + "\n" +
                        "Encarcelado: " + Boolean.toString(this.encarcelado) + "\n" +
                        "Saldo: " + Integer.toString(this.saldo) + "\n" +
                        "Casilla Actual: " + this.casillaActual.toStringNumeroCasilla()+ "\n";
            
            if(this.tengoCartaLibertad()){
                salida += "Carta Libertad = Si\n\n";
                salida += "\tPROPIEDADES:\n";
                for (TituloPropiedad propiedad : this.propiedades)
                    salida += propiedad.toString() + "\n";
            }    
            else{
                salida += "Carta Libertad = No\n\n";
                salida += "\tPROPIEDADES:\n";
                for (TituloPropiedad propiedad : this.propiedades)
                    salida += propiedad.toString() + "\n";
                }
            
            return salida;
        }
        
    }
    
    public String toStringNombre(){
        return this.nombre;
    }
}

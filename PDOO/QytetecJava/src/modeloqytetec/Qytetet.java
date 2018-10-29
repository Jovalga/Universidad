
package modeloqytetec;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author Jorge Valenzuela garcia
 */
public class Qytetet {
    
    // ATRIBUTOS
    private static final Qytetet instance = new Qytetet();
    public static final int MAX_JUGADORES = 4 ;
    protected static final int MAX_CARTAS = 10;
    protected static final int MAX_CASILLAS = 20;
    protected static final int PRECIO_LIBERTAD = 200;
    protected static final int SALDO_SALIDA = 1000;
    
    // ATRIBUTOS REFERENCIADOS
    //private Dado dado = Dado.getInstance();
    private Sorpresa cartaActual;
    private ArrayList<Sorpresa> mazo;
    private Jugador jugadorActual;
    private ArrayList<Jugador> jugadores;
    private Tablero tablero;
    
    // El constructor privado asegura que no se puede instanciar
    // desde otras clases
    private Qytetet(){}
    
    
    // MÉTODOS
    
    public boolean aplicarSorpresa(){
        boolean tienePropietario = false;
        TipoSorpresa tipo = this.cartaActual.getTipo();
        switch(tipo){
        
            case PAGARCOBRAR:
                this.jugadorActual.modificarSaldo(this.cartaActual.getValor());
                this.mazo.add(this.cartaActual);
                break;
            
                
            case IRACASILLA:
                int numeroCasilla = this.cartaActual.getValor();
                boolean esCarcel = this.tablero.esCasillaCarcel(numeroCasilla);
                if(esCarcel)
                    this.encarcelarJugador();
                else{
                    Casilla nuevaCasilla = this.tablero.obtenerCasillaNumero(numeroCasilla);
                    tienePropietario = this.jugadorActual.actualizarPosicion(nuevaCasilla);
                }
                this.mazo.add(this.cartaActual);
                break;
            
                
            case PORCASAHOTEL:
                this.jugadorActual.pagarCobrarPorCasaYHotel(this.cartaActual.getValor());
                this.mazo.add(this.cartaActual);
                break;
           
                
            case PORJUGADOR:
                for(Jugador jugador : this.jugadores){
                    // Si el "jugador" es distinto del jugadorActual...
                    if(!jugador.equals(this.jugadorActual)){
                        jugador.modificarSaldo(this.cartaActual.getValor());
                        this.jugadorActual.modificarSaldo(-this.cartaActual.getValor());
                    }
                }
                this.mazo.add(this.cartaActual);
                break;
        
                
            case SALIRCARCEL:
                this.jugadorActual.setCartaLibertad(this.cartaActual);
                break;

            case CONVERTIRME:
                // Cogemos el indice del jugador actual
                int indice = this.jugadores.indexOf(this.jugadorActual);
                // Creamos el objeto especulador del jugador actual
                Especulador espec = this.jugadorActual.convertirme(this.cartaActual.getValor());
                // Añadimos el especulador creado al array de jugadores en la posicion de jugador actual
                this.jugadores.add(indice, espec);
                // Volvemos a coger el nuevo indice de jugador actual
                indice = jugadores.indexOf(this.jugadorActual);
                // Y lo borramos
                jugadores.remove(indice);
                // Finalmente guardamos en jugador actual el nuevo especulador
                this.jugadorActual = espec;
                break;
        }
        
        return tienePropietario;
    }
    
    public boolean cancelarHipoteca(Casilla casilla){
        boolean cancelar = false;
        if(casilla.soyEdificable()){
            Calle calle = (Calle) casilla;
            if(calle.estaHipotecada()){
                if(this.jugadorActual.puedoPagarHipoteca(casilla)){
                    cancelar = true;
                    int cantidadRecibida = calle.cancelarHipoteca();
                    this.jugadorActual.modificarSaldo(-cantidadRecibida);
                }
            }
        }
        return cancelar;
    }
    
    public boolean comprarTituloPropiedad(){
        return this.jugadorActual.comprarTitulo();
    }
    
    public boolean edificarCasa(Casilla casilla){
        boolean puedoEdificar = false;
        if(casilla.soyEdificable()){
            Calle calle = (Calle) casilla;
            if(calle.sePuedeEdificarCasa(this.jugadorActual.getFactor())){
                if(this.jugadorActual.puedoEdificarCasa(casilla)){
                    int costeEdificarCasa = calle.edificarCasa();
                    this.jugadorActual.modificarSaldo(-costeEdificarCasa);
                    puedoEdificar = true;
                }
            }
        }
        return puedoEdificar;
    }
    
    public boolean edificarHotel(Casilla casilla){
        boolean puedoEdificar = false;
        if(casilla.soyEdificable()){
            Calle calle = (Calle) casilla;
            if(calle.sePuedeEdificarHotel(this.jugadorActual.getFactor())){
                if(this.jugadorActual.puedoEdificarHotel(casilla)){
                    int costeEdificarHotel = calle.edificarHotel();
                    this.jugadorActual.modificarSaldo(-costeEdificarHotel);
                    puedoEdificar = true;
                }
            }
        }
        return puedoEdificar;
    }
    
    public Sorpresa getCartaActual(){
        return this.cartaActual;
    }
    
    public static Qytetet getInstance(){
        return instance;
    }
    
    public Jugador getJugadorActual(){
        return this.jugadorActual;
    }
    
    public ArrayList<Jugador> getJugadores(){
        return this.jugadores;
    }
    
    public boolean hipotecarPropiedad(Casilla casilla){
        boolean puedoHipotecarPropiedad = false;
        Calle calle = (Calle) casilla;
        if(casilla.soyEdificable())
            if(!calle.estaHipotecada())
                if(this.jugadorActual.puedoHipotecar(casilla)){
                    puedoHipotecarPropiedad = true;
                    int cantidadRecibida = calle.hipotecar();
                    this.jugadorActual.modificarSaldo(cantidadRecibida);
                }
        return puedoHipotecarPropiedad;
    }
    
    public void inicializarJuego(ArrayList<String> nombres) throws Exception{
        this.inicializarJugadores(nombres); // Este metodo puede lanzar excepcion en caso nombres < 2
        this.inicializarCartasSorpresa();
        this.inicializarTablero();
        this.salidaJugadores();
    }
    
    public boolean intentarSalirCarcel(MetodoSalirCarcel metodo){
        boolean libre = false;
        GUIQytetet.Dado dado = GUIQytetet.Dado.getInstance();
        if(metodo == MetodoSalirCarcel.TIRANDODADO){
            int valorDado = dado.nextNumber();
            System.out.println("Ha salido: " + Integer.toString(valorDado));
            libre = valorDado > 5;
        }
        else{
            boolean tengoSaldo = this.jugadorActual.pagarLibertad(Qytetet.PRECIO_LIBERTAD);
            if (tengoSaldo)
                libre = true;
        }
        if(libre)
            this.jugadorActual.setEncarcelado(false);
        return libre;
    }
    
    public boolean jugar(){
        GUIQytetet.Dado dado = GUIQytetet.Dado.getInstance();
        int valorDado = dado.nextNumber();
        System.out.println(valorDado);
        Casilla casillaPosicion = this.jugadorActual.getCasillaActual();
        Casilla nuevaCasilla = this.tablero.obtenerNuevaCasilla(casillaPosicion, valorDado);
        boolean tienePropietario = this.jugadorActual.actualizarPosicion(nuevaCasilla);
        if(!nuevaCasilla.soyEdificable()){
            if(nuevaCasilla.getTipo().equals(TipoCasilla.JUEZ))
                this.encarcelarJugador();
            else{
                if(nuevaCasilla.getTipo().equals(TipoCasilla.SORPRESA)){
                    // Cogemos la primera carta del mazo
                    this.cartaActual = this.mazo.remove(0);
                }
            }
        }
        return tienePropietario;
    }
    
    public ArrayList obtenerRanking(){//
        return null;
    }
    
    public ArrayList<Casilla> propiedadesHipotecadasJugador(boolean hipotecadas){
        ArrayList<Casilla> devolver = new ArrayList();
        ArrayList<TituloPropiedad> listaPropiedades = this.jugadorActual.obtenerPropiedadesHipotecadas(hipotecadas);
        for (TituloPropiedad titulo : listaPropiedades){
            devolver.add(titulo.getCasilla());
        }
        return devolver;
    }
    
    public void siguienteJugador(){
        int numero_jugadores = this.jugadores.size();
        int numero_jugador = this.jugadores.indexOf(this.jugadorActual);
        if (numero_jugador == numero_jugadores -1) // Si es el ultimo jugador
            this.jugadorActual = this.jugadores.get(0);
        else
            this.jugadorActual = this.jugadores.get(numero_jugador+1);
    }
    
    public boolean venderPropiedad(Casilla casilla){
        boolean puedoVender = false;
        if(casilla.soyEdificable()){
            puedoVender = this.jugadorActual.puedoVenderPropiedad(casilla);
            if(puedoVender){
                this.jugadorActual.venderPropiedad(casilla);
            }
        }
        return puedoVender;
    }
    
    private void encarcelarJugador(){
        if(!this.jugadorActual.tengoCartaLibertad()){
            Casilla carcel = this.tablero.getCarcel();
            this.jugadorActual.irACarcel(carcel);
        }
        else{
            Sorpresa carta = this.jugadorActual.devolverCartaLibertad();
            this.mazo.add(carta);
        }
    }
    
    private void inicializarCartasSorpresa(){
        this.mazo = new ArrayList();
        this.mazo.add( new Sorpresa ("Parece que te vas a convertir en un especulador...", 3000, TipoSorpresa.CONVERTIRME));
        this.mazo.add( new Sorpresa ("Te han dado una donación de 150 euros", 150, TipoSorpresa.PAGARCOBRAR));    
        this.mazo.add( new Sorpresa ("Te has dejado el coche donde no debías, pagas una multa de 150 euros", -150, TipoSorpresa.PAGARCOBRAR));      
        this.mazo.add( new Sorpresa ("Te hemos pillado con chanclas y calcetines, lo sentimos, ¡debes ir a la carcel!", 11, TipoSorpresa.IRACASILLA));
        this.mazo.add( new Sorpresa ("La patrulla antisuperstición te lleva a la casilla 13", 13, TipoSorpresa.IRACASILLA));
        this.mazo.add( new Sorpresa ("Se te ve con ganas de volver a empezar, vuelve a la casilla de salida", 0, TipoSorpresa.IRACASILLA));
        this.mazo.add( new Sorpresa ("Inspección te ha pillado, pagas 50€ por cada propiedad que tengas", -50, TipoSorpresa.PORCASAHOTEL));
        this.mazo.add( new Sorpresa ("Has generado muchos beneficios, por cada propiedad cobras 50 euros", 50, TipoSorpresa.PORCASAHOTEL));
        this.mazo.add( new Sorpresa ("Es tu cumpleaños, cada jugador te da 20 euros", -20, TipoSorpresa.PORJUGADOR));
        this.mazo.add( new Sorpresa ("Has perdido una apuesta, debes darle a cada jugador 20 euros", 20, TipoSorpresa.PORJUGADOR));
        this.mazo.add( new Sorpresa ("Un fan anónimo ha pagado tu fianza. Sales de la cárcel", 0, TipoSorpresa.SALIRCARCEL));
        this.mazo.add( new Sorpresa ("Parece que te vas a convertir en un especulador...", 5000, TipoSorpresa.CONVERTIRME));
    }
    
    private void inicializarJugadores(ArrayList<String> nombres) throws Exception{
        this.jugadores = new ArrayList();
        if (nombres.size() >= 2 && nombres.size() <= MAX_JUGADORES){
            for(String nombre : nombres){
                Jugador jugador = new Jugador(nombre);
                this.jugadores.add(jugador);
            }
        }
        else{
            throw new Exception("Numero de jugadores incorrecto. Para jugar se necesitan dos o mas jugadores");
        }
    }
    
    private void inicializarTablero(){
            this.tablero = new Tablero();
    }
    
    private void salidaJugadores(){
        for (Jugador jugador : this.jugadores){
            jugador.setCasillaActual(this.tablero.obtenerCasillaNumero(0));
        }
        Random randomGenerator = new Random();
        int posicion = (randomGenerator.nextInt() % this.jugadores.size());
        if(posicion < 0)
            posicion = -posicion;
        this.jugadorActual = this.jugadores.get(posicion);
    }
    
    
    @Override
    public String toString(){
        String salida;
        salida =    "Qytetet:" +
                    "\nMaximo de jugadores: " + Integer.toString(MAX_JUGADORES) + 
                    "\nMaximo de cartas: " + Integer.toString(MAX_CARTAS) +
                    "\nMaximo de casillas: " + Integer.toString(MAX_CASILLAS) +
                    "\nPrecio de libertad: " + Integer.toString(PRECIO_LIBERTAD) +
                    "\nSaldo de salida: " + Integer.toString(SALDO_SALIDA);
        //salida += "\nAun faltan datos para una correcta inicializacion de los atributos de instancia";
        return salida;
    }
    
}
